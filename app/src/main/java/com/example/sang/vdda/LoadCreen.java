package com.example.sang.vdda;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

public class LoadCreen extends AppCompatActivity {
ProgressBar progressBar;
    int progressStatus=0;
    Handler handler= new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_creen);
        progressBar=(ProgressBar) findViewById(R.id.progressBar);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progressStatus<100){
                    progressStatus +=10;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(progressStatus);

                        }
                    });
                    try
                    {
                        Thread.sleep(500);
                    }
                    catch (InterruptedException e){
                        e.printStackTrace();

                    }

                }
                if(progressBar.getProgress()==100)
                {
                    startActivity(new Intent(LoadCreen.this, FirstCreen.class));
                }


            }

        }).start();

    }

}

