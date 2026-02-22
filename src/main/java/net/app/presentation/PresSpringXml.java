package net.app.presentation;

import net.app.metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PresSpringXml {
    public static void main(String[] args) {
        ApplicationContext springcontext = new ClassPathXmlApplicationContext("config.xml");
        IMetier metier =(IMetier) springcontext.getBean("metier");
    }
}
