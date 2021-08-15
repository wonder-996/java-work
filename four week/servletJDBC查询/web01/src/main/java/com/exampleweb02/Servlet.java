package com.exampleweb02;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class Servlet extends HttpServlet {
    public void service(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        int id = Integer.parseInt(request.getParameter("id"));

        Connection conn = null;
        PreparedStatement prep = null;
        ResultSet rst = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student_system",
                    "root","123456");
            prep = conn.prepareStatement(
                    "select * from students where id=?");
            prep.setInt(1, id);
            rst = prep.executeQuery();
            if(rst.next()){
                out.println("id:" + id + "<br/>");
            }
        }catch(Exception e){
            e.printStackTrace();
            out.println("无该id");
        }finally{
            if(rst != null){
                try {
                    rst.close();
                } catch (SQLException e) {
                }
            }
            if( prep != null){
                try {
                    prep.close();
                } catch (SQLException e) {
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
