package customadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.vtp.btl_ltandroid.R;

import java.util.List;
import object.BienBao;

public class BienBaoAdapter extends BaseAdapter {
    Context contex;
    int pos;
    List<BienBao> list;

    public BienBaoAdapter(Context contex, int pos, List<BienBao> list) {
        this.contex = contex;
        this.pos = pos;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater) contex.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(pos,null);
        //Anh xa
        TextView txtTenBien = (TextView) view.findViewById(R.id.txt_tenBienBao);
        TextView txtSoHieu = (TextView) view.findViewById(R.id.txt_soHieu);
        TextView txtNoiDung = (TextView) view.findViewById(R.id.txt_noiDung);
        ImageView imgHinhAnh = (ImageView) view.findViewById(R.id.img_hinhanh);

        // Gan du lieu
        txtTenBien.setText(list.get(i).getTenBienBao());
        txtSoHieu.setText("Số hiệu: " + list.get(i).getSoHieu());
        imgHinhAnh.setImageResource(list.get(i).getHinhAnh());
        txtNoiDung.setText(list.get(i).getNoiDung());
        // tra ve
        return view;

    }
}
