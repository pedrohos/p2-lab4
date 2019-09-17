package controleAlunos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Sistema {
	HashMap<String, Aluno> mapaMatriculaAlunos;
	HashSet<GrupoEstudos> grupos;
	ArrayList<Aluno> alunosResponderam;
	
	public Sistema() {
		mapaMatriculaAlunos = new HashMap<>();
		grupos = new HashSet<>();
		this.alunosResponderam =  new ArrayList<>();
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
		if(!this.mapaMatriculaAlunos.containsKey(matricula)) {
			return "Aluno não cadastrado.";
		}
		for (GrupoEstudos e: grupos) {
			if(e.getNome().equals(nomeGrupo)) {
				return e.alocaAluno(mapaMatriculaAlunos.get(matricula));
			}
		}
		return "Grupo não cadastrado.";
	}
	
	public String imprimeGrupo(String grupo) {
		String resultado = "\nAlunos do grupo " + grupo + ":\n";
		for (GrupoEstudos e: grupos) {
			if(e.getNome().equals(grupo)) {
				if (e.getQntAlunos() == 0) {
					return "Não há alunos cadastrados.";
				}
				resultado += "* " + e.toString() + "\n";
				return resultado;
			}
			
		}
		
		return "Grupo não cadastrado.";
	}
	
	public String cadastraPerguntaRespondida(String matricula) {
		if(!this.mapaMatriculaAlunos.containsKey(matricula)) {
			return "Aluno não cadastrado.\n";
		}
		this.alunosResponderam.add(this.mapaMatriculaAlunos.get(matricula));
		return "ALUNO REGISTRADO!\n";
	}
	
	public String imprimePerguntaRespondida() {
		if(this.alunosResponderam.size() == 0) {
			return "Nenhuma pergunta cadastrada.\n\n";
		}
		
		String resultado = "Alunos:\n";
		for(int i = 0; i < this.alunosResponderam.size(); i++) {
			resultado += (i + 1) + ". " + this.alunosResponderam.get(i).toString() + "\n";
		}
		return resultado + "\n";
	}
}
