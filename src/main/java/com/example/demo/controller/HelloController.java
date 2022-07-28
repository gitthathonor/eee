package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello") //매핑은 도메인에 보이는 이름이라고 생각하면 된다.
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello"; // 리턴값은 view 페이지의 이름을 뜻한다.(여기서는 resources/templates 내의 파일명)
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-api")
    @ResponseBody
    public String helloApi(@RequestParam("name") String name) {
        return "hello " + name;
    }

    @GetMapping("hello-spring")
    @ResponseBody
    public Hello helloSpring(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }





}
