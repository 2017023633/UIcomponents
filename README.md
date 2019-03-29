# UIcomponents  
  
### 目的：对UI组件的使用  
  
### SimpleAdapter  
#### 主要代码：  
##### SimpleadapterActivity  
```
package com.example.uicomponents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleadapterActivity extends AppCompatActivity {
    private  String text[]={"Lion","Tiger","Monkey","Dog","Cat","Elephant"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        ListView listview=(ListView) findViewById(R.id.list_view);
        List<Map<String,Object>> list=new ArrayList<Map<String, Object>>();
        int image[]={R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat,R.drawable.elephant};
        for(int i=0;i<6;i++){
            Map<String,Object> map=new HashMap<String, Object>();
            map.put("text",text[i]);
            map.put("image",image[i]);
            list.add(map);
        }
        String from[]={"text","image"};
        int to[]={R.id.text,R.id.image};
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,list,R.layout.simpleadapter,from,to);
        listview.setAdapter(simpleAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                view.setSelected(true);
                CharSequence t=text[position];
                Toast toast=Toast.makeText(SimpleadapterActivity.this,t,Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
    public void onClick(View view){
        startActivity(new Intent("android.intent.action.VOICE_COMMAND"));
    }
    public void Click(View view){
        startActivity(new Intent("android.intent.action.VIEW"));
    }
    public void on(View view){
        startActivity(new Intent("android.intent.action.INSERT"));
    }
}
```  
##### listview  
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">
<ListView
    android:id="@+id/list_view"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:listSelector="@color/colorAccent">

</ListView>
    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="2"
        android:onClick="onClick"/>
    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="3"
        android:onClick="Click"/>
    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="4"
        android:onClick="on"/>
</LinearLayout>
```  
##### simpleadapter  
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".SimpleadapterActivity"
    android:orientation="horizontal">
    <TextView
        android:id="@+id/text"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:gravity="center"
        />
    <RelativeLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content">
        <ImageView
            android:id="@+id/image"
            android:layout_width="50dp"
            android:layout_height="50dp"
            android:layout_margin="0dp"
            android:layout_alignParentRight="true"/>
    </RelativeLayout>
</LinearLayout>

```  
#### 结果截图:  

