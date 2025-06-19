package com.fashionappp.fashionAppBackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fashionappp.fashionAppBackend.model.ItemResponseDto;
import com.fashionappp.fashionAppBackend.model.Items;

@Repository
public interface ItemRepository extends JpaRepository<Items, Long> {

	@Query("SELECT new com.fashionappp.fashionAppBackend.model.ItemResponseDto(i.id, i.name ,i.image_url) " +
	           "FROM Items i WHERE i.is_trending = 'Y' AND i.category_id = :category_id AND i.sub_category_id = :sub_category_id")
	    List<ItemResponseDto> findTrendingItems(@Param("category_id") Long category_id, @Param("sub_category_id") Long sub_category_id);


}

