package com.project.cinderella.model.product.repository;

import java.util.List;

import com.project.cinderella.model.domain.Gender;

public interface GenderDAO {
	public List selectAll();//��� ��� �������� 
	public List selectById(int product_id); //fk�� �Ҽӵ� ��� ��������
	public Gender select(int gender_id);
	public void insert(Gender gender);
	public void update(Gender gender);
	public void delete(int gender_id);
}
