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

public class TelaDesativarAluno extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public TelaDesativarAluno() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 463, 301);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(143, 188, 143));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDesativarAluno = new JLabel("DESATIVAR ALUNO");
		lblDesativarAluno.setFont(new Font("Georgia", Font.BOLD, 20));
		lblDesativarAluno.setBounds(125, 60, 212, 33);
		contentPane.add(lblDesativarAluno);
		
		JLabel lblDigiteOCpf = new JLabel("Digite o CPF do Aluno:");
		lblDigiteOCpf.setBounds(88, 129, 142, 16);
		contentPane.add(lblDigiteOCpf);
		
		textField = new JTextField();
		textField.setBounds(200, 123, 170, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(113, 196, 117, 29);
		contentPane.add(btnCancelar);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(235, 196, 117, 29);
		contentPane.add(btnConfirmar);
	}

}
