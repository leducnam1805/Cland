package edu.vinaenter.models;

import java.sql.Timestamp;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class Land {

	private int lid;

	@NotEmpty
	@Length(min = 4, max = 255 )
	private String lname;
	
	@NotEmpty
	@Length(min = 4, max = 255 )
	private String description;

	private Timestamp dateCreate;
	
	private Category cat;
	
	private String picture;
	
	@Min(value=50)
	private int area;
	
	@NotEmpty
	private String address;

	private int countViews;

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(Timestamp dateCreate) {
		this.dateCreate = dateCreate;
	}

	public Category getCat() {
		return cat;
	}

	public void setCat(Category cat) {
		this.cat = cat;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCountViews() {
		return countViews;
	}

	public void setCountViews(int countViews) {
		this.countViews = countViews;
	}

	public Land(int lid, String lname, String description, Timestamp dateCreate, Category cat, String picture,
			int area, String address, int countViews) {
		super();
		this.lid = lid;
		this.lname = lname;
		this.description = description;
		this.dateCreate = dateCreate;
		this.cat = cat;
		this.picture = picture;
		this.area = area;
		this.address = address;
		this.countViews = countViews;
	}

	public Land() {
		super();
	}

}
