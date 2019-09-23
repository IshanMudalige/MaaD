package com.aim.sliitquizapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {






    Button btnIns;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnIns=(Button) findViewById(R.id.btnIns);
        btnIns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openexp();

            }
        });


    }

    public void openexp(){

        Intent intent = new Intent(this,exp.class);
        startActivity(intent);
    }


    /*
    private Button btnIns;



    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnIns = (Button)findViewById(R.id.btnIns);


        btnIns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new exp();

            }
        });
    }

    public void openbtnIns(){

        Intent intent = new Intent(this,exp.class);
        startActivity(intent);
    }



*/



/*

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }


*/




    public void selectBtn(View view){
        Intent intent = new Intent(HomeActivity.this,QuestionActivity.class);
        startActivity(intent);
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
}
