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
import javax.swing.JToolBar;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaConsultarAluno extends JFrame {

	private static TelaConsultarAluno instance = null;
	private JPanel contentPane;
	private JTextField numeroCartao;
	private JTextField valor;
	
	public static TelaConsultarAluno getInstance(){
		if (instance == null){
			instance = new TelaConsultarAluno();
		}
		return instance;
	}
	
	public TelaConsultarAluno() {
		setTitle("Adm - Consultar Aluno");
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 267);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(143, 188, 143));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRecarregarCarto = new JLabel("Informe cpf ou nome ou número do cartão: ");
		lblRecarregarCarto.setBounds(84, 63, 328, 25);
		lblRecarregarCarto.setForeground(Color.DARK_GRAY);
		lblRecarregarCarto.setFont(new Font("Consolas", Font.BOLD, 15));
		contentPane.add(lblRecarregarCarto);
		
		numeroCartao = new JTextField();
		numeroCartao.setBounds(68, 99, 367, 25);
		contentPane.add(numeroCartao);
		numeroCartao.setColumns(10);

		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(147, 136, 98, 27);
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				TelaAdm.getInstance().setVisible(true);
			}
		});
		btnVoltar.setForeground(Color.BLACK);
		btnVoltar.setBackground(UIManager.getColor("Button.background"));
		contentPane.add(btnVoltar);
		
		JToolBar tool = new JToolBar();
		
		JButton btnCancelar = new JButton("Pesquisar");
		btnCancelar.setBounds(255, 135, 95, 29);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try{
					TelaDadosAluno<Aluno> telaDadosAluno = new TelaDadosAluno<Aluno>
					(Fachada.getInstance().procurarPorParametro((numeroCartao.getText())));
					telaDadosAluno.setVisible(true);
					setVisible(false);
				}catch(NegocioException e1){
					TelaDadosAluno.getInstance().setVisible(true);
					TelaDadosAluno<String> telaDadosAluno = new TelaDadosAluno<String>(e1.getMessage());
					telaDadosAluno.setVisible(true);
					setVisible(false);
				}catch(NumberFormatException e2){
					JOptionPane.showMessageDialog(null, "Nenhum resultado encontrado", "", JOptionPane.ERROR_MESSAGE);
					limpar();
				}
				}
			
		})
		
		;
		contentPane.add(btnCancelar);
		
		JLabel lblConsultarDadosDo = new JLabel("Consultar Dados do Aluno");
		lblConsultarDadosDo.setBounds(106, 11, 281, 25);
		lblConsultarDadosDo.setFont(new Font("Consolas", Font.PLAIN, 20));
		contentPane.add(lblConsultarDadosDo);
	}
	
	private void limpar(){
		numeroCartao.setText("");
	}
}