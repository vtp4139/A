package com.vtp.btl_ltandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import customadapter.BienBaoAdapter;
import customadapter.LyThuyetAdapter;
import object.BienBao;
import object.LyThuyet;

public class OnLyThuyet extends AppCompatActivity {

    LyThuyetAdapter lyThuyetAdapter;
    ArrayList<LyThuyet> list;
    ListView listView;
    MyDbHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_ly_thuyet);

        ActionBarSetting();

        listView = (ListView) findViewById(R.id.listLyThuyet);
        db = new MyDbHelper(OnLyThuyet.this);
        db.createLyThuyet();

        LoadLyThuyet();
    }

    private void ActionBarSetting() {
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Ôn lý thuyết");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#4CAF50")));
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    void LoadLyThuyet()
    {
        list = new ArrayList<LyThuyet>();
        list = db.getAllLyThuyet();

        lyThuyetAdapter = new LyThuyetAdapter(OnLyThuyet.this,R.layout.lythuyet_listview,list);
        listView.setAdapter(lyThuyetAdapter);
    }
}