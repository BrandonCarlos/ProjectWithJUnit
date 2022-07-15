package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteServiceTest {
	
	//Ao inv�s de ser "V�riaveis locais" agora s�o campos, atributos que podemos reusar em todo nosso c�digo
	private ReajusteService service;
	private Funcionario funcionario;

	@BeforeEach //esta annotation far� com que cada m�todo de teste quando iniciar inicie primeiro com este m�todo initializar()
	public void initializar() {
		System.out.println("Inicializar.");
		this.service = new ReajusteService();
		this.funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000.00"));
	}
	
	@AfterEach //Ap�s executar cada teste, executar por fim este m�todo finalizar();
	public void finalizar() {
		System.out.println("Teste finalizado.");
	}
	
	@BeforeAll //este m�todo ser� executado apenas "uma vez"
	public static void antesDeTodos() {
		System.out.println("ANTES DE TODOS");
	}
	
	@AfterAll //este m�todo roda depois de todos apenas "uma vez"
	public static void depoisDeTodos() {
		System.out.println("DEPOIS DE TODOS");
	}
	
	@Test
	public void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoForADesejar() {
		//vamos dizer ao JUnit que ele precisa inicializar o m�todo de todos os m�todos de teste
		service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
	}
	
	@Test
	public void reajusteDeveriaSerDeQuinzePorcentoQuandoDesempenhoForBom() {
		service.concederReajuste(funcionario, Desempenho.BOM);
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
	}
	
	@Test
	public void reajusteDeveriaSerDeVintePorcentoQuandoDesenpenhoForOtimo() {
		service.concederReajuste(funcionario, Desempenho.OTIMO);
		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
	}
	
	@Test
	public void reajusteDeveriaSerDeQuarentaPorcentoQuandoDesempenhoForEspetacular() {
		service.concederReajuste(funcionario, Desempenho.ESPETACULAR);
		assertEquals(new BigDecimal("1400.00"), funcionario.getSalario());
	}
	
}
