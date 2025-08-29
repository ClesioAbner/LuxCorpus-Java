

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TicTacToe implements ActionListener {
	
	
	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel title_panel = new JPanel();
	JPanel button_panel = new JPanel();
	JLabel text_field = new JLabel();
	JButton[] buttons = new JButton[9];
	boolean player_one;
	
	
	public TicTacToe() {
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(800, 800);
		frame.getContentPane().setBackground(new Color(50, 50, 50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		text_field.setBackground(new Color(25, 25, 25));
		text_field.setForeground(new Color(25, 255, 0));
		text_field.setFont(new Font("Sans Serif", Font.BOLD, 75));
		text_field.setHorizontalAlignment(JLabel.CENTER);
		text_field.setText("Tic-Tac-Toe");
		text_field.setOpaque(true);
		
		title_panel.setLayout(new BorderLayout());
		title_panel.setBounds(0,0,800,100);
		
		button_panel.setLayout(new GridLayout(3, 3));
		button_panel.setBackground(new Color(150, 150, 150));
		
		for (int i = 0; i < 9; i++) {
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("Sans Serif", Font.BOLD, 120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		
		title_panel.add(text_field);
		frame.add(title_panel, BorderLayout.NORTH);
		frame.add(button_panel);
		
		firstTurn();
		
	}
	
	public void firstTurn() {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if (random.nextInt(2) == 0) {
			player_one = true;
			text_field.setText("X Turn");
		} else {
			player_one = false;
			text_field.setText("O turn");
		}
		
	}
	
	public void check() {
		// X conditions
		
		if ((buttons[0].getText() == "X") && buttons[1].getText() == "X" && buttons[2].getText() == "X") {
			JOptionPane.showMessageDialog(null, " ::: X Wins! :::");
		}
		
		if ((buttons[0].getText() == "X") && buttons[3].getText() == "X" && buttons[6].getText() == "X") {
			JOptionPane.showMessageDialog(null, " ::: X Wins :::");
		}
		
		if ((buttons[1].getText() == "X") && buttons[4].getText() == "X" && buttons[7].getText() == "X") {
			JOptionPane.showMessageDialog(null, " ::: X wins ! :::");
		}
		
		if ((buttons[2].getText() == "X") && buttons[5].getText() == "X" && buttons[8].getText() == "X") {
			JOptionPane.showMessageDialog(null, " ::: X Wins! :::");
		}
		
		if ((buttons[0].getText() == "X") && buttons[4].getText() == "X" && buttons[8].getText() == "X") {
			JOptionPane.showMessageDialog(null, " ::: X Wins! :::");
		}
		
		if ((buttons[2].getText() == "X") && buttons[4].getText() == "X" && buttons[6].getText() == "X") {
			JOptionPane.showMessageDialog(null, " ::: X Wins! :::");
		}
		
		// O Conditions
		if ((buttons[0].getText() == "O") && buttons[1].getText() == "X" && buttons[2].getText() == "X") {
			JOptionPane.showMessageDialog(null, " ::: 0 Wins! :::");
		}
		
		if ((buttons[0].getText() == "X") && buttons[3].getText() == "X" && buttons[6].getText() == "X") {
			JOptionPane.showMessageDialog(null, " ::: X Wins! :::");
		}
		
		if ((buttons[1].getText() == "X") && buttons[4].getText() == "X" && buttons[7].getText() == "X") {
			JOptionPane.showMessageDialog(null, " ::: X Wins! :::");
		}
		
		if ((buttons[2].getText() == "0") && buttons[5].getText() == "X" && buttons[8].getText() == "X") {
			JOptionPane.showMessageDialog(null, " ::: 0 Wins! :::");
		}
		
		if ((buttons[0].getText() == "0") && buttons[4].getText() == "X" && buttons[8].getText() == "X") {
			JOptionPane.showMessageDialog(null, " ::: 0 Wins! :::");
		}
		
		if ((buttons[2].getText() == "0") && buttons[4].getText() == "X" && buttons[6].getText() == "X") {
			JOptionPane.showMessageDialog(null, " ::: 0 Wins! :::");
		}
		
		
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		for (int i = 0; i < 9; i++) {
			if (e.getSource() == buttons[i]) {
				if (player_one) {
					if (buttons[i].getText() == "") {
						buttons[i].setForeground(new Color(255, 0,0));
						buttons[i].setText("X");
						player_one = !player_one;
						text_field.setText("O Turn");
						check();
					}
				}
				else {
					if (buttons[i].getText() == "") {
						buttons[i].setForeground(new Color(0,0,255));
						buttons[i].setText("O");
						player_one = !player_one;
						text_field.setText("X Turn");
						check();
					}
				}
			}
		}
		
	}
	public static void main(String[] args)
	{
		TicTacToe game = new TicTacToe();
	}

}







