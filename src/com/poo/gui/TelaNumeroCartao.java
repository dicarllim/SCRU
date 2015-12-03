package com.poo.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaNumeroCartao extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaNumeroCartao frame = new TelaNumeroCartao();
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
	public TelaNumeroCartao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 345);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDigiteONmero = new JLabel("DIGITE O NÚMERO DO CARTÃO:");
		lblDigiteONmero.setForeground(new Color(255, 140, 0));
		lblDigiteONmero.setBackground(new Color(255, 140, 0));
		lblDigiteONmero.setFont(new Font("Consolas", Font.PLAIN, 18));
		lblDigiteONmero.setBounds(135, 111, 288, 29);
		contentPane.add(lblDigiteONmero);
		
		textField = new JTextField();
		textField.setBounds(113, 152, 308, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaAluno telaAluno = new TelaAluno();
				telaAluno.setVisible(true);
			}
		});
		btnEnter.setForeground(new Color(119, 136, 153));
		btnEnter.setBackground(new Color(119, 136, 153));
		btnEnter.setBounds(264, 192, 117, 29);
		contentPane.add(btnEnter);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(new Color(119, 136, 153));
		btnCancelar.setBounds(149, 192, 117, 29);
		contentPane.add(btnCancelar);
	}
}
