package org.kidding.service;

import java.util.List;

import org.kidding.domain.StoreVO;
import org.kidding.domain.Todo;

public interface TodoService {

	public List<Todo> getList();
	
	public List<StoreVO> getStores(String cat);
}
