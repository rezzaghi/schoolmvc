package schoolbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import schoolbd.controller.SchoolController;
import schoolbd.model.AlunoModel;
import schoolbd.model.AulaModel;
import schoolbd.model.ProfessorModel;
import schoolbd.view.SchoolView;


public class Main {
    public static void main(String[] args) {
    	
    	Connection connection = null;
		try {
    		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo", "root", "");
		} catch (Exception e) {
			System.out.println(e);
		}

    	ArrayList<AlunoModel> alunos = retriveAlunosFromDatabase(connection);
    	ArrayList<AulaModel> aulas = retriveAulasFromDatabase(connection);
    	ArrayList<ProfessorModel> professores = retriveProfessoresFromDatabase(connection);

    	SchoolView schoolView = new SchoolView();

    	SchoolController schoolCtrl = new SchoolController(alunos, aulas, professores, schoolView);
    	
    	schoolCtrl.showAlunoView();
    	schoolCtrl.showAulaView();
    	schoolCtrl.showProfessorView();
    	

		addNewAluno(connection, "111", "bruno", 20, 2, "0000");
		alunos =  retriveAlunosFromDatabase(connection);
		schoolCtrl = new SchoolController(alunos, aulas, professores, schoolView);
    	schoolCtrl.showAlunoView();

		removeAluno(connection, "111");
		alunos =  retriveAlunosFromDatabase(connection);
		schoolCtrl = new SchoolController(alunos, aulas, professores, schoolView);
    	schoolCtrl.showAlunoView();
    	
    	novoAno(connection);
		alunos =  retriveAlunosFromDatabase(connection);
		schoolCtrl = new SchoolController(alunos, aulas, professores, schoolView);
    	schoolCtrl.showAlunoView();
    	
    	aproveAluno(connection);
		alunos =  retriveAlunosFromDatabase(connection);
		schoolCtrl = new SchoolController(alunos, aulas, professores, schoolView);
    	schoolCtrl.showAlunoView();

    }
    
    private static void addNewAluno(Connection connection, String rg, String nome, int idade, int media, String aulaId) {
    	AlunoModel aluno = new AlunoModel();
    	aluno.novoAluno(connection,rg,nome,idade,media,aulaId);
    }

    private static void removeAluno(Connection connection, String rg) {
    	AlunoModel aluno = new AlunoModel();
    	aluno.removerAluno(connection,rg);
    }

    private static void novoAno(Connection connection) {
    	AlunoModel aluno = new AlunoModel();
    	aluno.novoAno(connection);
    }

    private static void aproveAluno(Connection connection) {
    	AlunoModel aluno = new AlunoModel();
    	aluno.aprovarAluno(connection);
    }

	private static ArrayList<ProfessorModel> retriveProfessoresFromDatabase(Connection connection){
		ArrayList<ProfessorModel> professores = new ArrayList<ProfessorModel>();

		try {
			Statement statement = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            ResultSet profResultSet = statement.executeQuery("select * from professor");
			System.out.println("------PROFESSORES-----");
            while(profResultSet.next()) {
                System.out.println("----------------------");
				professores.add(new ProfessorModel(
								profResultSet.getString(1),
								profResultSet.getString(2),
								profResultSet.getString(3)));

			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return professores;
	}

	private static ArrayList<AulaModel> retriveAulasFromDatabase(Connection connection){
		ArrayList<AulaModel> aulas = new ArrayList<AulaModel>();

		try {
			Statement statement = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            ResultSet aulaResultSet = statement.executeQuery("select * from aula");
            while(aulaResultSet.next()) {
				aulas.add(new AulaModel(
								aulaResultSet.getString(1),
								aulaResultSet.getString(4),
								aulaResultSet.getString(2),
								aulaResultSet.getInt(3)));

			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return aulas;
	}

	private static ArrayList<AlunoModel> retriveAlunosFromDatabase(Connection connection){
		ArrayList<AlunoModel> alunos = new ArrayList<AlunoModel>();
		try {
			Statement statement = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
			ResultSet resultSet = statement.executeQuery("select * from aluno");
			while (resultSet.next()) {
				alunos.add(new AlunoModel(
								resultSet.getString(1),
								resultSet.getString(2),
								resultSet.getString(5),
								resultSet.getInt(6),
								resultSet.getInt(3),
								resultSet.getInt(4)));

			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return alunos;
	  }   	
}