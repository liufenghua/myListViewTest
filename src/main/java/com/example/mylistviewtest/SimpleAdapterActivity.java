
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

public class SimpleAdapterActivity extends Activity implements OnClickListener{
     private ListView listview;
     private Button button1;
     private SimpleAdapter adapter;
     private List<Map<String,Object>>listItems;
     private String []str=new String[]{"虎头","弄玉","李清照","李白"};
     private String []content=new String[]{"小孩","音乐女孩","女诗人","浪漫诗人"};
     
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button1=(Button)this.findViewById(R.id.mybutton1);
        listview=(ListView)this.findViewById(R.id.listview);
        listItems=new ArrayList<Map<String,Object>>();
        for(int i=0;i<str.length;i++){
            Map<String,Object>item=new HashMap<String,Object>();
            item.put("image", R.drawable.ic_launcher);
            item.put("name", str[i]);
            item.put("jieshao",content[i]);
            listItems.add(item);
        }
        adapter=new SimpleAdapter(this,listItems,R.layout.activity_main3,new String[]{"image","name","jieshao"},new int[]{R.id.imageview,R.id.mytextview1,R.id.mytextview2});
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
          /*  TextView textview1=(TextView)view.findViewById(R.id.mytextview1);
              TextView textview2=(TextView)view.findViewById(R.id.mytextview2);
              Toast.makeText(SimpleAdapterActivity.this, textview1.getText().toString()+"/"+textview2.getText().toString(), 100).show();*/
                SimpleAdapter myadapter=(SimpleAdapter)parent.getAdapter();
                Map<String,Object> object= (Map<String,Object>)myadapter.getItem(position);
                Toast.makeText(SimpleAdapterActivity.this, object.get("name")+"/"+object.get("jieshao"), Toast.LENGTH_LONG).show();
             }
            
        });
        button1.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View v) {
                Map<String,Object>item=new HashMap<String,Object>();
                item.put("image", R.drawable.ic_launcher);
                item.put("name", "新虎头");
                item.put("jieshao","新小孩");
                listItems.set(0, item);
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
