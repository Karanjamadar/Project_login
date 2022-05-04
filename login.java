import java.sql.*;
import java.io.*;
import java.util.ResourceBundle;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.*;
public class login extends HttpServlet{
    public void doPost(HttpServletRequest req,
    HttpServletResponse resp)
throws IOException, ServletException
{
    String email_user= req.getParameter("email");
    String password_user= req.getParameter("password");
    String email_db=null;
    String password_db=null;
    HttpSession session=req.getSession();  
        session.setAttribute("email",email_user);
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
       
        
        try {
           
            String querry = "select * from user_login";
            Class.forName("org.postgresql.Driver");
            // out.println("Driver loaded ");
            Connection cn = DriverManager.getConnection("jdbc:postgresql:karan", "postgres", "karan");
            System.out.println("connection Established");
            Statement st = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            System.out.println("statement created");
            ResultSet rs = st.executeQuery(querry);
            rs.last();
            int size = rs.getRow();
            rs.beforeFirst();
            if (size != 0) {
                while (rs.next()) {
                    email_db = rs.getString(3);
                    password_db = rs.getString(4);
                }
            }
            rs.close();
            st.close();
            cn.close();     
            System.out.println(email_db);
            System.out.println(password_db);
            if(email_db.equals(email_user)){
                if(password_db.equals(password_user)){
                    String doctype = "<!doctype html>\n";
                    out.println(doctype + "<html>\n" + "<head><title>" + "</title></head>\n" +
                    "<body bgcolor=\"cyan\">\n" + "<h1> Welcome!! You have successfully login to our website</h1>");
                    out.println("<form action=\"/form.html\">"+"<button style=\"background-color:#150985; border-radius:5px; color:white;\">LOGOUT</button>"+"</form><br><br>");
            out.println("<form action=\"http://localhost:8080/examples/servlets/servlet/delete\">"+"<button style=\"background-color:#150985; border-radius:5px; color:white;\">DELETE YOUR ACCOUNT</button>"+"</form>");
                }
                else{
                    out.println("<h1>Password Invalid!</h1>");
                }
            }
            else{
                out.println("<h1>Email invalid</h1>");
            }
            

            }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
       
