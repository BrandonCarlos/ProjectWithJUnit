package br.com.alura.tdd.modelo;

import java.math.BigDecimal;

public enum Desempenho {
	//Agora cada constante sabe qual é seu percentual de reajuste
	A_DESEJAR {
		@Override
		public BigDecimal percentualReajuste() {
			return new BigDecimal("0.03");
		}
	}, 
	BOM {
		@Override
		public BigDecimal percentualReajuste() {
			return new BigDecimal("0.15");
		}
	}, 
	OTIMO {
		@Override
		public BigDecimal percentualReajuste() {
			return new BigDecimal("0.2");
		}
	},
	ESPETACULAR {
		@Override
		public BigDecimal percentualReajuste() {
			return new BigDecimal("0.4");
		}
	};
	
	//Aqui dentro do ENUM podemos ter método e lógicas também
	
	public abstract BigDecimal percentualReajuste();//forçando a cada uma das CONSTANTES ter sua implementação
	
}
