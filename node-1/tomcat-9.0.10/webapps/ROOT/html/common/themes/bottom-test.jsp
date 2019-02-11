<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>

<%
String ppstate = ParamUtil.getString(request, "p_p_state", "normal");

if (ppstate.equals("normal")) {
%>

	<div class="alert alert-info" id="currentHead" style="margin: 2em">
		Commit: <a href="https://github.com/liferay/liferay-portal/commit/ef011e6017b96f4a4841bb5567a968c534c6da92" target="_blank">ef011e6017b96f4a4841bb5567a968c534c6da92</a><br />Updated on: Sun Feb 10 19:36:08 2019 -0800
	</div>

<%
}
%>