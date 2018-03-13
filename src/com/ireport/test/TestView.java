package com.ireport.test;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.HashMap;

public class TestView extends HttpServlet {
	
	private static final long serialVersionUID = -7355955083067480442L;

	public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
//        Connection connection = DBUtils.getDBInstance().getInitDBConnection();
		String url = "jdbc:mysql://192.168.199.188:3306/blk";
		String user = "blk";
		String password = "111111";
		Connection connection = null;
        try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
        
        try 
        {
            //据据jasper文件生成JasperPrint对象
            ServletContext context = this.getServletConfig().getServletContext();
            String fileName = request.getParameter("fileName");
//            File reportFile = new File(context.getRealPath("/WEB-INF/jaspers/"+fileName));
            File reportFile = new File(context.getRealPath("C:\\Users\\fanghao\\Desktop\\"+fileName));
            HashMap<String, Object> parameters = new HashMap<String, Object>();//给报表模板文件传参

            //得到枚举类型的参数名称，参数名称若有重复的只能得到第一个--获取页面传来的参数，和模板中文件的sql参数名称一一对应
            Enumeration<?> temp = request.getParameterNames();
               while (temp.hasMoreElements()) 
               {
                String paramName = (String) temp.nextElement();
                String paramValue = request.getParameter(paramName);
                parameters.put(paramName, paramValue);
               }
            byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parameters,connection);
            response.setContentType("application/pdf");
            response.setContentLength(bytes.length);
            ServletOutputStream out = response.getOutputStream();
            out.write(bytes, 0, bytes.length);
            out.flush();
            out.close();
        } 
        catch (JRException e) 
        {
            e.printStackTrace();
        }       
    }

}
