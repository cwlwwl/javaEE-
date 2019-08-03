package com.xxx.po;

public class Subject {
	private int id;
	private String title;
	private String itema;
	private String itemb;
	private String itemc;
	private String itemd;
	private String answer;
	private int categoryId;
	
	public Subject() {
		super();
	}
	
	public Subject(String title, String itema, String itemb, String itemc, String itemd, String answer,
			int categoryId) {
		super();
		this.title = title;
		this.itema = itema;
		this.itemb = itemb;
		this.itemc = itemc;
		this.itemd = itemd;
		this.answer = answer;
		this.categoryId = categoryId;
	}
	
	public Subject(int id, String title, String itema, String itemb, String itemc, String itemd, String answer,
			int categoryId) {
		super();
		this.id = id;
		this.title = title;
		this.itema = itema;
		this.itemb = itemb;
		this.itemc = itemc;
		this.itemd = itemd;
		this.answer = answer;
		this.categoryId = categoryId;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getItema() {
		return itema;
	}

	public void setItema(String itema) {
		this.itema = itema;
	}

	public String getItemb() {
		return itemb;
	}

	public void setItemb(String itemb) {
		this.itemb = itemb;
	}

	public String getItemc() {
		return itemc;
	}

	public void setItemc(String itemc) {
		this.itemc = itemc;
	}

	public String getItemd() {
		return itemd;
	}

	public void setItemd(String itemd) {
		this.itemd = itemd;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", title=" + title + ", itema=" + itema + ", itemb=" + itemb + ", itemc=" + itemc
				+ ", itemd=" + itemd + ", answer=" + answer + ", categoryId=" + categoryId + "]";
	}
}
