package com.example.mocandroid5yen1;

import com.example.mocandroid5yen1.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;

/**
 * デコード処理をメインと別スレッドで行います。
 */
class PhotoTask extends AsyncTask<CheckedImage, Void, Bitmap> {
 
    /** 描画対象のImageView。 */
    private ImageView mView;
    private Context mContext;
 
    public PhotoTask(ImageView view, Context context) {
        this.mView = view;
        this.mContext = context;
        this.mView.setImageResource(R.drawable.ic_launcher);
        this.mView.setImageDrawable(null);
    }
     
    @Override
    protected Bitmap doInBackground(CheckedImage... params) {
        // メインとは別のスレッドでデコード
        return (params[0]).getBitmap(this.mContext);
    }
 
    @Override
    protected void onPostExecute(Bitmap result) {
        // メインスレッドの処理。
        // デコードしたBitmapをImageViewに設定します。
        mView.setImageBitmap(result);
    }
}
