package schoolbd.controller;

import java.util.ArrayList;

import schoolbd.model.AlunoModel;
import schoolbd.model.AulaModel;
import schoolbd.model.ProfessorModel;
import schoolbd.view.SchoolView;

public class SchoolController {
	
	private ArrayList<AlunoModel> alunoModel;
	private ArrayList<AulaModel> aulaModel;
	private ArrayList<ProfessorModel> professorModel;
	private SchoolView schoolView;

	public SchoolController(ArrayList<AlunoModel> alunoModel, ArrayList<AulaModel> aulaModel, ArrayList<ProfessorModel> professorModel, SchoolView schoolView) {
		this.alunoModel = alunoModel;
		this.aulaModel = aulaModel;
		this.professorModel = professorModel;
		this.schoolView = schoolView;
	}  
	
	public void showAlunoView() {
		schoolView.MostrarAlunos(alunoModel);
	}
	
	public void showAulaView() {
		schoolView.mostrarAula(aulaModel);
	}
	
	public void showProfessorView() {
		schoolView.mostrarProf(professorModel);
	}

}
