package org.kidding.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class OrderList {

	private List<OrderVO> list;

	public OrderList() {
		list = new ArrayList<>();
		
	}
	
	
}
