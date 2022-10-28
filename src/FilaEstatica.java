import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class FilaEstatica {
    public static class Jogo {

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

    public static class Fila {
        private Jogo jogos[];
        private int frente = 0, tras = 0;

        public Fila(int tamanho) {
            jogos = new Jogo[tamanho];
        }

        public Fila() {
            this(100);
        }

        public void enfileirar(Jogo jogo) {
            if (this.estaCheia())
                return;
            jogos[tras] = jogo;
            tras = avanca(tras);
        }

        public Jogo desenfileirar() {
            int frenteAUX = frente;
            frente = avanca(frente);
            return jogos[frenteAUX];
        }

        public void mostrar() {
            int posicao = frente;
            int posicaoFila = 0;
            while (true) {
                if (posicao == tras && !this.estaCheia())
                    break;
                System.out.printf("[%d]", posicaoFila);
                jogos[posicao].imprimir();
                posicao = avanca(posicao);
                posicaoFila++;
                if (this.estaCheia() && posicao == tras)
                    break;
            }
        }

        public double mediaGols() {
            int posicao = frente;
            int posicaoFila = 1;
            double media = 0;
            while (true) {
                if (posicao == tras && !this.estaCheia())
                    break;
                media+=(jogos[posicao].getPlacarSelecao1() + jogos[posicao].getPlacarSelecao2()) / 2.0;
                posicao = avanca(posicao);
                posicaoFila++;
                if (this.estaCheia() && posicao == tras)
                    break;
            }
            media/=posicaoFila;
            return Math.round(media);
        }

        public boolean estaCheia(){
            if (avanca(tras) == frente)
                return true;
            return false;
        }

        private static int avanca(int variavel) {
            return (variavel + 1) % 100;
        }
    }

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
                System.out.printf("(D)");
                fila.desenfileirar().imprimir();
            }
            else {
                String atributos = input.nextLine();
                if (fila.estaCheia()) {
                    System.out.printf("(D)");
                    fila.desenfileirar().imprimir();
                }
                fila.enfileirar(procuraJogo(jogos, atributos));
                System.out.println(fila.mediaGols());
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
        int dia = Integer.parseInt(data[0].trim());
        int mes = Integer.parseInt(data[1].trim());
        int ano = Integer.parseInt(data[2].trim());
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
