package com.gtwm.jasperexecute;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

public class GenReportText extends HttpServlet {

	private static final long serialVersionUID = -5911696088113279402L;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
        {
            //据据jasper文件生成JasperPrint对象
//            String fileName = request.getParameter("fileName");//ireport编译文件：*.jasper（由模板文件*.jrxml文件编译生成）
//            File reportFile = new File("C:\\Users\\fanghao\\Desktop\\report-sample.jrxml");
            HashMap<String, Object> parameters = new HashMap<String, Object>();//给报表模板文件传参

            //得到枚举类型的参数名称，参数名称若有重复的只能得到第一个--获取页面传来的参数，和模板中文件的sql参数名称一一对应
            Enumeration<?> temp = request.getParameterNames();
               while (temp.hasMoreElements()) 
               {
                String paramName = (String) temp.nextElement();
                String paramValue = request.getParameter(paramName);
                parameters.put(paramName, paramValue);
               }
            
            InputStream is = getServletConfig().getServletContext().getResourceAsStream("WEB-INF/blk-table.jasper");
            OutputStream os = response.getOutputStream();
            System.out.println(is.available());
            JasperRunManager.runReportToPdfStream(is, os, parameters, ConnectionUtil.conn());
            response.setContentType("application/pdf");
            os.flush();
            os.close();
            is.close();
        } 
        catch (JRException e)
        {
            e.printStackTrace();
        }
	}
}
