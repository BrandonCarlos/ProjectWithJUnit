package br.com.alura.tdd.modelo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class Funcionario {

	private String nome;
	private LocalDate dataAdmissao;
	private BigDecimal salario;

	// quando for adicionado um objeto funcionário temos que passar essas 3
	// informações
	public Funcionario(String nome, LocalDate dataAdmissao, BigDecimal salario) {
		this.nome = nome;
		this.dataAdmissao = dataAdmissao;
		this.salario = salario;
	}

	public String getNome() {
		return nome;
	}

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDataAdmissao(LocalDate dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public void reajustarSalario(BigDecimal reajuste) {
		this.salario = this.salario.add(reajuste);
		arredondarSalario();
	}

	//método "privado" não podemos chamar , o que poderemos chamar é o método acima "reajustarSalario(BigDecimal reajuste)"
	private void arredondarSalario() {
		//abaixo estamos fazer o arredondamento do salario novamente, pois pode ser que precisemos deste
		//método mais vezes e ai não precisamos reescrever está linha e sim apenas chamar o método arredondarSalario()
		this.salario = this.salario.setScale(2, RoundingMode.HALF_UP);
	}


}
