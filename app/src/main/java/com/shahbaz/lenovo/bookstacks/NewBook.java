package com.shahbaz.lenovo.bookstacks;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NewBook extends AppCompatActivity  implements View.OnClickListener

{
    private static final String TAG = "MainActivity";
    private Spinner spinner;
    int PERMISSION_ALL = 1;
    EditText bname, bphone, bemail, bdetails, bpin, baddress;
    String name, phone, email, pin, details, address, msg;
    Button btnbook;
    String text;
    String receiver = "8840008980";
    DatabaseReference myRef;
    FirebaseDatabase database;

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old_book);
        spinner = (Spinner) findViewById(R.id.spinner);
        // spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
        bname = (EditText) findViewById(R.id.bname);
        bphone = (EditText) findViewById(R.id.bphone);
        bemail = (EditText) findViewById(R.id.bemail);
        bpin = (EditText) findViewById(R.id.bpin);
        bdetails = (EditText) findViewById(R.id.bdetails);
        baddress = (EditText) findViewById(R.id.baddress);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                text = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();


            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // The request code used in ActivityCompat.requestPermissions()
// and returned in the Activity's onRequestPermissionsResult()

        String[] PERMISSIONS = {android.Manifest.permission.SEND_SMS, android.Manifest.permission.READ_CONTACTS, Manifest.permission.CALL_PHONE};

        if(!hasPermissions(this, PERMISSIONS)){
            ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_ALL);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnbook = (Button) findViewById(R.id.btnbook);
        btnbook.setOnClickListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        btnbook.setOnClickListener(null);
    }

    /*  private View.OnClickListener okListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {


        }


    };*/

    public static boolean hasPermissions(Context context, String... permissions) {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }

    public void sendSms(String uname, String uphone, String uemail, String upin, String udetails, String uaddress) {


        // Toast.makeText(getApplicationContext(), "stream is " + text + " " + "name is" + uname, Toast.LENGTH_SHORT).show();
        msg = ("NEW\n" + "name is " + uname + "\n" + uphone + "\n" + text + "\n" + "email is  " + uemail + "\n" + "book " +
                udetails + "\n" +
                "pin" + upin + "\n" + "address " + uaddress);
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setTitle("Order Placed");
        builder1.setMessage("We have received your order...We will contact you shortly");
        builder1.setCancelable(true);
        builder1.setNeutralButton("ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        SmsManager sm = SmsManager.getDefault();
                        Intent i = new Intent(getApplicationContext(), OldBook.class);
                        //PendingIntent pi = PendingIntent.getActivity(getApplicationContext(), 2, i, PendingIntent.FLAG_ONE_SHOT);
                        //2 is any positive num(res code)
                        //flagoneshot means the pending intent is not modified(o pass 0)
                        sm.sendTextMessage(receiver, null, msg, null, null);
                        Toast.makeText(getApplicationContext(), "order placed successfully", Toast.LENGTH_SHORT).show();

                        dialog.dismiss();

                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    @Override
    public void onClick(View v) {
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("booking");

        name = bname.getText().toString();
        phone = bphone.getText().toString();
        email = bemail.getText().toString();
        pin = bpin.getText().toString();
        details = bdetails.getText().toString();
        address = baddress.getText().toString();

        // Write a message to the database

        DatabaseReference reference = myRef.push();
        reference.setValue(BeanClass.create(name,phone,email,text,"new "+details,address,pin));
        sendSms(name, phone, email, pin, details, address);
    }

}




