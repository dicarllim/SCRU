package com.poo.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextPane;

public class TelaInfoCartao extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public TelaInfoCartao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCartoGeradoCom = new JLabel("CARTÃO GERADO COM SUCESSO!");
		lblCartoGeradoCom.setForeground(new Color(0, 0, 0));
		lblCartoGeradoCom.setBackground(new Color(255, 255, 255));
		lblCartoGeradoCom.setFont(new Font("Consolas", Font.PLAIN, 17));
		lblCartoGeradoCom.setBounds(102, 20, 234, 27);
		contentPane.add(lblCartoGeradoCom);
		
		JTextPane Cartao = new JTextPane();
		Cartao.setBackground(new Color(173, 216, 230));
		Cartao.setBounds(102, 48, 245, 207);
		contentPane.add(Cartao);
		
	
		
	}
}
