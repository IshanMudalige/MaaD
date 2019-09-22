package com.aim.sliitquizapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void selectBtn(View view){
        Intent intent = new Intent(HomeActivity.this,SelectquizActivity.class);
        startActivity(intent);
    }

    public void statBtn(View view){
        Intent intent = new Intent(HomeActivity.this,StatisticsActivity.class);
        startActivity(intent);
    }

    public void feedBtn(View view){
        Intent intent = new Intent(HomeActivity.this,FeedbackActivity.class);
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
        if (id == R.id.action_exit) {
            AlertDialog.Builder adb = new AlertDialog.Builder(HomeActivity.this);
            adb.setMessage("Do you really want to close ?");
            //adb.setIcon(R.drawable.tott);

            adb.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    moveTaskToBack(true);
                    android.os.Process.killProcess(android.os.Process.myPid());
                    System.exit(1);

                }
            });

            adb.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });

            AlertDialog alert = adb.create();
            alert.setTitle("Exiting tha app");
            alert.show();

        }else if(id == R.id.action_clear){
            DatabaseReference dbNode = FirebaseDatabase.getInstance().getReference().getRoot().child("Statistics");
            dbNode.setValue(null);
            Toast.makeText(HomeActivity.this, "Records Cleared Successfully", Toast.LENGTH_SHORT).show();
        }else if(id == R.id.action_about){
            AlertDialog.Builder adb = new AlertDialog.Builder(HomeActivity.this);
            adb.setMessage("SLIIT Quiz app is a better app for practicing for online mid term examinations");

            adb.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });

            AlertDialog alert = adb.create();
            alert.setTitle("SLIIT Quiz App");
            alert.show();

        }else if(id == R.id.action_logout){
            FirebaseAuth.getInstance().signOut();
            Intent intToMain = new Intent(HomeActivity.this, MainActivity.class);
            startActivity(intToMain);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

    }
}
