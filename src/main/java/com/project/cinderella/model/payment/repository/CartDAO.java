package com.project.cinderella.model.payment.repository;

import java.util.List;

import com.project.cinderella.model.domain.Cart;
import com.project.cinderella.model.domain.Member;

public interface CartDAO {
   public List selectAll(); //ȸ�� ���� ���� ��� ������ ��������
   public List selectAll(int member_id); //Ư�� ȸ���� ��ٱ��� ����
   public Cart select(int cart_id);
   public void duplicateCheck(Cart cart); //��ٱ��� �ߺ���ǰ ���� üũ
   public void insert(Cart cart); 
   public void update(Cart cart);
   public void deleteOne(int cart_id); //PK�� �̿��� ����
   public void deleteCart(int product_id); //��ǰ�� �����ɶ� �� ��ǰ�� īƮ���� ����
   public void delete(Member member); //ȸ���� ���� ������ ������ ����
}