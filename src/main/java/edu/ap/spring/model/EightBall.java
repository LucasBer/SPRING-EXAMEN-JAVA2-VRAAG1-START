package edu.ap.spring.model;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.ap.spring.jpa.Question;
import edu.ap.spring.jpa.QuestionRepository;

@Component
public class EightBall {
	
    private QuestionRepository repository;
    
    @Autowired
    public void setRepository(QuestionRepository repository) {
    		this.repository = repository;
    }
	
	
	private String[] answers = {"It is certain", 
								"Yes definitely", 
								"Most likely",
								"Outlook good",
								"Better not tell you now",
								"Cannot predict now",
								"Don't count on it", 
								"Outlook not so good"};
	
	private String[] copyAnswers = answers.clone();
	
	
	public String getRandomAnswer(String question) {
		Question found = repository.findByQuestion(question);
		if (found != null) {
			System.out.println("Found in DB: ");
			return found.getAnswer();
		}
		else
		{
			if (answers.length == 0)
				answers = copyAnswers;
			List<String> remainingAnswers = new ArrayList<String>(Arrays.asList(answers));
			int idx = new Random().nextInt(answers.length);
			String answer = (answers[idx]);
			remainingAnswers.remove(answer);
			System.out.println(remainingAnswers);
			answers = remainingAnswers.toArray(new String[0]);
			return answer;
		}
	}

	public String[] getAnswers() {
		return answers;
	}

	public void setAnswers(String[] answers) {
		this.answers = answers;
	}

	
	
}
