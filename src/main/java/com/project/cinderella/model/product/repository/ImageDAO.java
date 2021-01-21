package com.project.cinderella.model.product.repository;

import java.util.List;

import com.project.cinderella.model.domain.Image;

public interface ImageDAO {
	public List selectAll(); //��� �̹���
	public List selectById(int product_id); //fk�� �Ҽӵ� ��� �̹���
	public Image select(int image_id);
	public void insert(Image image);
	public void update(Image image);
	public void delete(int image_id);
}
