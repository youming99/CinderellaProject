package com.project.cinderella.model.product.service;

import java.util.List;

import com.project.cinderella.common.FileManager;
import com.project.cinderella.model.domain.Product;


public interface ProductService {
   public List selectAll(); //��� ��ǰ
   public List selectAllByHit(); //��ȸ�������� ��� ��ǰ
   public List selectByTopcategoryId(int topcategory_id); //���� ī�װ��� �Ҽӵ� ��� ��ǰ
   public List selectBySubcategoryId(int subcategory_id); //���� ī�װ��� �Ҽӵ� ��� ��ǰ
   public List selectBySize(String size); //����� ��� ��ǰ
   public Product select(int product_id); //���̵�ΰ˻�
   public Product selectByProductName(String product_name); //��ǰ������ �˻�
   public void regist(FileManager fileManager, Product product); //insert�� �ϴ°� �ƴϱ� ����
   public void updateHit(int product_id); //��ȸ�� ����
   public void update(Product product);
   public void delete(int product_id);
}