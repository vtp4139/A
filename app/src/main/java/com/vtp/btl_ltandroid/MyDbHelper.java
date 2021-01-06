package com.vtp.btl_ltandroid;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import object.BienBao;
import object.Luat;
import object.LyThuyet;
import object.LyThuyetBienBao;
import object.LyThuyetHinhAnh;

public class MyDbHelper extends SQLiteOpenHelper {

    public MyDbHelper(@Nullable Context context) {
        super(context, "DB_OnThiBLX", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE LyThuyet(" +
                "CauHoi varchar  primary key," +
                "DapAn1 varchar," +
                "DapAn2 varchar," +
                "DapAn3 varchar," +
                "DapAnDung varchar" +
                ")"
        );

        sqLiteDatabase.execSQL("CREATE TABLE LyThuyetBienBao(" +
                "CauHoi text  primary key," +
                "HinhAnh integer," +
                "DapAn1 text," +
                "DapAn2 text," +
                "DapAn3 text," +
                "DapAnDung text" +
                ")"
        );

        sqLiteDatabase.execSQL("CREATE TABLE LyThuyetHinhAnh(" +
                "CauHoi text  primary key," +
                "HinhAnh interger," +
                "DapAn1 text," +
                "DapAn2 text," +
                "DapAn3 text," +
                "DapAnDung text" +
                ")"
        );

        sqLiteDatabase.execSQL("CREATE TABLE BienBao(" +
                "SoHieu text  primary key," +
                "HinhAnh interger," +
                "TenBienBao text," +
                "NoiDung text" +
                ")"
        );

        sqLiteDatabase.execSQL("CREATE TABLE Luat(" +
                "SoLuat text  primary key," +
                "NoiDung text," +
                "MucPhat text" +
                ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS LyThuyet");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS LyThuyetBienBao");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS LyThuyetHinhAnh");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS BienBao");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Luat");
        onCreate(sqLiteDatabase);
    }

    //XỬ LÝ DỮ LIỆU CÂU HỎI LÝ THUYẾT
    public  void insertDbLyThuyet(LyThuyet lt) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("CauHoi", lt.getCauHoi());
        contentValues.put("DapAn1", lt.getDapAn1());
        contentValues.put("DapAn2", lt.getDapAn2());
        contentValues.put("DapAn3", lt.getDapAn3());
        contentValues.put("DapAnDung", lt.getDapAnDung());

        int result = (int) db.insert("LyThuyet", null, contentValues);
        db.close();
    }

    public void createLyThuyet() {
        //Kiểm tra dữ liệu đã được add vào DB hay chưa
        String countQuery = "SELECT  * FROM " + "LyThuyet";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();

        if(count == 0)
        {
            LyThuyet lt1 = new LyThuyet("Phần của đường bộ được sử dụng cho các phương tiện giao thông qua lại là gì?","Phần mặt đường và lề đường.","Phần đường xe chạy.","Phần đường xe cơ giới.","2");
            LyThuyet lt2 = new LyThuyet("\"Phương tiện tham gia giao thông đường bộ\" gồm những loại nào?","Phương tiện giao thông cơ giới đường bộ.","Phương tiện giao thông thô sơ đường bộ và xe máy chuyên dùng.","Cả ý 1 và ý 2.","3");
            LyThuyet lt3 = new LyThuyet("Khi đang lái xe mô tô và ô tô, nếu có nhu cầu sử dụng điện thoại để nhắn tin hoặc gọi điện, người lái xe phải thực hiện như thế nào trong các tình huống nêu dưới đây?","Giảm tốc độ để đảm bảo an toàn với xe phía trước và sử dụng điện thoại để liên lạc.","Giảm tốc độ để dừng xe ở nơi cho phép dừng xe sau đó sử dụng điện thoại để liên lạc.","Tăng tốc độ để cách xa xe phía sau và sử dụng điện thoại để liên lạc.","2");
            LyThuyet lt4 = new LyThuyet("Trong trường hợp đặc biệt, để được lắp đặt, sử dụng còi, đèn không đúng với thiết kế của nhà sản xuất đối với từng loại xe cơ giới bạn phải đảm bảo yêu cầu nào dưới đây?","Phải đảm bảo phụ tùng do đúng nhà sản xuất đó cung cấp.","Phải được chấp thuận của cơ quan có thẩm quyền.","Phải là xe đăng ký và hoạt động tại các khu vực có địa hình phức tạp.","2");
            LyThuyet lt5 = new LyThuyet("Trên đường một chiều có vạch kẻ phân làn đường, xe thô sơ và xe cơ giới phải đi như thế nào là đúng quy tắc giao thông?","Xe thô sơ phải đi trên làn đường bên trái ngoài cùng, xe cơ giới, xe máy chuyên dùng đi trên làn đường bên phải.","Xe thô sơ phải đi trên làn đường bên phải trong cùng; xe cơ giới, xe máy chuyên dùng đi trên làn đường bên trái.","Xe thô sơ đi trên làn đường phù hợp không gây cản trở giao thông, xe cơ giới, xe máy chuyên dùng đi trên làn đường bên phải.","2");
            LyThuyet lt6 = new LyThuyet("Tại nơi đường bộ giao nhau cùng mức với đường sắt chỉ có đèn tín hiệu hoặc chuông báo hiệu, khi đèn tín hiệu màu đỏ đã bật sáng hoặc có tiếng chuông báo hiệu, người tham gia giao thông phải dừng lại ngay và giữ khoảng cách tối thiểu bao nhiêu mét tính từ ray gần nhất?","5 mét.","3 mét.","4 mét.","1");
            LyThuyet lt7 = new LyThuyet("Người lái xe mô tô xử lý như thế nào khi cho xe mô tô phía sau vượt?","Nếu đủ điều kiện an toàn, người lái xe phải giảm tốc độ, đi sát về bên phải của phần đường xe chạy cho đến khi xe sau đã vượt qua, không được gây trở ngại đối với xe xin vượt.","Lái xe vào lề đường bên trái và giảm tốc độ để xe phía sau vượt qua, không được gây trở ngại đối với xe xin vượt.","Nếu đủ điều kiện an toàn, người lái xe phải tăng tốc độ, đi sát về bên phải của phần đường xe chạy cho đến khi xe sau đã vượt qua.","1");
            LyThuyet lt8 = new LyThuyet("Khi gặp xe buýt đang dừng đón, trả khách, người điều khiển xe mô tô phải xử lý như thế nào dưới đây để đảm bảo an toàn giao thông?","Tăng tốc độ để nhanh chóng vượt qua bến đỗ.","Giảm tốc độ đến mức an toàn có thể và quan sát người qua đường và từ từ vượt qua xe buýt.","Yêu cầu phải dừng lại phía sau xe buýt chờ xe rời bến mới đi tiếp.","2");
            LyThuyet lt9 = new LyThuyet("Người lái xe phải giảm tốc độ thấp hơn tốc độ tối đa cho phép đến mức cần thiết, chú ý quan sát và chuẩn bị sẵn sàng những tình huống có thế xảy ra để phòng ngừa tai nạn trong các trường hợp nào dưới đây?","Gặp biển báo nguy hiểm trên đường.","Gặp biển chỉ dẫn trên đường.","Gặp biển báo hết mọi lệnh cấm.","1");
            LyThuyet lt10 = new LyThuyet("Người có giấy phép lái xe mô tô hạng A1 không được phép điều khiển loại xe nào dưới đây?","Xe mô tô có dung tích xi-lanh 125 cm3.","Xe mô tô có dung tích xi-lanh từ 175 cm3 trở lên.","Xe mô tô có dung tích xi-lanh 100 cm3.","2");
            LyThuyet lt11 = new LyThuyet("Khái niệm \"phương tiện giao thông thô sơ đường bộ\" được hiểu thế nào là đúng?","Gồm xe đạp (kể cả xe đạp máy, xe đạp điện), xe xích lô, xe lăn dùng cho người khuyết tật, xe súc vật kéo và các loại xe tương tự.","Gồm xe đạp (kể cả xe đạp máy, xe đạp điện), xe gắn máy, xe cơ giới dùng cho người khuyết tật và xe máy chuyên dùng.","Gồm xe ô tô, máy kéo, rơ moóc hoặc sơ mi rơ moóc được kéo bởi xe ô tô, máy kéo.","1");
            LyThuyet lt12 = new LyThuyet("Người lái xe sử dụng đèn như thế nào khi lái xe trong khu đô thị và đông dân cư vào ban đêm?","Bất cứ đèn nào miễn là mắt nhìn rõ phía trước.","Chỉ bật đèn chiếu xa (đèn pha) khi không nhìn rõ đường.","Đèn chiếu gần (đèn cốt).","3");
            LyThuyet lt13 = new LyThuyet("Tại nơi đường giao nhau không có báo hiệu đi theo vòng xuyến, người điều khiển phương tiện phải nhường đường như thế nào là đúng quy tắc giao thông?","Phải nhường đường cho xe đi đến từ bên phải.","Xe báo hiệu xin đường trước xe đó được đi trước.","Phải nhường đường cho xe đi đến từ bên trái.","1");
            LyThuyet lt14 = new LyThuyet("Trên đoạn đường hai chiều không có giải phân cách giữa, người lái xe không được vượt xe khác trong các trường hợp nào dưới đây?","Xe bị vượt bất ngờ tăng tốc độ và cố tình không nhường đường.","Phát hiện có xe đi ngược chiều.","Cả ý 1 và ý 2.","3");
            LyThuyet lt15 = new LyThuyet("Khi điều khiển xe chạy với tốc độ dưới 60 km/h, để đảm bảo khoảng cách an toàn giữa hai xe, người lái xe phải điều khiển xe như thế nào?","Chủ động giữ khoảng cách an toàn phù hợp với xe chạy liền trước xe của mình.","Đảm bảo khoảng cách an toàn theo mật độ phương tiện, tình hình giao thông thực tế.","Cả ý 1 và ý 2.","3");
            LyThuyet lt16 = new LyThuyet("Người lái xe phải xử lý như thế nào khi quan sát phía trước thấy người đi bộ đang sang đường tại nơi có vạch đường dành cho người đi bộ để đảm bảo an toàn?","Giảm tốc độ, đi từ từ để vượt qua trước người đi bộ.","Giảm tốc độ, có thể dừng lại nếu cần thiết trước vạch dừng xe để nhường đường cho người đi bộ qua đường.","Tăng tốc độ để vượt qua trước người đi bộ.","2");
            LyThuyet lt17 = new LyThuyet("Kỹ thuật cơ bản để giữ thăng bằng khi điều khiển xe mô tô đi trên đường gồ ghề như thế nào trong các trường hợp dưới đây?","Đứng thẳng trên giá gác chân lái sau đó hơi gập đầu gối và khuỷu tay, đi chậm để không nẩy quá mạnh.","Ngồi lùi lại phía sau, tăng ga vượt nhanh qua đoạn đường xóc.","Ngồi lệch sang bên trái hoặc bên phải để lấy thăng bằng đoạn đường gồ ghề.","1");
            LyThuyet lt18 = new LyThuyet("Khi lái xe trong khu đô thị và đông dân cư trừ các khu vực có biển cấm sử dụng còi, người lái xe được sử dụng còi như thế nào trong các trường hợp dưới đây?","Từ 22 giờ đêm đến 5 giờ sáng.","Từ 5 giờ sáng đến 22 giờ tối.","Từ 23 giờ đêm đến 5 giờ sáng hôm sau.","2");
            LyThuyet lt19 = new LyThuyet("Người có giấy phép lái xe mô tô hạng A1 được phép điều khiển loại xe nào dưới đây?","Xe mô tô hai bánh có dung tích xi-lanh từ 50 cm3 đến dưới 175 cm3.","Xe mô tô ba bánh dùng cho người khuyết tật.","Cả ý 1 và ý 2.","3");
            LyThuyet lt20 = new LyThuyet("Tại nơi đường giao nhau, người lái xe đang đi trên đường không ưu tiên phải nhường đường như thế nào là đúng quy tắc giao thông?","Nhường đường cho xe đi ở bên phải mình tới.","Nhường đường cho xe đi ở bên trái mình tới.","Nhường đường cho xe đi trên đường ưu tiên hoặc đường chính từ bất kỳ hướng nào tới.","3");

            insertDbLyThuyet(lt1);
            insertDbLyThuyet(lt2);
            insertDbLyThuyet(lt3);
            insertDbLyThuyet(lt4);
            insertDbLyThuyet(lt5);
            insertDbLyThuyet(lt6);
            insertDbLyThuyet(lt7);
            insertDbLyThuyet(lt8);
            insertDbLyThuyet(lt9);
            insertDbLyThuyet(lt10);
            insertDbLyThuyet(lt11);
            insertDbLyThuyet(lt12);
            insertDbLyThuyet(lt13);
            insertDbLyThuyet(lt14);
            insertDbLyThuyet(lt15);
            insertDbLyThuyet(lt16);
            insertDbLyThuyet(lt17);
            insertDbLyThuyet(lt18);
            insertDbLyThuyet(lt19);
            insertDbLyThuyet(lt20);
        }
    }

    public ArrayList<LyThuyet> getAllLyThuyet() {
        ArrayList<LyThuyet> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from LyThuyet", null);
        if (cursor != null)
            cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            list.add(new LyThuyet(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4)));
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return list;
    }

    //XỬ LÝ DỮ LIỆU CÂU HỎI BIỂN BÁO
    public  void insertDbLyThuyetBienBao(LyThuyetBienBao lt) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("CauHoi", lt.getCauHoi());
        contentValues.put("HinhAnh", lt.getHinhAnh());
        contentValues.put("DapAn1", lt.getDapAn1());
        contentValues.put("DapAn2", lt.getDapAn2());
        contentValues.put("DapAn3", lt.getDapAn3());
        contentValues.put("DapAnDung", lt.getDapAnDung());

        int result = (int) db.insert("LyThuyetBienBao", null, contentValues);
        db.close();
    }

    public void createLyThuyetBienBao() {
        String countQuery = "SELECT  * FROM " + "LyThuyetBienBao";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();

        if(count == 0)
        {
            LyThuyetBienBao lt1 =  new LyThuyetBienBao("Khi gặp biển nào thì xe mô tô hai bánh được đi vào?",R.drawable.ltbienbao_1,"Không biển nào.","Biển 1 và 2.","Biển 2 và 3.","3");
            LyThuyetBienBao lt2 = new LyThuyetBienBao("Biển nào xe được phép quay đầu nhưng không được rẽ trái?",R.drawable.ltbienbao_2,"Biển 1.","Biển 2.","Cả hai biển.","1");
            LyThuyetBienBao lt3 = new LyThuyetBienBao("Biển nào báo hiệu \"Giao nhau với đường sắt có rào chắn\"?",R.drawable.ltbienbao_3,"Biển 1.","Biển 2 và 3.","Biển 3..","1");
            LyThuyetBienBao lt4 = new LyThuyetBienBao("Biển nào báo hiệu \"Đường bị thu hẹp\"?",R.drawable.ltbienbao_4,"Biển 1 và 2.","Biển 1 và 3.","Biển 2 và 3.","1");
            LyThuyetBienBao lt5 = new LyThuyetBienBao("Biển nào báo hiệu \"Chú ý chướng ngại vật\"?",R.drawable.ltbienbao_5,"Biển 1.","Biển 2 và 3.","Cả ba biển.","2");
            LyThuyetBienBao lt6 =  new LyThuyetBienBao("Biển nào cấm các phương tiện giao thông đường bộ rẽ phải?",R.drawable.ltbienbao_6,"Biển 1 và 2","Biển 1 và 3","Biển 2 và 3.","1");
            LyThuyetBienBao lt7 = new LyThuyetBienBao("Biển nào cấm tất cả các loại xe cơ giới và xe thô sơ đi lại trên đường, trừ xe ưu tiên theo luật định (nếu đường vẫn cho xe chạy được)?",R.drawable.ltbienbao_7,"Biển 1.","Biển 2.","Cả hai biển.","1");
            LyThuyetBienBao lt8 = new LyThuyetBienBao("Gặp biển nào người lái xe phải nhường đường cho người đi bộ?",R.drawable.ltbienbao_8,"Biển 1.","Biển 2.","Biển 3.","1");
            LyThuyetBienBao lt9 = new LyThuyetBienBao("Biển nào báo hiệu sắp đến chỗ giao nhau với đường bộ và đường sắt?",R.drawable.ltbienbao_9,"Biển 1.","Biển 2.","Biển 3.","1");
            LyThuyetBienBao lt10 = new LyThuyetBienBao("Biển nào báo hiệu \"Đường đôi\"?",R.drawable.ltbienbao_10,"Biển 1.","Biển 2.","Biển 3.","3");

            insertDbLyThuyetBienBao(lt1);
            insertDbLyThuyetBienBao(lt2);
            insertDbLyThuyetBienBao(lt3);
            insertDbLyThuyetBienBao(lt4);
            insertDbLyThuyetBienBao(lt5);
            insertDbLyThuyetBienBao(lt6);
            insertDbLyThuyetBienBao(lt7);
            insertDbLyThuyetBienBao(lt8);
            insertDbLyThuyetBienBao(lt9);
            insertDbLyThuyetBienBao(lt10);
        }
    }

    public ArrayList<LyThuyetBienBao> getAllLyThuyetBienBao() {
        ArrayList<LyThuyetBienBao> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from LyThuyetBienBao", null);
        if (cursor != null)
            cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            list.add(new LyThuyetBienBao(cursor.getString(0),cursor.getInt(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5)));
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return list;
    }

    //XỬ LÝ DỮ LIỆU CÂU HỎI HÌNH ẢNH
    public  void insertDbLyThuyetHinhAnh(LyThuyetHinhAnh lt) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("CauHoi", lt.getCauHoi());
        contentValues.put("HinhAnh", lt.getHinhAnh());
        contentValues.put("DapAn1", lt.getDapAn1());
        contentValues.put("DapAn2", lt.getDapAn2());
        contentValues.put("DapAn3", lt.getDapAn3());
        contentValues.put("DapAnDung", lt.getDapAnDung());

        int result = (int) db.insert("LyThuyetHinhAnh", null, contentValues);
        db.close();
    }

    public void createLyThuyetHinhAnh() {
        String countQuery = "SELECT  * FROM " + "LyThuyetHinhAnh";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();

        if(count == 0)
        {
            LyThuyetHinhAnh lt1 =  new LyThuyetHinhAnh("Thứ tự các xe đi như thế nào là đúng quy tắc giao thông?",R.drawable.lthinhanh_1,"Xe tải, xe khách, xe con, mô tô.","Xe tải, mô tô, xe khách, xe con.","Xe khách, xe tải, xe con, mô tô.","2");
            LyThuyetHinhAnh lt2 = new LyThuyetHinhAnh("Các xe đi theo hướng mũi tên, xe nào vi phạm quy tắc giao thông?",R.drawable.lthinhanh_2,"Xe khách, xe tải, mô tô.","Xe tải, xe con, mô tô.","Xe khách, xe con, mô tô.","1");
            LyThuyetHinhAnh lt3 = new LyThuyetHinhAnh("Theo hướng mũi tên, những hướng nào xe gắn máy đi được?",R.drawable.lthinhanh_3,"Cả ba hướng.","Chỉ hướng 1 và 3.","Chỉ hướng 1.","1");
            LyThuyetHinhAnh lt4 = new LyThuyetHinhAnh("Các xe đi như thế nào là đúng quy tắc giao thông?",R.drawable.lthinhanh_4,"Các xe ở phía tay phải và tay trái của người điều khiển được phép đi thẳng","Cho phép các xe ở mọi hướng được rẽ phải.","Tất cả các xe phải dừng lại trước ngã tư, trừ những xe đã ở trong ngã tư được phép tiếp tục đi.","3");
            LyThuyetHinhAnh lt5 = new LyThuyetHinhAnh("Theo tín hiệu đèn của xe cơ giới, xe nào vi phạm quy tắc giao thông?",R.drawable.lthinhanh_5,"Xe mô tô.","Xe ô tô con.","Cả hai xe.","3");
            LyThuyetHinhAnh lt6 =  new LyThuyetHinhAnh("Xe nào dừng đúng theo quy tắc giao thông?",R.drawable.lthinhanh_6,"Xe con.","Xe mô tô.","Cả hai xe đều đúng.","1");
            LyThuyetHinhAnh lt7 = new LyThuyetHinhAnh("Thứ tự các xe đi như thế nào là đúng quy tắc giao thông?",R.drawable.lthinhanh_7,"Xe tải, xe con, mô tô.","Xe con, xe tải, mô tô.","Mô tô, xe con, xe tải.","3");
            LyThuyetHinhAnh lt8 = new LyThuyetHinhAnh("Thứ tự các xe đi như thế nào là đúng quy tắc giao thông?",R.drawable.lthinhanh_8,"Xe khách, xe tải, mô tô, xe con.","Xe con, xe khách, xe tải, mô tô.","Mô tô, xe tải, xe khách, xe con.","3");
            LyThuyetHinhAnh lt9 = new LyThuyetHinhAnh("Xe nào đỗ vi phạm quy tắc giao thông?",R.drawable.lthinhanh_9,"Cả hai xe.","Không xe nào vi phạm.","Chỉ xe mô tô vi phạm.","1");
            LyThuyetHinhAnh lt10 = new LyThuyetHinhAnh("Theo hướng mũi tên, xe nào được phép đi?",R.drawable.lthinhanh_10,"Mô tô, xe con.","Xe con, xe tải.","Mô tô, xe tải.","3");

            insertDbLyThuyetHinhAnh(lt1);
            insertDbLyThuyetHinhAnh(lt2);
            insertDbLyThuyetHinhAnh(lt3);
            insertDbLyThuyetHinhAnh(lt4);
            insertDbLyThuyetHinhAnh(lt5);
            insertDbLyThuyetHinhAnh(lt6);
            insertDbLyThuyetHinhAnh(lt7);
            insertDbLyThuyetHinhAnh(lt8);
            insertDbLyThuyetHinhAnh(lt9);
            insertDbLyThuyetHinhAnh(lt10);
        }
    }

    public ArrayList<LyThuyetHinhAnh> getAllLyThuyetHinhAnh() {
        ArrayList<LyThuyetHinhAnh> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from LyThuyetHinhAnh", null);
        if (cursor != null)
            cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            list.add(new LyThuyetHinhAnh(cursor.getString(0),cursor.getInt(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5)));
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return list;
    }

    //XỬ LÝ DỮ LIỆU BIỂN BÁO
    public  void insertDbBienBao(BienBao lt) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("SoHieu", lt.getSoHieu());
        contentValues.put("HinhAnh", lt.getHinhAnh());
        contentValues.put("TenBienBao", lt.getTenBienBao());
        contentValues.put("NoiDung", lt.getNoiDung());

        int result = (int) db.insert("BienBao", null, contentValues);
        db.close();
    }

    public void createBienBao() {
        String countQuery = "SELECT  * FROM " + "BienBao";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();

        if(count == 0)
        {
            BienBao b1 = new BienBao("140", R.drawable.bienbao_1, "Cấm xe công nông", "Để báo đường cấm công nông.");
            BienBao b2 = new BienBao("139", R.drawable.bienbao_2, "Cấm đi thẳng và rẽ phải", "Biểu thị đường qua nút giao cấm tất cả các loại xe đi thẳng và rẽ phải; biển đặt ở vị trí ngay trước nút giao. Nếu có quy định cấm về thời gian hoặc loại xe thì sử dụng biển báo phụ thời gian hoặc hình vẽ loại xe cấm.");
            BienBao b3 = new BienBao("138", R.drawable.bienbao_3, "Cấm đi thẳng và rẽ trái", "Biểu thị đường qua nút giao cấm tất cả các loại xe đi thẳng và rẽ trái; biển đặt ở vị trí ngay trước nút giao. Nếu có quy định cấm về thời gian hoặc loại xe thì sử dụng biển báo phụ thời gian hoặc hình vẽ loại xe cấm.");
            BienBao b4 = new BienBao("137", R.drawable.bienbao_4, "Cấm rẽ trái và rẽ phải", "Các ngả đường phía trước cấm tất cả các lại xe rẽ trái hay rẽ phải. Biển được đặt ở vị trí ngay trước nút giao của đường cấm rẽ phải hay rẽ trái. Nếu có quy định cấm về thời gian hoặc loại xe thì sử dụng biển báo phụ thời gian hoặc hình vẽ loại xe cấm.");
            BienBao b5 = new BienBao("136", R.drawable.bienbao_5, "Cấm đi thẳng", "Đường ở phía trước cấm tất cả các loại xe đi thẳng. Biển được đặt ở vị trí ngay trước nút giao của đường cấm đi thẳng. Nếu có quy định cắm về thời gian và loại xe thì sử dụng biển báo phụ thời gian hoặc hình vẽ loại xe cấm.");
            BienBao b6 = new BienBao("135", R.drawable.bienbao_6, "Hết tất cả các lệnh cấm", "Báo hết đoạn đường mà nhiều biển báo cấm cùng hết hiệu lực. Biển có giá trị báo cho người lái xe biết hiệu lực của biển số 121 và nhiều biển cấm khác từ biển số 125 đến biển số 131 (a,b,c) được đặt trước đó cùng hết tác dụng.");
            BienBao b7 = new BienBao("134", R.drawable.bienbao_7, "Hết hạn chế tốc độ tối đa", "Báo hết đoạn đường hạn chế tốc độ tối đa. Biển có giá trị báo cho người lái xe biết hiệu lực của biển số 127 hết tác dụng. Kể từ biển này, các xe được phép chạy với tốc độ tối đa đã quy định trong luật đường đường bộ.");
            BienBao b8 = new BienBao("133", R.drawable.bienbao_8, "Hết cấm vượt", "Báo hết đoạn đường cấm vượt. Biển có tác dụng báo cho người lái xe biết hiệu lực của các biển số 125 và biển số 126 hết tác dụng. Các xe cơ giới được phép vượt nhau nhưng phải theo quy định về điều kiện cho phép vượt nhau.");
            BienBao b9 = new BienBao("132", R.drawable.bienbao_9, "Nhường đường cho xe cơ giới đi ngược chiều qua đường hẹp", "Báo các loại xe (cơ giới và thô sơ) kể cả các xe được ưu tiên theo quy định khi thấy biển số 132 phải nhường đường cho các loại xe cơ giới đang đi theo hướng ngược lại qua các đoạn đường hẹp hoặc cầu hẹp.");
            BienBao b10 = new BienBao("131c", R.drawable.bienbao_10, "Cấm đỗ xe", "Biển số 131c có hiệu lực cấm các loại xe cơ giới đỗ ở phía đường có đặt biển vào những ngày chẵn.");
            BienBao b11 = new BienBao("131b", R.drawable.bienbao_11, "Cấm đỗ xe", "Biển số 131b có hiệu lực cấm các loại xe cơ giới đỗ ở phía đường có đặt biển vào những ngày lẻ.");
            BienBao b12 = new BienBao("131a", R.drawable.bienbao_12, "Cấm đỗ xe", "Biển số 131a có hiệu lực cấm các loại xe cơ giới đỗ ở phía đường có đặt biển.");
            BienBao b13 = new BienBao("130", R.drawable.bienbao_13, "Cấm dừng xe và đỗ xe", "Để báo nơi cấm dừng xe và đỗ xe. Biển có hiệu lực cấm các loại xe cơ giới dừng và đỗ ở phía đường có đặt biển trừ các xe được ưu tiên theo quy định. Đối với các loại xe ôtô buýt, tắc xi chạy theo hành trình quy định được hướng dẫn vị trí dừng thích hợp.");
            BienBao b14 = new BienBao("129", R.drawable.bienbao_14, "Kiểm tra", "Để báo nơi đặt trạm kiểm tra; các loại phương tiện vận tải qua đó phải dừng lại để làm thủ tục kiểm tra, kiểm soát theo quy định.");
            BienBao b15 = new BienBao("128", R.drawable.bienbao_15, "Cấm sử dụng còi", "Báo cấm các loại xe cơ giới sử dụng còi. Chiều dài có hiệu lực của biển cấm bóp còi được báo bằng biển số 501 \"Phạm vi tác dụng của biển\" đặt dưới biển chính (hoặc từ vị trí đặt biển đến vị trí đặt biển số 135 \"Hết tất cả các lệnh cấm\" nếu đồng thời có nhiều biển cấm khác hết tác dụng).");
            BienBao b16 = new BienBao("127", R.drawable.bienbao_16, "Tốc độ tối đa cho phép", "Để báo tốc độ tối đa cho phép các xe cơ giới chạy. Biển có hiệu lực cấm tất cả các loại xe cơ giới chạy với tốc độ tối đa vượt quá trị số ghi trên biển trừ các xe được ưu tiên theo quy định.");
            BienBao b17 = new BienBao("125", R.drawable.bienbao_17, "Cấm vượt", "Báo cấm các loại xe cơ giới vượt nhau.Biển có hiệu lực cấm tất cả các loại xe cơ giới vượt nhau kể cả xe được ưu tiên theo quy định. Được phép vượt xe môtô 2 bánh, xe gắn máy. Biển hết hiệu lực cấm khi có biển số 133 \"Hết cấm vượt\" hoặc đến vị trí đặt biển số 135 \"Hết tất cả các lệnh cấm\" nếu đồng thời có nhiều biển cấm khác hết tác dụng.");
            BienBao b18 = new BienBao("124b", R.drawable.bienbao_18, "Cấm ôtô quay đầu xe", "Báo cấm xe ôtô quay đầu (theo kiểu chữ U)");
            BienBao b19 = new BienBao("124a", R.drawable.bienbao_19, "Cấm quay xe", "Báo cấm các loại xe quay đầu (theo kiểu chữ U.");
            BienBao b20 = new BienBao("123a", R.drawable.bienbao_20, "Cấm rẽ trái", "Báo cấm rẽ trái (theo hướng mũi tên chỉ) ở những vị trí đường giao nhau. Biển có hiệu lực cấm các loại xe (cơ giới và thô sơ) rẽ sang phía trái trừ các xe được ưu tiên theo quy định.");

            insertDbBienBao(b1);
            insertDbBienBao(b2);
            insertDbBienBao(b3);
            insertDbBienBao(b4);
            insertDbBienBao(b5);
            insertDbBienBao(b6);
            insertDbBienBao(b7);
            insertDbBienBao(b8);
            insertDbBienBao(b9);
            insertDbBienBao(b10);
            insertDbBienBao(b11);
            insertDbBienBao(b12);
            insertDbBienBao(b13);
            insertDbBienBao(b14);
            insertDbBienBao(b15);
            insertDbBienBao(b16);
            insertDbBienBao(b17);
            insertDbBienBao(b18);
            insertDbBienBao(b19);
            insertDbBienBao(b20);
        }
    }

    public ArrayList<BienBao> getAllBienBao() {
        ArrayList<BienBao> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from BienBao", null);
        if (cursor != null)
            cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            list.add(new BienBao(cursor.getString(0),cursor.getInt(1), cursor.getString(2), cursor.getString(3)));
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return list;
    }
    public BienBao getBienBao(String soHieu) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from BienBao where SoHieu like " + soHieu, null);

        if(cursor.moveToFirst() && cursor.getCount() > 0){
            //cursor.moveToFirst();
            BienBao bienBao = new BienBao(cursor.getString(0), cursor.getInt(1), cursor.getString(2), cursor.getString(3));

            cursor.close();
            db.close();
            return bienBao;
        }
        return null;
    }

    //XỬ LÝ DỮ LIỆU LUẬT
    public  void insertDbLuat(Luat lt) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("SoLuat", lt.getSoLuat());
        contentValues.put("NoiDung", lt.getNoiDung());
        contentValues.put("MucPhat", lt.getMucPhat());

        int result = (int) db.insert("Luat", null, contentValues);
        db.close();
    }

    public void createLuat() {
        String countQuery = "SELECT  * FROM " + "Luat";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();

        if(count == 0)
        {
            Luat l1 = new Luat("Điểm i Khoản 1 Điều 6 NĐ 100/2019/NĐ-CP","Chuyển làn không có tín hiệu báo trước (Không Xi nhan)","100.000 đồng đến 200.000 đồng");
            Luat l2 = new Luat("Điểm a Khoản 3 Điều 6 NĐ 100/2019/NĐ-CP","Chuyến hướng không có tín hiệu báo hướng rẽ","400.000 đồng đến 600.000 đồng");
            Luat l3 = new Luat("Điểm h Khoản 4 Điều 6 NĐ 100/2019/NĐ-CP","Người đang điều khiển xe máy sử dụng điện thoại di động, thiết bị âm thanh (trừ thiết bị trợ thính)","600.000 đồng đến 1.000.000 đồng");
            Luat l4 = new Luat("Điểm e, khoản 4, Điều 6 NĐ 100/2019/NĐ-CP","Vượt đèn đỏ, đèn vàng","600.000 đồng đến 1.000.000 đồng");
            Luat l5 = new Luat("Điểm g Khoản 3 Điều 6 NĐ 100/2019/NĐ-CP","Đi không đúng phần đường hoặc làn đường quy định (Đi sai làn)","400.000 đồng đến 600.000 đồng (4.000.000 đồng đến 5.000.000 đồng nếu gây tai nạn giao thông).");
            Luat l6 = new Luat("Điểm a Khoản 1 Điều 6 NĐ 100/2019/NĐ-CP","Đi không đúng theo chỉ dẫn của vạch kẻ đường","100.000 đồng đến 200.000 đồng");
            Luat l7 = new Luat("Khoản 5 Điều 6 NĐ 100/2019/NĐ-CP","Đi ngược chiều của đường một chiều, đi ngược chiều trên đường có biển “Cấm đi ngược chiều”","1.000.000 đồng đến 2.000.000 đồng (4.000.000 đồng đến 5.000.000 đồng nếu gây tai nạn giao thông).");
            Luat l8 = new Luat("Điểm i Khoản 3 Điều 6 NĐ 100/2019/NĐ-CP","Đi vào đường có biển báo cấm phương tiện đang điều khiển","400.000 đồng đến 600.000 đồng");
            Luat l9 = new Luat("Điểm a Khoản 1 Điều 17 NĐ 100/2019/NĐ-CP","Điều khiển xe máy không có gương chiếu hậu bên trái hoặc có nhưng không có tác dụng","100.000 đồng đến 200.000 đồng");
            Luat l10 = new Luat("Điểm a Khoản 2 Điều 17 NĐ 100/2019/NĐ-CP","Điều khiển xe không có Giấy đăng ký xe","300.000 đồng đến 400.000 đồng");
            Luat l11 = new Luat("Điểm a Khoản 2 Điều 21 NĐ 100/2019/NĐ-CP","Không có hoặc không mang theo Giấy chứng nhận bảo hiểm trách nhiệm dân sự của chủ xe cơ giới còn hiệu lực","100.000 đồng đến 200.000 đồng");
            Luat l12 = new Luat("Điểm c Khoản 6 Điều 6 NĐ 100/2019/NĐ-CP","Có nồng độ cồn trong máu hoặc hơi thở khi điều khiển xe","2.000.000 đồng đến 3.000.000 đồng nếu trong máu hoặc hơi thở có nồng độ cồn nhưng chưa vượt quá 50 miligam/100 mililít máu hoặc chưa vượt quá 0,25 miligam/1 lít khí thở.");
            Luat l13 = new Luat("Điểm c Khoản 7 Điều 6 NĐ 100/2019/NĐ-CP","Có nồng độ cồn trong máu hoặc hơi thở khi điều khiển xe","4.000.000 đồng đến 5.000.000 đồng nếu có nồng độ cồn vượt quá 50 miligam đến 80 miligam/100 mililít máu hoặc vượt quá 0,25 miligam đến 0,4 miligam/1 lít khí thở.");
            Luat l14 = new Luat("Điểm e Khoản 8 Điều 6 NĐ 100/2019/NĐ-CP","Có nồng độ cồn trong máu hoặc hơi thở khi điều khiển xe","6.000.000 đồng đến 8.000.000 đồng nếu có nồng độ cồn vượt quá 80 miligam/100 mililít máu hoặc vượt quá 0,4 miligam/1 lít khí thở.");
            Luat l15 = new Luat("Điểm a Khoản 7 Điều 6 NĐ 100/2019/NĐ-CP","Điều khiển xe chạy quá tốc độ","4.000.000 đồng đến 5.000.000 đồng nếu chạy quá tốc độ quy định trên 20 km/h.");

            insertDbLuat(l1);
            insertDbLuat(l2);
            insertDbLuat(l3);
            insertDbLuat(l4);
            insertDbLuat(l5);
            insertDbLuat(l6);
            insertDbLuat(l7);
            insertDbLuat(l8);
            insertDbLuat(l9);
            insertDbLuat(l10);
            insertDbLuat(l11);
            insertDbLuat(l12);
            insertDbLuat(l13);
            insertDbLuat(l14);
            insertDbLuat(l15);
        }
    }

    public ArrayList<Luat> getAllLuat() {
        ArrayList<Luat> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Luat", null);
        if (cursor != null)
            cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            list.add(new Luat(cursor.getString(0),cursor.getString(1), cursor.getString(2)));
            cursor.moveToNext();
        }
        cursor.close();
        db.close();
        return list;
    }
}
