
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
import android.widget.TextView;
import android.widget.Toast;

public class ArrayAdapterActivity extends Activity implements OnClickListener{
     private ListView listview;  
     private ArrayAdapter<String>adapter;
     private String[]str=new String[]{"刘少华","刘风华","刘峰哈","刘峰话","刘封话"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button button=(Button)this.findViewById(R.id.mybutton1);
        listview=(ListView)this.findViewById(R.id.listview);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,str);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              /*  TextView textview=(TextView)view.findViewById(android.R.id.text1);
                Toast.makeText(ArrayAdapterActivity.this, textview.getText().toString(), 100).show();*/
               // Toast.makeText(ArrayAdapterActivity.this, parent.getAdapter().getItem(position).toString(), 100).show();
                //  Toast.makeText(ArrayAdapterActivity.this, str[position], 100).show();
                ArrayAdapter<String>myadapter=(ArrayAdapter)parent.getAdapter();
                String str=(String)myadapter.getItem(position);
                Toast.makeText(ArrayAdapterActivity.this, str, Toast.LENGTH_LONG).show();
            }
            
        });
        
        button.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View v) {
                //str=new String[]{"刘少华1","刘风华1","刘峰哈1","刘峰话1","刘封话1"};
                str[1]="liufenghua";
                adapter.notifyDataSetChanged();
            }
            
        });
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

    @Override
    public void onClick(View v) {
        switch(v.getId()){
        case R.id.button1:{
            Intent mIntent=new Intent(this,MyListActivity.class);
            this.startActivity(mIntent); 
            break;
            }
        case R.id.button2:{
            Intent mIntent=new Intent(this,MyListActivity.class);
            this.startActivity(mIntent); 
            break;
        }
       }        
    }
}
