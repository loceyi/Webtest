package com.test.demo;

import com.DBTool.DBUtil;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@javax.servlet.annotation.WebServlet(name = "Servlet")
public class Servlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String User_name = request.getParameter("id"); //接收ID值，
        String Password= request.getParameter("pw");//接收PW值
        boolean type=false;//判断账号和密码是否与数据库一致
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        try
        {
            Connection con=DBUtil.getConnection();
            Statement stmt=con.createStatement();
            String sql="select * from logininfo where User_name="+User_name+" and password ="+Password;
            ResultSet rset=stmt.executeQuery(sql);

            while(rset.next())
            {
                type=true;
            }
        String result = "";
        if (type){

            result = "Success";

        }

        else {

            result  = "Failure";
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", result);
        response.getWriter().print(jsonObject);

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            DBUtil.Close();
            ((PrintWriter) out).print(type);
            out.flush();
            out.close();
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
