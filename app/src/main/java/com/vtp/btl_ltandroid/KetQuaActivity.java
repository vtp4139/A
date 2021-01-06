package com.vtp.btl_ltandroid;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class KetQuaActivity extends AppCompatActivity {

    TextView Diem, KetQua;
    Button btnBack, btnExam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ket_qua);

        ActionBarSetting();

        Diem = (TextView) findViewById(R.id.textView_Diem);
        KetQua = (TextView) findViewById(R.id.textView_result);
        btnBack = (Button) findViewById(R.id.button_back);
        btnExam = (Button) findViewById(R.id.button_thilai);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(KetQuaActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(KetQuaActivity.this, ThiSatHachActivity.class);
                startActivity(intent);
            }
        });

        int TongDiem = getIntent().getExtras().getInt("TongDiem");

        if(TongDiem > 21)
        {
            KetQua.setText("Đạt yêu cầu");
            KetQua.setTextColor(Color.parseColor("#4CAF50"));
        }
        else
        {
            int diemDatThem = 25 - TongDiem;
            KetQua.setText("Không đạt yêu cầu");
            KetQua.setTextColor(Color.parseColor("#F44336"));
        }
        Diem.setText(TongDiem + "/25");
    }

    private void ActionBarSetting() {
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setTitle("Kết quả thi");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#4CAF50")));
    }
}