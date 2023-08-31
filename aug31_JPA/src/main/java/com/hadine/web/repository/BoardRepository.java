package com.hadine.web.repository;

import org.springframework.data.repository.Repository;

import com.hadine.web.JBoard;

public interface BoardRepository extends Repository<JBoard, Long> {

	void save(JBoard jBoard);

}
