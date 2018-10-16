package org.kidding.controller;

import org.junit.Test;
import org.kidding.domain.Todo;
import org.kidding.mapper.TimeMapper;
import org.kidding.mapper.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
public class TimeMapperTests extends AbstractTests {
	
	@Setter(onMethod_=@Autowired)
	private TimeMapper mapper;
	
	@Setter(onMethod_=@Autowired)
	private TodoMapper todoMapper;
	
	//TimeMapper는 인터페이스인데 어떻게 동작했나?
	//스프링이 인터페이스에 맞는 클래스를 생성함. 코드를 만들지 않아도 내부적으로 만들어냄. 
	@Test
	public void testTime() {
		log.info(mapper.getTime());
	}
	
	@Test
	public void testTime2() {
		log.info(mapper.getTime2());
	}
	
	@Test
	public void testTodo() {
		log.info(todoMapper.select());
	}
	
	@Test
	public void testInsert(){
		todoMapper.insert("블라블라블라");
	}
	
	@Test
	public void testDelete() {
		todoMapper.delete(3);
	}
	
	@Test
	public void testUpdate() {
		
		Todo todo = todoMapper.select().get(1);
		todo.setTitle("수정합니다.");
		todoMapper.update(todo);
	}
}
