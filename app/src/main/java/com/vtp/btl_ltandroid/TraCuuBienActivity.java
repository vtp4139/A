package com.vtp.btl_ltandroid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import customadapter.BienBaoAdapter;
import object.BienBao;

public class TraCuuBienActivity extends AppCompatActivity {

    BienBaoAdapter bienBaoAdapter;
    ArrayList<BienBao> list;
    ListView listView;
    MyDbHelper db;
    EditText edtFind;
    Button btnFind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tra_cuu_bien);

        ActionBarSetting();

        listView = (ListView) findViewById(R.id.list_bienbao);
        edtFind = (EditText) findViewById(R.id.editText_find);
        btnFind = (Button) findViewById(R.id.button_find);

        db = new MyDbHelper(TraCuuBienActivity.this);
        db.createBienBao();

        LoadBienBao();

        btnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = edtFind.getText().toString();
                BienBao bienBao = new BienBao();
                bienBao = db.getBienBao(s);//Tìm kiếm biển báo

                if(bienBao != null)
                {
                    //Xuất dialog tìm kiếm
                    AlertDialog.Builder builder = new AlertDialog.Builder(TraCuuBienActivity.this);
                    LayoutInflater inflater = TraCuuBienActivity.this.getLayoutInflater();
                    final View view1 = inflater.inflate(R.layout.timkiem_layout, null);
                    builder.setTitle("Thông tin tìm kiếm").setView(view1);

                    TextView txtTenBien = (TextView) view1.findViewById(R.id.txt_TenBien);
                    TextView txtSoHieu = (TextView) view1.findViewById(R.id.txt_SoHieu);
                    TextView txtNoiDung = (TextView) view1.findViewById(R.id.txt_NoiDung);
                    ImageView img = (ImageView) view1.findViewById(R.id.img_HinhAnh);

                    txtTenBien.setText(bienBao.getTenBienBao());
                    txtSoHieu.setText("Số hiệu: " + bienBao.getSoHieu());
                    txtNoiDung.setText(bienBao.getNoiDung());
                    img.setImageResource(bienBao.getHinhAnh());

                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    }).show();
                }
                else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(TraCuuBienActivity.this);
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    }).setMessage("Không tìm thấy biển báo có số hiệu này !").setTitle("Thông tin tìm kiếm").show();
                }
            }
        });
    }

    private void ActionBarSetting() {
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Tra cứu biển báo");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#4CAF50")));
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    void LoadBienBao()
    {
        list = new ArrayList<BienBao>();
        list = db.getAllBienBao();

        bienBaoAdapter = new BienBaoAdapter(TraCuuBienActivity.this,R.layout.bienbao_listview,list);
        listView.setAdapter(bienBaoAdapter);
    }
}