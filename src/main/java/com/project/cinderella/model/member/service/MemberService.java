package com.project.cinderella.model.member.service;

import java.util.List;

import com.project.cinderella.model.domain.Member;



public interface MemberService {
   public List selectAll();

   /* public List selectMember(); */
   public Member select(Member member);
   public void regist(Member member); //회원등록및 기타필요사항 처리
   public void update(Member member); //회원정보 수정
   public void delete(Member member); //회원정보 삭제
}