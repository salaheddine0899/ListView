package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.icu.text.Transliterator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<ListItem> items=new ArrayList<ListItem>();
        ListItem item=new ListItem("name1","that's the first item.");
        ListItem item2=new ListItem("name2","that's the second item.");

        items.add(item);
        items.add(item2);
        MyCustomAdapter ad=new MyCustomAdapter(items);
        ListView lv=findViewById(R.id.lv1);
        lv.setAdapter(ad);
        /*lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView txtname=(TextView) view.findViewById(R.id.txt_name);
                TextView txtdesc=(TextView) view.findViewById(R.id.txt_desc);
                Toast.makeText(getApplicationContext(), txtname.getText()+": "+txtdesc.getText(), Toast.LENGTH_LONG).show();
                /*items.add(new ListItem("name3","that's the third item."));
                items.add(new ListItem("name4","that's the fourth item."));
                ad.notifyDataSetChanged();
            }
        });*/
    }
    public void display(String text){
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
    }
    class MyCustomAdapter extends BaseAdapter{
        private ArrayList<ListItem> _items=new ArrayList<ListItem>();
        MyCustomAdapter(ArrayList<ListItem> items){
            _items=items;
        }

        @Override
        public int getCount() {
            return _items.size();
        }

        @Override
        public String getItem(int position) {
            return _items.get(position).get_name();
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater li=getLayoutInflater();
            View v1=li.inflate(R.layout.itemview,null);
            TextView txtname=(TextView) v1.findViewById(R.id.txt_name);
            TextView txtdesc=(TextView) v1.findViewById(R.id.txt_desc);

            txtname.setText(_items.get(position).get_name());
            txtdesc.setText(_items.get(position).get_description());
            Button b=(Button) v1.findViewById(R.id.button);
            //final ListItem litem=_items.get(position);
            if(b!=null) {
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        display(_items.get(position).get_name());
                    }
                });
            }
            return v1;
        }
    }
}