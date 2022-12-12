package com.example.oficinaco.jpa.entidade;

public enum EnumUf {

	/**
11-Rondônia
12-Acre
13-Amazonas
14-Roraima
15-Pará
16-Amapá
17-Tocantins

21-Maranhão
22-Piauí
23-Ceará
24-Rio Grande do Norte
25-Paraíba
26-Pernambuco
27-Alagoas
28-Sergipe
29-Bahia


31-Minas Gerais
32-Espírito Santo
33-Rio de Janeiro
35-São Paulo

41-Paraná
42-Santa Catarina
43-Rio Grande do Sul

50-Mato Grosso do Sul
51-Mato Grosso
52-Goiás
53-Distrito Federal

9999999 - Exterior

	 */

	AC("Acre"),
	AL("Alagoas"),
	AP("Amapá"),
	AM("Amazonas"),
	BA("Bahia"),
	CE("Ceará"),
	DF("Distrito Federal"),
	ES("Espírito Santo"),
	GO("Goiás"),
	MA("Maranhão"),
	MT("Mato Grosso"),
	MS("Mato Grosso do Sul"),
	MG("Minas Gerais"),
	PA("Pará"),
	PB("Paraíba"),
	PE("Pernambuco"),
	PR("Paraná"),
	PI("Piauí"),
	RJ("Rio De Janeiro"),
	RN("Rio Grande do Norte"),
	RS("Rio Grande do Sul"),
	RO("Rondônia"),
	RR("Roraima"),
	SC("Santa Catarina"),
	SE("Sergipe"),
	SP("São Paulo"),
	TO("Tocantins"),
	EX("Exterior");

	private String descricao;
	
	EnumUf(String descricao) {
		this.descricao = descricao;
	}

	
//teste
	public String getDescricao() {
		return descricao;
	}

	

}