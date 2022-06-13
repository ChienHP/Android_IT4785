package com.example.email;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<EmailModel> arraylist;
    EmailAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arraylist = new ArrayList<>();
        arraylist.add(new EmailModel("Edurila.com", "12:34 PM", "$19 Only (First 10 spots) - Bestselling ...)"));
        arraylist.add(new EmailModel("Chris Abad", "11:22 PM", "Help make Campaign Monitor better. Let us know ..."));
        arraylist.add(new EmailModel("Tuto.com", "11:04 PM", "8h de formation gratuite et les nouvea ..."));
        arraylist.add(new EmailModel("support", "10:26 PM", "Societe Ovh : suivi de vps services - hp ..."));
        arraylist.add(new EmailModel("Matt from Ionic", "10:12 PM", "The New Ionic Creater is Here! Announcing the all ...)"));
        arraylist.add(new EmailModel("Nguyen Huu Huan", "15:24 PM", "$19 Only (First 10 spots) - Bestselling ...)"));
        arraylist.add(new EmailModel("BK Ha Noi", "12:30 PM", "$19 Only (First 10 spots) - Bestselling ...)"));

        adapter = new EmailAdapter(MainActivity.this, R.layout.email_layout, arraylist);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void chooseEmail(View view){
        MainActivity.this.startActionMode(new ActionMode.Callback() {
            @Override
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                getMenuInflater().inflate(R.menu.action_mode_menu, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {

                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode actionMode) {

            }
        });
    }
}