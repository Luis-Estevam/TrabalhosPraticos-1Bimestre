package Trabalhos.src.ProjetoArvores.Arvores;


    enum Cor {
        VERMELHO, PRETO
    }

    class NoRB {

        int valor;
        Cor cor;
        NoRB esquerda, direita, pai;

        NoRB(int valor) {
            this.valor = valor;
            cor = Cor.VERMELHO;
        }
    }

    public class ArvoreRubroNegra {

        private NoRB raiz;
        private NoRB NULO = new NoRB(0);

        public ArvoreRubroNegra() {
            NULO.cor = Cor.PRETO;
            raiz = NULO;
        }

        public void inserir(int chave) {

            NoRB no = new NoRB(chave);

            no.pai = null;
            no.esquerda = NULO;
            no.direita = NULO;

            NoRB y = null;
            NoRB x = raiz;

            while (x != NULO) {

                y = x;

                if (no.valor < x.valor)
                    x = x.esquerda;
                else
                    x = x.direita;
            }

            no.pai = y;

            if (y == null)
                raiz = no;

            else if (no.valor < y.valor)
                y.esquerda = no;

            else
                y.direita = no;

            if (no.pai == null) {
                no.cor = Cor.PRETO;
                return;
            }

            if (no.pai.pai == null)
                return;

            corrigirInsercao(no);
        }

        private void corrigirInsercao(NoRB k) {

            NoRB tio;

            while (k.pai.cor == Cor.VERMELHO) {

                if (k.pai == k.pai.pai.direita) {

                    tio = k.pai.pai.esquerda;

                    if (tio.cor == Cor.VERMELHO) {

                        tio.cor = Cor.PRETO;
                        k.pai.cor = Cor.PRETO;
                        k.pai.pai.cor = Cor.VERMELHO;
                        k = k.pai.pai;

                    } else {

                        if (k == k.pai.esquerda) {
                            k = k.pai;
                            rotacionarDireita(k);
                        }

                        k.pai.cor = Cor.PRETO;
                        k.pai.pai.cor = Cor.VERMELHO;
                        rotacionarEsquerda(k.pai.pai);
                    }

                } else {

                    tio = k.pai.pai.direita;

                    if (tio.cor == Cor.VERMELHO) {

                        tio.cor = Cor.PRETO;
                        k.pai.cor = Cor.PRETO;
                        k.pai.pai.cor = Cor.VERMELHO;
                        k = k.pai.pai;

                    } else {

                        if (k == k.pai.direita) {
                            k = k.pai;
                            rotacionarEsquerda(k);
                        }

                        k.pai.cor = Cor.PRETO;
                        k.pai.pai.cor = Cor.VERMELHO;
                        rotacionarDireita(k.pai.pai);
                    }
                }

                if (k == raiz)
                    break;
            }

            raiz.cor = Cor.PRETO;
        }

        public void remover(int chave) {
            removerNoAux(this.raiz, chave);
        }

        private void removerNoAux(NoRB no, int chave) {

            NoRB z = NULO;
            NoRB x, y;

            while (no != NULO) {

                if (no.valor == chave)
                    z = no;

                if (no.valor <= chave)
                    no = no.direita;
                else
                    no = no.esquerda;
            }

            if (z == NULO)
                return;

            y = z;
            Cor corOriginalY = y.cor;

            if (z.esquerda == NULO) {

                x = z.direita;
                transplantar(z, z.direita);

            } else if (z.direita == NULO) {

                x = z.esquerda;
                transplantar(z, z.esquerda);

            } else {

                y = minimo(z.direita);
                corOriginalY = y.cor;
                x = y.direita;

                if (y.pai == z) {
                    x.pai = y;
                } else {

                    transplantar(y, y.direita);
                    y.direita = z.direita;
                    y.direita.pai = y;
                }

                transplantar(z, y);

                y.esquerda = z.esquerda;
                y.esquerda.pai = y;
                y.cor = z.cor;
            }

            if (corOriginalY == Cor.PRETO)
                corrigirRemocao(x);
        }

        private void corrigirRemocao(NoRB x) {

            NoRB irmao;

            while (x != raiz && x.cor == Cor.PRETO) {

                if (x == x.pai.esquerda) {

                    irmao = x.pai.direita;

                    if (irmao.cor == Cor.VERMELHO) {

                        irmao.cor = Cor.PRETO;
                        x.pai.cor = Cor.VERMELHO;
                        rotacionarEsquerda(x.pai);
                        irmao = x.pai.direita;
                    }

                    if (irmao.esquerda.cor == Cor.PRETO &&
                            irmao.direita.cor == Cor.PRETO) {

                        irmao.cor = Cor.VERMELHO;
                        x = x.pai;

                    } else {

                        if (irmao.direita.cor == Cor.PRETO) {

                            irmao.esquerda.cor = Cor.PRETO;
                            irmao.cor = Cor.VERMELHO;
                            rotacionarDireita(irmao);
                            irmao = x.pai.direita;
                        }

                        irmao.cor = x.pai.cor;
                        x.pai.cor = Cor.PRETO;
                        irmao.direita.cor = Cor.PRETO;
                        rotacionarEsquerda(x.pai);
                        x = raiz;
                    }

                } else {

                    irmao = x.pai.esquerda;

                    if (irmao.cor == Cor.VERMELHO) {

                        irmao.cor = Cor.PRETO;
                        x.pai.cor = Cor.VERMELHO;
                        rotacionarDireita(x.pai);
                        irmao = x.pai.esquerda;
                    }

                    if (irmao.direita.cor == Cor.PRETO &&
                            irmao.esquerda.cor == Cor.PRETO) {

                        irmao.cor = Cor.VERMELHO;
                        x = x.pai;

                    } else {

                        if (irmao.esquerda.cor == Cor.PRETO) {

                            irmao.direita.cor = Cor.PRETO;
                            irmao.cor = Cor.VERMELHO;
                            rotacionarEsquerda(irmao);
                            irmao = x.pai.esquerda;
                        }

                        irmao.cor = x.pai.cor;
                        x.pai.cor = Cor.PRETO;
                        irmao.esquerda.cor = Cor.PRETO;
                        rotacionarDireita(x.pai);
                        x = raiz;
                    }
                }
            }

            x.cor = Cor.PRETO;
        }

        private void transplantar(NoRB u, NoRB v) {

            if (u.pai == null)
                raiz = v;

            else if (u == u.pai.esquerda)
                u.pai.esquerda = v;

            else
                u.pai.direita = v;

            v.pai = u.pai;
        }

        private NoRB minimo(NoRB no) {

            while (no.esquerda != NULO)
                no = no.esquerda;

            return no;
        }

        private void rotacionarEsquerda(NoRB x) {

            NoRB y = x.direita;

            x.direita = y.esquerda;

            if (y.esquerda != NULO)
                y.esquerda.pai = x;

            y.pai = x.pai;

            if (x.pai == null)
                raiz = y;

            else if (x == x.pai.esquerda)
                x.pai.esquerda = y;

            else
                x.pai.direita = y;

            y.esquerda = x;
            x.pai = y;
        }

        private void rotacionarDireita(NoRB y) {

            NoRB x = y.esquerda;

            y.esquerda = x.direita;

            if (x.direita != NULO)
                x.direita.pai = y;

            x.pai = y.pai;

            if (y.pai == null)
                raiz = x;

            else if (y == y.pai.direita)
                y.pai.direita = x;

            else
                y.pai.esquerda = x;

            x.direita = y;
            y.pai = x;
        }
    }

