package com.fashionappp.fashionAppBackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashionappp.fashionAppBackend.model.ItemResponseDto;
import com.fashionappp.fashionAppBackend.model.Items;
import com.fashionappp.fashionAppBackend.repository.ItemRepository;

@Service
public class FashionService {

	@Autowired
	ItemRepository itemRepository;

	public List<ItemResponseDto> getTrendingItems(Long categoryId, Long subcategoryId) {
		return itemRepository.findTrendingItems(categoryId, subcategoryId);
	}

}
