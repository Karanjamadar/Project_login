import java.io.*;
import java.util.ResourceBundle;
import java.sql.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class registered extends HttpServlet {

    public void doPost(HttpServletRequest req,
                      HttpServletResponse resp)
        throws IOException, ServletException
    {
       
       
        String title="You have succesfully created your account";


      String fname = req.getParameter("fname");
      String lname = req.getParameter("lname");
      String email = req.getParameter("email");
      String password = req.getParameter("password");
      
      resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        
        String doctype = "<!doctype html>\n";
        out.println(doctype + "<html>\n" + "<head><title>" + title +"</title></head>\n" +
        "<body bgcolor=\"cyan\">\n" + "<h1 align=\"center\">" + title + "</h1>\n" +
        "<ul>\n" + 
        "<li> <b> First name </b>:" 
       +fname+"\n" +
        "<li><b>last name</b>:" 
        +lname +"\n" +
        "<li><b>email</b>:" 
       +email+"\n" +
        "<li><b>password</b>:" 
        +password +"\n" +
        "</ul>\n"+ " <form action=\"/form.html\">"+"<button style=\"background-color:#150985; border-radius:5px; color:white;\">GO TO LOGIN</button>"+"</form>" + "</body> </html>");
      
      try{
      String querry = "INSERT INTO user_login VALUES('" + fname + "','" + lname + "','" + email + "','" + password
              + "')";
       Class.forName("org.postgresql.Driver");
         Connection cn = DriverManager.getConnection("jdbc:postgresql:karan", "postgres", "karan");
         

         Statement st = cn.createStatement();
         

         ResultSet rs = st.executeQuery(querry);
         out.println("<p><values inserted</p>");
         
        rs.close();
         st.close();
         cn.close();
         }
          catch(SQLException se) {
            se.printStackTrace();
         }  
   
       catch(Exception e) {
         e.printStackTrace();
         
      }
      
   }
}


