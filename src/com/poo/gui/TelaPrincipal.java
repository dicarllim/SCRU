package com.poo.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;

public class TelaPrincipal extends JFrame {
	private static TelaPrincipal instance = null;
	private JPanel contentPane;

	public static TelaPrincipal getInstance(){
		if (instance == null){
			instance = new TelaPrincipal();
		}
		return instance;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setTitle("SCRU");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 345);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRestauranteUniversitrio = new JLabel("RESTAURANTE UNIVERSITÁRIO");
		lblRestauranteUniversitrio.setForeground(new Color(244, 164, 96));
		lblRestauranteUniversitrio.setFont(new Font("Georgia", Font.PLAIN, 25));
		lblRestauranteUniversitrio.setBounds(64, 57, 411, 56);
		contentPane.add(lblRestauranteUniversitrio);
		
		JButton btnAlunoUfrpe = new JButton("ALUNO UFRPE");
		btnAlunoUfrpe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaNumeroCartao.getInstance().setVisible(true);
			}
		});
		btnAlunoUfrpe.setForeground(new Color(244, 164, 96));
		btnAlunoUfrpe.setBackground(UIManager.getColor("Button.background"));
		btnAlunoUfrpe.setBounds(101, 159, 155, 72);
		contentPane.add(btnAlunoUfrpe);
		
		JButton btnAdministrador = new JButton("ADMINISTRADOR");
		btnAdministrador.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setVisible(false);
				TelaLoginAdm.getInstance().setVisible(true);
			}
		});
		btnAdministrador.setForeground(new Color(178, 34, 34));
		btnAdministrador.setBounds(258, 159, 160, 72);
		contentPane.add(btnAdministrador);
		
		JLabel lblUfrpe = new JLabel("UFRPE");
		lblUfrpe.setForeground(new Color(220, 20, 60));
		lblUfrpe.setFont(new Font("Georgia", Font.PLAIN, 21));
		lblUfrpe.setBounds(223, 103, 71, 16);
		contentPane.add(lblUfrpe);
	}

}
