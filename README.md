# UIcomponents  
  
### 目的：对UI组件的使用  
  
### SimpleAdapter  
#### 主要代码：  
#### SimpleadapterActivity.java  
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
#### listview.xml  
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
#### simpleadapter.xml  
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
![image text](https://github.com/2017023633/hello-world/blob/master/image/%E5%AE%9E%E9%AA%8C3.1%E6%88%AA%E5%9B%BE.png)    
  
### AlertDialog  
#### 主要代码:  
#### AlertDialogActivity.java  
```
package com.example.uicomponents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AlertDialogActivity extends AppCompatActivity {
    private Button button1;
    private Button button2;
    private AlertDialog.Builder dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
         dialog=new AlertDialog.Builder(this).setTitle("Dialog")
                .setIcon(R.mipmap.ic_launcher).setView(R.layout.activity_alert_dialog)
                 .setPositiveButton("Cancle",null)
                 .setNegativeButton("Sign in",null);
        dialog.show();
    }
}
```  
#### activity_alert_dialog.xml  
```  
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".AlertDialogActivity"
    android:orientation="vertical">
   <LinearLayout
       android:layout_width="match_parent"
       android:layout_height="wrap_content"
       android:orientation="horizontal">
       <EditText
           android:layout_width="match_parent"
           android:layout_height="match_parent"
           android:hint="Username"/>
   </LinearLayout>
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">
        <EditText
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:password="true"
            android:hint="Password"/>
    </LinearLayout>
</LinearLayout>  
```  
### 结果截图：  
![image text](https://github.com/2017023633/hello-world/blob/master/image/%E5%AE%9E%E9%AA%8C3.2%E6%88%AA%E5%9B%BE.png)    
  
### menu  
#### 主要代码：  
#### MenuActivity.java  
```
package com.example.uicomponents;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MenuActivity extends AppCompatActivity {
    private TextView test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        test=(TextView)findViewById(R.id.test);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=new MenuInflater(this);
        inflater.inflate(R.menu.menu,menu);
        super.onCreateOptionsMenu(menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch (menuItem.getItemId()){
            case R.id.font1:
                test.setTextSize(10);
                break;
            case R.id.font2:
                test.setTextSize(16);
                break;
            case R.id.font3:
                test.setTextSize(20);
                break;
            case R.id.nor:
                Toast toast=Toast.makeText(MenuActivity.this,"普通菜单项",Toast.LENGTH_SHORT);
                toast.show();
                break;
            case R.id.red:
                test.setTextColor(Color.RED);
                break;
            case R.id.black:
                test.setTextColor(Color.BLACK);
                break;
        }
        return true;
    }
}
```  
#### activity_menu.xml  
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MenuActivity">
    <TextView
        android:id="@+id/test"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="用于测试的内容"
        />
    <View
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>
</LinearLayout>
```  
#### menu.xml  
```
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <item
        android:id="@+id/size"
        android:title="字体大小">
        <menu>
            <group>
                <item
                    android:id="@+id/font1"
                    android:title="小">
                </item>
                <item
                    android:id="@+id/font2"
                    android:title="中">
                </item>
                <item
                    android:id="@+id/font3"
                    android:title="大">
                </item>
            </group>
        </menu>
    </item>
    <item
        android:id="@+id/nor"
        android:title="普通菜单项">
    </item>
    <item
        android:id="@+id/color"
        android:title="字体颜色">
        <menu>
            <group>
                <item
                    android:id="@+id/red"
                    android:title="红色">
                </item>
                <item
                    android:id="@+id/black"
                    android:title="黑色">
                </item>
            </group>
        </menu>
    </item>
</menu>
```  
### 结果截图：  
![image text](https://github.com/2017023633/hello-world/blob/master/image/实验3.3截图1.png)    
![image text](https://github.com/2017023633/hello-world/blob/master/image/%E5%AE%9E%E9%AA%8C3.3%E6%88%AA%E5%9B%BE2.png)    
![image text](https://github.com/2017023633/hello-world/blob/master/image/%E5%AE%9E%E9%AA%8C3.3%E6%88%AA%E5%9B%BE3.png)    
![image text](https://github.com/2017023633/hello-world/blob/master/image/%E5%AE%9E%E9%AA%8C3.3%E6%88%AA%E5%9B%BE4.png)    
  
### ActionMode  
#### 主要代码：  
#### ActionModeActivity.java  
```
package com.example.uicomponents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActionModeActivity extends AppCompatActivity {
    private  String text[]={"One","Two","Three","Four","Five"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_mode);
        final ListView listview=(ListView) findViewById(R.id.lv);
        List<Map<String,Object>> list=new ArrayList<Map<String, Object>>();
        int image[]={R.drawable.dog,R.drawable.dog,R.drawable.dog,R.drawable.dog,R.drawable.dog};
        for(int i=0;i<5;i++){
            Map<String,Object> map=new HashMap<String, Object>();
            map.put("text",text[i]);
            map.put("image",image[i]);
            list.add(map);
        }
        String from[]={"text","image"};
        int to[]={R.id.text,R.id.image};
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,list,R.layout.action_mode_layout,from,to);
        listview.setAdapter(simpleAdapter);
        listview.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        listview.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position,
                                                  long id, boolean checked) {
                mode.setTitle(listview.getCheckedItemCount()+" selected");
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                // Respond to clicks on the actions in the CAB
                switch (item.getItemId()) {
                    case R.menu.m:
//                        deleteSelectedItems();
                        mode.finish(); // Action picked, so close the CAB
                        return true;
                    default:
                        return false;
                }
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                // Inflate the menu for the CAB
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.m, menu);
                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                // Here you can make any necessary updates to the activity when
                // the CAB is removed. By default, selected items are deselected/unchecked.
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                // Here you can perform updates to the CAB due to
                // an invalidate() request
                return false;
            }
        });
    }
}
```  
#### activity_action_mode.xml  
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".ActionModeActivity"
    android:orientation="vertical">
    <ListView
        android:id="@+id/lv"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        >
    </ListView>
</LinearLayout>
```  
#### activity_mode_layout.xml  
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="horizontal"
    android:background="@drawable/item">
    <ImageView
        android:id="@+id/image"
        android:layout_width="50dp"
        android:layout_height="50dp" />
    <TextView
        android:id="@+id/text"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginLeft="10dp"/>
</LinearLayout>
```  
#### m.xml  
```
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <item
        android:id="@+id/m"
        android:icon="@android:drawable/ic_input_delete"
        android:title="title"/>
</menu>
```  
#### 结果截图：  
![image text](https://github.com/2017023633/hello-world/blob/master/image/%E5%AE%9E%E9%AA%8C3.4%E6%88%AA%E5%9B%BE.png)    
