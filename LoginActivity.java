package com.example.gnanesh.hotelmgmt;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button b1=findViewById(R.id.button7);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText uEditText1=findViewById(R.id.editText);
                EditText pEditText2=findViewById(R.id.editText4);
                String uname=uEditText1.getText().toString();
                String pass=pEditText2.getText().toString();
                String pesu="pes";
                if(uname.equals(pesu) && pass.equals(pesu)){
                    Intent i=new Intent(getApplicationContext(),Admin.class);
                    startActivity(i);
                }

            }
        });
    }
    public void login(View view)
    {
        MyDb myDb=new MyDb(this);
        SQLiteDatabase db=myDb.getReadableDatabase();

        String[] columns={"username","pass"};
        EditText uEditText=findViewById(R.id.editText);
        EditText pEditText=findViewById(R.id.editText4);
        String[] cValues={uEditText.getText().toString(),pEditText.getText().toString()};
        Cursor cursor=db.query("Customer",columns,"username = ? AND pass = ?",cValues,null,null,null);
        if(cursor!=null)
        {
            if(cursor.moveToFirst()){
                Intent intent=new Intent(this,ProfileActivity.class);
                intent.putExtra("Username",uEditText.getText().toString());
                startActivity(intent);
            }
            else
            {
                Toast.makeText(this,"Wrong Login Details",Toast.LENGTH_LONG).show();
            }
        }

    }
}
