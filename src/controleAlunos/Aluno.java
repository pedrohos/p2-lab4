package controleAlunos;

public class Aluno {
	private String matricula;
	private String nome;
	private String curso;
	
	public Aluno(String matricula, String nome, String curso) {
		if(matricula == null || matricula.equals("")) {
			throw new IllegalArgumentException("ENTRADA NUlA OU VAZIA!");
		}
		if(nome == null || nome.equals("")) {
			throw new IllegalArgumentException("ENTRADA NUlA OU VAZIA!");
		}
		if(curso == null || curso.equals("")) {
			throw new IllegalArgumentException("ENTRADA NUlA OU VAZIA!");
		}
		
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "Aluno: " + matricula + " - " + nome + " - " + curso;
	}
}
