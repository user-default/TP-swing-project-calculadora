package calculadora;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Calculadora implements ActionListener {
	
	private static JTextField show = new JTextField(14);
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		JPanel p = new JPanel();
		Calculadora calculadora = new Calculadora();
		
		f.setResizable(false);
		f.setTitle("Calculadora");
		f.setSize(180, 240);
		Componentes(f, calculadora, p, show);
		f.add(p);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}
	public static void Componentes(JFrame f ,Calculadora calculadora, JPanel p, JTextField show) {
		

		JButton button0 = new JButton("0");
		JButton button1 = new JButton("1");
		JButton button2 = new JButton("2");
		JButton button3 = new JButton("3");
		JButton button4 = new JButton("4");
		JButton button5 = new JButton("5");
		JButton button6 = new JButton("6");
		JButton button7 = new JButton("7");
		JButton button8 = new JButton("8");
		JButton button9 = new JButton("9");
		
		JButton buttonSoma = new JButton("+");
		JButton buttonSub = new JButton("-");
		JButton buttonVezes = new JButton("*");
		JButton buttonDiv = new JButton("/");
		JButton buttonResult = new JButton("=");
		JButton buttonClear = new JButton("C");
		
		show.setEditable(false);
		p.add(BorderLayout.NORTH, show);
		p.add(BorderLayout.SOUTH, button0);
		p.add(BorderLayout.CENTER, button1);
		p.add(BorderLayout.CENTER, button2);
		p.add(BorderLayout.CENTER, button3);
		p.add(BorderLayout.CENTER, button4);
		p.add(BorderLayout.CENTER, button5);
		p.add(BorderLayout.CENTER, button6);
		p.add(BorderLayout.CENTER, button7);
		p.add(BorderLayout.CENTER, button8);
		p.add(BorderLayout.CENTER, button9);
		p.add(BorderLayout.SOUTH, buttonSoma);
		p.add(BorderLayout.SOUTH, buttonSub);
		p.add(BorderLayout.SOUTH, buttonVezes);
		p.add(BorderLayout.SOUTH, buttonDiv);
		p.add(BorderLayout.SOUTH, buttonClear);
		p.add(BorderLayout.SOUTH, buttonResult);
		
		button0.addActionListener(calculadora);
		button1.addActionListener(calculadora);
		button2.addActionListener(calculadora);
		button3.addActionListener(calculadora);
		button4.addActionListener(calculadora);
		button5.addActionListener(calculadora);
		button6.addActionListener(calculadora);
		button7.addActionListener(calculadora);
		button8.addActionListener(calculadora);
		button9.addActionListener(calculadora);
		buttonSoma.addActionListener(calculadora);
		buttonSub.addActionListener(calculadora);
		buttonVezes.addActionListener(calculadora);
		buttonDiv.addActionListener(calculadora);
		buttonResult.addActionListener(calculadora);
		buttonClear.addActionListener(calculadora);		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		String acao = e.getActionCommand();
		
		if(acao.charAt(0) == 'C'){
			show.setText("");
		}
		else if(acao.charAt(0) == '=') {
			show.setText(operacao(show.getText()));
		}
		else {
			show.setText(show.getText() + acao);
		}
			
			
	}
	public static String operacao(String a) {
		String operador = "";
		String num1 = "";
		String num2 = "";
		double resultado = 0;
		char[] lista = a.toCharArray();
		for(int i = 0; i < lista.length; i++) {
			if (lista[i] >= '0' && lista[i] <= '9' || lista[i] == '.') {
				if(operador.isEmpty()) {
					num1 += lista[i];
				}
				else
					num2 += lista[i];
			}
		if(lista[i] == '+' || lista[i] == '-' || lista[i] == '/' || lista[i] == '*') {
			operador += lista[i];
		}
	
		}
		if(operador.equals("+")) {
			resultado = (Double.parseDouble(num1) + Double.parseDouble(num2)); 
		}
		else if(operador.equals("-")) {
			resultado = (Double.parseDouble(num1) - Double.parseDouble(num2)); 
		}
		else if(operador.equals("*")) {
			resultado = (Double.parseDouble(num1) * Double.parseDouble(num2)); 
		}
		else if(operador.equals("/")) {
			resultado = (Double.parseDouble(num1) / Double.parseDouble(num2)); 
		}
		else
			resultado = 0;
		
		
		return "" +resultado;
		
	}

}
