package org.pavelkortp.springcourse.controllers;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false ) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model){

        model.addAttribute("message", "Hello, "+name+" "+surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage(){
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "act", required = false) String act,
                             @RequestParam(value = "a", required = false) int a,
                             @RequestParam(value = "b", required = false) int b,
                             Model model){
        int answer=0;
        if(act.equals("multiplication")){
            answer = a*b;
        } else if (act.equals("addition")) {
        } else if (act.equals("subtraction")) {
            answer = a-b;
        } else if (act.equals("division")) {
            answer = a/b;
        }else{
            model.addAttribute("answer", "Error!!!");
        }
        model.addAttribute("answer", answer);
        return "first/calculator";
    }
}
