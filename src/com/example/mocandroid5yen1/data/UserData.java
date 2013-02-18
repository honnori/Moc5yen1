package com.example.mocandroid5yen1.data;

import java.util.ArrayList;

/**
 * モック用データ
 * @author ictnt
 */
public class UserData {

	private static UserData instance = new UserData();
	
	// 注文種別リスト
	private ArrayList<String> orderKindList = new ArrayList<String>();

	// 写真サイズリスト
	private ArrayList<String> photoSizeList = new ArrayList<String>();

	// 選択中の注文種別のINDEX
	private int orderIndex = 0;
	
	public static UserData getInstance() {
		return instance;
	}

	private UserData() {
		// 注文種別リスト　ダミー情報
		this.orderKindList.add("5円 5円プリント(Lのみ)");
		this.orderKindList.add("8円 高級プリント(L/DSC/LW/ましかくS)");
		this.orderKindList.add("8円 13サイズ一括プリント(L/DSC/LW/ましかくS/KG/HV/DSCW/2L/6切/W6切/4切/W4切/ましかくL) ");
		this.orderKindList.add("11円 最高級プリント(L/DSC/LW)");
		this.orderKindList.add("15円 プロ仕上げ(L/DSC/LW/ましかくS)");
		
		
		// 写真サイズリスト　ダミー情報
		this.photoSizeList.add("L");
		this.photoSizeList.add("DSC");
		this.photoSizeList.add("LW");
		this.photoSizeList.add("ましかくS");
		this.photoSizeList.add("KG");
		this.photoSizeList.add("HV");
		this.photoSizeList.add("DSCW");
		this.photoSizeList.add("2L");
		this.photoSizeList.add("6切");
		this.photoSizeList.add("W6切");
		this.photoSizeList.add("4切");

	}

	public ArrayList<String> getOrderKindList() {
		return orderKindList;
	}

	public void setOrderKindList(ArrayList<String> orderKindList) {
		this.orderKindList = orderKindList;
	}

	public int getOrderIndex() {
		return orderIndex;
	}

	public void setOrderIndex(int orderIndex) {
		this.orderIndex = orderIndex;
	}

	public ArrayList<String> getPhotoSizeList() {
		return photoSizeList;
	}

	public void setPhotoSizeList(ArrayList<String> photoSizeList) {
		this.photoSizeList = photoSizeList;
	}

}
