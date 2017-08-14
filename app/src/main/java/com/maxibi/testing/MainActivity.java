package com.maxibi.testing;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ListView listView;
    public Button buttonSearch;
    public EditText editText;
    public TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = (ListView)findViewById(R.id.listView);
        buttonSearch = (Button)findViewById(R.id.searchButton);
        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.test);

        final DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        final ArrayList<Word> quotes = databaseAccess.getQuotes(); // dapatkan semua qoutes

        CustomAdapter customAdapter = new CustomAdapter(this,quotes);
        listView.setAdapter(customAdapter);


    }



}
