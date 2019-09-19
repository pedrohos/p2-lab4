package controleAlunos;

import java.util.Scanner;

public class Menu {
	
	private static Scanner sc = new Scanner(System.in);
	private static Sistema sistema = new Sistema();
	private final static String LS = System.lineSeparator();
	
	public static void main(String[] args) {
		final String MENU = "(C)adastrar Aluno\r\n" + 
				  			"(E)xibir Aluno\r\n" + 
				  			"(N)ovo Grupo\r\n" + 
				  			"(A)locar Aluno no Grupo e Imprimir Grupos\r\n" + 
				  			"(R)egistrar Aluno que Respondeu\r\n" + 
				  			"(I)mprimir Alunos que Responderam\r\n" + 
				  			"(O)ra, vamos fechar o programa!\r\n" + 
				  			"\n" + 
				  			"Opção> ";
		
		
		
		boolean rodando = true;
		while (rodando) {
			System.out.print(MENU);
			switch(sc.nextLine()) {
				case "C":
					System.out.print(LS + cadastrarAlunoSistema() + LS);
					break;
				case "E":
					System.out.println(LS + exibirAlunoSistema() + LS);
					break;
				case "N":
					System.out.println(LS + cadastrarGrupoSistema() + LS);
					break;
				case "A":
					System.out.print(LS + "(A)locar Aluno ou (I)mprimir Grupo? ");
					String opcao = sc.nextLine();
					System.out.print(LS);
					if(opcao.equals("A")) {
						System.out.println(alocaAlunoSistema() + LS);
					} else if(opcao.equals("I")) {
						System.out.println(imprimeGrupoSistema() + LS);
					} else {
						throw new IllegalArgumentException("OPÇÃO INVÁLIDA!");
					}
					break;
				case "R":
					System.out.print(cadastraPerguntaRespondidaSistema() + LS);
					break;
				case "I":
					System.out.print(imprimePerguntaRespondidaSistema());
					break;
				case "O":
					rodando = false;
					break;
				default:
					throw new IllegalArgumentException("OPÇÃO INVÁLIDA!");
			}
		}
	}
	
	private static String validaEntrada() {
		String entrada = sc.nextLine().trim();
		if(entrada == null || entrada.equals("")) {
			throw new IllegalArgumentException("ENTRADA NUlA OU VAZIA!");
		}
		return entrada;
	}
	
	private static String cadastrarAlunoSistema() {
		System.out.print("Matrícula: ");
		String matricula = validaEntrada();
		System.out.print("Nome: ");
		String nome = validaEntrada();
		System.out.print("Curso: ");
		String curso = validaEntrada();
		if (sistema.cadastraAluno(matricula, nome, curso)) {
			return "MATRÍCULA JÁ CADASTRADA!" + LS;
		}
		return "CADASTRO REALIZADO!" + LS;
	}
	
	private static String exibirAlunoSistema() {
		System.out.print("Matrícula: ");
		String matricula = validaEntrada();
		String aluno = sistema.exibirAluno(matricula);
		if (aluno == null) {
			return "Aluno não cadastrado.";
		}
		return aluno;
	}
	
	private static String cadastrarGrupoSistema() {
		System.out.print("Grupo: ");
		String nome = validaEntrada();
		if(sistema.cadastrarGrupo(nome)) {
			return "CADASTRO REALIZADO!";
		}
		return "GRUPO JÁ CADASTRADO!";
	}
	
	private static String alocaAlunoSistema() {
		System.out.print("Matrícula: ");
		String nome = validaEntrada();
		System.out.print("Grupo: ");
		String grupo = validaEntrada();
		
		switch (sistema.alocaAluno(nome, grupo)) {
			case "NaNAluno":
				return "Aluno não cadastrado.";
			case "NaNGrupo":
				return "Grupo não cadastrado.";
			default:
				return "ALUNO ALOCADO!";
		}
	}
	
	private static String imprimeGrupoSistema() {
		System.out.print("Grupo: ");
		String grupo = validaEntrada();
		String grupoImpresso = sistema.imprimeGrupo(grupo);
		if (grupoImpresso == null) {
			return "Não há alunos cadastrados.";
		}
		return grupoImpresso;
		
	}
	
	private static String cadastraPerguntaRespondidaSistema() {
		System.out.print("Matrícula: ");
		String matricula = validaEntrada();
		if (sistema.cadastraPerguntaRespondida(matricula)) {
			return "ALUNO REGISTRADO!" + LS;
		}
		return "Aluno não cadastrado." + LS;
	}
	
	private static String imprimePerguntaRespondidaSistema() {
		String resultado = sistema.imprimePerguntaRespondida();
		if(resultado == null) {
			return "Nenhuma pergunta cadastrada." + LS + LS;
		}
		return resultado;
	}
	
}
