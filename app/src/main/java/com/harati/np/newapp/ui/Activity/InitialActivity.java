package com.harati.np.newapp.ui.Activity;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;


import com.cete.dynamicpdf.Document;
import com.cete.dynamicpdf.Font;
import com.cete.dynamicpdf.Page;
import com.cete.dynamicpdf.PageOrientation;
import com.cete.dynamicpdf.PageSize;
import com.cete.dynamicpdf.TextAlign;
import com.cete.dynamicpdf.pageelements.Label;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Sameer on 5/5/2017.
 */

public class InitialActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        startActivity(new Intent(this, MainActivity.class));
        final int MyVersion = Build.VERSION.SDK_INT;
        if (MyVersion >= Build.VERSION_CODES.LOLLIPOP_MR1) {
            if (!checkIfAlreadyhavePermission()) {
                ActivityCompat.requestPermissions(this,new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
            } else {
                stringtopdf("bookingId : " +"bookingId"+ "\n"
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



    public void stringtopdf(String data) {
        Log.e("start","start");
        String root = Environment.getExternalStorageDirectory().toString();
        File myDir = new File(root + "/TNDownloads");
        if (!myDir.exists()) {
            myDir.mkdirs();
        }
//        String name = new Date().toString() + ".jpg";

        try {
            final File file = new File(myDir , "sample.pdf");
            file.setReadable(true);
            Log.d("fil9676867868e",file.toString());
            file.createNewFile();
            FileOutputStream fOut = new FileOutputStream(file);


            PdfDocument document = new PdfDocument();
            PdfDocument.PageInfo pageInfo = new
                    PdfDocument.PageInfo.Builder(10000, 10000, 1).create();
            PdfDocument.Page page = document.startPage(pageInfo);
            Canvas canvas = page.getCanvas();
            Paint paint = new Paint();

            canvas.drawText(data, 10, 10, paint);


            document.finishPage(page);
            document.writeTo(fOut);
            document.close();
            Log.d("success","success"+"==0-0-");
            Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();

        } catch (IOException e) {
            Log.i("EEEEEERRRRRRRRRRRR", e.getLocalizedMessage());
        }
    }
    private boolean checkIfAlreadyhavePermission() {
        int result = ContextCompat.checkSelfPermission(getBaseContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
//        return result == PackageManager.PERMISSION_GRANTED;
        if (result== PackageManager.PERMISSION_GRANTED){
            return true;
        }else{
            return false;
        }

    }


}
