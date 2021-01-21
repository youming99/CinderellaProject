package com.project.cinderella.model.member.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.cinderella.exception.MemberNotFoundException;
import com.project.cinderella.exception.MemberRegistException;
import com.project.cinderella.model.domain.Member;

@Repository
public class MybatisMemberDAO implements MemberDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List selectAll() {
		return sqlSessionTemplate.selectList("Member.selectAll");

	}

	// �α��� ����
	@Override
	public Member select(Member member) throws MemberNotFoundException {
		Member obj = sqlSessionTemplate.selectOne("Member.select", member);
		if (obj == null) { // �ùٸ��� ���� ������ ȸ���� ��ȸ�Ϸ��� �ϴ� ����..
			throw new MemberNotFoundException("�α��� ������ �ùٸ��� �ʽ��ϴ�");
		}
		return obj;
	}

	/*
	 * @Override public List selectMember() { return
	 * sqlSessionTemplate.selectList("Member.selectMember");
	 * 
	 * }
	 */

	@Override
	public void insert(Member member) {

		int result = sqlSessionTemplate.insert("Member.insert", member);
		if (result == 0) {
			throw new MemberRegistException("ȸ�����Կ� �����Ͽ����ϴ�.");
		}
	}

	@Override
	public void update(Member member) {
		System.out.println("����DAO�Ͻ���");
		int result = sqlSessionTemplate.update("Member.update", member);

		System.out.println("����DAO�ϳ�");

	}

	@Override
	public void delete(Member member) {
		sqlSessionTemplate.delete("Member.delete", member);

	}

	@Override
	public Member selectbyuser_id(String user_id) {

		return sqlSessionTemplate.selectOne("Member.selectbyuser_id", user_id);
	}

	@Override
	public void updateBuyCount(Member member, int member_id) {
		int result = sqlSessionTemplate.insert("Member.updateBuyCount", member);
		if (result == 0) {
			throw new MemberRegistException("����Ƚ�� ������Ʈ�� �����Ͽ����ϴ�.");
		}

	}

}