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
	private JList listaDeAlunos;
	public TelaDadosAluno() {
		this.setLayout(null);
		this.setSize(1000,600);
		listaDeAlunos = new JList();
		listaDeAlunos.setLayout(null);
		listaDeAlunos.setSize(1200,1200);
		listaDeAlunos.setListData(Fachada.getInstance().listarAlunos().toArray());
		this.add(listaDeAlunos);
		
	}
	
	public TelaDadosAluno(T objeto ){
	
			this.setLayout(null);
			this.setSize(1000,600);
			listaDeAlunos = new JList();
			listaDeAlunos.setLayout(null);
			listaDeAlunos.setSize(1200,1200);
			DefaultListModel modelo = new DefaultListModel<T>();
			modelo.addElement(objeto);
			listaDeAlunos.setModel(modelo);
			this.add(listaDeAlunos);
	}
}