import java.sql.*;
import java.io.*;
import java.util.ResourceBundle;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.*;

public class delete extends HttpServlet {
    public void doPost(HttpServletRequest req,
    HttpServletResponse resp)
throws IOException, ServletException
{
        HttpSession session=req.getSession(false);  
        String email_user=(String)session.getAttribute("email");  

    
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
       
        
        try {
            String querry = "delete from user_login where email='"+email_user+"' ";
            Class.forName("org.postgresql.Driver");
            // out.println("Driver loaded ");
            Connection cn = DriverManager.getConnection("jdbc:postgresql:karan", "postgres", "karan");
            System.out.println("connection Established");
            Statement st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            System.out.println("statement created");
            ResultSet rs = st.executeQuery(querry);
            
            rs.close();
            st.close();
            cn.close();
            String doctype = "<!doctype html>\n";
                    out.println(doctype + "<html>\n" + "<head><title>" + "</title></head>\n" +
                    "<body bgcolor=\"cyan\">\n" + "<h1>Your Account has successfully Deleted from our server</h1>");
                    out.println("<form action=\"/form.html\">"+"<button style=\"background-color:#150985; border-radius:5px; color:white;\">LOGOUT</button>"+"</form><br><br>");
           
            }catch (Exception e) {
                e.printStackTrace();
            }

    }
}
