package com.gtwm.web;

import com.gtwm.enums.JasperFiles;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.HashMap;

@Controller
@RequestMapping("/jasper")
public class JasperController {

    @Resource
    private JdbcTemplate JdbcTemplate;

    @RequestMapping(value = "/list")
    public String reportView(){
        return "reportList";
    }

    @RequestMapping(value = "genText")
    public void genReportText(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        try {
            //据据jasper文件生成JasperPrint对象
//	          String fileName = request.getParameter("fileName");//ireport编译文件：*.jasper（由模板文件*.jrxml文件编译生成）
//	          File reportFile = new File("C:\\Users\\fanghao\\Desktop\\report-sample.jrxml");
            HashMap<String, Object> parameters = new HashMap<String, Object>();//给报表模板文件传参

            //得到枚举类型的参数名称，参数名称若有重复的只能得到第一个--获取页面传来的参数，和模板中文件的sql参数名称一一对应
            Enumeration<?> temp = request.getParameterNames();
            while (temp.hasMoreElements()) {
                String paramName = (String) temp.nextElement();
                String paramValue = request.getParameter(paramName);
                parameters.put(paramName, paramValue);
            }
            InputStream is = request.getServletContext().getResourceAsStream(JasperFiles.SALETABLE.getClassPath());
            OutputStream os = response.getOutputStream();
            System.out.println(is.available());
            JasperRunManager.runReportToPdfStream(is, os, parameters, JdbcTemplate.getDataSource().getConnection());
            response.setContentType("application/pdf");
            os.flush();
            os.close();
            is.close();
        } catch (JRException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "genView")
    public void genReportView(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        try {
            //据据jasper文件生成JasperPrint对象
//          String fileName = request.getParameter("fileName");//ireport编译文件：*.jasper（由模板文件*.jrxml文件编译生成）
//          File reportFile = new File("C:\\Users\\fanghao\\Desktop\\report-sample.jrxml");
            HashMap<String, Object> parameters = new HashMap<String, Object>();//给报表模板文件传参

            //得到枚举类型的参数名称，参数名称若有重复的只能得到第一个--获取页面传来的参数，和模板中文件的sql参数名称一一对应
            Enumeration<?> temp = request.getParameterNames();
            while (temp.hasMoreElements()) {
                String paramName = (String) temp.nextElement();
                String paramValue = request.getParameter(paramName);
                parameters.put(paramName, paramValue);
            }
            InputStream is = request.getServletContext().getResourceAsStream(JasperFiles.SALETVIEW.getClassPath());
            OutputStream os = response.getOutputStream();
            System.out.println(is.available());
            JasperRunManager.runReportToPdfStream(is, os, parameters, JdbcTemplate.getDataSource().getConnection());
            response.setContentType("application/pdf");
            os.flush();
            os.close();
            is.close();
        } catch (JRException e) {
            e.printStackTrace();
        }
    }
}
