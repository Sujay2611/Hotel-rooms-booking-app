package com.example.gnanesh.hotelmgmt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void gotoregister(View view)
    {
        Intent intent=new Intent(this,RegistrationActivity.class);
        startActivity(intent);
    }
    public void loginActivity(View view)
    {
        Intent intent1=new Intent(this,LoginActivity.class); startActivity(intent1);
    }
    public void inform(View view)
    {
        Intent intent3=new Intent(this,Main2Activity.class);
        startActivity(intent3);
    }
    @Override
    public void onBackPressed(){
        moveTaskToBack(true);
    }
}
