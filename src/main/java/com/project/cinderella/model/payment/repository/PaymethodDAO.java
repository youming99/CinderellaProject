package com.project.cinderella.model.payment.repository;

import java.util.List;

public interface PaymethodDAO {
	public List selectAll();
	public void registOrder(); //많�? ?��?��?��?�� 처리�? ?��구됨 (주문, 주문?��?��, 배송?���?)

}
