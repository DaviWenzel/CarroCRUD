package maven;

import java.time.LocalDate;

public class Carro {
	private int ano;
	private int potencia;
	private String modelo;
	private String placa;
	private String marca;
	
	public Carro() {}
	
	public Carro(int ano, int potencia, String modelo, String placa, String marca) {
		this.ano = ano;
		this.potencia = potencia;
		this.modelo = modelo;
		this.placa = placa;
		this.marca = marca;
	}




	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		LocalDate now = LocalDate.now();
		int year = now.getYear();
		if((ano < year + 1 && ano > 1886)) {
			this.ano = ano;
		} else {
			System.out.println("Ano inválido.");
		}
	}

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		if(potencia > 0 && potencia < 1500) {
			this.potencia = potencia;
		} 
		else
			System.out.println("Potência inválida.");
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		if(modelo != null && modelo.length() < 50)
			this.modelo = modelo;
		else
			System.out.println("Modelo inválido.");
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

}
