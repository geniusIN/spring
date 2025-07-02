package com.yedam.app.common.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // route 를 의미함 // route = Endpoint(URL + Http Method) + Service + Response(응답형태)(View or Data)
public class HomeController {
	
	@RequestMapping("/") // 경로를 매핑 하는 어노테이션
	public String mainPage(String message, Model model) { // 매개변수 => 사용자에게 받을수 있는 데이터값 (req, rep) 랑 같음 다른점은 타입을 정할수있음 model => req + res 2개를 합친것
		// service 실행
		model.addAttribute("msg", message); // req.setAttribute("A", b); 와 같음 (페이지에서 사용되는 머시기 , 매핑되는값 )
		return "home"; // <= classpath:/templates/home.html <= ViewResolver 를 거치게되면 이경로로 바뀜
	}
	
	// 같은 경로에 대해 get/post Mapping으로 나눔.
	// 동일한 경로에 같은메소드가 있으면 에러남
	
	@GetMapping("/")
	public String mainPage() {
		return "home";
	}
	
	@PostMapping("/")
	public String mainMsgPage(String message, Model model) {
		model.addAttribute("msg", message);
		return "home";
	}
	
}
