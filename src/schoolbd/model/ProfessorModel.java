package schoolbd.model;

public class ProfessorModel {
	String rg;
	String nome;
	String aulaId;

	public ProfessorModel(String rg, String nome, String aulaId) {
		this.rg = rg;
		this.nome = nome;
		this.aulaId = aulaId;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getAulaId() {
		return aulaId;
	}
	public void setAulaId(String aulaId) {
		this.aulaId = aulaId;
	}

}
