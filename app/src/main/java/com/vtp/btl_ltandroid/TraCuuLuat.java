package com.vtp.btl_ltandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import customadapter.LuatAdapter;
import customadapter.LyThuyetAdapter;
import object.Luat;
import object.LyThuyet;

public class TraCuuLuat extends AppCompatActivity {

    LuatAdapter luatAdapter;
    ArrayList<Luat> list;
    ListView listView;
    MyDbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tra_cuu_luat);

        ActionBarSetting();

        listView = (ListView) findViewById(R.id.listLuat);
        db = new MyDbHelper(TraCuuLuat.this);
        db.createLuat();

        LoadLyThuyet();
    }
    private void ActionBarSetting() {
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Tra cứu luật");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#4CAF50")));
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    void LoadLyThuyet()
    {
        list = new ArrayList<Luat>();
        list = db.getAllLuat();

        luatAdapter = new LuatAdapter(TraCuuLuat.this,R.layout.luat_listview,list);
        listView.setAdapter(luatAdapter);
    }
}