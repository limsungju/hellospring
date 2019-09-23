package kr.co.itcen.hellospring.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * @RequestMapping Type + Method
 */

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@ResponseBody
	@RequestMapping({"/list", ""}) // 배열을 이용해서 여러개의 Mapping을 걸어줄 수 있다.
	public String list() {
		return "BoardController:list";
	}
	
	@ResponseBody
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write() {
		return "/WEB-INF/views/board/write.jsp";
	}
	
	@ResponseBody
	@RequestMapping(value="/write", method=RequestMethod.POST)
	//@PostMapping("/write") -> @RequestMapping(value="/write", method=RequestMethod.POST)를 의미
	public String write(Map<String, Object> map) { // Map으로 해주면 파라미터 이름이 key 값이 value
		return "redirect:/board/list";
	}
	
	@ResponseBody
	@RequestMapping(value="/view/{no}") // {no}랑 @PathVariable값이 맞아야 Long no에 값이 셋팅된다.
	public String view(@PathVariable("no") Long no) {
		return "BoardController:view:" + no;
	}
}
