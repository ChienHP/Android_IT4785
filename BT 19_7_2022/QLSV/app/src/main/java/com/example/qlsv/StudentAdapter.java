package com.example.qlsv;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class StudentAdapter extends BaseAdapter {
    Cursor cs;

    public StudentAdapter(Cursor cs) {
        this.cs = cs;
    }

    @Override
    public int getCount() {
        return cs.getCount();
    }

    @Override
    public Object getItem(int i) {
        return cs.moveToPosition(i);
    }

    @Override
    public long getItemId(int i) {
        cs.moveToPosition(i);
        return cs.getInt(0);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null)
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_item, viewGroup, false);

        TextView textMssv = view.findViewById(R.id.text_mssv);
        TextView textName = view.findViewById(R.id.text_name);

        cs.moveToPosition(i);
        String mssv = cs.getString(0);
        String name = cs.getString(1);
        textMssv.setText(mssv);
        textName.setText(name);

        return view;
    }
}