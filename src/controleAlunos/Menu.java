package controleAlunos;

import java.util.Scanner;

public class Menu {
	
	private static Scanner sc = new Scanner(System.in);
	private static Sistema sistema = new Sistema();
	
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
					System.out.print("\n");
					System.out.print(cadastrarAluno());
					System.out.print("\n");
					break;
				case "E":
					System.out.print("\n");
					System.out.println(exibirAlunoSistema());
					System.out.print("\n");
					break;
				case "N":
					System.out.print("\n");
					System.out.println(cadastrarGrupoSistema());
					System.out.print("\n");
					break;
				case "A":
					System.out.print("\n");
					System.out.print("(A)locar Aluno ou (I)mprimir Grupo? ");
					String opcao = sc.nextLine();
					System.out.print("\n");
					if(opcao.equals("A")) {
						System.out.println(alocaAlunoSistema());
						System.out.print("\n");
					} else if(opcao.equals("I")) {
						
					} else {
						throw new IllegalArgumentException("OPÇÃO INVÁLIDA!");
					}
					break;
				case "R":
					break;
				case "I":
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
	
	private static String cadastrarAluno() {
		System.out.print("Matrícula: ");
		String matricula = validaEntrada();
		System.out.print("Nome: ");
		String nome = validaEntrada();
		System.out.print("Curso: ");
		String curso = validaEntrada();
		return sistema.cadastraAluno(matricula, nome, curso);
	}
	
	private static String exibirAlunoSistema() {
		System.out.print("Matrícula: ");
		String matricula = validaEntrada();
		System.out.print("\n");
		return sistema.exibirAluno(matricula);
	}
	
	private static String cadastrarGrupoSistema() {
		System.out.print("Grupo: ");
		String nome = validaEntrada();
		System.out.print("\n");
		return sistema.cadastrarGrupo(nome);
	}
	
	private static String alocaAlunoSistema() {
		System.out.print("Matrícula: ");
		String nome = validaEntrada();
		System.out.print("Grupo: ");
		String grupo = validaEntrada();
		return sistema.alocaAluno(nome, grupo);
	}
	
}
