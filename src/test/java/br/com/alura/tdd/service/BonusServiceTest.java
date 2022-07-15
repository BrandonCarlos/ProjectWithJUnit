package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	@Test
	void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
		BonusService service = new BonusService();
		//abaixo temos a forma de como JUnit espera pela Exception
		//assertThrows(IllegalArgumentException.class, () -> service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000"))));
	
		//Segunda forma de fazer o JUnit esperar a Exception
		try {
			service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000")));
			fail("N�o deu a exception!");//m�todo do JUnit para for�ar que o teste falhou
		} catch (Exception e) {
			//Verificando se a mensagem que chegou aqui na Exception � a mesma que declarei no IllegalArgumentException
			assertEquals("Funcion�rio com salario maior que 10000 n�o recebe bonus!", e.getMessage());
		}
		
	}
	
	@Test
	void bonusDeveriaSer10PorCentoDoSalario() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("2500")));
	
		assertEquals(new BigDecimal("250.00"), bonus);
	}
	
	@Test
	void bonusDeveriaSerDezPorCentoParaSalarioDeExatamente10000() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("10000")));
	
		assertEquals(new BigDecimal("1000.00"), bonus);//Se o sal�rio for > 10000 ai o bonus � 0
	}

}
