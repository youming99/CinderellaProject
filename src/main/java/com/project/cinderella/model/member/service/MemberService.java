package com.project.cinderella.model.member.service;

import java.util.List;

import com.project.cinderella.model.domain.Member;

public interface MemberService {
	 public List selectAll();

	   /* public List selectMember(); */
	   public Member select(Member member);
	   public void regist(Member member); //ȸ����Ϲ� ��Ÿ�ʿ���� ó��
	   public void update(Member member); //ȸ������ ����
	   public void delete(Member member); //ȸ������ ����
	   public void shotmail(String user_id);//��÷�� ���Ϻ�����
	   public void updateBuyCount(Member member, int member_id); //ȸ������ (����Ƚ��)����
}
