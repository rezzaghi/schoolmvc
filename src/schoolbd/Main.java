package schoolbd;

import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import schoolbd.controller.SchoolController;
import schoolbd.model.AlunoModel;
import schoolbd.model.AulaModel;
import schoolbd.model.ProfessorModel;
import schoolbd.view.SchoolView;

public class Main {
    public static void main(String[] args) {

	Connection connection = null;
        Scanner reader = new Scanner(System.in);
	try {
	    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo", "root", "");
	} catch (Exception e) {
	    System.out.println(e);
	}
	boolean endProgram = false;
	while(!endProgram) {
            ArrayList<AlunoModel> alunos = retriveAlunosFromDatabase(connection);
            ArrayList<AulaModel> aulas = retriveAulasFromDatabase(connection);
            ArrayList<ProfessorModel> professores = retriveProfessoresFromDatabase(connection);
            SchoolView schoolView = new SchoolView();
            SchoolController schoolCtrl = new SchoolController(alunos, aulas, professores, schoolView);

            System.out.println("pressione 1 para mostrar alunos, professores e aulas\npressione 2 para adicionar aluno\npressione 3 para remover aluno\npressione 4 para recomecar o ano\npressione 5 para aprovar alunos\npressione qualquer outro numero para terminar o programa: ");	
	    int operacao = reader.nextInt();
            String rg;
            String nome;
            int idade;
            int media;
            String aulaId;

	    switch(operacao) {
	    	case 1: 
                    schoolCtrl.showAulaView();
                    schoolCtrl.showProfessorView();
                    schoolCtrl.showAlunoView();
	    	    break;
	    	case 2:
	    	    System.out.println("RG do aluno: ");
	    	    rg = reader.next();
	    	    System.out.println("Nome do aluno: ");
	    	    nome = reader.next();
	    	    System.out.println("Idade do aluno: ");
	    	    idade = reader.nextInt();
	    	    System.out.println("Media do aluno: ");
	    	    media = reader.nextInt();
	    	    System.out.println("Id da aula: ");
	    	    aulaId = reader.next();
	    	    addNewAluno(connection,rg,nome,idade,media,aulaId);
	    	    break;
	    	case 3:
	    	    System.out.println("RG do aluno: ");
	    	    rg = reader.next();
	    	    removeAluno(connection, rg);
	    	    break;
	    	case 4:
	    	    novoAno(connection);
	    	    break;
	    	case 5:
                    aproveAluno(connection);
                    break;
                default:
                    System.out.println("TERMINO DO PROGRAMA");
                    endProgram = true;
                    break;
	    }
	    
	}
	reader.close();
	
    }

    private static void addNewAluno(Connection connection, String rg, String nome, int idade, int media,
	    String aulaId) {
	AlunoModel aluno = new AlunoModel();
	aluno.novoAluno(connection, rg, nome, idade, media, aulaId);
    }

    private static void removeAluno(Connection connection, String rg) {
	AlunoModel aluno = new AlunoModel();
	aluno.removerAluno(connection, rg);
    }

    private static void novoAno(Connection connection) {
	AlunoModel aluno = new AlunoModel();
	aluno.novoAno(connection);
    }

    private static void aproveAluno(Connection connection) {
	AlunoModel aluno = new AlunoModel();
	aluno.aprovarAluno(connection);
    }

    private static ArrayList<ProfessorModel> retriveProfessoresFromDatabase(Connection connection) {
	ArrayList<ProfessorModel> professores = new ArrayList<ProfessorModel>();

	try {
	    Statement statement = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
	    ResultSet profResultSet = statement.executeQuery("select * from professor");
	    while (profResultSet.next()) {
		professores.add(new ProfessorModel(profResultSet.getString(1), profResultSet.getString(2),
			profResultSet.getString(3)));

	    }
	} catch (Exception e) {
	    System.out.println(e);
	}

	return professores;
    }

    private static ArrayList<AulaModel> retriveAulasFromDatabase(Connection connection) {
	ArrayList<AulaModel> aulas = new ArrayList<AulaModel>();

	try {
	    Statement statement = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
	    ResultSet aulaResultSet = statement.executeQuery("select * from aula");
	    while (aulaResultSet.next()) {
		aulas.add(new AulaModel(aulaResultSet.getString(1), aulaResultSet.getString(4),
			aulaResultSet.getString(2), aulaResultSet.getInt(3)));

	    }
	} catch (Exception e) {
	    System.out.println(e);
	}

	return aulas;
    }

    private static ArrayList<AlunoModel> retriveAlunosFromDatabase(Connection connection) {
	ArrayList<AlunoModel> alunos = new ArrayList<AlunoModel>();
	try {
	    Statement statement = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
	    ResultSet resultSet = statement.executeQuery("select * from aluno");
	    while (resultSet.next()) {
		alunos.add(new AlunoModel(resultSet.getString(1), resultSet.getString(2), resultSet.getString(5),
			resultSet.getInt(6), resultSet.getInt(3), resultSet.getInt(4)));

	    }
	} catch (Exception e) {
	    System.out.println(e);
	}

	return alunos;
    }
}