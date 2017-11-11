package org.dfm.miniproject.miniproject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController("/test")
public class test {
	@RequestMapping(value="/delete")
    public ModelAndView root_test() throws Exception{
		ModelAndView mav = new ModelAndView();
        return mav;
    }
 
    @RequestMapping("/demo")
    public String demo_test() throws Exception{
        return "데모 페이지에 접속 하셨습니다.";
    }
}
