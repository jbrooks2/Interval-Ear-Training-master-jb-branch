package com.example.tazzie.intervaleartraining;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class PerformanceActivity extends ActionBarActivity {
    SQLiteDatabase mydatabase;
    private static final String TrackerTag = "TrackerTag";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_performance);
        mydatabase = openOrCreateDatabase("performance",MODE_PRIVATE,null);
        Cursor resultSet = mydatabase.rawQuery("Select * from history",null);
        resultSet.moveToFirst();
        Log.d(TrackerTag, "dbContent" + resultSet.getCount());
        while(!resultSet.isAfterLast()) {
            Log.d(TrackerTag, "dbContent " +  resultSet.getInt(4) + " " +resultSet.getInt(1) + " " + resultSet.getInt(2) + " " + resultSet.getInt(3) + " " + resultSet.getInt(0));
            resultSet.moveToNext();

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_performance, menu);
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
}
