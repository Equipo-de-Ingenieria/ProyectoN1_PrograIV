package org.apache.jsp.public_002dviews;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.AccountType;
import services.AccountTypeService;
import java.util.List;
import model.Account;
import model.User;
import services.AccountService;

public final class movementDisplay_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Raleway&display=swap\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"../css/clientaccounts.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      model.User aux = null;
      synchronized (session) {
        aux = (model.User) _jspx_page_context.getAttribute("aux", PageContext.SESSION_SCOPE);
        if (aux == null){
          aux = new model.User();
          _jspx_page_context.setAttribute("aux", aux, PageContext.SESSION_SCOPE);
          out.write("\n");
          out.write("        ");
        }
      }
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"wrapper\">\n");
      out.write("            <div class=\"subwrapper\">\n");
      out.write("                <div class=\"menubar\">\n");
      out.write("                    <ul>\n");
      out.write("                        <li class=\"nombre\">");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((model.User)_jspx_page_context.findAttribute("aux")).getName())));
      out.write("</li>\n");
      out.write("                            <li><a href=\"clientaccounts.jsp\">Cuentas</a></li>\n");
      out.write("                            <li><a href=\"syncmenu.jsp\">Vinculacion de cuentas</a></li>\n");
      out.write("                            <li><a href=\"clienttransfermenu.jsp\">Transferencia remota</a></li>\n");
      out.write("                            <li><a href=\"movements.jsp\">Movimientos</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div> \n");
      out.write("\n");
      out.write("                    <div class=\"maincontents\">\n");
      out.write("                        <div class=\"containerBox\">         \n");
      out.write("                            <div class=\"containerTable\">\n");
      out.write("                                <table class =\"table\">\n");
      out.write("                                    <thead>\n");
      out.write("                                        <tr class=\"head\">\n");
      out.write("                                            <th class=\"column1\">Fecha</th>\n");
      out.write("                                            <th class=\"column2\">Débito</th>\n");
      out.write("                                            <th class=\"column3\">Crédito</th>\n");
      out.write("                                            <th class=\"column4\">Comprobante</th>\n");
      out.write("                                            <th class=\"column6\">Descripción</th>\n");
      out.write("                                        </tr>\n");
      out.write("                                    </thead>\n");
      out.write("\n");
      out.write("                                    <tbody>\n");
      out.write("\n");
      out.write("                                    ");

                                        List <model.Movement> movementsList =  (java.util.ArrayList <model.Movement>) request.getAttribute("movementsList");
                    
                                        
                                        int index = 0;
                                        for (int i = 1; i <= movementsList.size(); i++) {
                                            index = i - 1;

                                            out.println("<tr>");
                                            out.println(String.format("<td class=\"%s\">%s</td>", "column1", movementsList.get(index).getDate()));
                                            out.println(String.format("<td class=\"%s\">%f</td>", "column2", movementsList.get(index).getDebit()));
                                            out.println(String.format("<td class=\"%s\">%f</td>", "column3", movementsList.get(index).getCredit()));

                                            out.println(String.format("<td class=\"%s\">%d</td>", "column4", movementsList.get(index).getId()));
                                            out.println(String.format("<td class=\"%s\">%s</td>", "column6", movementsList.get(index).getDescription()));

                                        }

                                    
      out.write("\n");
      out.write("\n");
      out.write("                                </tbody>\n");
      out.write("                            </table>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
