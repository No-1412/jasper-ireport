package com.gtwm.jasperexecute;

import java.io.File;
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

public class GenReportView extends HttpServlet {
	
	private static final long serialVersionUID = -7355955083067480442L;

	public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
//        RunJasperReports run = new RunJasperReports();
//        try {
//			run.generatePdfReport("C:\\tools\\eclipse\\jee-oxygen\\workspace\\run-jasper-reports-web\\webapp\\WEB-INF\\report-sample.jasper", "c:/", DatabaseType.MYSQL, "blk", "root", "5542065a", "jdbc:mysql://127.0.0.1:3306/blk", new HashMap<String, String>());
//		} catch (ClassNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (JRException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
        
        
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
//            byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parameters,connection);
               
            InputStream is = getServletConfig().getServletContext().getResourceAsStream("WEB-INF/aliblkDemo.jasper");
            OutputStream os = response.getOutputStream();
//            InputStream is = this.getClass().getClassLoader().getResourceAsStream("report-sample.jrxml");
//            InputStream is = new FileInputStream(reportFile);
            System.out.println(is.available());
//    		byte[] b = new byte[is.available()];
//    		is.read(b);
//            System.out.println(new String(b));
            JasperRunManager.runReportToPdfStream(is, os, parameters, ConnectionUtil.conn());
            response.setContentType("application/pdf");
            os.flush();
            os.close();
            is.close();
//            response.setContentLength(bytes.length);
//            ServletOutputStream out = response.getOutputStream();
//            out.write(bytes, 0, bytes.length);
//            out.flush();
//            out.close();
        } 
        catch (JRException e) 
        {
            e.printStackTrace();
        }
    }
	
	public static void main(String[] args) throws IOException {
		File reportFile = new File("C:\\\\Users\\\\fanghao\\\\Desktop\\\\report-sample.jrxml");
		System.out.println(reportFile.getPath());
		System.out.println(reportFile.getName());
//		InputStream is = new FileInputStream(reportFile);
//		System.out.println(is.available());
//		byte[] b = new byte[is.available()];
//		is.read(b);
		
//		System.out.println(new String(b));
	}

}
