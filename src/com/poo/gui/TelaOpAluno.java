package com.poo.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.poo.excecoes.NegocioException;
import com.poo.negocios.Fachada;
import com.poo.negocios.beans.Aluno;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaOpAluno extends JFrame {

	private JPanel contentPane;
	private JTextField numeroCartao;
	private JTextField valor;
	
	public TelaOpAluno() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 345);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(143, 188, 143));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRecarregarCarto = new JLabel("Informe cpf ou nome ou número do cartão: ");
		lblRecarregarCarto.setFont(new Font("Georgia", Font.BOLD, 20));
		lblRecarregarCarto.setBounds(10, 80, 500, 25);
		contentPane.add(lblRecarregarCarto);
		
		numeroCartao = new JTextField();
		numeroCartao.setBounds(20, 114, 200, 25);
		contentPane.add(numeroCartao);
		numeroCartao.setColumns(10);
		
		JButton btnCancelar = new JButton("Pesquisar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try{
					TelaDadosAluno<Aluno> telaDadosAluno = new TelaDadosAluno<Aluno>
					(Fachada.getInstance().procurarPorParametro((numeroCartao.getText())));
					telaDadosAluno.setVisible(true);
					setVisible(false);
				}catch(NegocioException e1){
					TelaDadosAluno<String> telaDadosAluno = new TelaDadosAluno<String>(e1.getMessage());
					telaDadosAluno.setVisible(true);
					setVisible(false);
				}catch(NumberFormatException e2){
					TelaDadosAluno<String> telaDadosAluno = new TelaDadosAluno<String>("nenhum resultado encontrado");
					telaDadosAluno.setVisible(true);
					setVisible(false);

				}
				}
			
		})
		
		;
		btnCancelar.setBounds(250, 112, 95, 29);
		contentPane.add(btnCancelar);
	
	
	
	
	}
	
	
	
	
}