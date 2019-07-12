package com.example.gnanesh.hotelmgmt;

import android.app.Notification;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AfterBooking extends AppCompatActivity {
    private final String Channel_ID="personal_notification";
    private final int NOTIFICATION_ID=001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyDb myDb=new MyDb(this);
        SQLiteDatabase db=myDb.getReadableDatabase();
        setContentView(R.layout.activity_after_booking);
        Bundle bundle=getIntent().getExtras();
        int j=0;
        final String usn=bundle.getString("Username");
        final String Room_no=bundle.getString("Room_no");
        //int numberofdays=getIntent().getExtras().getInt("Number_of_days");
        String nom=getIntent().getExtras().getString("Number_of_days");
        int nn=Integer.parseInt(nom);
        switch (Room_no)
        {
            case "Room-1":
                j=500;
                break;
            case "Room-2":
                j=1000;
                break;
            case "Room-3":
                j=1100;
                break;
            case "Room-4":
                j=1400;
                break;
            case "Room-5":
                j=2000;
                break;
            default:
                j=0;
        }
        int num=nn*j;
        TextView text=findViewById(R.id.textView18);
        text.setText("Your total cost will be \n"+String.valueOf(num));
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,Channel_ID);
        builder.setSmallIcon(R.drawable.ic_hotel_book);
        builder.setContentTitle("Nikhil hotels");
        builder.setContentText("Booked" +
                " "+Room_no);


        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat notificationManagerCompat=NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(NOTIFICATION_ID,builder.build());
        TextView tt=findViewById(R.id.textView13);
        tt.setText("Thank You!");
        Button butt=findViewById(R.id.button4);
        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(j);
            }
        });
    }

    @Override
    public void onBackPressed(){
        moveTaskToBack(true);
    }
}
