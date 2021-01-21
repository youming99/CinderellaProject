package com.project.cinderella.model.product.repository;

import java.util.List;

import com.project.cinderella.model.domain.Tag;


public interface TagDAO {
	public List selectAll();//��� ��� �������� 
	public List selectById(int product_id); //fk�� �Ҽӵ� ��� ��������
	public Tag select(int tag_id);
	public Tag selectByName(String tag_name);
	public void insert(Tag tag);
	public void update(Tag tag);
	public void delete(int tag_id);
}
