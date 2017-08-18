 package com.harati.np.newapp.ui;

import android.content.ContextWrapper;
import android.graphics.pdf.PdfDocument;
import android.os.Environment;
import android.print.pdf.PrintedPdfDocument;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.harati.np.newapp.R;

import org.w3c.dom.Document;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

 public class PdfGenerator extends AppCompatActivity {

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_pdf_generator);


     }
 }
    /*public boolean createPDF(String rawHTML, String fileName, ContextWrapper context){
        final String APPLICATION_PACKAGE_NAME = context.getBaseContext().getPackageName();
        File path = new File( Environment.getExternalStorageDirectory(), APPLICATION_PACKAGE_NAME );
        if ( !path.exists() ){ path.mkdir(); }
        File file = new File(path, fileName);

        try{

            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();

            // Подготавливаем HTML
            String htmlText = Jsoup.clean( rawHTML, Whitelist.relaxed() );
            InputStream inputStream = new ByteArrayInputStream( htmlText.getBytes() );

            // Печатаем документ PDF
            XMLWorkerHelper.getInstance().parseXHtml(writer, document,
                    inputStream, null, Charset.defaultCharset(), new MyFont());

            document.close();
            return true;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (DocumentException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
}*/
