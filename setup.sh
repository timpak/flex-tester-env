#!/bin/bash

#### Constants

# Set current working directory
	cwd=$(pwd)

# Create bundle folders
	mkdir -p bundles/7.1.x
	mkdir -p bundles/master
# Exceptions
	set -e

# Check if 7z is installed
	if ! archiverLocation="$(type -p "7z")" || [[ -z $archiverLocation ]]; then
 		echo -e "\e[101m7z is not installed. Please install 7z and try again.\e[0m"
	fi

#### Functions

71toprivate ()
{
# Delete old bundle if it exists
	echo -e "\e[44mDeleting old bundle\e[0m"
	rm -rf $cwd/../private/bundles

# Move 7.1.x bundle to private folder
	echo -e "\e[44mMoving bundle to public\e[0m"
	mv $cwd/../7.1.x $cwd/../private/bundles
}

clean ()
{
	echo -e "\e[44mDeletes everything but .git, resources, and setup.sh\e[0m"
	rm -rf `ls | grep -v ".git\|resources\|setup.sh"`
}

cleandb ()
{
	read -p "Enter database name [lportal]: " db_name
	db_name=${db_name:-lportal}
	echo -e "\e[44mOkay! I will drop $db_name and recreate it.\e[0m"
	mysql -e "DROP DATABASE if exists $db_name; create database $db_name character set utf8;"
}

cleanmaster ()
{
# Clean out old copy
	echo -e "\e[44mCleaning out old extracted binaries/folders\e[0m"
	rm -rf master
	mkdir -p master

# Copy the new bundle
	echo -e "\e[44mCopying it over to the working directory [$cwd]/master\e[0m"
	cp -r $cwd/bundles/master/liferay-portal-master/* $cwd/master
	echo -e "\e[44mCopying a basic portal-ext.properties over\e[0m"
	cp -r $cwd/resources/portal-ext.properties $cwd/master

# Clear the database and create
	echo -e "\e[44mLets clear the database\e[0m"
	cleandb
	echo -e "\e[44mThe bundle is ready for testing.\e[0m"
	echo -e "\e[44mYou are on Githash: $(cat master/tomcat-9.0.17/.githash)\e[0m"
	notify-send "The bundle is ready for testing!"
}

cluster ()
{
	# Clean out old copy
	echo -e "\e[44mCleaning out old extracted binaries/folders\e[0m"
	rm -rf $cwd/bundles/master/liferay-portal-master
	rm -rf $cwd/node-1
	rm -rf $cwd/node-2

# Create directories that will be used
	echo -e "\e[44mCreating folders for bundle backup if they don't exist\e[0m"
	mkdir -p bundles/master
	mkdir -p node-1
	mkdir -p node-2

# Check if a new master snapshot exists and if so, download it
	echo -e "\e[44mDownloading the master snapshot if its updated\e[0m"
	wget -c -N https://releases.liferay.com/portal/snapshot-master/latest/liferay-portal-tomcat-master.7z -P $cwd/bundles/master
	echo -e "\e[44mDone downloading or checking\e[0m"

# Extract the new bundle and make two copies
	echo -e "\e[44mDeleting old bundle if it exists\e[0m"
	rm -rf $cwd/bundles/master/liferay-portal-master
	echo -e "\e[44mExtracting the master bundle\e[0m"
	7z x $cwd/bundles/master/liferay-portal-tomcat-master.7z -O$cwd/bundles/master
	echo -e "\e[44mCopying it over to the working directory [$cwd]/node-1\e[0m"
	cp -r $cwd/bundles/master/liferay-portal-master/* $cwd/node-1
	echo -e "\e[44mCopying it over to the working directory [$cwd]/node-2\e[0m"
	cp -r $cwd/bundles/master/liferay-portal-master/* $cwd/node-2
	echo -e "\e[44mCopying properties for node-1\e[0m"
	cp -r $cwd/resources/single-cluster-ext.properties $cwd/node-1/portal-ext.properties
	echo -e "\e[44mCopying properties for node-2\e[0m"
	cp -r $cwd/resources/single-cluster-ext.properties $cwd/node-2/portal-ext.properties

# Replace server.xml on live
	echo -e "\e[44mReplacing server.xml on node-2.\e[0m"
	rm -rf $cwd/node-2/tomcat-9.0.17/conf/server.xml
	cp -r $cwd/resources/server.xml $cwd/node-2/tomcat-9.0.17/conf

# Prepare databases master-staged and master-live
	echo -e "\e[44mPreparing database for the cluster\e[0m"
	mysql -e "DROP DATABASE if exists lportal; create database lportal character set utf8;"

# Prepare nodes to use a remote elastic search cluster
	echo -e "\e[44mPreparing the nodes to use remote elastic search\e[0m"
	echo -e "\e[44mCopying configs into osgi/configs for both nodes\e[0m"
	cp -r $cwd/resources/com.liferay.portal.search.elasticsearch6.configuration.ElasticsearchConfiguration.config $cwd/node-1/osgi/configs/com.liferay.portal.search.elasticsearch6.configuration.ElasticsearchConfiguration.config
	cp -r $cwd/resources/com.liferay.portal.search.elasticsearch6.configuration.ElasticsearchConfiguration.config $cwd/node-2/osgi/configs/com.liferay.portal.search.elasticsearch6.configuration.ElasticsearchConfiguration.config
	echo -e "\e[44mExtracting elastic search server into [$cwd]/elasticsearch-6.5.4\e[0m"
	cp -r $cwd/resources/elasticsearch-6.5.4 $cwd/elasticsearch-6.5.4

#Delete the osgi/state folder
	echo -e "\e[44mDeleting the osgi/state folder on node-1\e[0m"
	rm -rf $cwd/node-1/osgi/state
	echo -e "\e[44mDeleting the osgi/state folder on node-2\e[0m"
	rm -rf $cwd/node-2/osgi/state

	echo -e "\e[44mThe bundle is ready for testing.\e[0m"
	echo -e "\e[44mYou are on Githash: $(cat node-1/tomcat-9.0.17/.githash)\e[0m"
	echo -e "\e[44mTo start elastic search run /elasticsearch-6.5.4/bin/elasticsearch\e[0m"
	notify-send "The bundle is ready for testing! Start both node-1 and node-2 concurrently."
}

createdb ()
{
	read -p "Enter database name [lportal]: " db_name
	db_name=${db_name:-lportal}
	echo -e "\e[44mOkay! I will drop $db_name and recreate it.\e[0m"
	mysql -e "create database $db_name character set utf8;"
}

dl71 ()
{
# Clean out old copy
	echo -e "\e[44mCleaning out old extracted binaries/folders\e[0m"
	rm -rf $cwd/bundles/7.1.x/liferay-ce-portal-7.1.2-ga3
	rm -rf $cwd/7.1-ga3

# Create directories that will be used
	echo -e "\e[44mCreating folders for bundle backup if they don't exist\e[0m"
	mkdir -p bundles/7.1.x
	mkdir -p 7.1-ga3

# Check if 7.1-ga3 has already been downloaded and if so, download it
	echo -e "\e[44mChecking if 7.1 GA3 was already downloaded\e[0m"

	DIRECTORY=$cwd/bundles/7.1.x/liferay-ce-portal-7.1.2-ga3
	if [[ -d "$DIRECTORY" ]]; then
		echo -e "\e[44mFound a copy of 7.1 GA3. Copying it to the working directory $cwd/7.1-ga3\e[0m"
	else
		echo -e "\e[44mDownloading the 7.1 GA3 because it wasn't found\e[0m"
		wget -c -N https://releases.liferay.com/portal/7.1.2-ga3/liferay-ce-portal-tomcat-7.1.2-ga3-20190107144105508.7z -P $cwd/bundles/7.1.x
		echo -e "\e[44mDone downloading or checking\e[0m"
# Extract the new bundle
		echo -e "\e[44mDeleting old bundle if it exists\e[0m"
		rm -rf $cwd/bundles/7.1.x/liferay-ce-portal-7.1.2-ga3
		echo -e "\e[44mExtracting the 7.1 GA3 bundle\e[0m"
		7z x $cwd/bundles/7.1.x/liferay-ce-portal-tomcat-7.1.2-ga3-20190107144105508.7z -O$cwd/bundles/7.1.x
	fi
	echo -e "\e[44mCopying it over to the working directory [$cwd]/7.1-ga3\e[0m"
	cp -r $cwd/bundles/7.1.x/liferay-ce-portal-7.1.2-ga3/* $cwd/7.1-ga3
	echo -e "\e[44mCopying a basic portal-ext.properties over\e[0m"
	cp -r $cwd/resources/portal-ext.properties $cwd/7.1-ga3

#Delete the osgi/state folder
	echo -e "\e[44mDeleting the osgi/state folder\e[0m"
	rm -rf $cwd/7.1-ga3/osgi/state
	echo -e "\e[44mThe bundle is ready for testing.\e[0m"
	notify-send "The bundle is ready for testing!\e[0m"
}

dl71x ()
{
# Clean out old copy
	echo -e "\e[44mCleaning out old extracted binaries/folders\e[0m"
	rm -rf $cwd/bundles/7.1.x/liferay-portal-7.1.x
	rm -rf $cwd/7.1.x

# Create directories that will be used
	echo -e "\e[44mCreating folders for bundle backup if they don't exist\e[0m"
	mkdir -p bundles/7.1.x
	mkdir -p 7.1.x

# Check if 7.1.x has already been downloaded and if so, download it
	echo -e "\e[44mChecking if 7.1.x was already downloaded\e[0m"

	DIRECTORY=$cwd/bundles/7.1.x/liferay-portal-tomcat-7.1.x
	if [[ -d "$DIRECTORY" ]]; then
		echo -e "\e[44mFound a copy of 7.1.x. Copying it to the working directory $cwd/7.1.x\e[0m"
	else
		echo -e "\e[44mDownloading the 7.1.x because it wasn't found\e[0m"
		wget -c -N https://releases.liferay.com/portal/snapshot-7.1.x/latest/liferay-portal-tomcat-7.1.x.7z -P $cwd/bundles/7.1.x
		echo -e "\e[44mDone downloading or checking\e[0m"
# Extract the new bundle
		echo -e "\e[44mDeleting old bundle if it exists\e[0m"
		rm -rf $cwd/bundles/7.1.x/liferay-portal-tomcat-7.1.x
		echo -e "\e[44mExtracting the 7.1.x bundle\e[0m"
		7z x $cwd/bundles/7.1.x/liferay-portal-tomcat-7.1.x.7z -O$cwd/bundles/7.1.x
	fi
	echo -e "\e[44mCopying it over to the working directory [$cwd]/7.1.x\e[0m"
	cp -r $cwd/bundles/7.1.x/liferay-portal-7.1.x/* $cwd/7.1.x
	echo -e "\e[44mCopying a basic portal-ext.properties over\e[0m"
	cp -r $cwd/resources/portal-ext.properties $cwd/7.1.x

#Delete the osgi/state folder
	echo -e "\e[44mDeleting the osgi/state folder\e[0m"
	rm -rf $cwd/7.1.x/osgi/state
	echo -e "\e[44mThe bundle is ready for testing.\e[0m"
	notify-send "The bundle is ready for testing!\e[0m"
}

dlmaster ()
{
# Clean out old copy
	echo -e "\e[44mCleaning out old extracted binaries/folders\e[0m"
	rm -rf $cwd/bundles/master/liferay-portal-master
	rm -rf $cwd/master

# Create directories that will be used
	echo -e "\e[44mCreating folders for bundle backup if they don't exist\e[0m"
	mkdir -p bundles/master
	mkdir -p master

# Check if a new master snapshot exists and if so, download it
	echo -e "\e[44mDownloading the master snapshot if its updated\e[0m"
	wget -c -N https://releases.liferay.com/portal/snapshot-master/latest/liferay-portal-tomcat-master.7z -P $cwd/bundles/master
	echo -e "\e[44mDone downloading or checking\e[0m"


# Extract the new bundle
	echo -e "\e[44mDeleting old bundle if it exists\e[0m"
	rm -rf $cwd/bundles/master/liferay-portal-master
	echo -e "\e[44mExtracting the master bundle\e[0m"
	7z x $cwd/bundles/master/liferay-portal-tomcat-master.7z -O$cwd/bundles/master
	echo -e "\e[44mCopying it over to the working directory [$cwd]/master\e[0m"
	cp -r $cwd/bundles/master/liferay-portal-master/* $cwd/master
	echo -e "\e[44mCopying a basic portal-ext.properties over\e[0m"
	cp -r $cwd/resources/portal-ext.properties $cwd/master

#Delete the osgi/state folder
	echo -e "\e[44mDeleting the osgi/state folder\e[0m"
	rm -rf $cwd/master/osgi/state
	echo -e "\e[44mThe bundle is ready for testing.\e[0m"
	echo -e "\e[44mYou are on Githash: $(cat master/tomcat-9.0.17/.githash)\e[0m"
	notify-send "The bundle is ready for testing!"
}

mastertopublic ()
{
# Delete old bundle if it exists
	echo -e "\e[44mDeleting old bundle\e[0m"
	rm -rf $cwd/../public/bundles

# Move master bundle to public folder
	echo -e "\e[44mMoving bundle to public\e[0m"
	mv $cwd/../master $cwd/../public/bundles
}

rstaging ()
{
# Clean out old copy
	echo -e "\e[44mCleaning out old extracted binaries/folders\e[0m"
	rm -rf $cwd/bundles/master/liferay-portal-master
	rm -rf $cwd/master-live
	rm -rf $cwd/master-staged

# Create directories that will be used
	echo -e "\e[44mCreating folders for bundle backup if they don't exist\e[0m"
	mkdir -p bundles/master
	mkdir -p master-staged
	mkdir -p master-live

# Check if a new master snapshot exists and if so, download it
	echo -e "\e[44mDownloading the master snapshot if its updated\e[0m"
	wget -c -N https://releases.liferay.com/portal/snapshot-master/latest/liferay-portal-tomcat-master.7z -P $cwd/bundles/master
	echo -e "\e[44mDone downloading or checking\e[0m"

# Extract the new bundle and make two copies
	echo -e "\e[44mDeleting old bundle if it exists\e[0m"
	rm -rf $cwd/bundles/master/liferay-portal-master
	echo -e "\e[44mExtracting the master bundle\e[0m"
	7z x $cwd/bundles/master/liferay-portal-tomcat-master.7z -O$cwd/bundles/master
	echo -e "\e[44mCopying it over to the working directory [$cwd]/master-staged\e[0m"
	cp -r $cwd/bundles/master/liferay-portal-master/* $cwd/master-staged
	echo -e "\e[44mCopying it over to the working directory [$cwd]/master-live\e[0m"
	cp -r $cwd/bundles/master/liferay-portal-master/* $cwd/master-live
	echo -e "\e[44mCopying properties for staged\e[0m"
	cp -r $cwd/resources/staged-ext.properties $cwd/master-staged/portal-ext.properties
	echo -e "\e[44mCopying properties for live\e[0m"
	cp -r $cwd/resources/live-ext.properties $cwd/master-live/portal-ext.properties

# Replace server.xml on live
	echo -e "\e[44mReplacing server.xml on master-live.\e[0m"
	rm -rf $cwd/master-live/tomcat-9.0.17/conf/server.xml
	cp -r $cwd/resources/server.xml $cwd/master-live/tomcat-9.0.17/conf

#Delete the osgi/state folder
	echo -e "\e[44mDeleting the osgi/state folder on live\e[0m"
	rm -rf $cwd/master-live/osgi/state
	echo -e "\e[44mDeleting the osgi/state folder on staged\e[0m"
	rm -rf $cwd/master-staged/osgi/state

# Prepare databases master-staged and master-live
	echo -e "\e[44mPreparing databases master-staged and master-live\e[0m"
	mysql -e "DROP DATABASE if exists master_staged; create database master_staged character set utf8;"
	mysql -e "DROP DATABASE if exists master_live; create database master_live character set utf8;"
	echo -e "\e[44mThe bundle is ready for testing.\e[0m"
	echo -e "\e[44mYou are on Githash: $(cat master-staged/tomcat-9.0.17/.githash)\e[0m"
	notify-send "The bundle is ready for testing!"
}

testproperties ()
{
# Clean out old copy
	echo -e "\e[44mCleaning out old properties files\e[0m"
	rm -rf $cwd/../public/master-portal/test.liferay.properties
	rm -rf $cwd/../private/7.1.x-portal/test.liferay.properties
	rm -rf $cwd/../private/7.0.x-portal/test.liferay.properties

# Add new test.liferay.properties files
	echo -e "\e[44mCopying to master\e[0m"
	cp -r $cwd/resources/test.liferay.properties $cwd/../public/master-portal
	echo -e "\e[44mCopying to 7.1.x\e[0m"
	cp -r $cwd/resources/test.liferay.properties $cwd/../private/7.1.x-portal
	echo -e "\e[44mCopying to 7.0.x\e[0m"
	cp -r $cwd/resources/test.liferay.properties $cwd/../private/7.0.x-portal
	echo -e "\e[44mReady for testing!\e[0m"
}

#### Help documentation

usage ()
{
	cat <<HELP_USAGE


	$0 <parameter>

	Parameters
	----------

	71toprivate        - Move 7.1.x bundle to private folder
	clean              - Deletes everything except bundles, resources and setup.sh
	cleandb            - Cleans the database if it already exists
	cleanmaster        - Doesn't download, just cleans up completely
	cluster		       - Sets up a clean 2 cluster node
	createdb           - Creates the database
	dl71               - Downloads the 7.1 CE GA3
	dl71x              - Downloads the latest 7.1.x
	dlmaster           - Downloads the latest master
	mastertopublic     - Move master bundle to public folder
	rstaging           - Sets up remote staging where remote is 8080 and live is 9080
	testproperties     - Deploys test.liferay.properties


HELP_USAGE
}

#### Check if no parameters are sent

if [ $# -eq 0 ]
  then
    usage
fi

#### Accepts Parameters
for setupParameters in "$@"
do
    $setupParameters
done