package com.example.sang.vdda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Help extends AppCompatActivity {
ImageView imback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        imback=(ImageView) findViewById(R.id.idback1);
        imback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Help.this, FirstCreen.class));
                finish();

                //overridePendingTransition(R.anim.anim_enter, R.anim.anim_exit);
            }
        });
    }
}
