package com.example.mylistviewtest;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyBaseAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<MyPerson>personlist;   
    public MyBaseAdapter(Context mContext,ArrayList<MyPerson>personlist){
        this.mContext=mContext;
        this.personlist=personlist;
    }
    @Override
    public int getCount() {        
        return personlist.size();
    }

    @Override
    public Object getItem(int position) {
       return personlist.get(position);
    }

    @Override
    public long getItemId(int position) {        
        return position;
    }
    public class ViewHolder{
        public TextView myTextView1;
        public TextView myTextView2;
        public TextView myTextView3;
        public ImageView imageview;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       ViewHolder viewholder=null;
       final MyPerson person=(MyPerson)this.getItem(position);
       Log.v("MyBaseAdapter", "convertView,position="+position+"/"+convertView);
       if(convertView==null){
           Log.v("MyBaseAdapter", "convertView,新建position="+position+"/"+convertView);
           convertView =LayoutInflater.from(mContext).inflate(R.layout.activity_main4, null);
           viewholder=new ViewHolder();
           viewholder.myTextView1=(TextView)convertView.findViewById(R.id.mytextview5);
           viewholder.myTextView2=(TextView)convertView.findViewById(R.id.mytextview6);
           viewholder.myTextView3=(TextView)convertView.findViewById(R.id.mytextview7);
           viewholder.imageview = new ImageView(mContext);
           LinearLayout.LayoutParams mParams = new LinearLayout.LayoutParams(  
                    LinearLayout.LayoutParams.WRAP_CONTENT,  
                   LinearLayout.LayoutParams.WRAP_CONTENT); 
           viewholder.imageview.setLayoutParams(mParams);
           ((LinearLayout)convertView).addView(viewholder.imageview,2);  
           convertView.setTag(viewholder);
       }else{
           Log.v("MyBaseAdapter", "convertView,旧position="+position+"/"+convertView);
           viewholder = (ViewHolder)convertView.getTag();   
        }
       viewholder.myTextView1.setText(person.getName());
       viewholder.myTextView2.setText(person.getAge()+"");
       viewholder.myTextView3.setText(person.getCountry());
       viewholder.imageview.setImageResource(R.drawable.ic_launcher);
       
       viewholder.myTextView1.setOnClickListener(new OnClickListener(){
        @Override
            public void onClick(View v) {
               Toast.makeText(mContext, ((TextView)v).getText().toString(), Toast.LENGTH_LONG).show();
         }           
       });
       
      /* convertView.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View v) {
               TextView tx=(TextView)v.findViewById(R.id.mytextview5);
               Toast.makeText(mContext, tx.getText().toString()+"这一行", 100).show();
            }           
       });  */    

        return convertView;
    }

}
