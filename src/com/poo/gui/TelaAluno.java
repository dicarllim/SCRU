package com.poo.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.poo.negocios.Fachada;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaAluno extends JFrame {

	private JPanel contentPane;

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
		
		JLabel lblSelecioneAOpo = new JLabel("SELECIONE A OPCAO DESEJADA:");
		lblSelecioneAOpo.setBackground(new Color(165, 42, 42));
		lblSelecioneAOpo.setForeground(new Color(165, 42, 42));
		lblSelecioneAOpo.setFont(new Font("Consolas", Font.BOLD, 18));
		lblSelecioneAOpo.setBounds(126, 73, 270, 36);
		contentPane.add(lblSelecioneAOpo);
		
		JButton btnJantarr = new JButton("JANTAR (R$1,50)");
		btnJantarr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaSaldo telaSaldo = new TelaSaldo();
				telaSaldo.setVisible(true);
			}
		});
		btnJantarr.setForeground(new Color(112, 128, 144));
		btnJantarr.setBounds(96, 185, 335, 58);
		contentPane.add(btnJantarr);
		
		JButton btnAlmoor = new JButton("ALMOCO (R$2,00)");
		btnAlmoor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaSaldo telaSaldo = new TelaSaldo();
				telaSaldo.setVisible(true);
				
			}
		});
		btnAlmoor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaSaldo telaSaldo = new TelaSaldo();
				telaSaldo.setVisible(true);
			}
		});
		btnAlmoor.setForeground(new Color(112, 128, 144));
		btnAlmoor.setBounds(96, 121, 335, 58);
		contentPane.add(btnAlmoor);
	}
}
