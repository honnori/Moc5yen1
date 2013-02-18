package com.example.mocandroid5yen1;

import com.example.mocandroid5yen1.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.Window;

/**
 * TOP画面クラス
 */
public class TopActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.setContentView(R.layout.top_activity);
	}

	/**
	 * 戻るボタン選択時
	 */
	public void onClickReturn(View v) {
		// 前の画面へ戻る
		this.finish();
	}

	/**
	 * 今すぐ注文をするボタン押下
	 */
	public void startOrderOnClick(View v) {
		// 写真フォルダ選択画面へ遷移する
		Intent i = new Intent(this, FolderListActivity.class);
		this.startActivity(i);
	}

}
