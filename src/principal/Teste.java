package principal;

import com.poo.dados.RepositorioAluno;
import com.poo.excecoes.NegocioException;
import com.poo.negocios.Fachada;
import com.poo.negocios.beans.Aluno;
import com.poo.negocios.beans.Gestor;

public class Teste {

	public static void main(String[] args) {
		Gestor gestor = new Gestor("Ariany Ferreira","10561403481", "123456");
		Aluno aluno = new Aluno("Maria Rebelo", "07354563480", "BCC", 2014.2f, 1646041125, 20.0, "03/12/2015");
		Aluno aluno1 = new Aluno("Thales","11762468441","BCC", 2014.2f,1646041121,30,"05,12,2015");
		//Aluno aluno2 = new Aluno("Olar", "10561402400", "BCC", 2014.2f, 16985775609, 30, "03/11/2015");
	    
		try {
			Fachada.getInstance().cadastrar(aluno1);
			System.out.println("Cadastro com sucesso!");
			Fachada.getInstance().cadastrar(gestor);
		} catch (NegocioException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
