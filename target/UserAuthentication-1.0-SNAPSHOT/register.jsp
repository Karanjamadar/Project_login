<%--
  Created by IntelliJ IDEA.
  User: karan
  Date: 6/7/22
  Time: 9:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.PrintWriter" %>

<html>
<head>
    <title>no</title>
</head>
<body>
<%
    String fname,lname,email,password,msg;
    fname = request.getParameter("fname");
    lname = request.getParameter("lname");
    email = request.getParameter("email");
    password = request.getParameter("password");


    String Querry = "insert into register values(?,?,?,?)";

    try {
        Connection con;
        PreparedStatement st;
        ResultSet rs;

        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/karan1","postgres","karan");
        st = con.prepareStatement(Querry);
        st.setString(1,fname);
        st.setString(2,lname);
        st.setString(3,email);
        st.setString(4,password);
        rs = st.executeQuery();
        response.sendRedirect("index.jsp?msg=\"register_successfully\"");
    }
    catch(Exception e){
        out.println(e);


    }

%>

</body>
</html>
