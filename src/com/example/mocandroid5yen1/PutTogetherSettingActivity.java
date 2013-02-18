package com.example.mocandroid5yen1;

import java.util.ArrayList;

import com.example.mocandroid5yen1.R;
import com.example.mocandroid5yen1.data.UserData;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * 一括設定画面クラス
 */
public class PutTogetherSettingActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.setContentView(R.layout.put_together_setting_activity);
		
		// 注文種別用スピナー設定
		Spinner orderKindSpinner = (Spinner)this.findViewById(R.id.OrderKindSpinner);
		ArrayList<String> orderKindList = UserData.getInstance().getOrderKindList();
		
//		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, orderKindList);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner, orderKindList);
//		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		adapter.setDropDownViewResource(R.layout.spinner_dropdown);
		orderKindSpinner.setAdapter(adapter);
		
		// スピナーのクリックイベントを取得する
		orderKindSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
				// Itemが選択された時
				public void onItemSelected(AdapterView parent, View view, int position, long id) {
					// 選択した注文種別のインデックス情報
					UserData.getInstance().setOrderIndex(position);
				}
				// 何も選択されなかったとき
				public void onNothingSelected(AdapterView parent) {
				}
		});

		
		
		// 写真サイズ用スピナー
		Spinner photoSizeSpinner = (Spinner)this.findViewById(R.id.photoSizeSpinner);
		ArrayList<String> photoSizeList = UserData.getInstance().getPhotoSizeList();
		
		ArrayAdapter<String> photoSizeadapter = new ArrayAdapter<String>(this, R.layout.spinner, photoSizeList);
		photoSizeadapter.setDropDownViewResource(R.layout.spinner_dropdown);
		photoSizeSpinner.setAdapter(photoSizeadapter);
		
	}

	/**
	 * 戻るボタン選択時
	 */
	public void onClickReturn(View v) {
		// 前の画面へ戻る
		this.finish();
	}
	
	/**
	 * 一括設定ボタン押下時
	 */
	public void execTogetherSettingOnClick(View v) {
		// 一括設定を実行
		
		// 前の画面へ戻る
		this.setResult(Activity.RESULT_OK);
		this.finish();
	}


}