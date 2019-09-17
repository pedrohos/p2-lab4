package controleAlunos;

import java.util.HashSet;

public class GrupoEstudos {
	private String nome;
	private HashSet<String> alunosCadastrados;
	
	public GrupoEstudos(String nome) {
		if(nome == null || nome.equals("")) {
			throw new IllegalArgumentException("ENTRADA NUlA OU VAZIA!");
		}
		
		this.nome = nome;
		this.alunosCadastrados = new HashSet<>();
	}
	
	public String alocaAluno(String matricula) {
		if (!alunosCadastrados.contains(matricula)) {
			this.alunosCadastrados.add(matricula);
		}
		return "ALUNO ALOCADO!";
	}
	
	public String getNome() {
		return this.nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GrupoEstudos other = (GrupoEstudos) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
}
