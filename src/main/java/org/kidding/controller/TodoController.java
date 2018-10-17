package org.kidding.controller;

import java.util.Arrays;
import java.util.List;

import org.kidding.domain.OrderList;
import org.kidding.domain.StoreVO;
import org.kidding.domain.Todo;
import org.kidding.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller	//해당 패키지에 이미 component-scan이 걸려있음.
@RequestMapping("/todo/")	// todo로 시작하는 모든 경로를 받아볼 수 있도록. 
@Log4j
@AllArgsConstructor
public class TodoController {

	//이거 하나만 주입하므로 자동주입 가능. 
	private TodoService service;
	
	@GetMapping("/stores")
	public @ResponseBody List<StoreVO> getStores(String cat){
	
		return service.getStores(cat);
	}
	
	// ResponseBody가 없으면 list2.jsp로 감. ResponseBody 해주면 localhost:8080/todo/list2 했을 때 json 데이터 나옴. 
	// ResponseBody는 내부적으로 결과를 변환하여 반환. 어떤 형식으로 변환할지는 직접 지정할 수 있음. 
//	@GetMapping("/list2")
//	@ResponseBody
//	public List<Todo> list2(){
//		return service.getList();
//	}

	@GetMapping("/list2")
	@ResponseBody
	public ResponseEntity<List<Todo>> list2(){
		// 처리를 했는데, 잘못된 처리인지 올바른 처리인지 상태값까지 보내는 것? 404 등의 에러가 아니라, 필요한 방식으로 메세지 코드를 조정.
		return new ResponseEntity<List<Todo>>(service.getList(), HttpStatus.OK);
	}
	
	@GetMapping("/list")
	public void list() {
		log.info("list...page");
	}
	
	//등록하는 화면 만들기. 파라미터 필요 없음(GET 호출)
	// http://localhost:8080/controller/todo/register 호출하면 WEB-INF/views/todo/register.jsp 라는 경로가 보임
	//return타입은 String 혹은 void를 씀. if~else가 필요한 경우는 String, 아닌 경우에는 void.
	@GetMapping("/register")
	public void register() {
		log.info("register...");
	}
	
	//배열을 해보자
	@GetMapping("/exArray")
	public String exArray( String[] ids) {
		log.info(Arrays.toString(ids));
		return "todo/success";
	}
	
	@GetMapping("/order")
	public String order(OrderList list, Model model) {
		log.info(list);
		model.addAttribute("total", 3000);
		return "todo/success";
	}
	
	@PostMapping("/register")
	public String registerPost(Todo todo
			, RedirectAttributes rttr ) {
		log.info(todo);
		//게시물 등록 성공&실패 여부 확인
		//addFlashAttribute는 한 번만 실행됨. 
		rttr.addFlashAttribute("result", "SUCCESS");
		return "redirect:/todo/list";
//		return "todo/success";
	}
	
}
