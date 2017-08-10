package com.example.hp.expplayerdemo;


import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnMp3Device, btnVideoDevice,
    btnMp3Localhost, btnVideoLocalhost,
    btnMp3FromInternet, btnVideoFromInternet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMp3Device = (Button) findViewById(R.id.btnPlayMp3DeviceStorage);
        btnVideoDevice = (Button) findViewById(R.id.btnPlayVideoDeviceStorage);
        btnMp3Localhost = (Button) findViewById(R.id.btnMp3Localhost);
        btnVideoLocalhost = (Button) findViewById(R.id.btnVideoLocalhost);
        btnMp3FromInternet = (Button) findViewById(R.id.btnMp3Internet);
        btnVideoFromInternet = (Button) findViewById(R.id.btnVideoInternet);

        btnMp3Device.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dir = Environment.getExternalStorageDirectory().getAbsolutePath() + "/exodemo/ov.mp3";

                Intent intent = new Intent(MainActivity.this, PlayerActivity.class);
                intent.putExtra("dir", dir);
                intent.putExtra("internet", "");
                startActivity(intent);
            }
        });

        btnVideoDevice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dir = Environment.getExternalStorageDirectory().getAbsolutePath() + "/exodemo/vdo.mp4";

                Intent intent = new Intent(MainActivity.this, PlayerActivity.class);
                intent.putExtra("dir", dir);
                intent.putExtra("internet", "");
                startActivity(intent);
            }
        });

        btnMp3Localhost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dir = Environment.getExternalStorageDirectory().getAbsolutePath() + "/exodemo/vdo.mp4";

                Intent intent = new Intent(MainActivity.this, PlayerActivity.class);
                intent.putExtra("dir", dir);
                intent.putExtra("internet", "local");
                startActivity(intent);
            }
        });

        btnVideoLocalhost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dir = Environment.getExternalStorageDirectory().getAbsolutePath() + "/exodemo/vdo.mp4";

                Intent intent = new Intent(MainActivity.this, PlayerActivity.class);
                intent.putExtra("dir", dir);
                intent.putExtra("internet", "local");
                startActivity(intent);
            }
        });

        btnMp3FromInternet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dir = Environment.getExternalStorageDirectory().getAbsolutePath() + "/exodemo/vdo.mp4";

                Intent intent = new Intent(MainActivity.this, PlayerActivity.class);
                intent.putExtra("dir", R.string.media_url_mp3);
                intent.putExtra("internet", "internet");
                startActivity(intent);
            }
        });

        btnVideoFromInternet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dir = Environment.getExternalStorageDirectory().getAbsolutePath() + "/exodemo/vdo.mp4";

                Intent intent = new Intent(MainActivity.this, PlayerActivity.class);
                intent.putExtra("dir", R.string.media_url_mp4);
                intent.putExtra("internet", "internet");
                startActivity(intent);
            }
        });

    }


}
