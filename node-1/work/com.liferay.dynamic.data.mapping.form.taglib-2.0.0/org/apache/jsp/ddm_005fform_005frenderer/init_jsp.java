package org.apache.jsp.ddm_005fform_005frenderer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.liferay.portal.json.JSONFactoryImpl;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.liferay.dynamic.data.mapping.exception.NoSuchFormInstanceException;
import com.liferay.dynamic.data.mapping.exception.NoSuchStructureException;
import com.liferay.dynamic.data.mapping.exception.NoSuchStructureLayoutException;
import com.liferay.dynamic.data.mapping.form.renderer.DDMFormRenderingException;
import com.liferay.dynamic.data.mapping.model.DDMFormInstance;
import com.liferay.dynamic.data.mapping.validator.DDMFormValuesValidationException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import java.util.Locale;
import java.util.ResourceBundle;

public final class init_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


private static ArrayList<Object> _toArrayList(Object obj) {
	return (ArrayList<Object>)_deserialize(obj);
}

private static HashMap<String, Object> _toHashMap(Object obj) {
	return (HashMap<String, Object>)_deserialize(obj);
}

public static void _initJSONFactoryUtil() {
	if (JSONFactoryUtil.getJSONFactory() == null) {
		(new JSONFactoryUtil()).setJSONFactory(new JSONFactoryImpl());
	}
}

private static Object _deserialize(Object obj) {
	if (obj != null) {
		String json = JSONFactoryUtil.looseSerialize(obj);

		json = StringUtil.unquote(json);

		return JSONFactoryUtil.looseDeserialize(json);
	}

	return null;
}

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/init.jsp");
    _jspx_dependants.add("/ddm_form_renderer/init-ext.jspf");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      out.write("\n\n\n\n\n\n");
      out.write('\n');
      out.write('\n');

_initJSONFactoryUtil();

      out.write('\n');
      out.write('\n');

java.lang.Long ddmFormInstanceId = GetterUtil.getLong(String.valueOf(request.getAttribute("liferay-form:ddm-form-renderer:ddmFormInstanceId")));
java.lang.Long ddmFormInstanceRecordId = GetterUtil.getLong(String.valueOf(request.getAttribute("liferay-form:ddm-form-renderer:ddmFormInstanceRecordId")));
java.lang.Long ddmFormInstanceRecordVersionId = GetterUtil.getLong(String.valueOf(request.getAttribute("liferay-form:ddm-form-renderer:ddmFormInstanceRecordVersionId")));
java.lang.Long ddmFormInstanceVersionId = GetterUtil.getLong(String.valueOf(request.getAttribute("liferay-form:ddm-form-renderer:ddmFormInstanceVersionId")));
java.lang.String namespace = GetterUtil.getString((java.lang.String)request.getAttribute("liferay-form:ddm-form-renderer:namespace"));
boolean showFormBasicInfo = GetterUtil.getBoolean(String.valueOf(request.getAttribute("liferay-form:ddm-form-renderer:showFormBasicInfo")), true);
boolean showSubmitButton = GetterUtil.getBoolean(String.valueOf(request.getAttribute("liferay-form:ddm-form-renderer:showSubmitButton")), true);
Map<String, Object> dynamicAttributes = (Map<String, Object>)request.getAttribute("liferay-form:ddm-form-renderer:dynamicAttributes");

      out.write('\n');
      out.write('\n');
      out.write("\n\n\n\n\n\n\n\n\n\n");

String ddmFormHTML = (String)request.getAttribute("liferay-form:ddm-form-renderer:ddmFormHTML");
DDMFormInstance ddmFormInstance = (DDMFormInstance)request.getAttribute("liferay-form:ddm-form-renderer:ddmFormInstance");
boolean hasAddFormInstanceRecordPermission = GetterUtil.getBoolean(request.getAttribute("liferay-form:ddm-form-renderer:hasAddFormInstanceRecordPermission"));
boolean hasViewFormInstancePermission = GetterUtil.getBoolean(request.getAttribute("liferay-form:ddm-form-renderer:hasViewFormInstancePermission"));
boolean isFormAvailable = GetterUtil.getBoolean(request.getAttribute("liferay-form:ddm-form-renderer:isFormAvailable"));
String languageId = (String)request.getAttribute("liferay-form:ddm-form-renderer:languageId");
String redirectURL = (String)request.getAttribute("liferay-form:ddm-form-renderer:redirectURL");
ResourceBundle resourceBundle = (ResourceBundle)request.getAttribute("liferay-form:ddm-form-renderer:resourceBundle");

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
