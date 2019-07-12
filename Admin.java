package com.example.gnanesh.hotelmgmt;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        final Spinner dropdown=findViewById(R.id.spinner);
        String[] items=new String[]{"Room-1","Room-2","Room-3","Room-4","Room-5"};
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,items);
        dropdown.setAdapter(adapter);
        MyDb myDb=new MyDb(this);
        Button all=findViewById(R.id.button8);
        final SQLiteDatabase db=myDb.getWritableDatabase();
        final SQLiteDatabase dbr=myDb.getReadableDatabase();
        final Button b1=findViewById(R.id.button5);
        Button b2=findViewById(R.id.button6);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c=dbr.rawQuery("SELECT * FROM rooms",null);
                StringBuffer buffer=new StringBuffer();
                while (c.moveToNext()){
                    buffer.append("Room number "+c.getString(0)+"\n");
                    buffer.append("Name"+c.getString(1)+"\n");
                    buffer.append("StartDate"+c.getString(2)+"\n");
                    buffer.append("Days"+c.getString(3)+"\n");

                }
                showMessage("Room details",buffer.toString());
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Room=dropdown.getSelectedItem().toString();
                String table="rooms";
                String where="room_no=?";
                db.delete(table,where,new String[]{Room});
                Toast.makeText(getApplicationContext(),"DELETED ROOM INFO OF "+Room,Toast.LENGTH_SHORT).show();
            }
        });
        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cc=dbr.rawQuery("SELECT * FROM Customer",null);
                StringBuffer buffer=new StringBuffer();
                while (cc.moveToNext())
                {
                    buffer.append("Name "+cc.getString(0)+"\n");
                    buffer.append("Username"+cc.getString(1)+"\n");
                    buffer.append("passs"+cc.getString(2)+"\n");
                    buffer.append("Gender "+cc.getString(3)+"\n");
                    //buffer.append("Start Date"+cc.getString(4)+"\n");
                    //buffer.append("End Date"+cc.getString(5)+"\n");
                }
                showMessage("Users Registered",buffer.toString());
            }
        });
    }
    public void showMessage(String title,String message) { AlertDialog.Builder builder=new AlertDialog.Builder(this); builder.setCancelable(true); builder.setTitle(title); builder.setMessage(message); builder.show(); }

}
