package controleAlunos;

import java.util.HashMap;
import java.util.HashSet;

public class Sistema {
	HashMap<String, Aluno> mapaMatriculaAlunos;
	HashSet<GrupoEstudos> grupos;
	
	public Sistema() {
		mapaMatriculaAlunos = new HashMap<>();
		grupos = new HashSet<>();
	}
	
	public String cadastraAluno(String matricula, String nome, String curso) {
		if(procuraMatricula(matricula)) {
			return "MATRÍCULA JÁ CADASTRADA!\n";
		}
		Aluno aluno = new Aluno(matricula, nome, curso);
		this.mapaMatriculaAlunos.put(matricula, aluno);
		return "CADASTRO REALIZADO!\n";
	}
	
	public boolean procuraMatricula(String matricula) {
		for(String matriculaRegistrada: this.mapaMatriculaAlunos.keySet()) {
			if(matriculaRegistrada.equals(matricula)) {
				return true;
			}
		}
		return false;
	}
	
	public String exibirAluno(String matricula) {
		if(procuraMatricula(matricula)) {
			return getAlunoString(matricula);
		}
		return "Aluno não cadastrado.";
	}
	
	public String getAlunoString(String matricula) {
		if (procuraMatricula(matricula)) {
			return this.mapaMatriculaAlunos.get(matricula).toString();
		}
		return "Aluno não cadastrado.";
	}
	
	public String cadastrarGrupo(String nome) {
		GrupoEstudos grupo = new GrupoEstudos(nome);
		for (GrupoEstudos e: grupos) {
			if(e.equals(grupo)) {
				return "GRUPO JÁ CADASTRADO!";
			}
		}
		this.grupos.add(grupo);
		return "CADASTRO REALIZADO!";
	}
	
	public String alocaAluno(String matricula, String nomeGrupo) {
		if(!mapaMatriculaAlunos.containsKey(matricula)) {
			return "Aluno não cadastrado.";
		}
		for (GrupoEstudos e: grupos) {
			if(e.getNome().equals(nomeGrupo)) {
				return e.alocaAluno(matricula);
			}
		}
		return "Grupo não cadastrado.";
	}
}
