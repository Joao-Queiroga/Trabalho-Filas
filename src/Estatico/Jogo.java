package Estatico;

import java.util.Scanner;

public class Jogo {

	private Scanner scanner = new Scanner(System.in);
	private int dia, mes, ano, placarSelecao1, placarSelecao2;
	private String etapa, selecao1, selecao2, local;

	// Primeiro construtor
	Jogo(int dia, int mes, int ano, int placarSelecao1, int placarSelecao2, String etapa, String selecao1,
			String selecao2, String local) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		this.placarSelecao1 = placarSelecao1;
		this.placarSelecao2 = placarSelecao2;
		this.etapa = etapa;
		this.selecao1 = selecao1;
		this.selecao2 = selecao2;
		this.local = local;
	}

	Jogo(){
		// construtor vazio
	}

	public Jogo clone() {
		Jogo copia;
		copia = new Jogo(this.dia, this.mes, this.ano, this.placarSelecao1, this.placarSelecao2, this.etapa,
				this.selecao1, this.selecao2, this.local);
		return copia;
	}

	public void ler() {
		Jogo jogo = new Jogo();
		String entrada;

		entrada = scanner.nextLine();
		jogo.setDia(Integer.parseInt(entrada));

		entrada = scanner.nextLine();
		jogo.setMes(Integer.parseInt(entrada));

		entrada = scanner.nextLine();
		jogo.setAno(Integer.parseInt(entrada));

		entrada = scanner.nextLine();
		jogo.setEtapa(entrada);

		entrada = scanner.nextLine();
		jogo.setSelecao1(entrada);

		entrada = scanner.nextLine();
		jogo.setPlacarSelecao1(Integer.parseInt(entrada));

		entrada = scanner.nextLine();
		jogo.setSelecao2(entrada);

		entrada = scanner.nextLine();
		jogo.setPlacarSelecao2(Integer.parseInt(entrada));

		entrada = scanner.nextLine();
		jogo.setLocal(entrada);

		jogo = new Jogo(jogo.getDia(), jogo.getMes(), jogo.getAno(), jogo.getPlacarSelecao1(), jogo.getPlacarSelecao2(),
				jogo.getEtapa(), jogo.getSelecao1(), jogo.getSelecao2(), jogo.getLocal());

	}

	public void imprimir() {
		System.out.println("[COPA " + this.ano + "] [" + this.etapa + "] [" + this.dia + "/" + this.mes + "] [" + this.selecao1 + " ("
				+ this.placarSelecao1 + ") x (" + this.placarSelecao2 + ") " + this.selecao2 + "] [" + this.local + "]");
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getPlacarSelecao1() {
		return placarSelecao1;
	}

	public void setPlacarSelecao1(int placarSelecao1) {
		this.placarSelecao1 = placarSelecao1;
	}

	public int getPlacarSelecao2() {
		return placarSelecao2;
	}

	public void setPlacarSelecao2(int placarSelecao2) {
		this.placarSelecao2 = placarSelecao2;
	}

	public String getEtapa() {
		return etapa;
	}

	public void setEtapa(String etapa) {
		this.etapa = etapa;
	}

	public String getSelecao1() {
		return selecao1;
	}

	public void setSelecao1(String selecao1) {
		this.selecao1 = selecao1;
	}

	public String getSelecao2() {
		return selecao2;
	}

	public void setSelecao2(String selecao2) {
		this.selecao2 = selecao2;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}
	
}
