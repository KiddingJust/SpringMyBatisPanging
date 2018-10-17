package org.kidding.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import org.kidding.domain.StoreVO;
import org.kidding.domain.Todo;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService {

//	@Setter(onMethod_=@Autowired)
//	private TodoMapper mapper;
	
	private Map<String, List<StoreVO>> storeMap;
	
	public TodoServiceImpl() {
		
		storeMap = new HashMap<>();
		
		List<StoreVO> korList = new ArrayList<>();
		korList.add(new StoreVO(1,"청진식당"));
		korList.add(new StoreVO(2,"뚝배기집"));
		korList.add(new StoreVO(3,"마마된장"));
		
		storeMap.put("kor", korList);
		
		List<StoreVO> jpList = new ArrayList<>();
		jpList.add(new StoreVO(11,"이춘복참치"));
		jpList.add(new StoreVO(22,"가쓰야"));
		jpList.add(new StoreVO(33,"갓덴스시"));
		
		storeMap.put("jp", jpList);
		
	}
	
	
	
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



	@Override
	public List<StoreVO> getStores(String cat) {

		return storeMap.get(cat);
	}

	
}

