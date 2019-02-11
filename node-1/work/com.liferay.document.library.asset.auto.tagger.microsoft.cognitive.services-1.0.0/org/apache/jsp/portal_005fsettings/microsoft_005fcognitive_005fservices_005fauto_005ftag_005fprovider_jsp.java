package org.apache.jsp.portal_005fsettings;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.liferay.document.library.asset.auto.tagger.microsoft.cognitive.services.internal.configuration.MSCognitiveServicesAssetAutoTagProviderCompanyConfiguration;
import com.liferay.document.library.asset.auto.tagger.microsoft.cognitive.services.internal.constants.MSCognitiveServicesAssetAutoTagProviderConstants;
import com.liferay.document.library.asset.auto.tagger.microsoft.cognitive.services.internal.constants.PortalSettingsMSCognitiveServicesAssetAutoTagProviderConstants;
import com.liferay.portal.kernel.language.LanguageUtil;
import javax.portlet.ActionRequest;

public final class microsoft_005fcognitive_005fservices_005fauto_005ftag_005fprovider_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/init.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_input_value_name_label_id_helpMessage_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_liferay$1frontend_defineObjects_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_input_value_type_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_aui_input_value_type_name_label_id_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_aui_input_value_name_label_id_helpMessage_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_liferay$1frontend_defineObjects_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_input_value_type_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_aui_input_value_type_name_label_id_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_aui_input_value_name_label_id_helpMessage_nobody.release();
    _jspx_tagPool_liferay$1frontend_defineObjects_nobody.release();
    _jspx_tagPool_aui_input_value_type_name_nobody.release();
    _jspx_tagPool_aui_input_value_type_name_label_id_nobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      out.write('\n');
      out.write("\n\n\n\n\n\n\n\n");
      //  liferay-frontend:defineObjects
      com.liferay.frontend.taglib.servlet.taglib.DefineObjectsTag _jspx_th_liferay$1frontend_defineObjects_0 = (com.liferay.frontend.taglib.servlet.taglib.DefineObjectsTag) _jspx_tagPool_liferay$1frontend_defineObjects_nobody.get(com.liferay.frontend.taglib.servlet.taglib.DefineObjectsTag.class);
      _jspx_th_liferay$1frontend_defineObjects_0.setPageContext(_jspx_page_context);
      _jspx_th_liferay$1frontend_defineObjects_0.setParent(null);
      int _jspx_eval_liferay$1frontend_defineObjects_0 = _jspx_th_liferay$1frontend_defineObjects_0.doStartTag();
      if (_jspx_th_liferay$1frontend_defineObjects_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_liferay$1frontend_defineObjects_nobody.reuse(_jspx_th_liferay$1frontend_defineObjects_0);
        return;
      }
      _jspx_tagPool_liferay$1frontend_defineObjects_nobody.reuse(_jspx_th_liferay$1frontend_defineObjects_0);
      java.lang.String currentURL = null;
      javax.portlet.PortletURL currentURLObj = null;
      java.lang.String npmResolvedPackageName = null;
      java.util.ResourceBundle resourceBundle = null;
      javax.portlet.WindowState windowState = null;
      currentURL = (java.lang.String) _jspx_page_context.findAttribute("currentURL");
      currentURLObj = (javax.portlet.PortletURL) _jspx_page_context.findAttribute("currentURLObj");
      npmResolvedPackageName = (java.lang.String) _jspx_page_context.findAttribute("npmResolvedPackageName");
      resourceBundle = (java.util.ResourceBundle) _jspx_page_context.findAttribute("resourceBundle");
      windowState = (javax.portlet.WindowState) _jspx_page_context.findAttribute("windowState");
      out.write('\n');
      out.write('\n');

MSCognitiveServicesAssetAutoTagProviderCompanyConfiguration MSCognitiveServicesAssetAutoTagProviderCompanyConfiguration = (MSCognitiveServicesAssetAutoTagProviderCompanyConfiguration)request.getAttribute(MSCognitiveServicesAssetAutoTagProviderCompanyConfiguration.class.getName());

      out.write('\n');
      out.write('\n');
      //  aui:input
      com.liferay.taglib.aui.InputTag _jspx_th_aui_input_0 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_value_type_name_nobody.get(com.liferay.taglib.aui.InputTag.class);
      _jspx_th_aui_input_0.setPageContext(_jspx_page_context);
      _jspx_th_aui_input_0.setParent(null);
      _jspx_th_aui_input_0.setName( ActionRequest.ACTION_NAME );
      _jspx_th_aui_input_0.setType("hidden");
      _jspx_th_aui_input_0.setValue(new String("/portal_settings/document_library_asset_auto_tagger_microsoft_cognitive_services"));
      int _jspx_eval_aui_input_0 = _jspx_th_aui_input_0.doStartTag();
      if (_jspx_th_aui_input_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_0);
        return;
      }
      _jspx_tagPool_aui_input_value_type_name_nobody.reuse(_jspx_th_aui_input_0);
      out.write('\n');
      out.write('\n');
      //  aui:input
      com.liferay.taglib.aui.InputTag _jspx_th_aui_input_1 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_value_type_name_label_id_nobody.get(com.liferay.taglib.aui.InputTag.class);
      _jspx_th_aui_input_1.setPageContext(_jspx_page_context);
      _jspx_th_aui_input_1.setParent(null);
      _jspx_th_aui_input_1.setId("enabled");
      _jspx_th_aui_input_1.setLabel("enabled");
      _jspx_th_aui_input_1.setName( PortalSettingsMSCognitiveServicesAssetAutoTagProviderConstants.FORM_PARAMETER_NAMESPACE + "enabled" );
      _jspx_th_aui_input_1.setType("checkbox");
      _jspx_th_aui_input_1.setValue( MSCognitiveServicesAssetAutoTagProviderCompanyConfiguration.enabled() );
      int _jspx_eval_aui_input_1 = _jspx_th_aui_input_1.doStartTag();
      if (_jspx_th_aui_input_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_aui_input_value_type_name_label_id_nobody.reuse(_jspx_th_aui_input_1);
        return;
      }
      _jspx_tagPool_aui_input_value_type_name_label_id_nobody.reuse(_jspx_th_aui_input_1);
      out.write('\n');
      out.write('\n');
      //  aui:input
      com.liferay.taglib.aui.InputTag _jspx_th_aui_input_2 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_value_name_label_id_helpMessage_nobody.get(com.liferay.taglib.aui.InputTag.class);
      _jspx_th_aui_input_2.setPageContext(_jspx_page_context);
      _jspx_th_aui_input_2.setParent(null);
      _jspx_th_aui_input_2.setHelpMessage( LanguageUtil.format(resourceBundle, "api-key-description", new String[] {MSCognitiveServicesAssetAutoTagProviderConstants.API_KEY_DOCS_URL}, false) );
      _jspx_th_aui_input_2.setId("api-key");
      _jspx_th_aui_input_2.setLabel("api-key");
      _jspx_th_aui_input_2.setName( PortalSettingsMSCognitiveServicesAssetAutoTagProviderConstants.FORM_PARAMETER_NAMESPACE + "apiKey" );
      _jspx_th_aui_input_2.setValue( MSCognitiveServicesAssetAutoTagProviderCompanyConfiguration.apiKey() );
      int _jspx_eval_aui_input_2 = _jspx_th_aui_input_2.doStartTag();
      if (_jspx_th_aui_input_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_aui_input_value_name_label_id_helpMessage_nobody.reuse(_jspx_th_aui_input_2);
        return;
      }
      _jspx_tagPool_aui_input_value_name_label_id_helpMessage_nobody.reuse(_jspx_th_aui_input_2);
      out.write('\n');
      out.write('\n');
      //  aui:input
      com.liferay.taglib.aui.InputTag _jspx_th_aui_input_3 = (com.liferay.taglib.aui.InputTag) _jspx_tagPool_aui_input_value_name_label_id_helpMessage_nobody.get(com.liferay.taglib.aui.InputTag.class);
      _jspx_th_aui_input_3.setPageContext(_jspx_page_context);
      _jspx_th_aui_input_3.setParent(null);
      _jspx_th_aui_input_3.setHelpMessage( LanguageUtil.format(resourceBundle, "api-endpoint-description", new String[] {MSCognitiveServicesAssetAutoTagProviderConstants.SAMPLE_API_ENDPOINT, MSCognitiveServicesAssetAutoTagProviderConstants.API_KEY_DOCS_URL}, false) );
      _jspx_th_aui_input_3.setId("api-endpoint");
      _jspx_th_aui_input_3.setLabel("api-endpoint");
      _jspx_th_aui_input_3.setName( PortalSettingsMSCognitiveServicesAssetAutoTagProviderConstants.FORM_PARAMETER_NAMESPACE + "apiEndpoint" );
      _jspx_th_aui_input_3.setValue( MSCognitiveServicesAssetAutoTagProviderCompanyConfiguration.apiEndpoint() );
      int _jspx_eval_aui_input_3 = _jspx_th_aui_input_3.doStartTag();
      if (_jspx_th_aui_input_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_aui_input_value_name_label_id_helpMessage_nobody.reuse(_jspx_th_aui_input_3);
        return;
      }
      _jspx_tagPool_aui_input_value_name_label_id_helpMessage_nobody.reuse(_jspx_th_aui_input_3);
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
