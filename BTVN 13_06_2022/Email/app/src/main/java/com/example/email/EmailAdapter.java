package com.example.email;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class EmailAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<EmailModel> arraylist;

    public EmailAdapter(Context context, int layout, List<EmailModel> arraylist) {
        this.context = context;
        this.layout = layout;
        this.arraylist = arraylist;
    }

    @Override
    public int getCount() {
        return arraylist.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.email_layout, null);
            viewHolder = new MyViewHolder();
            viewHolder.name = view.findViewById(R.id.name);
            viewHolder.time = view.findViewById(R.id.time);
            viewHolder.content = view.findViewById(R.id.content);
            view.setTag(viewHolder);
        } else {
            viewHolder =(MyViewHolder) view.getTag();
        }

        EmailModel email = arraylist.get(i);
        viewHolder.name.setText(email.getName());
        viewHolder.content.setText(email.getContent());
        viewHolder.time.setText(email.getTime());

        return view;
    }

    class MyViewHolder{
        TextView name;
        TextView time;
        TextView content;
    }
}
