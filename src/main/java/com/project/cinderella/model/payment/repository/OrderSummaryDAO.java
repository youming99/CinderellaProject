package com.project.cinderella.model.payment.repository;

import java.util.List;

import com.project.cinderella.model.domain.OrderSummary;

public interface OrderSummaryDAO {
   public List selectAll();
   public void insert(OrderSummary orderSummary);
}