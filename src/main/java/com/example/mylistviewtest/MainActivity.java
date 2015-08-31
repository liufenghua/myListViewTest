
package com.example.mylistviewtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{
    private Button button1,button2,button3,button4,button5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //xinzengjiadezhushi
        button1=(Button)this.findViewById(R.id.button1);
        button2=(Button)this.findViewById(R.id.button2);
        button3=(Button)this.findViewById(R.id.button3);
        button4=(Button)this.findViewById(R.id.button4);
        button5=(Button)this.findViewById(R.id.button5);
        //最后合并的
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        //我再次添加的注释
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        //xinzengjiadezhushi
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
            Intent mIntent=new Intent(this,ArrayAdapterActivity.class);
            this.startActivity(mIntent); 
            break;
            }
        case R.id.button3:{
            Intent mIntent=new Intent(this,SimpleAdapterActivity.class);
            this.startActivity(mIntent); 
            break;
            }
        case R.id.button4:{
            Intent mIntent=new Intent(this,MyBaseAdapterActivity.class);
            this.startActivity(mIntent); 
            break;
        }
        case R.id.button5:{
            Intent mIntent=new Intent(this,SimpleSursorAdapterActivity.class);
            this.startActivity(mIntent); 
            break;
        }
       }        
    }
}
