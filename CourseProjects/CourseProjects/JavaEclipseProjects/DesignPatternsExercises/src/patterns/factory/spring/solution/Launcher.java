package patterns.factory.spring.solution;

import javax.swing.JFrame;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launcher {
    public static void main(String[] args) throws Exception {
    	ApplicationContext factory = new ClassPathXmlApplicationContext("spring-config.xml");
        JFrame gui = (JFrame)factory.getBean("gui");
        gui.setVisible(true);
    }
}
