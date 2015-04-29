package com.applet;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TicTacToeApplet extends JApplet implements MouseListener {
	private static final long serialVersionUID = 1L;

	private static final String PLAYERX = "Player X";
	private static final String PLAYERO = "Player O";

	private String playerName = PLAYERX;

	private JLabel playerNumberLabel;
	private JPanel buttonPanel;

	private JButton[] button;
	public void init() {
		// constructor
		initComponents();
		 setFocusable(true);
	}

	
	private void initComponents() {		
		    setSize(400, 400);
		 
		buttonPanel = new JPanel();
		playerNumberLabel = new JLabel(playerName, SwingConstants.CENTER);
		Font font = new Font("Helvetica", Font.PLAIN, 60);
		buttonPanel.setLayout(new GridLayout(4, 3));

		button = new JButton[9];
		for (int i = 0; i < button.length; i++) {
			button[i] = new JButton();
			button[i].setFont(font);
			button[i].addMouseListener(this);
			buttonPanel.add(button[i]);
		}
		setPlayerName(PLAYERX);
		buttonPanel.add(playerNumberLabel);
		add(buttonPanel);
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
		playerNumberLabel.setText(playerName + " you turn ");
	}

	public void reset() {
		for (int i = 0; i < button.length; i++) {
			button[i].setText("");
			button[i].setBackground(Color.white);
		}
		setPlayerName(PLAYERX);
	}

	public void checkForWinner() {

		if (findThreeInRow()) {

			int dialogButton = JOptionPane.showConfirmDialog(this,
					"Would you like to begin again?", "Repeat? or exit? ",
					JOptionPane.YES_NO_OPTION);

			if (dialogButton == JOptionPane.YES_OPTION) { // <<< start
				reset();

			}// <<< stop
			if (dialogButton == JOptionPane.NO_OPTION) {

				System.exit(0);
			}
		}
	}

	public void checkForWinner3() {
		String[] str = { "OK" };
		if (findThreeInRow()) {
			String winnerName = (playerName == PLAYERX) ? PLAYERO : PLAYERX;

			JOptionPane.showOptionDialog(this,
					winnerName.concat("  wan!!! COOL !!!"), "SUPER !! ",
					JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null,
					str, "OK");
			reset();
		}
	}

	private boolean setMyColor(int i, int j, int k) {
		button[i].setBackground(Color.red);
		button[j].setBackground(Color.red);
		button[k].setBackground(Color.red);

		return true;

	}

	boolean flag = false;

	private boolean findThreeInRow() {

		if ((button[0].getText() == button[1].getText()
				&& button[1].getText() == button[2].getText() && button[0]
					.getText() != "")) {
			flag = setMyColor(0, 1, 2);
			return true;

		}

		if ((button[3].getText() == button[4].getText()
				&& button[4].getText() == button[5].getText() && button[4]
					.getText() != "")) {
			setMyColor(3, 4, 5);
			return true;
		}

		if (button[6].getText() == button[7].getText()
				&& button[7].getText() == button[8].getText()
				&& button[6].getText() != "") {
			setMyColor(6, 7, 8);
			return true;
		}

		if (button[0].getText() == button[3].getText()
				&& button[3].getText() == button[6].getText()
				&& button[0].getText() != "") {
			setMyColor(0, 3, 6);
			return true;
		}

		if (button[1].getText() == button[4].getText()
				&& button[4].getText() == button[7].getText()
				&& button[1].getText() != "") {
			setMyColor(1, 4, 7);
			return true;
		}

		if (button[2].getText() == button[5].getText()
				&& button[5].getText() == button[8].getText()
				&& button[2].getText() != "") {
			setMyColor(2, 5, 8);
			return true;
		}

		if (button[0].getText() == button[4].getText()
				&& button[4].getText() == button[8].getText()
				&& button[0].getText() != "") {
			setMyColor(0, 4, 8);
			return true;
		}

		if (button[2].getText() == button[4].getText()
				&& button[4].getText() == button[6].getText()
				&& button[2].getText() != "")
		{setMyColor(2, 4, 6);
			return true; }
		else
			return false;

	}

	@Override
	public void mousePressed(MouseEvent e) {

		JButton curButton = (JButton) e.getComponent();
		if (curButton.getText() == "") {

			if (playerName == PLAYERX) {
				curButton.setText("X");
				setPlayerName(PLAYERO);
			} else if (playerName == PLAYERO) {
				curButton.setText("O");
				setPlayerName(PLAYERX);
			}
		}// if(1)

		checkForWinner();
	}

	@Override
	public void mouseClicked(MouseEvent e) {		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	
	}

}
