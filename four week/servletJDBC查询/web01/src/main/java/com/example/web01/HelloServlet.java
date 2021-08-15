package com.example.web01;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }
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
            out.println("系统繁忙，稍后重试");
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
    public void destroy() {
    }
}