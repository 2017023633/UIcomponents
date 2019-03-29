# UIcomponents  
  
### 目的：对UI组件的使用  
  
### SimpleAdapter  
##### 主要代码：  
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
##### 结果截图:  

