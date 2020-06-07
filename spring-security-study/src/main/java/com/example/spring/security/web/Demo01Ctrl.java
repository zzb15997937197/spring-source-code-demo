package com.example.spring.security.web;


import com.example.spring.security.di.Demo01;
import com.example.spring.security.di.Quest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Demo01Ctrl {



    @GetMapping("/test01")
    public void test01(){
        Demo01 demo01=new Demo01(new Quest());
        Quest quest=demo01.getQuest();
        quest.q1();
        quest.q2();
        quest.q3();
        Demo01 demo02=new Demo01();
        demo02.B();
    }
}
