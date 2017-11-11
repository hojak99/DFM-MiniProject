package org.dfm.miniproject.miniproject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/master")
public class test {
	@RequestMapping(value="/delete")
    public String root_test() throws Exception{
        return "Hello World";
    }
 
    @RequestMapping("/demo")
    public String demo_test() throws Exception{
        return "데모 페이지에 접속 하셨습니다.";
    }

}
