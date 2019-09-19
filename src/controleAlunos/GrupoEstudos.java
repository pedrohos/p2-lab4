package controleAlunos;

import java.util.HashSet;

public class GrupoEstudos {
	private String nomeCadastrado;
	private String nomeArmazenado;
	private HashSet<Aluno> alunosCadastrados;
	
	public GrupoEstudos(String nome) {
		nome = nome.trim();
		
		if(nome == null || nome.equals("")) {
			throw new IllegalArgumentException("ENTRADA NUlA OU VAZIA!");
		}
		
		this.nomeCadastrado = nome;
		this.nomeArmazenado = nome.toLowerCase();
		this.alunosCadastrados = new HashSet<>();
	}
	
	public Boolean alocaAluno(Aluno aluno) {
		if (!alunosCadastrados.contains(aluno)) {
			this.alunosCadastrados.add(aluno);
			return true;
		}
		return false;
	}
	
	public int getQntAlunos() {
		return this.alunosCadastrados.size();
	}
	
	public String getNomeReal() {
		return this.nomeCadastrado;
	}
	
	public String getNomeArmazenado() {
		return this.nomeArmazenado;
	}

	@Override
	public String toString() {
		String resultado = "";
		for (Aluno e: alunosCadastrados) {
			resultado += e.toString() + "\n";
		}
		return resultado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeArmazenado == null) ? 0 : nomeArmazenado.hashCode());
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
		if (nomeArmazenado == null) {
			if (other.nomeArmazenado != null)
				return false;
		} else if (!nomeArmazenado.equals(other.nomeArmazenado))
			return false;
		return true;
	}
	
}
