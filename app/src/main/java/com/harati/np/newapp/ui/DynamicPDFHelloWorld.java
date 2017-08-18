package com.harati.np.newapp.ui;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.cete.dynamicpdf.Font;
import com.cete.dynamicpdf.Page;
import com.cete.dynamicpdf.PageOrientation;
import com.cete.dynamicpdf.PageSize;
import com.cete.dynamicpdf.TextAlign;
import com.cete.dynamicpdf.pageelements.Label;
import com.harati.np.newapp.R;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;



public class DynamicPDFHelloWorld extends AppCompatActivity {
    private static String FILE = Environment.getExternalStorageDirectory()
            + "/";
    private BaseFont bfBold;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_pdfhello_world);
        String formattedDate = new SimpleDateFormat("yyyy/MM/dd HH/mm/ss").format(Calendar.getInstance().getTime());
        Log.v("dateNow","---->"+formattedDate.toString());
        // Create a document and set it's properties
        final int MyVersion = Build.VERSION.SDK_INT;
        if (MyVersion >= Build.VERSION_CODES.LOLLIPOP_MR1) {
            if (!checkIfAlreadyhavePermission()) {
                ActivityCompat.requestPermissions(this,new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
            } else {
                createPdf("bookingId : " +"bookingId"+ "\n"
                        + "IssueDate : "+"IssueDate"+ "\n"
                        + "IssueDate : "+"IssueDate"+ "\n"
                        + "TaxCurrency : "+"TaxCurrency"+ "\n"
                        + "Airline : "+"Airline"+ "\n"
                        + "Departure : "+"Departure"+ "\n"
                        + "Sector : "+"Sector"+ "\n"
                        + "Surcharge : "+"Surcharge"+ "\n"
                        + "PaxType : "+"PaxType"+ "\n"
                        + "FlightDate : "+"FlightDate"+ "\n"
                        + "TicketNo : "+"TicketNo"+ "\n"
                        + "FreeBaggage : "+"FreeBaggage"+ "\n"
                        + "FirstName : "+"FirstName"+ "\n"
                        + "BarcodeImage : "+"BarcodeImage"+ "\n"
                        + "Arrival : "+"Arrival"+ "\n"
                        + "CommissionAmount : "+"CommissionAmount"+ "\n"
                        + "FlightNo : "+"FlightNo"+ "\n"
                        + "ArrivalTime : "+"ArrivalTime"+ "\n"
                        + "Currency : "+"Currency"+ "\n"
                        + "Fare : "+"Fare"+ "\n"
                        + "Refundable : "+"Refundable"+ "\n"
                        + "FlightTime : "+"FlightTime"+ "\n"
                        + "Tax : "+"Tax"+ "\n"
                        + "Nationality : "+"Nationality"+ "\n"
                        + "ClassCode : "+"ClassCode"+ "\n"
                        + "PnrNo : "+"PnrNo"+ "\n"
                        + "Gender : "+"Gender"+ "\n"
                        + "BarCodeValue : "+"BarCodeValue"+ "\n"
                        + "ReportingTime : "+"ReportingTime"+ "\n");
            }
        }
    }

/*    public void generatePdf(String  text){
        String root = Environment.getExternalStorageDirectory().toString();
        File myDir = new File(root + "/Pdfdownloads");
        if (!myDir.exists()) {
            myDir.mkdirs();
        }
        String formattedDate = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(Calendar.getInstance().getTime());
        Log.v("dateNow","---->"+formattedDate.toString());
        String concate = FILE+formattedDate.toString()+"flight_ticket.pdf";
        Log.v("called","==>"+"called");
        Document objDocument = new Document();
        objDocument.setCreator("DynamicPDFHelloWorld.java");
        objDocument.setAuthor("Your Name");
        objDocument.setTitle("Hello World");

        // Create a page to add to the document
        Page objPage = new Page(PageSize.LETTER, PageOrientation.PORTRAIT,
                54.0f);

        // Create a Label to add to the page
//        String strText = "Hello World...\nFrom DynamicPDF Generator " + "for Java\nDynamicPDF.com";
        String strText = text;
        Label objLabel = new Label(strText, 0, 0, 5040, 1000,
                Font.getHelvetica(), 18, TextAlign.LEFT);

        // Add label to page
        objPage.getElements().add(objLabel);

        // Add page to document
        objDocument.getPages().add(objPage);

        Log.v("tesxxt","=="+text);
        try {
            Log.v("pdfsuccess",concate);
            // Outputs the document to file
            objDocument.draw(concate);
            Toast.makeText(this, "File has been written to :" + concate,
                    Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(this, "Error, unable to write to file\n" + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }*/
    private boolean checkIfAlreadyhavePermission() {
        int result = ContextCompat.checkSelfPermission(getBaseContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
//        return result == PackageManager.PERMISSION_GRANTED;
        if (result== PackageManager.PERMISSION_GRANTED){
            return true;
        }else{
            return false;
        }

    }
    private void createPdf(String personName) {
        String root = Environment.getExternalStorageDirectory().toString();
        File mydir = new File(root + "/PDFDownloads");
        if (!mydir.exists()) {
            mydir.mkdirs();
        }
        Document document = new Document();
        try {
            File file = new File(mydir, FILE);
            file.setReadable(true);
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            PdfWriter docWriter = PdfWriter.getInstance(document, fileOutputStream);
            document.open();
            PdfContentByte cb = docWriter.getDirectContent();
            //initialize fonts for text printing
            initializeFonts();
            //the company logo is stored in the assets which is read only
            //get the logo and print on the document
            InputStream inputStream = getAssets().open("hrm_logo.png");
            Bitmap bmp = BitmapFactory.decodeStream(inputStream);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
            Image companyLogo = Image.getInstance(stream.toByteArray());
            companyLogo.setAbsolutePosition(25, 700);
            companyLogo.scalePercent(25);
            document.add(companyLogo);
            //creating a sample invoice with some customer data
            createHeadings(cb, 400, 780, "Company Name");
            createHeadings(cb, 400, 765, "Address Line 1");
            createHeadings(cb, 400, 750, "Address Line 2");
            createHeadings(cb, 400, 735, "City, State - ZipCode");
            createHeadings(cb, 400, 720, "Country");
            //list all the products sold to the customer
            float[] columnWidths = {1.5f, 2f, 5f, 2f, 2f};
            //create PDF table with the given widths
            PdfPTable table = new PdfPTable(columnWidths);
            // set table width a percentage of the page width
            table.setTotalWidth(500f);
            PdfPCell cell = new PdfPCell(new Phrase("Qty"));
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase("Item Number"));
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase("Item Description"));
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase("Price"));
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase("Ext Price"));
            cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            table.addCell(cell);
            table.setHeaderRows(1);
            DecimalFormat df = new DecimalFormat("0.00");
            for (int i = 0; i < 15; i++) {
                double price = Double.valueOf(df.format(Math.random() * 10));
                double extPrice = price * (i + 1);
                table.addCell(String.valueOf(i + 1));
                table.addCell("ITEM" + String.valueOf(i + 1));
                table.addCell("Product Description - SIZE " + String.valueOf(i + 1));
                table.addCell(df.format(price));
                table.addCell(df.format(extPrice));
            }
            //absolute location to print the PDF table from
            table.writeSelectedRows(0, -1, document.leftMargin(), 650, docWriter.getDirectContent());
            //print the signature image along with the persons name
            inputStream = getAssets().open("hrm_logo.png");
            bmp = BitmapFactory.decodeStream(inputStream);
            stream = new ByteArrayOutputStream();
            bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
            Image signature = Image.getInstance(stream.toByteArray());
            signature.setAbsolutePosition(400f, 150f);
            signature.scalePercent(25f);
            document.add(signature);
            createHeadings(cb, 450, 135, personName);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Toast.makeText(this, "saved!!", Toast.LENGTH_SHORT).show();
    }
    private void createHeadings(PdfContentByte cb, float x, float y, String text) {
        cb.beginText();
        cb.setFontAndSize(bfBold, 8);
        cb.setTextMatrix(x, y);
        cb.showText(text.trim());
        cb.endText();
    }
    private void initializeFonts() {
        try {
            bfBold = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
