package br.com.alura.tdd.service;

import java.math.BigDecimal;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteService {

	public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
			BigDecimal percentual = desempenho.percentualReajuste();//retornar o A_DESEJAR, BOM ou OTIMO
			BigDecimal reajuste = funcionario.getSalario().multiply(percentual);//salarioAtual * 0.3 = 1150.00
			funcionario.reajustarSalario(reajuste);//e aqui reajustando o salario para 1150.00
	
	}
	
}
