package com.huaqin.lxbaseadapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    //--------------通过构造方法，将数据源与适配器进行关联，创建的值（mList）=传进来的值(list)
    private List<ItemBean> mList;

    private long haoshi;//耗时时间

    public MyAdapter(Context context, List<ItemBean> list) {
        mList = list;
        mInflater = LayoutInflater.from(context);//通过context对象，对mInflater初始化
    }

    //--------------
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        //>>>>>>>>>>>>>>>>>逗比式，无优化处理，每次都会创建新的view，设置控件，效率及其低下
//        View view1 = mInflater.inflate(R.layout.item, null);
//        ImageView imageView = view1.findViewById(R.id.iv_image);
//        TextView title = view1.findViewById(R.id.tv_title);
//        TextView neirong = view1.findViewById(R.id.neirong);
//        ItemBean bean = mList.get(i);
//        imageView.setImageResource(bean.getImageResId());
//        title.setText(bean.getTitle());
//        neirong.setText(bean.getNeirong());
//        return view1;
        //>>>>>>>>>>>>>>>>>


        //>>>>>>>>>>>>>>>>>普通式，充分利用ListView的缓存机制，但findViewById仍会浪费大量时间
//
//        if (view==null){            //如果没有缓存，创建新的view
//            view = mInflater.inflate(R.layout.item, null);
//        }
//
//
//        ImageView imageView = view.findViewById(R.id.iv_image);
//        TextView title = view.findViewById(R.id.tv_title);
//        TextView neirong = view.findViewById(R.id.neirong);
//        ItemBean bean = mList.get(i);
//        imageView.setImageResource(bean.getImageResId());
//        title.setText(bean.getTitle());
//        neirong.setText(bean.getNeirong());
//        return view;
        //>>>>>>>>>>>>>>>>>

        //>>>>>>>>>>>>>>>>>文艺式，充分利用ListView的缓存机制，极大节省资源，提高效率
        long start = System.nanoTime();//获取系统纳秒时间

        ViewHolder viewHolder; //首先声明ViewHolder对象

        if (view==null){//如果没有缓存，创建新的view
            viewHolder = new ViewHolder();
            view = mInflater.inflate(R.layout.item, null);
            viewHolder.imageView = view.findViewById(R.id.iv_image);
            viewHolder.title = view.findViewById(R.id.tv_title);
            viewHolder.content = view.findViewById(R.id.neirong);
            view.setTag(viewHolder); //通过view.setTag(）方法，将view跟viewholder进行关联，保存
        }else{
           viewHolder = (ViewHolder) view.getTag();//直接读取保存的
        }
        ItemBean bean = mList.get(i);
        viewHolder.imageView.setImageResource(bean.getImageResId());
        viewHolder.title.setText(bean.getTitle());
        viewHolder.content.setText(bean.getNeirong());
        long end = System.nanoTime();//获取系统纳秒时间
        long dValue = end-start;
        haoshi+=dValue;
        Log.d("wkdfkdskgjslkdjg", String.valueOf(haoshi));
        return view;
        //>>>>>>>>>>>>>>>>>

    }
    //ViewHolder中包含了需要的三个控件，避免重复的findid操作
    private class ViewHolder{
        private ImageView imageView;
        private TextView title;
        private TextView content;
    }
}
