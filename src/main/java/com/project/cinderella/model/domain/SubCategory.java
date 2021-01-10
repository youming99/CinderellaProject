package com.project.cinderella.model.domain;

import java.util.List;

import lombok.Data;

@Data
public class SubCategory {
   private int subcategory_id;
   private int topcategory_id;
   private String subcategory_name;
   
  // private List<Product> product;
}