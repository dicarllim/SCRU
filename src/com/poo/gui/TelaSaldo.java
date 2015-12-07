package com.poo.gui;
import java.awt.event.ActionListener;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionEvent;

public class TelaSaldo extends JFrame {
	private static TelaSaldo instance = null;
	private JPanel contentPane;

	public static TelaSaldo getInstance(double saldo){
		if (instance == null){
			instance = new TelaSaldo(saldo);
		}
		return instance;
	}
	/**
	 * Create the frame.
	 */
	public TelaSaldo(double saldo) {
		setTitle("Aluno - Saldo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 345);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBoaRefeio = new JLabel("BOA REFEICAO!");
		lblBoaRefeio.setForeground(new Color(105, 105, 105));
		lblBoaRefeio.setFont(new Font("Consolas", Font.BOLD, 35));
		lblBoaRefeio.setBounds(132, 68, 247, 66);
		contentPane.add(lblBoaRefeio);
		
		JLabel lblSaldo = new JLabel("SALDO DISPONIVEL:");
		lblSaldo.setFont(new Font("Consolas", Font.BOLD, 25));
		lblSaldo.setForeground(new Color(144, 238, 144));
		lblSaldo.setBounds(83, 162, 238, 31);
		contentPane.add(lblSaldo);
		
		JTextPane infoSaldo = new JTextPane();
		infoSaldo.setForeground(new Color(144, 238, 144));
		infoSaldo.setFont(new Font("Consolas", Font.PLAIN, 30));
		infoSaldo.setEditable(false);
		infoSaldo.setBackground(new Color(255, 255, 255));
		infoSaldo.setBounds(331, 151, 64, 42);
		contentPane.add(infoSaldo);
		infoSaldo.setText(String.valueOf(saldo));
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaPrincipal.getInstance().setVisible(true);
			}
		});
		btnSair.setForeground(new Color(169, 169, 169));
		btnSair.setBounds(194, 244, 138, 42);
		contentPane.add(btnSair);
		
		
		
		}
	}
