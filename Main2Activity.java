package com.example.gnanesh.hotelmgmt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gnanesh.hotelmgmt.R;
public class Main2Activity extends AppCompatActivity {
    GridView gridView;

    String[] facilities = {"Pool","Gym","Spa","Restaurant","WiFi","Chauffeur"};
    String[] text={"Massive pool in the hotel","Be healthy and hit the gym","A unisex spa for relaxation","Amazing restaurant with famous chefs","Upto 100 mbps","Luxury service"};
    int[] facimages = {R.drawable.pool,R.drawable.gym,R.drawable.spa,R.drawable.restaurant,R.drawable.wifi,R.drawable.car};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //finding listview
        gridView = findViewById(R.id.gridview);

        CustomAdapter customAdapter = new CustomAdapter();
        gridView.setAdapter(customAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(getApplicationContext(),fruitNames[i],Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), GriDItemActivity.class);
                intent.putExtra("name",facilities[i]);
                intent.putExtra("image",facimages[i]);
                intent.putExtra("msg",text[i]);
                startActivity(intent);

            }
        });


    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return facimages.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1 = getLayoutInflater().inflate(R.layout.row_data,null);
            //getting view in row_data
            TextView name = view1.findViewById(R.id.facilities);
            ImageView image = view1.findViewById(R.id.images);

            name.setText(facilities[i]);
            image.setImageResource(facimages[i]);
            return view1;



        }
    }
}
