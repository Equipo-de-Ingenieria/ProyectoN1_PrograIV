package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.User;

public final class messege_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <link href=\"css/default.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Raleway&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Bank Crosaint</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    ");
      model.User aux = null;
      synchronized (session) {
        aux = (model.User) _jspx_page_context.getAttribute("aux", PageContext.SESSION_SCOPE);
        if (aux == null){
          aux = new model.User();
          _jspx_page_context.setAttribute("aux", aux, PageContext.SESSION_SCOPE);
          out.write("\r\n");
          out.write("    ");
        }
      }
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("        <div id=\"wrapper\">\r\n");
      out.write("            <div id=\"content\">\r\n");
      out.write("                <div id=\"menubar\">\r\n");
      out.write("                    <ul>\r\n");
      out.write("                        <li class=\"nombre\">");
      out.print( aux.getName());
      out.write("</li>\r\n");
      out.write("                        <li><a href=\"depositmenu.jsp\">Deposito</a></li>\r\n");
      out.write("                        <li><a href=\"retiremenu.jsp\">Retiro</a></li>\r\n");
      out.write("                        <li><a href=\"transfermenu.jsp\">Transferencias</a></li>\r\n");
      out.write("                        <li><a href=\"creditmenu.jsp\">Acreditacion</a></li>\r\n");
      out.write("                        <li><a href=\"accountopening.jsp\">Apertura de cuenta cliente</a></li>\r\n");
      out.write("                        <li><a href=\"usercreatemenu.jsp\">Apertura de usuario</a></li>\r\n");
      out.write("                        <li><a href=\"accountupdate.jsp\">Actualizar cuenta</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("                        ");

                            String message = (String)request.getAttribute("message");
                        
      out.write("\r\n");
      out.write("                        <div id =\"depositbox\">\r\n");
      out.write("                    <div class=\"depContainer\">\r\n");
      out.write("                        <form class=\"loginForm\" action=\"RetireServlet\">\r\n");
      out.write("                            <div class=\"box1\">\r\n");
      out.write("                                <span>\r\n");
      out.write("                                   ");
      out.print(message);
      out.write("\r\n");
      out.write("                                </span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </form>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div id=\"main\">\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
