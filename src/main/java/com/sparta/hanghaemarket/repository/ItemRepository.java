package com.sparta.hanghaemarket.repository;

import com.sparta.hanghaemarket.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findAllByOrderByTitleDesc();

}
