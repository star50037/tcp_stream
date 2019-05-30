package com.example.vedio;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;
import android.net.Uri;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    EditText addrField;
    Button btnConnect, btnBack;
    VideoView streamView;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addrField = findViewById(R.id.addr);
        btnConnect = findViewById(R.id.connect);
        streamView = findViewById(R.id.streamview);
        btnBack = findViewById(R.id.back);

        btnConnect.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                String s = addrField.getEditableText().toString();
                playStream(s);
            }
        });

        btnBack.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                jump();

            }
        });

    }

    private void jump() {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, Main2Activity.class);
        startActivity(intent);
    }

    private void playStream(String src) {
        Uri UriSrc = Uri.parse(src);
        if (UriSrc == null) {
            Toast.makeText(MainActivity.this,
                    "UriSrc == null", Toast.LENGTH_LONG).show();
        } else {
            streamView.setVideoURI(UriSrc);
            mediaController = new MediaController(this);
            streamView.setMediaController(mediaController);
            streamView.start();

            Toast.makeText(MainActivity.this,
                    "Connect: " + src,
                    Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        streamView.stopPlayback();
    }

}
