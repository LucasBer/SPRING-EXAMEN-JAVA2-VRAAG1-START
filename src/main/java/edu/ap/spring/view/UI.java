package edu.ap.spring.view;

import java.awt.FlowLayout;

import javax.swing.*;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@Component
public class UI implements InitializingBean {
	
	private JFrame jFrame;
	private JLabel lblQuestion, lblAnswer;
	private JPanel controlPanel;
    private JButton btn_Ask;
    private JTextField text_Question;
    
    /**
     * @wbp.parser.entryPoint
     */
    public void setupUI() {
	  jFrame = new JFrame("Spring JFrame");
	    	
	  controlPanel = new JPanel();

		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.getContentPane().setLayout(null);
		
		lblQuestion = new JLabel("Enter your question:");
		lblQuestion.setBounds(10, 11, 134, 35);
		jFrame.getContentPane().add(lblQuestion);
		
		text_Question = new JTextField();
		text_Question.setBounds(127, 17, 127, 23);
		jFrame.getContentPane().add(text_Question);
		text_Question.setColumns(10);
		
		btn_Ask = new JButton("Ask");
		btn_Ask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btn_Ask.setBounds(279, 17, 89, 23);
		jFrame.getContentPane().add(btn_Ask);
		
		lblAnswer = new JLabel("");
		lblAnswer.setBounds(149, 77, 46, 14);
		jFrame.getContentPane().add(lblAnswer);
		jFrame.setVisible(true);
    }
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.setProperty("java.awt.headless", "false");
	}
}
