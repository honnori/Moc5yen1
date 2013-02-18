package com.example.mocandroid5yen1;

import com.example.mocandroid5yen1.R;
import com.example.mocandroid5yen1.data.UserData;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

/**
 * 注文リスト画面クラス
 */
public class OrderListActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.setContentView(R.layout.order_list_activity);
		
		// 注文種別初期値設定
		TextView tv = (TextView)this.findViewById(R.id.orderKindText);
		tv.setText(UserData.getInstance().getOrderKindList().get(UserData.getInstance().getOrderIndex()));
		
	}

	/**
	 * 戻るボタン選択時
	 */
	public void onClickReturn(View v) {
		// 前の画面へ戻る
		this.finish();
	}
	
	/**
	 * ボタン押下
	 */
	public void putTogetherSettingOnClick(View v) {
		// 写真フォルダ選択画面へ遷移する
		Intent i = new Intent(this, PutTogetherSettingActivity.class);
		this.startActivityForResult(i, 1);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		
		// 設定一覧から復帰
		if (requestCode == 1) {
			if (resultCode == RESULT_OK) {
				TextView tv = (TextView)this.findViewById(R.id.orderKindText);
				tv.setText(UserData.getInstance().getOrderKindList().get(UserData.getInstance().getOrderIndex()));
			}
		}

		
	}
	
	

}