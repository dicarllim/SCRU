package com.poo.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;

public class TelaAluno extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAluno frame = new TelaAluno();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaAluno() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 345);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelecioneAOpo = new JLabel("SELECIONE A OPÇÃO DESEJADA:");
		lblSelecioneAOpo.setBackground(new Color(165, 42, 42));
		lblSelecioneAOpo.setForeground(new Color(165, 42, 42));
		lblSelecioneAOpo.setFont(new Font("Consolas", Font.BOLD, 18));
		lblSelecioneAOpo.setBounds(126, 73, 270, 36);
		contentPane.add(lblSelecioneAOpo);
		
		JButton btnJantarr = new JButton("JANTAR (R$1,50)");
		btnJantarr.setForeground(new Color(112, 128, 144));
		btnJantarr.setBounds(96, 185, 335, 58);
		contentPane.add(btnJantarr);
		
		JButton btnAlmoor = new JButton("ALMOÇO (R$2,00)");
		btnAlmoor.setForeground(new Color(112, 128, 144));
		btnAlmoor.setBounds(96, 121, 335, 58);
		contentPane.add(btnAlmoor);
		
		JLabel lblAtm = new JLabel("ATM® 2015");
		lblAtm.setForeground(new Color(211, 211, 211));
		lblAtm.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lblAtm.setBounds(431, 301, 75, 16);
		contentPane.add(lblAtm);
	}
}
