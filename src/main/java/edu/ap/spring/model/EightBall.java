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
	private String[] copyAnswers2 = answers.clone(); //Werkte eerst met de orinele Array answers maar die moet intact blijven voor de test
	
	
	public String getRandomAnswer(String question) {
		Question found = repository.findByQuestion(question);
		if (found != null) {
			return found.getAnswer();
		}
		else
		{
			if (copyAnswers.length == 0)
				copyAnswers = copyAnswers2;
			List<String> remainingAnswers = new ArrayList<String>(Arrays.asList(copyAnswers));
			int idx = new Random().nextInt(copyAnswers.length);
			String answer = (copyAnswers[idx]);
			remainingAnswers.remove(answer);
			copyAnswers = remainingAnswers.toArray(new String[0]);
			Question newQuestion = new Question(question, answer);
			repository.save(newQuestion);
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
