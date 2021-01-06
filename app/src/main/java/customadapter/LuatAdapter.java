package customadapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.vtp.btl_ltandroid.R;

import java.util.List;

import object.Luat;
import object.LyThuyet;

public class LuatAdapter extends BaseAdapter {
    Context contex;
    int pos;
    List<Luat> list;

    public LuatAdapter(Context contex, int pos, List<Luat> list) {
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
        TextView txtSoLuat = (TextView) view.findViewById(R.id.textView_soluat);
        TextView txtNoiDung = (TextView) view.findViewById(R.id.textView_noidung);
        TextView txtMucPhat = (TextView) view.findViewById(R.id.textView_mucphat);

        // Gan du lieu

        txtSoLuat.setText(list.get(i).getSoLuat());
        txtNoiDung.setText(list.get(i).getNoiDung());
        txtMucPhat.setText("Mức phạt: " + list.get(i).getMucPhat());

        return view;
    }
}
