package com.example.intern;

import android.os.Bundle;

import android.text.format.DateFormat;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDate;

import de.hdodenhof.circleimageview.CircleImageView;

public class Screen4 extends AppCompatActivity {


    CircleImageView userphoto = null;
    CircleImageView profileimage = null;
    TextView replyname = null;
    TextView username = null;
    TextView userdate = null;
    TextView useramount = null;
    TextView profilename = null;
    TextView email = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_screen4);
        userphoto = findViewById(R.id.userphoto);
        replyname = findViewById(R.id.replyname);
        username = findViewById(R.id.username);
        userdate = findViewById(R.id.userdate);
        useramount = findViewById(R.id.useramount);

        profileimage = findViewById(R.id.profileimage);
        profilename = findViewById(R.id.profilename);
        email = findViewById(R.id.email);

        Userdata userdata = Utility.userdata;
        email.setText(userdata.username+"@gmail.com");
        userphoto.setImageResource(userdata.imageid);
        profileimage.setImageResource(userdata.imageid);
        replyname.setText("Re: " +userdata.replyname);
        profilename.setText(userdata.username);


        String day          = (String) DateFormat.format("dd",userdata.date);
        String monthString  = (String) DateFormat.format("MMM", userdata.date);
        userdate.setText(day +" " +monthString);
        useramount.setText(String.valueOf(userdata.amount));

    }
}