package com.harati.np.newapp.ui;

import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sameer on 8/16/2017.
 */

public class GenerateSimplePdfReportWithJasperReports {

    public static void main(String[] args) {

        Connection connection = null;
        try {

            String reportName = "myreport";
            Map<String, Object> parameters = new HashMap<String, Object>();
//            connection = new ConnectionFactory().getConnection(); // opens a jdbc connection

            // compiles jrxml
            JasperCompileManager.compileReportToFile(reportName + ".jrxml");
            // fills compiled report with parameters and a connection
            JasperPrint print = JasperFillManager.fillReport(reportName + ".jasper", parameters, connection);
            // exports report to pdf
            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, new FileOutputStream(reportName + ".pdf")); // your output goes here

            exporter.exportReport();

        } catch (Exception e) {
            throw new RuntimeException("It's not possible to generate the pdf report.", e);
        } finally {
            // it's your responsibility to close the connection, don't forget it!
            if (connection != null) {
                try { connection.close(); } catch (Exception e) {}
            }
        }

    }


}