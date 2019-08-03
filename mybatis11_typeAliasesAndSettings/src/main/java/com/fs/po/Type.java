package com.fs.po;

//table   type:id,type_name, type_level
public class Type {
	private int id;
	private String typeName;
	private String typeLevel;
	
	
	@Override
	public String toString() {
		return "Type [id=" + id + ", typeName=" + typeName + ", typeLevel=" + typeLevel + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getTypeLevel() {
		return typeLevel;
	}
	public void setTypeLevel(String typeLevel) {
		this.typeLevel = typeLevel;
	}
}
