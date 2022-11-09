package schoolbd.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AlunoModel {
	public AlunoModel(String rg, String nome, String aulaId, int aprovado, int idade, int media) {
		this.rg = rg;
		this.nome = nome;
		this.aulaId = aulaId;
		this.aprovado = aprovado;
		this.idade = idade;
		this.media = media;
	}

	public AlunoModel() {
	}

	String rg;
	String nome;
	String aulaId;
	int aprovado;
	int idade;
	int media;

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
	public int getAprovado() {
		return aprovado;
	}
	public void setAprovado(int aprovado) {
		this.aprovado = aprovado;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public int getMedia() {
		return media;
	}
	public void setMedia(int media) {
		this.media = media;
	}

	public void novoAluno(Connection connection, String rgV, String nomeV, int idadeV, int mediaV, String aulaIdV) {
		  try {
          String sql = "INSERT INTO aluno(`rg`, `nome`, `idade`, `media`, `aulaId`, `aprovado`) VALUES (?, ? ,? ,? ,?, ?)";
          PreparedStatement statement = connection.prepareStatement(sql);
          statement.setString(1, rgV);
          statement.setString(2, nomeV);
          statement.setInt(3, idadeV);
          statement.setInt(4, mediaV);
          statement.setString(5, aulaIdV);
          statement.setInt(6, 0);
          
          statement.executeUpdate();

      } catch (Exception e) {
          System.out.println(e);
      }
	}
	
	public void removerAluno(Connection connection, String rgV) {
	  try {
          String sql = "DELETE FROM aluno WHERE rg = ?";
          PreparedStatement statement = connection.prepareStatement(sql);
          statement.setString(1, rgV);
			statement.executeUpdate();

      } catch (Exception e) {
          System.out.println(e);
      }
	}

	public void novoAno(Connection connection) {
	  try {
          Statement statement = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
          String sql = "UPDATE aluno SET aprovado=0";
			statement.executeUpdate(sql);

      } catch (Exception e) {
          System.out.println(e);
      }
	}

	public void aprovarAluno(Connection connection) {
	  try {
          Statement statement = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
          String sql = "UPDATE aluno SET aprovado=1 WHERE media >= 6";
			statement.executeUpdate(sql);

      } catch (Exception e) {
          System.out.println(e);
      }

	}
	

}
