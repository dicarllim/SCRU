package com.poo.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.poo.excecoes.NegocioException;
import com.poo.negocios.Fachada;
import com.poo.negocios.beans.Aluno;


public class TelaDadosAluno <T> extends JFrame {

	private static TelaDadosAluno instance = null;
	private JList listaDeAlunos;
	private JPanel contentPane;
	
	public static TelaDadosAluno getInstance(){
		if (instance == null){
			instance = new TelaDadosAluno();
		}
		return instance;
	}
	
	public TelaDadosAluno() {
		getContentPane().setBackground(new Color(143, 188, 143));
		setTitle("Dados do Aluno");
		getContentPane().setFont(new Font("Consolas", Font.PLAIN, 15));
		this.setSize(450,347);
		getContentPane().setLayout(null);
		listaDeAlunos = new JList();
		listaDeAlunos.setBounds(0, 0, 0, 0);
		listaDeAlunos.setLayout(null);
		listaDeAlunos.setListData(Fachada.getInstance().listarAlunos().toArray());
		getContentPane().add(listaDeAlunos);
		
	}
	
	public TelaDadosAluno(T objeto ){
			getContentPane().setLayout(null);
			this.setSize(1000,600);
			listaDeAlunos = new JList();
			listaDeAlunos.setLayout(null);
			listaDeAlunos.setSize(1200,1200);
			DefaultListModel modelo = new DefaultListModel<T>();
			modelo.addElement(objeto);
			listaDeAlunos.setModel(modelo);
			getContentPane().add(listaDeAlunos);
			
	}
}