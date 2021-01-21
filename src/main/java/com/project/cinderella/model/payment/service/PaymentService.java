package com.project.cinderella.model.payment.service;

import java.util.List;

import com.project.cinderella.model.domain.Cart;
import com.project.cinderella.model.domain.Member;
import com.project.cinderella.model.domain.OrderSummary;
import com.project.cinderella.model.domain.Receiver;

public interface PaymentService {
   // ��ٱ��� ���� ����
   public List selectCartList();// ȸ�� ���о��� ��� ������ ��������

   public List selectCartList(int member_id);// Ư�� ȸ���� ��ٱ��� ����

   public Cart selectCart(int cart_id);

   public void insert(Cart cart);

   public void update(List<Cart> cartList); // �ϰ� ����

   public void delete(Cart cart); // pk�� ���� ������ �����ҿ���

   public void delete(Member member); // ȸ���� ���� ������ �����ҿ���

   public void delete(int product_id); // ȸ���� ���� ������ �����ҿ���

   // ���� ����
   public List selectPaymethodList();
   
   public List selectOrderList(); //�ֹ���� ��������
   public List selectOrderStateList(); //�ֹ���� ��������

   // public void registOrder(OrderSummary orderSummary);//Ʈ����� ó���� �䱸�Ǵ� �޼���...
   public void registOrder(OrderSummary orderSummary, Receiver receiver);// Ʈ����� ó���� �䱸�Ǵ� �޼���...
}