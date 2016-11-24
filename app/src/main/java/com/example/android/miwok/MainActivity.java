package com.example.android.miwok;

import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openNumbersList(View view){

        Intent intent = new Intent(MainActivity.this,NumbersActivity.class);
        startActivity(intent);
    }

    public void openFamilyMembers(View view){

        Intent intent = new Intent(MainActivity.this,FamilyActivity.class);
        startActivity(intent);
    }

    public void openColors(View view){

        Intent intent = new Intent(MainActivity.this,ColorsActivity.class);
        startActivity(intent);
    }

    public void openPhrases(View view){

        Intent intent = new Intent(MainActivity.this,PhrasesActivity.class);
        startActivity(intent);
    }


}
