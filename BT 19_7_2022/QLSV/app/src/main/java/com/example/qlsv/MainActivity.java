package com.example.qlsv;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.example.qlsv.databinding.ActivityMainBinding;

import io.bloco.faker.Faker;

public class MainActivity extends AppCompatActivity {

//    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    SQLiteDatabase db;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        listView = findViewById(R.id.list_view);


        setSupportActionBar(binding.toolbar);

        //NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        //appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        // Open DB
        String path = getFilesDir() + "/mydb";
        try {
            db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.CREATE_IF_NECESSARY);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        createTable();

        findViewById(R.id.button_insert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.beginTransaction();
                try {
                    Faker faker = new Faker();
                    String mssv = faker.number.digit();
                    String name = faker.name.name();
                    String email = faker.internet.email();
                    String birth = faker.date.toString();

                    db.execSQL("insert into tblStudent (mssv, name, email, birth) values('" + mssv + "', '" + name + "','" + email + "', '" + birth + "')");

                    db.setTransactionSuccessful();
                } catch (Exception ex) {
                    ex.printStackTrace();
                } finally {
                    db.endTransaction();
                }
            }
        });

        findViewById(R.id.button_select).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String sql = "select * from tblStudent";
//                Cursor cs = db.rawQuery(sql, null);
                String[] columns = {"mssv", "name", "email"};
                Cursor cs = db.query("tblStudent", columns,
                        null, null, null, null ,null);

                Log.v("TAG", "# records: " + cs.getCount());

                cs.moveToPosition(-1);
                while (cs.moveToNext()) {
                    String mssv = cs.getString(0);
                    String name = cs.getString(1);
                    String email = cs.getString(2);

                    Log.v("TAG", mssv + " --- " +name + " --- " + email);
                }

                StudentAdapter adapter = new StudentAdapter(cs);
                listView.setAdapter(adapter);
            }
        });

    }

    public void createTable() {
        db.beginTransaction();
        try {
            db.execSQL("create table tblStudent(" +
                    "mssv text PRIMARY KEY," +
                    "name text," +
                    "email text," +
                    "birth text)");

            db.execSQL("insert into tblStudent(mssv, name, email, birth) values('194233', 'Lê Văn Chiến', 'levanchien220801@gmail.com', '22/08/2001')");
            db.execSQL("insert into tblStudent(mssv, name, email, birth) values('194234', 'Lê Văn Chiến', 'levanchien@gmail.com', '23/08/2001')");
            db.execSQL("insert into tblStudent(mssv, name, email, birth) values('194235', 'Lê Văn Chiến', 'levanchien', '24/08/2001')");

            db.setTransactionSuccessful();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }

    @Override
    protected void onDestroy() {
        db.close();
        super.onDestroy();
    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //@Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
//        return NavigationUI.navigateUp(navController, appBarConfiguration)
//                || super.onSupportNavigateUp();
//    }
}
