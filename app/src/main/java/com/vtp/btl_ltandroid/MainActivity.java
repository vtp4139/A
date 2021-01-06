package com.vtp.btl_ltandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    CardView cv_thiSatHach, cv_traCuuBienBao, cv_traCuuLuat, cv_onLyThuyet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        cv_thiSatHach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, QuyCheThi.class);
                startActivity(intent);
            }
        });

        cv_traCuuBienBao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TraCuuBienActivity.class);
                startActivity(intent);
            }
        });

        cv_onLyThuyet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OnLyThuyet.class);
                startActivity(intent);
            }
        });

        cv_traCuuLuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TraCuuLuat.class);
                startActivity(intent);
            }
        });

    }

    private void init()
    {
        cv_thiSatHach = (CardView) findViewById(R.id.cv_ThiSatHach);
        cv_traCuuBienBao = (CardView) findViewById(R.id.cv_TraCuuBienBao);
        cv_traCuuLuat = (CardView) findViewById(R.id.cv_TraCuuLuat);
        cv_onLyThuyet = (CardView) findViewById(R.id.cv_OnLyThuyet);
    }
}