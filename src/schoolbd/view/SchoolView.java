package schoolbd.view;

import java.util.ArrayList;

import schoolbd.model.AlunoModel;
import schoolbd.model.AulaModel;
import schoolbd.model.ProfessorModel;

public class SchoolView {
	
	public void mostrarProf(ArrayList<ProfessorModel> professorModel) {
		System.out.println("---PROFESSOR---");
		for(int i = 0;i<professorModel.size();i++) {
			System.out.println("PROFESSOR NUMERO: " + i );
			System.out.println("--------------");
			System.out.println("nome do professor: " + professorModel.get(i).getNome());
			System.out.println("rg do professor: " + professorModel.get(i).getRg());
			System.out.println("aula id: " + professorModel.get(i).getAulaId());
			System.out.println("--------------");
		}
	}

	public void mostrarAula(ArrayList<AulaModel> aulaModel) {
		System.out.println("---AULAS---");
		for(int i = 0;i<aulaModel.size();i++) {
			System.out.println("AULAS NUMERO: " + i);
			System.out.println("--------------");
			System.out.println("nome da materia: " + aulaModel.get(i).getMateria());
			System.out.println("rg do professor: " + aulaModel.get(i).getProfessorRG());
			System.out.println("aula id: " + aulaModel.get(i).getAulaID());
			System.out.println("qtd_alunos: " + aulaModel.get(i).getQtd_alunos());
			System.out.println("--------------");
		}
	}
	
	public void MostrarAlunos(ArrayList<AlunoModel> alunoModel) {
		System.out.println("---ALUNOS---");
		for(int i = 0;i<alunoModel.size();i++) {
			System.out.println("ALUNO NUMERO: " + i);
			System.out.println("--------------");
			System.out.println("aluno aprovado: " + alunoModel.get(i).getAprovado());
			System.out.println("idade do aluno: " + alunoModel.get(i).getIdade());
			System.out.println("rg do aluno: " + alunoModel.get(i).getRg());
			System.out.println("nome do aluno: " + alunoModel.get(i).getNome());
			System.out.println("ID da aula: " + alunoModel.get(i).getAulaId());
			System.out.println("media do aluno: " + alunoModel.get(i).getMedia());
			System.out.println("--------------");
		}
	}
}
