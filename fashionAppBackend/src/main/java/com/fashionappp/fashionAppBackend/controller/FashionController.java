package com.fashionappp.fashionAppBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fashionappp.fashionAppBackend.model.ItemResponseDto;
import com.fashionappp.fashionAppBackend.model.Items;
import com.fashionappp.fashionAppBackend.service.FashionService;

@RestController
@RequestMapping("/api/items")
public class FashionController {
	
	@Autowired
    FashionService fashionService;

    @GetMapping("/trending")
    public ResponseEntity<List<ItemResponseDto>> getTrendingItems(
            @RequestParam Long categoryId,
            @RequestParam Long subcategoryId) {
        List<ItemResponseDto> items = fashionService.getTrendingItems(categoryId, subcategoryId);
        return ResponseEntity.ok(items);
    }
}
