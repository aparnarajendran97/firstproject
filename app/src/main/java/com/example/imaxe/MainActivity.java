package com.example.imaxe;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    ImageView imageView2;
    public static final int CAMERA_REQUEST=9999;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView2=(ImageView)findViewById(R.id.imageView2);
    }
    public void opencamera(View view)
    {

        Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAMERA_REQUEST);
    }
    @Override
    protected void onActivityResult (int requestcode,int resultcode,Intent data) {
      super.onActivityResult(requestcode,resultcode, data);
        if(requestcode==CAMERA_REQUEST)
        {
            Bitmap bitmap=(Bitmap)data.getExtras().get("data");
            imageView2.setImageBitmap(bitmap);
        }
    }


}
