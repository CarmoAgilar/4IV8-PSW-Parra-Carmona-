/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.servlet.ServletConfig;

/**
 *
 * @author crist
 */
public class editarUsuario extends HttpServlet {
    
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
            //tipo de driver
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(URL, userName, password);
            set = con.createStatement();
            System.out.println("Conexión exitosa");
        }catch(Exception e){
            System.out.println("Conexión no exitosa");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            //variables
            String nom, appat, domicilio, apmat, password, passwo, birth, tel, cel, ip, iph;
            int edad, puerto, puertoh, id;
                        
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Actualizar Usuario</title>");
            out.println("<link rel=\"stylesheet\" href=\"./CSS/style.css\">");
                            out.println("<link href=\'https://fonts.googleapis.com/css2?family=Lemonada:wght@300&family=Merriweather:ital@1&family=Montserrat:wght@500&display=swap\" rel=\"stylesheet\'>");

            out.println("</head>");
            out.println("<body style=\"background-image: url('css/img/89-892560_ice-cream-images-hd.jpg');\">");
                                    out.println("<style>"
                                    + ".table{\n"
                                    + "margin-right; 4 rem;\n"

                                    + "}\n"
                                    + "a{\n" +
                                    "  color: #58f0f0;\n" +
                                    "  font-family: 'Montserrat', sans-serif;\n" +
                                    "  text-decoration: none;\n" +
                                    "}\n" +
                                    "a:hover{\n" +
                                    "  color: #a0d5f3;\n" +
                                    "}"
                                    + ".boton{\n" +
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
                                    "}"
                                    + ".login-box{\n" +
                                        "    width: 500px;\n" +
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
                                        "}"
                                    
                                    + "</style>");
            out.println("<div class=\"login-box\">");
            out.println("<h1>Nuevos datos</h1>");
            out.println("<hr>");
            
                nom = request.getParameter("nombre_ediusu");
                appat = request.getParameter("appat_ediusu");
                apmat = request.getParameter("apmat_ediusu");
                passwo = request.getParameter("password_ediusu");
                edad = Integer.parseInt(request.getParameter("edad_ediusu"));
                id = Integer.parseInt(request.getParameter("id_ediusu"));
                domicilio = request.getParameter("domicilio_ediusu");
                birth = request.getParameter("birth_ediusu");
                tel = request.getParameter("tel_ediusu");
                cel = request.getParameter("cel_ediusu");
            try{
                //proceso para actualizar datos
                


                String qN="UPDATE heladeriaschalco SET nom_usu = '"+nom+"' WHERE id_usu = "+id;
                String qAp="UPDATE heladeriaschalco SET appat_usu = '"+appat+"' WHERE id_usu = "+id;
                String qAm="UPDATE heladeriaschalco SET apmat_usu = '"+apmat+"' WHERE id_usu = "+id;
                String qE="UPDATE heladeriaschalco SET edad_usu = "+edad+" WHERE id_usu = "+id;
                String qP="UPDATE heladeriaschalco SET password_usu = '"+passwo+"' WHERE id_usu = "+id;
                String qB="UPDATE heladeriaschalco SET birth_usu = "+birth+" WHERE where id_usu = "+id;
                String qD="UPDATE heladeriaschalco SET domicilio_usu = '"+domicilio+"' WHERE id_usu = "+id;
                String qT="UPDATE heladeriaschalco SET tel_usu = '"+tel+"' WHERE id_usu = "+id;
                String qC="UPDATE heladeriaschalco SET cel_usu = '"+cel+"' WHERE id_usu = "+id;
            
            
                //actualizacion del nombre
                //set=con.createStatement();
                set.executeUpdate(qN);
                
                //actualizacion del apellido paterno
                //set=con.createStatement();
                set.executeUpdate(qAp);
                
                //actualizacon del apellido materno
                //set=con.createStatement();
                set.executeUpdate(qAm);
                
                //actualizacion de la edad
                //set=con.createStatement();
                set.executeUpdate(qE);
                
                //actualizacion del correo
                //set=con.createStatement();
                set.executeUpdate(qP);
                set.executeUpdate(qB);
                set.executeUpdate(qD);
                set.executeUpdate(qT);
                set.executeUpdate(qC);
                
                System.out.println("Actualización de datos Exitosa");
                
            }catch(Exception e){
                System.out.println("Actualización de datos Fallida");
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
            }
            out.println("<table border='2' style=\"margin-right; 8 rem;\">"
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

                    out.println("<tbody>"
                            + "<tr><td>"+id+"</td>"
                            + "<td>"+nom+" "+appat+" "+apmat+"</td>"
                            + "<td>"+edad+"</td>"
                            + "<td>"+passwo+"</td>"
                            + "<td>"+birth+"</td>"
                            + "<td>"+domicilio+"</td>"
                            + "<td>"+tel+"</td>"
                            + "<td>"+cel+"</td></tr>"
                            + "</tbody>");
                   
 
            out.println("</table>"
            + "<a href=\"PPrincipal.html\"><input class=\"boton\" type=\"button\" name=\"Registro\" value=\"Regresar\"></a>");
                        out.println("<footer style=\"padding-top: 300px; font-size: 11px;\">\n" +
"      <ul>\n" +
"          <li>Carmona Aguilar Diego</li>\n" +
"          <li>Parra Rivas Arturo Gabriel</li>\n" +
"      </ul>\n" +
"  </footer> ");
            out.println("</div>");

            out.println("</body>");
            out.println("</html>");
        };
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}