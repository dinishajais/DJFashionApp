package com.fashionappp.fashionAppBackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;


@Entity
@Table(name = "all_Items")
public class Items {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	 @Column(name = "name")
	private String name;
	 
	 @Column(name = "price")
	private double price;
	 
	 @Column(name = "category_id")
	private Long category_id;
	 
	 @Column(name = "sub_category_id")
	private Long sub_category_id;
	 
	 @Column(name = "image_url")
	private String image_url;
	 
	 @Column(name = "is_trending")
	private char is_trending;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Long getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}
	public Long getSub_category_id() {
		return sub_category_id;
	}
	public void setSub_category_id(Long sub_category_id) {
		this.sub_category_id = sub_category_id;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public char getIs_trending() {
		return is_trending;
	}
	public void setIs_trending(char is_trending) {
		this.is_trending = is_trending;
	}
	
	
}