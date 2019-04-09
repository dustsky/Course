package com.shishike.course.ui.main.adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shishike.course.R;
import com.shishike.course.bean.SubjectBean;
import com.squareup.picasso.Picasso;

import java.util.List;


public class SubjectAdapter extends BaseAdapter {

    private static List<SubjectBean> mSubjects;
    private LayoutInflater mInflater;
    public SubjectAdapter(Context context, List<SubjectBean> subjects){
        mSubjects = subjects;
        mInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return mSubjects.size();
    }

    @Override
    public Object getItem(int position) {
        return mSubjects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            convertView = mInflater.inflate(R.layout.item_subject, null);
            holder = new ViewHolder();
            holder.icon = (ImageView) convertView.findViewById(R.id.subject_icon);
            holder.name = (TextView) convertView.findViewById(R.id.subject_name);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.name.setText(mSubjects.get(position).getName());
        Picasso.get().load(mSubjects.get(position).getIcon()).into(holder.icon);

        return convertView;
    }

    static class ViewHolder{
        ImageView icon;
        TextView name;
    }
}
