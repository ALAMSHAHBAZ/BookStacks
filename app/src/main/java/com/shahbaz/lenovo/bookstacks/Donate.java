package com.shahbaz.lenovo.bookstacks;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Donate extends AppCompatActivity {
EditText txt1,txt2,txt3,txt4,txt5,txt6,txt7;
    SharedPreferences sp;
    SharedPreferences.Editor se;
    String nm,ph,em,detail,pin,city,state,msg;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sp = getSharedPreferences("logininfo", MODE_PRIVATE);
        setContentView(R.layout.activity_donate);
        txt1 = (EditText) findViewById(R.id.txt1);
        txt2 = (EditText) findViewById(R.id.txt2);
        txt3 = (EditText) findViewById(R.id.txt3);
        txt4 = (EditText) findViewById(R.id.txt4);
        txt5 = (EditText) findViewById(R.id.txt5);
        txt6 = (EditText) findViewById(R.id.txt6);
        txt7 = (EditText) findViewById(R.id.txt7);
        btn=(Button)findViewById(R.id.btn);
        btn.setOnClickListener(okListener);

        nm = sp.getString("name", " ");

        ph = sp.getString("mobile", " ");

        em = sp.getString("email", " ");
        txt1.setText(nm);
        txt2.setText(ph);
        txt3.setText(em);
    }
   /* public void onClick(View v)
    {
        Toast.makeText(this,"sending email..",Toast.LENGTH_SHORT).show();
       // sendEmail();

        //openWhatsApp();
        sendSms(detail,pin,city,state);
    }*/

    private View.OnClickListener okListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {


            detail=txt4.getText().toString();
            pin=txt5.getText().toString();
            city=txt6.getText().toString();
            state=txt7.getText().toString();

            Toast.makeText(getApplicationContext(),"sending message..",Toast.LENGTH_SHORT).show();
            // sendEmail();

            //openWhatsApp();
            sendSms(detail,pin,city,state);
        }


    };

/*
        protected void sendEmail() {
            Log.i("Send email", "");

            String[] TO = {"bookstacks.info@gmail.com"};
           // String[] CC = {"xyz@gmail.com"};
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setData(Uri.parse("mailto:"));
            emailIntent.setType("text/plain");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
           // emailIntent.putExtra(Intent.EXTRA_CC, CC);
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Book Donation Bookstacks");
            emailIntent.putExtra(Intent.EXTRA_TEXT,"name "+nm+"\n"+"phone "+ph+"\n"+"email "+em+"\n"+"detail "+detail+"\n"+
                    "pin "+pin+"\n"+"city "+city+"\n"+"state "+state);

            try {
                startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                finish();
                Log.i("Finished sending email", "");
            }
            catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(getApplicationContext(),
                        "There is no email client installed.", Toast.LENGTH_SHORT).show();
            }
        }*/

/*    private void openWhatsApp() {
        String smsNumber = "917897335026"; //without '+'
        try {
            Intent sendIntent = new Intent("android.intent.action.MAIN");
            //sendIntent.setComponent(new ComponentName("com.whatsapp", "com.whatsapp.Conversation"));
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.setType("text/plain");
            sendIntent.putExtra(Intent.EXTRA_TEXT,"name "+nm+"\n"+"phone "+ph+"\n"+"email "+em+"\n"+"detail "+detail+"\n"+
                    "pin "+pin+"\n"+"city "+city+"\n"+"state "+state);
            sendIntent.putExtra("jid", smsNumber + "@s.whatsapp.net"); //phone number without "+" prefix
            sendIntent.setPackage("com.whatsapp");
            startActivity(sendIntent);
        } catch(Exception e) {
            Toast.makeText(this, "Error/n" + e.toString(), Toast.LENGTH_SHORT).show();
        }
    }*/




    public void sendSms(final String detail, final String pin, final String city, final String state) {

        // Toast.makeText(getApplicationContext(), "stream is " + text + " " + "name is" + uname, Toast.LENGTH_SHORT).show();
        msg = ("Book Donation Bookstacks\n"+ "\n" +"name "+nm+"\n"+"phone "+ph+"\n"+"email "+em+"\n"+"detail "+detail+"\n"+
                "pin "+pin+"\n"+"city "+city+"\n"+"state "+state);


        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setTitle("Book Donation");
        builder1.setMessage("Thank you!!..We will contact you shortly");
        builder1.setCancelable(true);
        builder1.setNeutralButton("ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        String smsNumber = "918840008980"; //without '+'
                        try {
                            Intent sendIntent = new Intent("android.intent.action.MAIN");
                            //sendIntent.setComponent(new ComponentName("com.whatsapp", "com.whatsapp.Conversation"));
                            sendIntent.setAction(Intent.ACTION_SEND);
                            sendIntent.setType("text/plain");
                            sendIntent.putExtra(Intent.EXTRA_TEXT,"name "+nm+"\n"+"phone "+ph+"\n"+"email "+em+"\n"+"detail "+detail+"\n"+
                                    "pin "+pin+"\n"+"city "+city+"\n"+"state "+state);
                            sendIntent.putExtra("jid", smsNumber + "@s.whatsapp.net"); //phone number without "+" prefix
                            sendIntent.setPackage("com.whatsapp");
                            startActivity(sendIntent);
                        } catch(Exception e) {
                            Toast.makeText(getApplicationContext(), "Error/n" + e.toString(), Toast.LENGTH_SHORT).show();
                        }

                        dialog.dismiss();

                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();

    }


    }



