package controleAlunos;

import static org.junit.jupiter.api.Assertions.*;
import controleAlunos.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AlunoTest {
	
	static Aluno aluno1;
	static Aluno aluno2;
	static Aluno aluno3;
	
	@BeforeAll
	static void testCriaAlunos() {
		aluno1 = new Aluno("1234851","Carlos", "Computação");
		aluno2 = new Aluno("4161315","Rafael", "Engenharia Elétrica");
		aluno3 = new Aluno("1234851","Tiago", "Matemática");
		
		assertNotEquals(aluno1,aluno2);
		assertEquals(aluno1, aluno3);
	}
	
	@Test
	void testCriaAlunoInvalidos() {
		try {
			new Aluno("  ", "Pedro", "Línguas");
			fail("A exceção não foi lançada.");
		} catch(IllegalArgumentException iae) {
			assertEquals(iae.toString(), "java.lang.IllegalArgumentException: ENTRADA VAZIA!");
		}
		try {
			new Aluno("2515132", "  ", "Línguas");
			fail("A exceção não foi lançada.");
		} catch(IllegalArgumentException iae) {
			assertEquals(iae.toString(), "java.lang.IllegalArgumentException: ENTRADA VAZIA!");
		}
		try {
			new Aluno("2515132", "Pedro", "  ");
			fail("A exceção não foi lançada.");
		} catch(IllegalArgumentException iae) {
			assertEquals(iae.toString(), "java.lang.IllegalArgumentException: ENTRADA VAZIA!");
		}
		try {
			new Aluno(null, "Pedro", "Línguas");
			fail("A exeção não foi lançada.");
		} catch(IllegalArgumentException iae) {
			assertEquals(iae.toString(), "java.lang.IllegalArgumentException: ENTRADA NULA!");
		}
		try {
			new Aluno("2515132", null, "Línguas");
			fail("A exceção não foi lançada.");
		} catch(IllegalArgumentException iae) {
			assertEquals(iae.toString(), "java.lang.IllegalArgumentException: ENTRADA NULA!");
		}
		try {
			new Aluno("2515132", "Pedro", null);
			fail("A exceção não foi lançada.");
		} catch(IllegalArgumentException iae) {
			assertEquals(iae.toString(), "java.lang.IllegalArgumentException: ENTRADA NULA!");
		}
	}

	@Test
	void testToString() {
		assertEquals(aluno1.toString(), "Aluno: 1234851 - Carlos - Computação");
	}

	@Test
	void testEquals() {
		Aluno aluno4 = new Aluno("4161315","Rafael", "Engenharia Elétrica");
		Aluno aluno5 = new Aluno("4816912","Rafael", "Design");
		
		assertEquals(aluno1, aluno3);
	}

}
