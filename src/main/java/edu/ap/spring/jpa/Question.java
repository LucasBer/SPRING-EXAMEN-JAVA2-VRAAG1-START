package edu.ap.spring.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Question {
	
	@Id
	@GeneratedValue
	private Long id; 
	
	private String question;
	private String answer;
	
	public String getQuestion() {
		return question;
	}
	public void setName(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Question(String question, String answer) {
		this.question = question;
		this.answer = answer;
	} 
	
	public Question() {
		
	}
	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", answer=" + answer + "]";
	}
	
	
	
	
	
	
}
