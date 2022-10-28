package Estatico;

public class Fila {
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
            media+=jogos[posicao].getPlacarSelecao1() + jogos[posicao].getPlacarSelecao2();
            posicao = avanca(posicao);
            posicaoFila++;
            if (this.estaCheia() && posicao == tras)
                break;
        }
        return media / posicaoFila;
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
