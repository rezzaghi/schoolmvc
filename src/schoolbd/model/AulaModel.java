package schoolbd.model;

public class AulaModel {

	String materia;
	String aulaID;
	String professorRG;
	int qtd_alunos;

	public AulaModel(String materia, String aulaID, String professorRG, int qtd_alunos) {
		this.materia = materia;
		this.aulaID = aulaID;
		this.professorRG = professorRG;
		this.qtd_alunos = qtd_alunos;
	}

	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	public String getAulaID() {
		return aulaID;
	}
	public void setAulaID(String aulaID) {
		this.aulaID = aulaID;
	}
	public String getProfessorRG() {
		return professorRG;
	}
	public void setProfessorRG(String professorRG) {
		this.professorRG = professorRG;
	}
	public int getQtd_alunos() {
		return qtd_alunos;
	}
	public void setQtd_alunos(int qtd_alunos) {
		this.qtd_alunos = qtd_alunos;
	}

}
