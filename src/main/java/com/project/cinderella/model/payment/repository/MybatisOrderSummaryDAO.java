package com.project.cinderella.model.payment.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.cinderella.exception.OrderSummaryRegistException;
import com.project.cinderella.model.domain.OrderSummary;

@Repository
public class MybatisOrderSummaryDAO implements OrderSummaryDAO{
   @Autowired
   private SqlSessionTemplate sqlSessionTemplate;
   
   public void insert(OrderSummary orderSummary) throws OrderSummaryRegistException{
      int result=sqlSessionTemplate.insert("OrderSummary.insert", orderSummary);
      if(result==0) {
         throw new OrderSummaryRegistException("주문요약 등록실패");
      }
   }

   @Override
   public List selectAll() {
      return sqlSessionTemplate.selectList("OrderSummary.selectAll");
      
   }
   
}