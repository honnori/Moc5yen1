package com.example.mocandroid5yen1;

import java.util.ArrayList;

import com.example.mocandroid5yen1.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;

/**
 * 写真選択画面クラス
 */
public class PhotoSelectionActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.setContentView(R.layout.photo_selection_activity);
		
		final GridView mGridView = (GridView) findViewById(R.id.MyGrid);

		// グリッド4列表示
		mGridView.setNumColumns(4);
		
		
		ArrayList<CheckedImage> lstItem = new ArrayList<CheckedImage>();
		for (int i = 0; i < 10; i++) {
			lstItem.add(new CheckedImage(false, i));
		}
		
		// アイテムクリック時の振る舞いを実装
		mGridView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				//
				ViewHolder holder = (ViewHolder) v.getTag();
				CheckedImage ci = (CheckedImage) (mGridView.getAdapter())
						.getItem(position);

				if (ci.getChecked()) {
					// 選択済みの状態でクリックされたため、選択解除
					holder.imageBg.setBackgroundColor(Color.TRANSPARENT);
				} else {
					// 未選択の状態でクリックされたため、選択済みに設定
					holder.imageBg.setBackgroundColor(Color.CYAN);
				}
				ci.setChecked(!ci.getChecked());
			}
		});
		
		// アダプター作成
		BaseAdapter adapter = new BitmapAdapter(getApplicationContext(), lstItem);

		// グリッドにアダプタを設定
		mGridView.setAdapter(adapter);

	}
	

	/**
	 * 戻るボタン選択時
	 */
	public void onClickReturn(View v) {
		// 前の画面へ戻る
		this.finish();
	}
	
	/**
	 * 注文リストを見る選択時
	 */
	public void onClickLookOrderList(View v) {
		// 注文リスト画面へ遷移する
		Intent i = new Intent(this, OrderListActivity.class);
		this.startActivity(i);
	}


}