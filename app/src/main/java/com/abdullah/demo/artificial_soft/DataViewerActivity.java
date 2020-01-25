package com.abdullah.demo.artificial_soft;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DataViewerActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView userId;
    private TextView userName;
    private TextView userWho;
    private TextView userPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_viewer);

        Bundle bundle = getIntent().getExtras();

        imageView = (ImageView) findViewById(R.id.userImage);
        userId = (TextView) findViewById(R.id.userId);
        userName = (TextView) findViewById(R.id.userName);
        userWho = (TextView) findViewById(R.id.userWho);
        userPhone = (TextView) findViewById(R.id.userPhone);


        String id = bundle.getString("id");
        String name = bundle.getString("name");
        String user = bundle.getString("User");
        String who = bundle.getString("who");
        String image = bundle.getString("image");


        Picasso.with(this).load(image).into(imageView);
        userId.setText("User ID : "+id);
        userName.setText("User Name : "+name);
        userWho.setText("Who : "+who);
        userPhone.setText("Phone : "+user);



    }


}
