package com.huaqin.lxbaseadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<ItemBean> itemBeanList = new ArrayList<>();
      for (int i = 0; i<20; i++) {
                  itemBeanList.add(new ItemBean(
                          R.mipmap.ic_launcher,
                          "窝窝头"+i,
                          "一块钱四个，嘿嘿！"+i
                  ));
          }

        ListView listView = findViewById(R.id.lv_main);
      listView.setAdapter(new MyAdapter(this,itemBeanList));

    }
}
