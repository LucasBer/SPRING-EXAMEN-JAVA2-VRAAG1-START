package edu.ap.spring;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import edu.ap.spring.model.EightBall;
import edu.ap.spring.view.UI;

@SpringBootApplication
public class EightBallApplication {
	
	@Autowired
	UI ui;
	
	@Autowired
	EightBall eightBall;
	
	@Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return (args) -> {
			ui.setupUI();
			/*
			String[] original_answers = eightBall.getAnswers();
    		String[] answers = new String[original_answers.length];
    		for(int i = 0; i < original_answers.length; i++) {
    			answers[i] = eightBall.getRandomAnswer("selkomukauttaja" + i);
    		}
    		Arrays.sort(answers);
    		Arrays.sort(original_answers);
    		System.out.println(Arrays.asList(answers));
    		System.out.println(Arrays.asList(original_answers));
    		*/
		};
    }
	
	public static void main(String[] args) {
		new SpringApplicationBuilder(EightBallApplication.class).headless(false).run(args);
	}
}