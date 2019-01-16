package com.boyhotkey96.jsoupdemkhuyatv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BongDaCustomAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Bongda> bongdaArrayList;

    public BongDaCustomAdapter(Context context, ArrayList<Bongda> bongdaArrayList) {
        this.context = context;
        this.bongdaArrayList = bongdaArrayList;
    }

    @Override
    public int getCount() {
        return bongdaArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return bongdaArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.bongda_row, null);
            viewHolder = new ViewHolder();

            viewHolder.imgDoi1 = convertView.findViewById(R.id.imgDoi1);
            viewHolder.imgDoi2 = convertView.findViewById(R.id.imgDoi2);
            viewHolder.tvGio = convertView.findViewById(R.id.tvGio);
            viewHolder.tvNgay = convertView.findViewById(R.id.tvNgay);
            viewHolder.tvPhi = convertView.findViewById(R.id.tvPhi);
            viewHolder.tvTentran = convertView.findViewById(R.id.tvTentran);
            viewHolder.tvGiaidau = convertView.findViewById(R.id.tvGiaidau);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Bongda bongda = bongdaArrayList.get(position);
        Picasso.get().load(bongda.getImgDoi1()).into(viewHolder.imgDoi1);
        Picasso.get().load(bongda.getImgDoi2()).into(viewHolder.imgDoi2);
//        viewHolder.tvLink.setText(bongda.getLink());
        viewHolder.tvGio.setText(bongda.getGio());
        viewHolder.tvNgay.setText(bongda.getNgay());
        viewHolder.tvPhi.setText(bongda.getPhi());
        viewHolder.tvTentran.setText(bongda.getTentran());
        viewHolder.tvGiaidau.setText(bongda.getGiaidau());

        return convertView;
    }

    public class ViewHolder {
        TextView tvLink, tvGio, tvNgay, tvPhi, tvTentran, tvGiaidau;
        ImageView imgDoi1, imgDoi2;
    }
}
