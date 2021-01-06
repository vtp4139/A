package com.vtp.btl_ltandroid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.Random;

import object.LyThuyet;
import object.LyThuyetBienBao;
import object.LyThuyetHinhAnh;

public class ThiSatHachActivity extends AppCompatActivity {

    TextView txtCau1,txtCau2,txtCau3,txtCau4,txtCau5,txtCau6,txtCau7,txtCau8,txtCau9,txtCau10,txtCau11, txtCau12, txtCau13, txtCau14, txtCau15, txtCau16, txtCau17, txtCau18, txtCau19, txtCau20, txtCau21, txtCau22, txtCau23, txtCau24, txtCau25;
    RadioButton rdoCau1_dapan1,rdoCau1_dapan2,rdoCau1_dapan3,rdoCau2_dapan1,rdoCau2_dapan2,rdoCau2_dapan3,
            rdoCau3_dapan1,rdoCau3_dapan2,rdoCau3_dapan3,rdoCau4_dapan1,rdoCau4_dapan2,rdoCau4_dapan3,
            rdoCau5_dapan1,rdoCau5_dapan2,rdoCau5_dapan3,rdoCau6_dapan1,rdoCau6_dapan2,rdoCau6_dapan3,
            rdoCau7_dapan1,rdoCau7_dapan2,rdoCau7_dapan3,rdoCau8_dapan1,rdoCau8_dapan2,rdoCau8_dapan3,
            rdoCau9_dapan1,rdoCau9_dapan2,rdoCau9_dapan3,rdoCau10_dapan1,rdoCau10_dapan2,rdoCau10_dapan3,
            rdoCau11_dapan1,rdoCau11_dapan2,rdoCau11_dapan3,rdoCau12_dapan1,rdoCau12_dapan2,rdoCau12_dapan3,
            rdoCau13_dapan1,rdoCau13_dapan2,rdoCau13_dapan3,rdoCau14_dapan1,rdoCau14_dapan2,rdoCau14_dapan3,
            rdoCau15_dapan1,rdoCau15_dapan2,rdoCau15_dapan3,rdoCau16_dapan1,rdoCau16_dapan2,rdoCau16_dapan3,
            rdoCau17_dapan1,rdoCau17_dapan2,rdoCau17_dapan3,rdoCau18_dapan1,rdoCau18_dapan2,rdoCau18_dapan3,
            rdoCau19_dapan1,rdoCau19_dapan2,rdoCau19_dapan3,rdoCau20_dapan1,rdoCau20_dapan2,rdoCau20_dapan3,
            rdoCau21_dapan1,rdoCau21_dapan2,rdoCau21_dapan3, rdoCau22_dapan1,rdoCau22_dapan2,rdoCau22_dapan3,
            rdoCau23_dapan1,rdoCau23_dapan2,rdoCau23_dapan3,rdoCau24_dapan1,rdoCau24_dapan2,rdoCau24_dapan3,
            rdoCau25_dapan1,rdoCau25_dapan2,rdoCau25_dapan3;
    ImageView imgCau12, imgCau13, imgCau14, imgCau15, imgCau16, imgCau17, imgCau18, imgCau19, imgCau20, imgCau21, imgCau22, imgCau23, imgCau24, imgCau25;
    ViewFlipper viewFlipper;
    ArrayList<LyThuyet> lyThuyetList, lyThuyetFlags;
    ArrayList<LyThuyetBienBao> lyThuyetBienBao, lyThuyetBienBaoFlags;
    ArrayList<LyThuyetHinhAnh> lyThuyetHinhAnh, lyThuyetHinhAnhFlags;
    MyDbHelper db;

    int TongCauDung = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thi_sat_hach);

        //Thiết lập giao diện
        ActionBarSetting();
        viewFlipper = (ViewFlipper) findViewById(R.id.view_flipper);


        db = new MyDbHelper(ThiSatHachActivity.this);
        db.createLyThuyet();
        db.createLyThuyetBienBao();
        db.createLyThuyetHinhAnh();
        lyThuyetList = db.getAllLyThuyet();
        lyThuyetBienBao = db.getAllLyThuyetBienBao();
        lyThuyetHinhAnh = db.getAllLyThuyetHinhAnh();

        //Xử lý
        InitMapping();
        SetRandomLyThuyet();
        SetRandomLyThuyetBienBao();
        SetRandomLyThuyetHinhAnh();
    }

    //XỬ LÝ
    private void InitMapping()
    {
        //Câu hỏi
        txtCau1 = (TextView) findViewById(R.id.textView_cau1);
        txtCau2 = (TextView) findViewById(R.id.textView_cau2);
        txtCau3 = (TextView) findViewById(R.id.textView_cau3);
        txtCau4 = (TextView) findViewById(R.id.textView_cau4);
        txtCau5 = (TextView) findViewById(R.id.textView_cau5);
        txtCau6 = (TextView) findViewById(R.id.textView_cau6);
        txtCau7 = (TextView) findViewById(R.id.textView_cau7);
        txtCau8 = (TextView) findViewById(R.id.textView_cau8);
        txtCau9 = (TextView) findViewById(R.id.textView_cau9);
        txtCau10 = (TextView) findViewById(R.id.textView_cau10);
        txtCau11 = (TextView) findViewById(R.id.textView_cau11);
        txtCau12 = (TextView) findViewById(R.id.textView_cau12);
        txtCau13 = (TextView) findViewById(R.id.textView_cau13);
        txtCau14 = (TextView) findViewById(R.id.textView_cau14);
        txtCau15 = (TextView) findViewById(R.id.textView_cau15);
        txtCau16 = (TextView) findViewById(R.id.textView_cau16);
        txtCau17 = (TextView) findViewById(R.id.textView_cau17);
        txtCau18 = (TextView) findViewById(R.id.textView_cau18);
        txtCau19 = (TextView) findViewById(R.id.textView_cau19);
        txtCau20 = (TextView) findViewById(R.id.textView_cau20);
        txtCau21 = (TextView) findViewById(R.id.textView_cau21);
        txtCau22 = (TextView) findViewById(R.id.textView_cau22);
        txtCau23 = (TextView) findViewById(R.id.textView_cau23);
        txtCau24 = (TextView) findViewById(R.id.textView_cau24);
        txtCau25 = (TextView) findViewById(R.id.textView_cau25);

        //Đáp án
        rdoCau1_dapan1 = (RadioButton) findViewById(R.id.radioButton_cau1_dapan1);
        rdoCau1_dapan2 = (RadioButton) findViewById(R.id.radioButton_cau1_dapan2);
        rdoCau1_dapan3 = (RadioButton) findViewById(R.id.radioButton_cau1_dapan3);

        rdoCau2_dapan1 = (RadioButton) findViewById(R.id.radioButton_cau2_dapan1);
        rdoCau2_dapan2 = (RadioButton) findViewById(R.id.radioButton_cau2_dapan2);
        rdoCau2_dapan3 = (RadioButton) findViewById(R.id.radioButton_cau2_dapan3);

        rdoCau3_dapan1 = (RadioButton) findViewById(R.id.radioButton_cau3_dapan1);
        rdoCau3_dapan2 = (RadioButton) findViewById(R.id.radioButton_cau3_dapan2);
        rdoCau3_dapan3 = (RadioButton) findViewById(R.id.radioButton_cau3_dapan3);

        rdoCau4_dapan1 = (RadioButton) findViewById(R.id.radioButton_cau4_dapan1);
        rdoCau4_dapan2 = (RadioButton) findViewById(R.id.radioButton_cau4_dapan2);
        rdoCau4_dapan3 = (RadioButton) findViewById(R.id.radioButton_cau4_dapan3);

        rdoCau5_dapan1 = (RadioButton) findViewById(R.id.radioButton_cau5_dapan1);
        rdoCau5_dapan2 = (RadioButton) findViewById(R.id.radioButton_cau5_dapan2);
        rdoCau5_dapan3 = (RadioButton) findViewById(R.id.radioButton_cau5_dapan3);

        rdoCau6_dapan1 = (RadioButton) findViewById(R.id.radioButton_cau6_dapan1);
        rdoCau6_dapan2 = (RadioButton) findViewById(R.id.radioButton_cau6_dapan2);
        rdoCau6_dapan3 = (RadioButton) findViewById(R.id.radioButton_cau6_dapan3);

        rdoCau7_dapan1 = (RadioButton) findViewById(R.id.radioButton_cau7_dapan1);
        rdoCau7_dapan2 = (RadioButton) findViewById(R.id.radioButton_cau7_dapan2);
        rdoCau7_dapan3 = (RadioButton) findViewById(R.id.radioButton_cau7_dapan3);

        rdoCau8_dapan1 = (RadioButton) findViewById(R.id.radioButton_cau8_dapan1);
        rdoCau8_dapan2 = (RadioButton) findViewById(R.id.radioButton_cau8_dapan2);
        rdoCau8_dapan3 = (RadioButton) findViewById(R.id.radioButton_cau8_dapan3);

        rdoCau9_dapan1 = (RadioButton) findViewById(R.id.radioButton_cau9_dapan1);
        rdoCau9_dapan2 = (RadioButton) findViewById(R.id.radioButton_cau9_dapan2);
        rdoCau9_dapan3 = (RadioButton) findViewById(R.id.radioButton_cau9_dapan3);

        rdoCau10_dapan1 = (RadioButton) findViewById(R.id.radioButton_cau10_dapan1);
        rdoCau10_dapan2 = (RadioButton) findViewById(R.id.radioButton_cau10_dapan2);
        rdoCau10_dapan3 = (RadioButton) findViewById(R.id.radioButton_cau10_dapan3);

        rdoCau11_dapan1 = (RadioButton) findViewById(R.id.radioButton_cau11_dapan1);
        rdoCau11_dapan2 = (RadioButton) findViewById(R.id.radioButton_cau11_dapan2);
        rdoCau11_dapan3 = (RadioButton) findViewById(R.id.radioButton_cau11_dapan3);

        rdoCau12_dapan1 = (RadioButton) findViewById(R.id.radioButton_cau12_dapan1);
        rdoCau12_dapan2 = (RadioButton) findViewById(R.id.radioButton_cau12_dapan2);
        rdoCau12_dapan3 = (RadioButton) findViewById(R.id.radioButton_cau12_dapan3);

        rdoCau13_dapan1 = (RadioButton) findViewById(R.id.radioButton_cau13_dapan1);
        rdoCau13_dapan2 = (RadioButton) findViewById(R.id.radioButton_cau13_dapan2);
        rdoCau13_dapan3 = (RadioButton) findViewById(R.id.radioButton_cau13_dapan3);

        rdoCau14_dapan1 = (RadioButton) findViewById(R.id.radioButton_cau14_dapan1);
        rdoCau14_dapan2 = (RadioButton) findViewById(R.id.radioButton_cau14_dapan2);
        rdoCau14_dapan3 = (RadioButton) findViewById(R.id.radioButton_cau14_dapan3);

        rdoCau15_dapan1 = (RadioButton) findViewById(R.id.radioButton_cau15_dapan1);
        rdoCau15_dapan2 = (RadioButton) findViewById(R.id.radioButton_cau15_dapan2);
        rdoCau15_dapan3 = (RadioButton) findViewById(R.id.radioButton_cau15_dapan3);

        rdoCau16_dapan1 = (RadioButton) findViewById(R.id.radioButton_cau16_dapan1);
        rdoCau16_dapan2 = (RadioButton) findViewById(R.id.radioButton_cau16_dapan2);
        rdoCau16_dapan3 = (RadioButton) findViewById(R.id.radioButton_cau16_dapan3);

        rdoCau17_dapan1 = (RadioButton) findViewById(R.id.radioButton_cau17_dapan1);
        rdoCau17_dapan2 = (RadioButton) findViewById(R.id.radioButton_cau17_dapan2);
        rdoCau17_dapan3 = (RadioButton) findViewById(R.id.radioButton_cau17_dapan3);

        rdoCau18_dapan1 = (RadioButton) findViewById(R.id.radioButton_cau18_dapan1);
        rdoCau18_dapan2 = (RadioButton) findViewById(R.id.radioButton_cau18_dapan2);
        rdoCau18_dapan3 = (RadioButton) findViewById(R.id.radioButton_cau18_dapan3);

        rdoCau19_dapan1 = (RadioButton) findViewById(R.id.radioButton_cau19_dapan1);
        rdoCau19_dapan2 = (RadioButton) findViewById(R.id.radioButton_cau19_dapan2);
        rdoCau19_dapan3 = (RadioButton) findViewById(R.id.radioButton_cau19_dapan3);

        rdoCau20_dapan1 = (RadioButton) findViewById(R.id.radioButton_cau20_dapan1);
        rdoCau20_dapan2 = (RadioButton) findViewById(R.id.radioButton_cau20_dapan2);
        rdoCau20_dapan3 = (RadioButton) findViewById(R.id.radioButton_cau20_dapan3);

        rdoCau21_dapan1 = (RadioButton) findViewById(R.id.radioButton_cau21_dapan1);
        rdoCau21_dapan2 = (RadioButton) findViewById(R.id.radioButton_cau21_dapan2);
        rdoCau21_dapan3 = (RadioButton) findViewById(R.id.radioButton_cau21_dapan3);

        rdoCau22_dapan1 = (RadioButton) findViewById(R.id.radioButton_cau22_dapan1);
        rdoCau22_dapan2 = (RadioButton) findViewById(R.id.radioButton_cau22_dapan2);
        rdoCau22_dapan3 = (RadioButton) findViewById(R.id.radioButton_cau22_dapan3);

        rdoCau23_dapan1 = (RadioButton) findViewById(R.id.radioButton_cau23_dapan1);
        rdoCau23_dapan2 = (RadioButton) findViewById(R.id.radioButton_cau23_dapan2);
        rdoCau23_dapan3 = (RadioButton) findViewById(R.id.radioButton_cau23_dapan3);

        rdoCau24_dapan1 = (RadioButton) findViewById(R.id.radioButton_cau24_dapan1);
        rdoCau24_dapan2 = (RadioButton) findViewById(R.id.radioButton_cau24_dapan2);
        rdoCau24_dapan3 = (RadioButton) findViewById(R.id.radioButton_cau24_dapan3);

        rdoCau25_dapan1 = (RadioButton) findViewById(R.id.radioButton_cau25_dapan1);
        rdoCau25_dapan2 = (RadioButton) findViewById(R.id.radioButton_cau25_dapan2);
        rdoCau25_dapan3 = (RadioButton) findViewById(R.id.radioButton_cau25_dapan3);


        //Hình ảnh
        imgCau12 = (ImageView) findViewById(R.id.imageView_cau12);
        imgCau13 = (ImageView) findViewById(R.id.imageView_cau13);
        imgCau14 = (ImageView) findViewById(R.id.imageView_cau14);
        imgCau15 = (ImageView) findViewById(R.id.imageView_cau15);
        imgCau16 = (ImageView) findViewById(R.id.imageView_cau16);
        imgCau17 = (ImageView) findViewById(R.id.imageView_cau17);
        imgCau18 = (ImageView) findViewById(R.id.imageView_cau18);
        imgCau19 = (ImageView) findViewById(R.id.imageView_cau19);
        imgCau20 = (ImageView) findViewById(R.id.imageView_cau20);
        imgCau21 = (ImageView) findViewById(R.id.imageView_cau21);
        imgCau22 = (ImageView) findViewById(R.id.imageView_cau22);
        imgCau23 = (ImageView) findViewById(R.id.imageView_cau23);
        imgCau24 = (ImageView) findViewById(R.id.imageView_cau24);
        imgCau25 = (ImageView) findViewById(R.id.imageView_cau25);
    }

    //XỬ LÝ LÝ THUYẾT
    private void RandomLyThuyet(TextView cauHoi, RadioButton da1, RadioButton da2, RadioButton da3, int i)
    {
        Random r = new Random();
        int randomNum;

        //Random câu hỏi ngẫu nhiên trong mảng
        randomNum = r.nextInt(lyThuyetList.size()-1);
        lyThuyetFlags.add(lyThuyetList.get(randomNum));// Xuất câu hỏi ra mảng mới
        //Set vào textview, radio button
        cauHoi.setText("Câu " + i + ": " + lyThuyetList.get(randomNum).getCauHoi());
        da1.setText(lyThuyetList.get(randomNum).getDapAn1());
        da2.setText(lyThuyetList.get(randomNum).getDapAn2());
        da3.setText(lyThuyetList.get(randomNum).getDapAn3());
        lyThuyetList.remove(randomNum);//Xóa câu hỏi vừa rút khỏi danh sách chính
    }

    private void SetRandomLyThuyet()
    {
        lyThuyetFlags = new ArrayList<LyThuyet>();
        int i = 1;
        RandomLyThuyet(txtCau1,rdoCau1_dapan1,rdoCau1_dapan2,rdoCau1_dapan3,i);i++;
        RandomLyThuyet(txtCau2,rdoCau2_dapan1,rdoCau2_dapan2,rdoCau2_dapan3,i);i++;
        RandomLyThuyet(txtCau3,rdoCau3_dapan1,rdoCau3_dapan2,rdoCau3_dapan3,i);i++;
        RandomLyThuyet(txtCau4,rdoCau4_dapan1,rdoCau4_dapan2,rdoCau4_dapan3,i);i++;
        RandomLyThuyet(txtCau5,rdoCau5_dapan1,rdoCau5_dapan2,rdoCau5_dapan3,i);i++;
        RandomLyThuyet(txtCau6,rdoCau6_dapan1,rdoCau6_dapan2,rdoCau6_dapan3,i);i++;
        RandomLyThuyet(txtCau7,rdoCau7_dapan1,rdoCau7_dapan2,rdoCau7_dapan3,i);i++;
        RandomLyThuyet(txtCau8,rdoCau8_dapan1,rdoCau8_dapan2,rdoCau8_dapan3,i);i++;
        RandomLyThuyet(txtCau9,rdoCau9_dapan1,rdoCau9_dapan2,rdoCau9_dapan3,i);i++;
        RandomLyThuyet(txtCau10,rdoCau10_dapan1,rdoCau10_dapan2,rdoCau10_dapan3,i);i++;
        RandomLyThuyet(txtCau11,rdoCau11_dapan1,rdoCau11_dapan2,rdoCau11_dapan3,i);i++;
    }

    //XỬ LÝ LÝ THUYẾT BIỂN BÁO
    private void RandomLyThuyetBienBao(TextView cauHoi, ImageView img, RadioButton da1, RadioButton da2, RadioButton da3, int i)
    {
        Random r = new Random();
        int randomNum;

        //Random câu hỏi ngẫu nhiên trong mảng
        randomNum = r.nextInt(lyThuyetBienBao.size()-1);

        lyThuyetBienBaoFlags.add(lyThuyetBienBao.get(randomNum));// Xuất câu hỏi ra mảng mới
        //Set vào textview, radio button
        cauHoi.setText("Câu " + i + ": " + lyThuyetBienBao.get(randomNum).getCauHoi());
        img.setImageResource(lyThuyetBienBao.get(randomNum).getHinhAnh());
        da1.setText(lyThuyetBienBao.get(randomNum).getDapAn1());
        da2.setText(lyThuyetBienBao.get(randomNum).getDapAn2());
        da3.setText(lyThuyetBienBao.get(randomNum).getDapAn3());
        lyThuyetBienBao.remove(randomNum);//Xóa câu hỏi vừa rút khỏi danh sách chính
    }

    private void SetRandomLyThuyetBienBao()
    {
        lyThuyetBienBaoFlags = new ArrayList<LyThuyetBienBao>();
        int i = 12;
        RandomLyThuyetBienBao(txtCau12,imgCau12,rdoCau12_dapan1,rdoCau12_dapan2,rdoCau12_dapan3,i);i++;
        RandomLyThuyetBienBao(txtCau13,imgCau13,rdoCau13_dapan1,rdoCau13_dapan2,rdoCau13_dapan3,i);i++;
        RandomLyThuyetBienBao(txtCau14,imgCau14,rdoCau14_dapan1,rdoCau14_dapan2,rdoCau14_dapan3,i);i++;
        RandomLyThuyetBienBao(txtCau15,imgCau15,rdoCau15_dapan1,rdoCau15_dapan2,rdoCau15_dapan3,i);i++;
        RandomLyThuyetBienBao(txtCau16,imgCau16,rdoCau16_dapan1,rdoCau16_dapan2,rdoCau16_dapan3,i);i++;
        RandomLyThuyetBienBao(txtCau17,imgCau17,rdoCau17_dapan1,rdoCau17_dapan2,rdoCau17_dapan3,i);i++;
        RandomLyThuyetBienBao(txtCau18,imgCau18,rdoCau18_dapan1,rdoCau18_dapan2,rdoCau18_dapan3,i);i++;
        RandomLyThuyetBienBao(txtCau19,imgCau19,rdoCau19_dapan1,rdoCau19_dapan2,rdoCau19_dapan3,i);i++;
    }

    //XỬ LÝ LÝ THUYẾT HÌNH ẢNH
    private void RandomLyThuyetHinhAnh(TextView cauHoi, ImageView img, RadioButton da1, RadioButton da2, RadioButton da3, int i)
    {
        Random r = new Random();
        int randomNum;

        //Random câu hỏi ngẫu nhiên trong mảng
        randomNum = r.nextInt(lyThuyetHinhAnh.size()-1);


        lyThuyetHinhAnhFlags.add(lyThuyetHinhAnh.get(randomNum));// Xuất câu hỏi ra mảng mới
        //Set vào textview, radio button
        cauHoi.setText("Câu " + i + ": " + lyThuyetHinhAnh.get(randomNum).getCauHoi());
        img.setImageResource(lyThuyetHinhAnh.get(randomNum).getHinhAnh());
        da1.setText(lyThuyetHinhAnh.get(randomNum).getDapAn1());
        da2.setText(lyThuyetHinhAnh.get(randomNum).getDapAn2());
        da3.setText(lyThuyetHinhAnh.get(randomNum).getDapAn3());
        lyThuyetHinhAnh.remove(randomNum);//Xóa câu hỏi vừa rút khỏi danh sách chính
    }

    private void SetRandomLyThuyetHinhAnh()
    {
        lyThuyetHinhAnhFlags = new ArrayList<LyThuyetHinhAnh>();
        int i = 20;
        RandomLyThuyetHinhAnh(txtCau20,imgCau20,rdoCau20_dapan1,rdoCau20_dapan2,rdoCau20_dapan3,i);i++;
        RandomLyThuyetHinhAnh(txtCau21,imgCau21,rdoCau21_dapan1,rdoCau21_dapan2,rdoCau21_dapan3,i);i++;
        RandomLyThuyetHinhAnh(txtCau22,imgCau22,rdoCau22_dapan1,rdoCau22_dapan2,rdoCau22_dapan3,i);i++;
        RandomLyThuyetHinhAnh(txtCau23,imgCau23,rdoCau23_dapan1,rdoCau23_dapan2,rdoCau23_dapan3,i);i++;
        RandomLyThuyetHinhAnh(txtCau24,imgCau24,rdoCau24_dapan1,rdoCau24_dapan2,rdoCau24_dapan3,i);i++;
        RandomLyThuyetHinhAnh(txtCau25,imgCau25,rdoCau25_dapan1,rdoCau25_dapan2,rdoCau25_dapan3,i);i++;
    }

    //KIỂM TRA KẾT QUẢ
    private void CheckResultLyThuyet(RadioButton da1, RadioButton da2, RadioButton da3, int i)
    {
        if(da1.isChecked())
        {
            if(lyThuyetFlags.get(i).getDapAnDung().equals("1")){
                TongCauDung++;
            }
        }
        if(da2.isChecked())
        {
            if(lyThuyetFlags.get(i).getDapAnDung().equals("2")) {
                TongCauDung++;
            }

        }
        if(da3.isChecked())
        {
            if(lyThuyetFlags.get(i).getDapAnDung().equals("3")){
                TongCauDung++;
            }
        }
    }

    private void CheckResultBienBao(RadioButton da1, RadioButton da2, RadioButton da3, int i)
    {
        if(da1.isChecked())
        {
            if(lyThuyetBienBaoFlags.get(i).getDapAnDung().equals("1")){
                TongCauDung++;
            }
        }
        if(da2.isChecked())
        {
            if(lyThuyetBienBaoFlags.get(i).getDapAnDung().equals("2")) {
                TongCauDung++;
            }

        }
        if(da3.isChecked())
        {
            if(lyThuyetBienBaoFlags.get(i).getDapAnDung().equals("3")){
                TongCauDung++;
            }
        }
    }

    private void CheckResultHinhAnh(RadioButton da1, RadioButton da2, RadioButton da3, int i)
    {
        if(da1.isChecked())
        {
            if(lyThuyetHinhAnhFlags.get(i).getDapAnDung().equals("1")){
                TongCauDung++;
            }
        }
        if(da2.isChecked())
        {
            if(lyThuyetHinhAnhFlags.get(i).getDapAnDung().equals("2")) {
                TongCauDung++;
            }

        }
        if(da3.isChecked())
        {
            if(lyThuyetHinhAnhFlags.get(i).getDapAnDung().equals("3")){
                TongCauDung++;
            }
        }
    }

    private void CallCheckResult()
    {
        int i = 0;
        //Kiểm tra kết quá lý thuyết
        CheckResultLyThuyet(rdoCau1_dapan1, rdoCau1_dapan2, rdoCau1_dapan3, i);i++;
        CheckResultLyThuyet(rdoCau2_dapan1, rdoCau2_dapan2, rdoCau2_dapan3, i);i++;
        CheckResultLyThuyet(rdoCau3_dapan1, rdoCau3_dapan2, rdoCau3_dapan3, i);i++;
        CheckResultLyThuyet(rdoCau4_dapan1, rdoCau4_dapan2, rdoCau4_dapan3, i);i++;
        CheckResultLyThuyet(rdoCau5_dapan1, rdoCau5_dapan2, rdoCau5_dapan3, i);i++;
        CheckResultLyThuyet(rdoCau6_dapan1, rdoCau6_dapan2, rdoCau6_dapan3, i);i++;
        CheckResultLyThuyet(rdoCau7_dapan1, rdoCau7_dapan2, rdoCau7_dapan3, i);i++;
        CheckResultLyThuyet(rdoCau8_dapan1, rdoCau8_dapan2, rdoCau8_dapan3, i);i++;
        CheckResultLyThuyet(rdoCau9_dapan1, rdoCau9_dapan2, rdoCau9_dapan3, i);i++;
        CheckResultLyThuyet(rdoCau11_dapan1, rdoCau11_dapan2, rdoCau11_dapan3, i);i++;

        i = 0;
        //Kiểm tra kết quả câu biển báo
        CheckResultBienBao(rdoCau12_dapan1, rdoCau12_dapan2, rdoCau12_dapan3, i);i++;
        CheckResultBienBao(rdoCau13_dapan1, rdoCau13_dapan2, rdoCau13_dapan3, i);i++;
        CheckResultBienBao(rdoCau14_dapan1, rdoCau14_dapan2, rdoCau14_dapan3, i);i++;
        CheckResultBienBao(rdoCau15_dapan1, rdoCau15_dapan2, rdoCau15_dapan3, i);i++;
        CheckResultBienBao(rdoCau16_dapan1, rdoCau16_dapan2, rdoCau16_dapan3, i);i++;
        CheckResultBienBao(rdoCau17_dapan1, rdoCau17_dapan2, rdoCau17_dapan3, i);i++;
        CheckResultBienBao(rdoCau18_dapan1, rdoCau18_dapan2, rdoCau18_dapan3, i);i++;
        CheckResultBienBao(rdoCau19_dapan1, rdoCau19_dapan2, rdoCau19_dapan3, i);i++;

        i = 0;
        //Kiểm tra kết quả câu hình ảnh
        CheckResultHinhAnh(rdoCau20_dapan1, rdoCau20_dapan2, rdoCau20_dapan3, i);i++;
        CheckResultHinhAnh(rdoCau21_dapan1, rdoCau21_dapan2, rdoCau21_dapan3, i);i++;
        CheckResultHinhAnh(rdoCau22_dapan1, rdoCau22_dapan2, rdoCau22_dapan3, i);i++;
        CheckResultHinhAnh(rdoCau23_dapan1, rdoCau23_dapan2, rdoCau23_dapan3, i);i++;
        CheckResultHinhAnh(rdoCau24_dapan1, rdoCau24_dapan2, rdoCau24_dapan3, i);i++;
        CheckResultHinhAnh(rdoCau25_dapan1, rdoCau25_dapan2, rdoCau25_dapan3, i);i++;
    }

    //XỬ LÝ GIAO DIỆN-----------------------------------------------------
    public void previousView(View v)
    {
        viewFlipper.showPrevious();
    }
    public void nextView(View v)
    {
        viewFlipper.showNext();
    }

    private void ActionBarSetting() {
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#4CAF50")));
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        new CountDownTimer(1140000, 1000) {

            public void onTick(long millisUntilFinished) {
                int minutes = (int) millisUntilFinished/60000;
                int seconds = (int) millisUntilFinished%60000/1000;

                String timeLeftText ;
                timeLeftText = "" + minutes;
                timeLeftText += ":";
                if(seconds < 10) timeLeftText +="0";
                timeLeftText += seconds;
                getSupportActionBar().setTitle("Thời gian làm bài: " + timeLeftText);
                //here you can have your logic to set text to edittext
            }
            public void onFinish() {
                CallCheckResult();
                Intent intent = new Intent(ThiSatHachActivity.this, KetQuaActivity.class);
                intent.putExtra("TongDiem",TongCauDung);
                startActivity(intent);
                //txt1.setText("done!");
            }
        }.start();

        //ActionBar bar = getSupportActionBar();

    }
    // create an action bar button
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // handle button activities
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.mybutton) {
            DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which){
                        case DialogInterface.BUTTON_POSITIVE:
                            CallCheckResult();
                            Intent intent = new Intent(ThiSatHachActivity.this, KetQuaActivity.class);
                            intent.putExtra("TongDiem",TongCauDung);
                            startActivity(intent);
                            break;

                        case DialogInterface.BUTTON_NEGATIVE:
                            //No button clicked
                            break;
                    }
                }
            };

            AlertDialog.Builder builder = new AlertDialog.Builder(ThiSatHachActivity.this);
            builder.setTitle("KẾT THÚC").setMessage("Bạn có muốn kết thúc bài thi ?").setPositiveButton("Đồng ý", dialogClickListener)
                    .setNegativeButton("Hủy bỏ", dialogClickListener).show();
        }
        return super.onOptionsItemSelected(item);
    }
}