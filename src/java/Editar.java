/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fer
 */

public class Editar extends HttpServlet {

        
    //variables globales
    private Connection con;
    private Statement set;
    private ResultSet rs;
    
    //constructor del servlet
    //nos va a ayudar a inicializar la conexion con la base de datos
    
    public void init(ServletConfig cfg) throws ServletException{
        //lo primero que necesitamos es trazar la ruta al servidor de la bd
        String URL = "jdbc:mysql://us-cdbr-east-03.cleardb.com/heroku_227d7237f19c8f4";
        //driver:gestor:puerto//ip/nombreBD
        String userName = "b44bfb41dfa2d9";
        String password = "e06e1848";
                
        try{
            //colocamos el tipo de driver
            Class.forName("com.mysql.jdbc.Driver");
            
            /*
            en algunas ocaciones enviar error al conectarse con la bd
            y eso se debe a que ya estegrado el puerto en el driver
            URL = "jdbc:mysql://localhost/registro4iv8";
            */
            URL = "jdbc:mysql://us-cdbr-east-03.cleardb.com/heroku_227d7237f19c8f4";
            con = DriverManager.getConnection(URL, userName, password);
            set = con.createStatement();
            System.out.println("Conexion exitosa");
        
        }catch(Exception e){
            
            System.out.println("Conexion no exitosa");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        
        }
    }
    /*
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
                    String nomb, appa, apma, passwor, birt, domicili, te, ce;
                    int ida, eda, idac;
                    
                    ida = Integer.parseInt(request.getParameter("id_editar")); 

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<script src=\"js/validacion.js\"></script>");
            out.println("<title>Consultar Sesion</title>"
+"<meta charset='UTF-8'>" 
+"<meta http-equiv='X-UA-Compatible' content='IE=edge'>" 
+"<meta name='viewport' content='width=device-width', initial-scale='1.0'>" 
+"<script src='https://kit.fontawesome.com/1ff3fcc7d1.js' crossorigin='anonymous'></script>");
                
            out.println("</head>");

            
            out.println("<body style=\"background-image: url('css/img/89-892560_ice-cream-images-hd.jpg');\">");
      
                   out.println("<style>"
                           + "body{\n" +
"    margin: 0;\n" +
"    padding: 0;\n" +
"    font-family: sans-serif;\n" +
"    background-image: url(css/img/89-892560_ice-cream-images-hd.jpg), linear-gradient(rgba(29, 29, 29, 1) 0%, rgba(29, 29, 29, 1) 100%) ;\n" +
"    background-size: cover;\n" +
"}\n" +
".login-box{\n" +
"    width: 400px;\n" +
"    position: absolute;\n" +
"    top: 50%;\n" +
"    left: 50%;\n" +
"    transform: translate(-50%,-50%);\n" +
"    color: white;\n" +
"}\n" +
".login-box h1{\n" +
"    float: left;\n" +
"    font-size: 40px;\n" +
"    border-bottom: 6px solid rgb(0, 225, 255);\n" +
"    margin-bottom: 50px;\n" +
"}\n" +
".textbox{\n" +
"    width: 100%;\n" +
"    overflow: hidden;\n" +
"    font-size: 20px;\n" +
"    padding: 8px 0;\n" +
"    margin: 8px 0;\n" +
"    border-bottom: 1px solid rgb(0, 225, 255); \n" +
"}\n" +
".textbox i{\n" +
"    width: 26px;\n" +
"    float: left;\n" +
"    text-align: center;\n" +
"}\n" +
".textbox input{\n" +
"    border: none;\n" +
"    outline: none;\n" +
"    background: none;\n" +
"    color: rgb(255, 255, 255);\n" +
"    font-size: 18px;\n" +
"    width: 80%;\n" +
"    float: left;\n" +
"    margin: 0 10px;\n" +
"}\n" +
".boton{\n" +
"    width: 100%;\n" +
"    background: none;\n" +
"    border: 2px solid rgb(0, 225, 255);\n" +
"    border-radius: 3px;\n" +
"    color: white;\n" +
"    margin-top: 10px;\n" +
"    font-size: 18px;\n" +
"}\n" +
".boton:hover{\n" +
"    background-color: rgb(0, 225, 255);\n" +
"}\n" +
".textbox p{\n" +
"    font-size: 10px;\n" +
"}"
                                    
                                    + "</style>");  
            out.println("<div class=\"login-box\">");       
            out.println("<h1 style=\"padding-top: 10%;\">Mis datos</h1>");
            out.println("<br>"
                    + "<hr>");
            
            out.println("<table id = 'tabla' border='2'>"
                    + "<thead>"
                        + "<tr><th>ID</th>"
                        + "<th>Nombre Completo</th>"
                        + "<th>Edad</th>"
                        + "<th>Contraseña</th>"
                        + "<th>Fecha de nacimiento</th>"
                        + "<th>Domicilio</th>"
                        + "<th>Telefono</th>"
                        + "<th>Celular</th></tr>"
                    + "</thead>");
            
            try{   
            
                
                //mostramos los datos de el id del usuario ingresado en el index
                String q = "select * from heladeriaschalco where id_usu="+ida;
                set=con.createStatement();
                rs=set.executeQuery(q);
                while(rs.next()){
                    idac = rs.getInt("id_usu");
                    nomb = rs.getString("nom_usu");
                    appa = rs.getString("appat_usu");
                    apma = rs.getString("apmat_usu");
                    eda = rs.getInt("edad_usu");
                    passwor = rs.getString("password_usu");
                    birt = rs.getString("birth_usu");
                    domicili = rs.getString("domicilio_usu");
                    te = rs.getString("tel_usu");
                    ce = rs.getString("cel_usu");
                    out.println("<tbody>"
                            + "<tr><td>"+idac+"</td>"
                            + "<td>"+nomb+" "+appa+" "+apma+"</td>"
                            + "<td>"+eda+"</td>"
                            + "<td>"+passwor+"</td>"
                            + "<td>"+birt+"</td>"
                            + "<td>"+domicili+"</td>"
                            + "<td>"+te+"</td>"
                            + "<td>"+ce+"</td></tr>"
                            + "</tbody>");
                }  
            }catch(Exception e){
                System.out.println("Consulta no exitosa");
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
            }
            
            out.println("</table>"+
            
            
"        <h1>Nuevos datos</h1>\n" +
"        <form name=\"formulario\" method=\"get\" action=\"editarUsuario\" onsubmit=\"return validarRegistro(this)\">\n"
        + "<div class=\"textbox\">\n" +
"            <i class=\"fas fa-user\"></i>\n" +                    
"            <input type=\"number\" size=\"10\" required placeholder=\"ID\" name=\"id_ediusu\" value=\"\">\n" +
"        </div>"+
"            \n" +
"            <div class=\"textbox\">\n" +
"            <i class=\"fas fa-user\"></i>\n" +
"            <input type=\"text\" placeholder=\"Nombre\" name=\"nombre_ediusu\" required>\n" +
"            </div>\n" +
"            \n" +
"            <div class=\"textbox\">\n" +
"            <i class=\"fas fa-male\"></i>\n" +
"            <input type=\"text\" placeholder=\"Apellido Paterno\" name=\"appat_ediusu\" required>\n" +
"            </div>\n" +
"            \n" +
"            <div class=\"textbox\">\n" +
"            <i class=\"fas fa-female\"></i>\n" +
"            <input type=\"text\" placeholder=\"Apellido Materno\" name=\"apmat_ediusu\" required>\n" +
"            </div>\n" +
"            \n" +
"            <div class=\"textbox\">\n" +
"            <i class=\"fas fa-user-lock\"></i>\n" +
"            <input type=\"password\" placeholder=\"Contraseña\" name=\"password_ediusu\" required>\n" +
"            </div>\n" +
"            \n" +
"            <div class=\"textbox\">\n" +
"            <i class=\"fas fa-sort-numeric-up-alt\"></i>\n" +
"            <input type=\"number\" placeholder=\"Edad\" name=\"edad_ediusu\" min=\"01\" max=\"99\" size=\"2\" required>\n" +
"            </div>\n" +
"            \n" +
"            <div class=\"textbox\">\n" +
"            <p>Por ejemplo, escriba 27 de mayo del 2004 como \"27052004\"</p>\n" +
"            <i class=\"fas fa-calendar-alt\"></i>\n" +
"            <input type=\"text\" name=\"birth_ediusu\" placeholder=\"Fecha de Nacimiento\" required onkeypress=\"return validarn(event)\">\n" +
"            </div>\n" +
"            \n" +
"            <div class=\"textbox\">\n" +
"            <i class=\"fas fa-house-user\"></i>\n" +
"            <input type=\"text\" placeholder=\"Domicilio\" name=\"domicilio_ediusu\" required>\n" +
"            </div>\n" +
"            \n" +
"            <div class=\"textbox\">\n" +
"            <i class=\"fas fa-phone\"></i>\n" +
"            <input type=\"text\" placeholder=\"Teléfono\" name=\"tel_ediusu\" required>\n" +
"            </div>\n" +
"            \n" +
"            <div class=\"textbox\">\n" +
"            <i class=\"fas fa-mobile-alt\"></i>\n" +
"            <input type=\"text\" placeholder=\"Celular\" name=\"cel_ediusu\" required>\n" +
"            </div>\n" +
"            \n" +
"                <input type=\"submit\" value=\"Actualizar datos\" class=\"boton\">\n" +
"                <input type=\"reset\" value=\"Borrar Registro\" class=\"boton\">\n" +
"\n" +
"                <a href=\"Editar.html\"><input class=\"boton\" type=\"button\" name=\"Registro\" value=\"Regresar\"></a>\n" +
"            </form>");
       out.println("  <footer style=\"padding-top: 25px; font-size: 11px;\">\n" +
"      <ul>\n" +
"          <li>Carmona Aguilar Diego</li>\n" +
"          <li>Parra Rivas Arturo Gabriel</li>\n" +
"      </ul>\n" +
"  </footer> ");

            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    
    public void destroy(){
        try{
            con.close();
        }catch(Exception e){
            super.destroy();
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}