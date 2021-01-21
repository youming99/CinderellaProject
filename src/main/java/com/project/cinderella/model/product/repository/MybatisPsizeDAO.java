package com.project.cinderella.model.product.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.cinderella.exception.ProductRegistException;
import com.project.cinderella.model.domain.Psize;


@Repository
public class MybatisPsizeDAO implements PsizeDAO{
   @Autowired
   private SqlSessionTemplate sqlSessionTemplate;
   
   @Override
   public List selectAll() {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public List selectById(int product_id) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public Psize select(int psize_id) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public List selectBySize(String size) {
      return sqlSessionTemplate.selectList("Psize.selectBySize", size);
   }
   
   @Override
   public void insert(Psize psize) throws ProductRegistException {
      int result = sqlSessionTemplate.insert("Psize.insert", psize);
      if(result==0) {
         throw new ProductRegistException("������ ��Ͽ� �����Ͽ����ϴ�");
      }
   }

   @Override
   public void update(Psize psize) throws ProductRegistException {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void delete(int product_id) throws ProductRegistException {
      int result = sqlSessionTemplate.delete("Psize.delete", product_id);
      if(result==0) {
         throw new ProductRegistException("������ ��Ͽ� �����Ͽ����ϴ�");
      }
   }


}