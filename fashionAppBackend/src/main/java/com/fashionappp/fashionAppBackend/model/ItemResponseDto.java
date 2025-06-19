package com.fashionappp.fashionAppBackend.model;

public class ItemResponseDto {

	private Long id;
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String image_url;

	public ItemResponseDto(Long id, String name ,String image_url) {
		super();
		this.id = id;
		this.image_url = image_url;
		this.name=name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImageUrl() {
		return image_url;
	}

	public void setImageUrl(String imageUrl) {
		this.image_url = imageUrl;
	}

}
