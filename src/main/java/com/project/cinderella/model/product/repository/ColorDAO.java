package com.project.cinderella.model.product.repository;

import java.util.List;

import com.project.cinderella.model.domain.Color;


public interface ColorDAO {
	public List selectAll();//��� ��� �������� 
	public List selectById(int product_id); //fk�� �Ҽӵ� ��� ��������
	public Color select(int color_id);
	public void insert(Color color);
	public void update(Color color);
	public void delete(int color_id);
}