
package com.example.mylistviewtest;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.CursorAdapter;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;


public class SimpleSursorAdapterActivity extends Activity implements OnClickListener{
     private ListView listview;  
     private ContentResolver contentsolover;
     private  SimpleCursorAdapter adapter;
     private Cursor cursor;
     public static final Uri ALLPATH=Uri.parse("content://"+"com.example.contentprovidertest"+"/newinfo");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button button=(Button)this.findViewById(R.id.mybutton1);
        listview=(ListView)this.findViewById(R.id.listview);
        contentsolover=this.getContentResolver();
        cursor=contentsolover.query(ALLPATH, null, null, null, null);
        adapter=new SimpleCursorAdapter(this,R.layout.item,cursor,new String[]{"news_title","news_content"},new int[]{R.id.textview9,R.id.textview10},
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               /* TextView title=(TextView)view.findViewById(R.id.textview9);
                TextView content=(TextView)view.findViewById(R.id.textview10);
                Toast.makeText(SimpleSursorAdapterActivity.this, title.getText().toString()+"/"+content.getText().toString(), 100).show();*/
                SimpleCursorAdapter myadapter=(SimpleCursorAdapter)parent.getAdapter();
                Cursor mycursor=myadapter.getCursor();
                String title=mycursor.getString(mycursor.getColumnIndex("news_title"));
                String content=mycursor.getString(mycursor.getColumnIndex("news_content"));
                Toast.makeText(SimpleSursorAdapterActivity.this, title+"++"+content, Toast.LENGTH_LONG).show();
            }
            
        });
        
        button.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View v) {
                //str=new String[]{"刘少华1","刘风华1","刘峰哈1","刘峰话1","刘封话1"};
                Toast.makeText(SimpleSursorAdapterActivity.this, "暂不修改", Toast.LENGTH_LONG).show();
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
