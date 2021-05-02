package edu.vinaenter.models;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class Category {

	private int cid;
	
	@NotEmpty
	@Length(min = 4,max = 255)
	private String cname;
	
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Category(int cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}
	
	public Category() {
		super();
	}

}
