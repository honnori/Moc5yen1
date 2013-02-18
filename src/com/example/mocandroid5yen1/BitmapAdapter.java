package com.example.mocandroid5yen1;

import java.util.ArrayList;
import java.util.List;

import com.example.mocandroid5yen1.R;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class BitmapAdapter extends ArrayAdapter<CheckedImage> {

	// GridView内で画像を表示するために作成したレイアウト  
    private static final int RESOURCE_ID = R.layout.grid_item;  

    private Context mContext;  
    private LayoutInflater mInflater;  
      
    public BitmapAdapter(Context context, List<CheckedImage> objects) {  
        super(context, RESOURCE_ID, objects);
        this.mContext = context;
        this.mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);  
    }  
 
    @Override  
    public View getView(int position, View convertView, ViewGroup parent) {  
    	ViewHolder holder; 
        if (convertView == null) {  
            convertView = this.mInflater.inflate(RESOURCE_ID, null);  
            holder = new ViewHolder();
            holder.imageview = (ImageView) convertView.findViewById(R.id.imageView1);  
            holder.imageBg = (LinearLayout) convertView.findViewById(R.id.imageBg);
            convertView.setTag(holder); 
        }
        else {
        	holder = (ViewHolder)convertView.getTag();
        }

        CheckedImage item = getItem(position);
        holder.position = position;

        // 画像のデコードを別スレッドで行う
        PhotoTask task = new PhotoTask(holder.imageview, this.mContext);
        task.execute(item);
//        holder.imageview.setImageBitmap(bitmap);
        
        if (item.getChecked()) {
        	holder.imageBg.setBackgroundColor(Color.CYAN);
        }
        else {
        	holder.imageBg.setBackgroundColor(Color.TRANSPARENT);
        }

        return convertView;
    }
    
    public List<CheckedImage> getCheckedItem(){
        List<CheckedImage> lstItem = new ArrayList<CheckedImage>();
        for ( int i = 0; i < getCount(); i++) {
            if (getItem(i).getChecked()){
                lstItem.add(getItem(i));
            }
        }
        return lstItem;
    }
}
