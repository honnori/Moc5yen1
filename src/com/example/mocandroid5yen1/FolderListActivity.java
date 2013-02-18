package com.example.mocandroid5yen1;

import com.example.mocandroid5yen1.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

/**
 * 写真選択画面クラス
 */
public class FolderListActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.setContentView(R.layout.folder_select_activity);
	}

	/**
	 * 戻るボタン選択時
	 */
	public void onClickReturn(View v) {
		// 前の画面へ戻る
		this.finish();
	}
	
	
	/**
	 * フォルダ選択時
	 */
	public void onClickFolder(View v) {
		// 写真選択画面へ遷移する
		Intent i = new Intent(this, PhotoSelectionActivity.class);
		this.startActivity(i);
	}

}
