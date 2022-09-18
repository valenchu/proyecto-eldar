package com.eldar.start.dao;

import org.springframework.data.repository.CrudRepository;

import com.eldar.start.entity.CardEntity;

public interface CardDao extends CrudRepository<CardEntity, Long> {

}
