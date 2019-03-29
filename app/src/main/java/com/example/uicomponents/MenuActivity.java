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
