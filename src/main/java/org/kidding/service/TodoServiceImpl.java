package org.kidding.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.kidding.domain.Todo;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService {

//	@Setter(onMethod_=@Autowired)
//	private TodoMapper mapper;
	
	@Override
	public List<Todo> getList() {
		
		ArrayList<Todo> list = new ArrayList<>();
		
		//for loop를 다른 방식으로 해보자 (JDK 8버전)
		//가짜 Todo를 만드는 작업
		IntStream.range(1, 100)
		.forEach( i -> {
			Todo todo = new Todo();
			todo.setTno(i);
			todo.setTitle("TITLE " + i);
			list.add(todo);
		});
		return list;
	}

	
}

