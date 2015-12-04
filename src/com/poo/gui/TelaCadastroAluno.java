package com.poo.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.poo.excecoes.NegocioException;
import com.poo.negocios.Fachada;
import com.poo.negocios.beans.Aluno;
import com.poo.negocios.controladores.ControladorAluno;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Label;

import javax.swing.JCheckBox;
import java.awt.Checkbox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroAluno extends JFrame {

	private JPanel contentPane;
	private JTextField Nome;
	private JTextField CPF;
	private JTextField AnoIngresso;
	private JTextField Curso;
	private JLabel label;

	/**
	 * Create the frame.
	 */
	public TelaCadastroAluno() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 354);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(143, 188, 143));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastrarNovoAluno = new JLabel("CADASTRAR NOVO ALUNO");
		lblCadastrarNovoAluno.setFont(new Font("Georgia", Font.BOLD, 20));
		lblCadastrarNovoAluno.setBounds(107, 48, 296, 16);
		contentPane.add(lblCadastrarNovoAluno);
		
		Nome = new JTextField();
		Nome.setBounds(85, 86, 359, 28);
		contentPane.add(Nome);
		Nome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(new Color(0, 0, 0));
		lblNome.setBounds(36, 92, 61, 16);
		contentPane.add(lblNome);
		
		CPF = new JTextField();
		CPF.setBounds(85, 120, 168, 28);
		contentPane.add(CPF);
		CPF.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(46, 126, 61, 16);
		contentPane.add(lblCpf);
		
		JLabel lblAnoIngresso = new JLabel("Ano Ingresso:");
		lblAnoIngresso.setBounds(264, 126, 92, 16);
		contentPane.add(lblAnoIngresso);
		
		AnoIngresso = new JTextField();
		AnoIngresso.setBounds(341, 120, 103, 28);
		contentPane.add(AnoIngresso);
		AnoIngresso.setColumns(10);
		
		Curso = new JTextField();
		Curso.setColumns(10);
		Curso.setBounds(85, 154, 359, 28);
		contentPane.add(Curso);
		
		JLabel lblCurso = new JLabel("Curso:");
		lblCurso.setBounds(36, 160, 61, 16);
		contentPane.add(lblCurso);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				TelaAdm telaAdm = new TelaAdm();
				telaAdm.setVisible(true);
			}
		});
		btnCancelar.setBounds(60, 255, 85, 29);
		contentPane.add(btnCancelar);

		label = new JLabel("");
		label.setBounds(171, 210, 304, 16);
		contentPane.add(label);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setBounds(157, 255, 75, 29);
		contentPane.add(btnLimpar);
	
		JButton btnGerarCdigo = new JButton("Gerar Codigo");
		btnGerarCdigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 label.setText(String.valueOf(new Object().hashCode())); //transforma o codigo do cartao que tem retorno inteiro para String 
				 
			}
		});
		btnGerarCdigo.setBounds(247, 255, 109, 29);
		contentPane.add(btnGerarCdigo);
		
		JButton btnGerarCarto = new JButton("Cadastrar");
		btnGerarCarto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				float ano = Float.parseFloat(AnoIngresso.getText());
				Aluno aluno = new Aluno(Nome.getText(), CPF.getText(), Curso.getText(), ano, Integer.parseInt(label.getText()), 0.0, ControladorAluno.pegarData());
				
					Fachada.getInstance().cadastrar(aluno);
					JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso!", "Cadastro Aluno", JOptionPane.INFORMATION_MESSAGE);
					limpar();
				} catch (NegocioException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					
				}				
			}
		});
		btnGerarCarto.setBounds(371, 255, 104, 29);
		contentPane.add(btnGerarCarto);
		
		JLabel lblC = new JLabel("Codigo do Cartao:");
		lblC.setBounds(36, 210, 123, 16);
		contentPane.add(lblC);
		
	}
	private void limpar(){
		Nome.setText("");
		CPF.setText("");
		AnoIngresso.setText("");
		Curso.setText("");
		label.setText("");
	}
}

