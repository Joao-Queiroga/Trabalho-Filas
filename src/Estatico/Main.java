package Estatico;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner arquivoPartidas = new Scanner(new File("/tmp/partidas.txt"));
        Scanner input = new Scanner(System.in);
        Fila fila  = new Fila();
        Vector<Jogo> jogos = new Vector<>();
        while (arquivoPartidas.hasNextLine()) {
            jogos.add(criaJogo(arquivoPartidas.nextLine()));
        }
        String entrada = input.nextLine();
        while (!entrada.equals("FIM")) {
            fila.enfileirar(procuraJogo(jogos, entrada));
            entrada = input.nextLine();
        }
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            entrada = input.next();
            if (entrada.equals("D")) {
                fila.desenfileirar().imprimir();
            }
            else {
                String atributos = input.nextLine();
                if (fila.estaCheia())
                    fila.desenfileirar().imprimir();
                fila.enfileirar(procuraJogo(jogos, atributos));
            }
        }
        fila.mostrar();
    }
    public static Jogo criaJogo(String atributo) {
        String[] Atributos = atributo.split("#");
        Jogo jogo = new Jogo();
        jogo.setAno(Integer.parseInt(Atributos[0]));
        jogo.setEtapa(Atributos[1]);
        jogo.setDia(Integer.parseInt(Atributos[2]));
        jogo.setMes(Integer.parseInt(Atributos[3]));
        jogo.setSelecao1(Atributos[4]);
        jogo.setPlacarSelecao1(Integer.parseInt(Atributos[5]));
        jogo.setPlacarSelecao1(Integer.parseInt(Atributos[6]));
        jogo.setSelecao2(Atributos[7]);
        jogo.setLocal(Atributos[8]);
        return jogo;
    }

    public static Jogo procuraJogo(Vector<Jogo> jogos, String atributo) {
        String[] atributos = atributo.split(";");
        String[] data = atributos[0].split("/");
        int dia = Integer.parseInt(data[0]);
        int mes = Integer.parseInt(data[1]);
        int ano = Integer.parseInt(data[2]);
        for (int i = 0; i < jogos.size(); i++) {
            Jogo jogoAux = jogos.elementAt(i);
            if (jogoAux.getSelecao1().equals(atributos[1]) &&
            jogoAux.getDia() == dia && jogoAux.getMes() == mes && jogoAux.getAno() == ano) {
                return jogoAux;
            }
        }
        return null;
    }
}
