package com.example.userauthentication;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

@WebServlet(name="register" ,value = "/register")
public class register extends HttpServlet {
    protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException,ServletException {
        String fname,lname,email,password,msg;
        fname = req.getParameter("fname");
        lname = req.getParameter("lname");
        email = req.getParameter("email");
        password = req.getParameter("password");
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        String Querry = "insert into register values(?,?,?,?)";

        try {
            Connection con;
            PreparedStatement st;
            ResultSet rs;

            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql:karan1","postgres","karan");
            st = con.prepareStatement(Querry);
            st.setString(1,fname);
            st.setString(2,lname);
            st.setString(3,email);
            st.setString(4,password);
            rs = st.executeQuery();
            resp.sendRedirect("index.jsp?msg=\"register_successfully\"");


        }
        catch(Exception e){
            out.println("database accessing problem or already registerd");


        }


    }

}
