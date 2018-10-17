package org.kidding.domain;

import lombok.Data;

@Data
public class OrderVO {

	//상품과 주문수량 받기
	private String pid;
	private int qty;

}
