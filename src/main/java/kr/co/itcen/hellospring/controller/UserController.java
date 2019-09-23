package kr.co.itcen.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * @RequestMapping Method 단독매핑
 */

@Controller
public class UserController {
	
	@ResponseBody
	// method를 생략하면 GET, POST방식 둘다 허용, 둘중 하나만 사용하고 싶으면 method 값 설정해주기
	@RequestMapping(value="/user/joinform", method=RequestMethod.POST)
	public String joinForm() {
		
		return "UserController.joinForm";
	}
	
	@RequestMapping(value="/user/join", method=RequestMethod.GET)
	public String join() {
		return "/WEB-INF/views/join.jsp";
	}
	
	@RequestMapping(value="/user/join", method=RequestMethod.POST)
	public String join(User user) {
		/* userDao.insert(user) */
		System.out.println(user);
		return "redirect:/hello"; // redirect:/hellospring/hello를 /hello만으로 처리
	}
	
}
