package org.kidding.mapper;

import java.util.List;

import org.kidding.domain.Todo;

public interface TodoMapper {

	public List<Todo> select();
	
	public void insert(String title);
	
	public void delete(Integer tno);
	
	public void update(Todo todo);
}
