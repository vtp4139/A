package customadapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.vtp.btl_ltandroid.R;

import java.util.List;

import object.BienBao;
import object.LyThuyet;

public class LyThuyetAdapter extends BaseAdapter {
    Context contex;
    int pos;
    List<LyThuyet> list;

    public LyThuyetAdapter(Context contex, int pos, List<LyThuyet> list) {
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
        TextView txtCauHoi = (TextView) view.findViewById(R.id.textView_cauHoi);
        TextView txtDapAna = (TextView) view.findViewById(R.id.textView_dapAnA);
        TextView txtDapAnb = (TextView) view.findViewById(R.id.textView_dapAnB);
        TextView txtDapanc = (TextView) view.findViewById(R.id.textView_dapAnC);
        // Gan du lieu
        int cau = i+1;
        txtCauHoi.setText("Câu " + cau +": " + list.get(i).getCauHoi());
        txtDapAna.setText("1. " + list.get(i).getDapAn1());
        txtDapAnb.setText("2. " + list.get(i).getDapAn2());
        txtDapanc.setText("3. " + list.get(i).getDapAn3());

        if(list.get(i).getDapAnDung().equals("1"))
        {
            txtDapAna.setTextColor(Color.parseColor("#4CAF50"));
        }
        else if(list.get(i).getDapAnDung().equals("2"))
        {
            txtDapAnb.setTextColor(Color.parseColor("#4CAF50"));
        }
        else{
            txtDapanc.setTextColor(Color.parseColor("#4CAF50"));
        }

        return view;

    }
}
