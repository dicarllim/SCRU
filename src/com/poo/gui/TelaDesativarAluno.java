package com.poo.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.poo.excecoes.NegocioException;
import com.poo.negocios.Fachada;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaDesativarAluno extends JFrame {

	private JPanel contentPane;
	private JTextField cpf;

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
		lblDigiteOCpf.setBounds(73, 129, 157, 16);
		contentPane.add(lblDigiteOCpf);
		
		cpf = new JTextField();
		cpf.setBounds(200, 123, 170, 28);
		contentPane.add(cpf);
		cpf.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaAdm telaAdm = new TelaAdm();
				telaAdm.setVisible(true);
			}
		});
		btnCancelar.setBounds(113, 196, 117, 29);
		contentPane.add(btnCancelar);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Fachada.getInstance().desativar(cpf.getText());
	           	JOptionPane.showMessageDialog(null, "Aluno Removido!", "Desativar Aluno", JOptionPane.INFORMATION_MESSAGE);
				} catch (NegocioException e1){
						JOptionPane.showMessageDialog(null, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
				}finally{
					limpar();
				}
			}
		});
		btnConfirmar.setBounds(235, 196, 117, 29);
		contentPane.add(btnConfirmar);
	}
	private void limpar(){
		cpf.setText("");
	}

}
