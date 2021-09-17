package com.cc.kr.api.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cc.kr.util.LogUtil;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class TestController {

	//http://localhost:8080/test?longValue=777 호출 테스트 url.
	@GetMapping(value = "/test")
	public String test(Long longValue) { 
		
		log.info("longValue param is : {}", LogUtil.toJSONString(longValue));
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("test1","1");
		map.put("test2","22");
		map.put("test3","333");
		map.put("test4","4444");
		map.put("test5","55555");
		log.info("map is : {}" , LogUtil.toJSONString(map));


		List<String> list = new ArrayList<>();
		list.add("t");
		list.add("e");
		list.add("s");
		list.add("t");
		log.info("list is : {}", LogUtil.toJSONString(list));
		
		Test t = new Test();
		t.setId(1L);
		t.setName("ShipJH");
		t.setAge(31);
		log.info("Test class is :{}", LogUtil.toJSONString(t));
		
		return "test Success"; 
	}
	
	@Getter @Setter
	public static class Test {
		private Long id;
		private String name;
		private int age;
	}
	
}
