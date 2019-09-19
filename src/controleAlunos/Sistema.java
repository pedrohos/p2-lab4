package controleAlunos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Sistema {
	private final static String LS = System.lineSeparator();
	private HashMap<String, Aluno> mapaMatriculaAlunos;
	private HashSet<GrupoEstudos> grupos;
	private ArrayList<Aluno> alunosResponderam;
	
	public Sistema() {
		mapaMatriculaAlunos = new HashMap<>();
		grupos = new HashSet<>();
		this.alunosResponderam =  new ArrayList<>();
	}
	
	public Boolean cadastraAluno(String matricula, String nome, String curso) {
		if(procuraMatricula(matricula)) {
			return true;
		}
		Aluno aluno = new Aluno(matricula, nome, curso);
		this.mapaMatriculaAlunos.put(matricula, aluno);
		return false;
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
		return null;
	}
	
	public String getAlunoString(String matricula) {
		return this.mapaMatriculaAlunos.get(matricula).toString();
	}
	
	public Boolean cadastrarGrupo(String nome) {
		GrupoEstudos grupo = new GrupoEstudos(nome);
		for (GrupoEstudos e: grupos) {
			if(e.equals(grupo)) {
				return false;
			}
		}
		this.grupos.add(grupo);
		return true;
	}
	
	public String alocaAluno(String matricula, String nomeGrupo) {
		if(!this.mapaMatriculaAlunos.containsKey(matricula)) {
			return "NaNAluno";
		}
		nomeGrupo = nomeGrupo.toLowerCase();
		for (GrupoEstudos e: grupos) {
			if(e.getNomeArmazenado().equals(nomeGrupo)) {
				if(e.alocaAluno(mapaMatriculaAlunos.get(matricula))) {
					return "";
				}
			}
		}
		return "NaNGrupo";
	}
	
	public String imprimeGrupo(String grupo) {
		String resultado = LS + "Alunos do grupo " + grupo + ":" + LS;
		grupo = grupo.toLowerCase();
		for (GrupoEstudos e: grupos) {
			if(e.getNomeArmazenado().equals(grupo)) {
				if (e.getQntAlunos() == 0) {
					return null;
				}
				resultado += "* " + e.toString() + LS;
				return resultado;
			}
		}
		
		return null;
	}
	
	public Boolean cadastraPerguntaRespondida(String matricula) {
		if(!this.mapaMatriculaAlunos.containsKey(matricula)) {
			return false;
		}
		this.alunosResponderam.add(this.mapaMatriculaAlunos.get(matricula));
		return true;
	}
	
	public String imprimePerguntaRespondida() {
		if(this.alunosResponderam.size() == 0) {
			return null;
		}
		
		String resultado = "Alunos:\n";
		for(int i = 0; i < this.alunosResponderam.size(); i++) {
			resultado += (i + 1) + ". " + this.alunosResponderam.get(i).toString() + LS;
		}
		return resultado + LS;
	}
}
