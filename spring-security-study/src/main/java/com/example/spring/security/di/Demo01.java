package com.example.spring.security.di;


/**
 * 演示在demo01里初始化demo02的类的行为
 */
public class Demo01 {

    private Demo02 demo02;


    private Quest quest;

    /**
     * 可以发现Demo02类与Demo01类紧紧耦合在一起,紧密耦合的代码难以测试，难以复用。紧耦合
     * demo01只能够做demo02的类的行为
     */

    public Demo01(){
        demo02=new Demo02();
    }


    /**
     * 将quest类注入到Demo01类里，可以把很多行为写在quest里，这种方式为构造器注入，
     * 可以定义一个quest接口或者抽象类，然后将所有的共同行为实现quest类,实现了松耦合
     * @param quest
     */
    public Demo01(Quest quest){
        this.quest=quest;
    }



    public Quest getQuest(){
        return this.quest;
    }

   public void B(){
       System.out.println(""+demo02.A());
   }

}
