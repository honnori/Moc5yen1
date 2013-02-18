
package com.example.mocandroid5yen1;

import com.example.mocandroid5yen1.R;

import android.content.Context;  
import android.graphics.Bitmap;  
import android.graphics.BitmapFactory;
import android.provider.MediaStore;  
  
/**
 *  チェック状態と画像を管理するクラス
 * @author ictnt
 */
public class CheckedImage {
	
    private boolean mChecked = false;  
    private long mBitmapId;  
    private Bitmap mBitmap = null;  
      
    public boolean getChecked() {  
        return this.mChecked;  
    }
    
    public void setChecked(boolean checked) {  
        this.mChecked = checked;  
    }
    
    public long getBitmapId() {  
        return this.mBitmapId;  
    }
    
    public void setBitmapId(long bitmapId) {  
        this.mBitmapId = bitmapId;  
    }
    
    public Bitmap getBitmap(Context context) {  
        if (this.mBitmap == null){  
//            this.mBitmap = MediaStore.Images.Thumbnails.getThumbnail(  
//                context.getContentResolver(), this.mBitmapId, MediaStore.Images.Thumbnails.MICRO_KIND, null);
        	this.mBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.sample1);
        } 
        return this.mBitmap;  
    }  
      
    public CheckedImage(boolean checked, long bitmapId){  
        this.mChecked = checked;  
        this.mBitmapId = bitmapId;  
    }  
      
}