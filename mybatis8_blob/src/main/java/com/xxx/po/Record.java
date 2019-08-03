package com.xxx.po;

public class Record {
    private int id;
    private byte[] mytinyblob;
    private byte[] myblob;
    private byte[] mymediumblob;
    private byte[] mylongblob;
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public byte[] getMytinyblob() {
		return mytinyblob;
	}
	public void setMytinyblob(byte[] mytinyblob) {
		this.mytinyblob = mytinyblob;
	}
	public byte[] getMyblob() {
		return myblob;
	}
	public void setMyblob(byte[] myblob) {
		this.myblob = myblob;
	}
	public byte[] getMymediumblob() {
		return mymediumblob;
	}
	public void setMymediumblob(byte[] mymediumblob) {
		this.mymediumblob = mymediumblob;
	}
	public byte[] getMylongblob() {
		return mylongblob;
	}
	public void setMylongblob(byte[] mylongblob) {
		this.mylongblob = mylongblob;
	}
}