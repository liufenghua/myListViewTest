
package com.example.mylistviewtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBaseAdapterActivity extends Activity{
     private ListView listview;
     private Button button1;
     private MyBaseAdapter adapter;
     private ArrayList<MyPerson>personlist=new ArrayList<MyPerson>();

     
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button1=(Button)this.findViewById(R.id.mybutton1);
        listview=(ListView)this.findViewById(R.id.listview);
        initList();
        adapter=new MyBaseAdapter(this,personlist);
        listview.setAdapter(adapter);  
        listview.setOnItemClickListener(new OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               /* TextView tx=(TextView)view.findViewById(R.id.mytextview5);
                Toast.makeText(MyBaseAdapterActivity.this, tx.getText().toString()+"这一行", 100).show();*/
                MyBaseAdapter myadapter=(MyBaseAdapter)parent.getAdapter();
                MyPerson person=(MyPerson)myadapter.getItem(position);
                Toast.makeText(MyBaseAdapterActivity.this, person.getName()+"/"+person.getAge()+"/"+person.getCountry(), Toast.LENGTH_LONG).show();
            }
            
        });
        button1.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View v) {
                personlist.get(0).setCountry("新加坡"); 
                personlist.set(2, new MyPerson("刘大嘴",32,"英国"));
                adapter.notifyDataSetChanged();           
            }
            
        });
    }
    
    public void initList(){
        personlist.add(new MyPerson("刘风华",25,"中国"));
        personlist.add(new MyPerson("刘少华",24,"美国"));
        personlist.add(new MyPerson("刘绍华",23,"韩国"));
        personlist.add(new MyPerson("刘华",25,"中国"));
        personlist.add(new MyPerson("刘华少",25,"法国"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
