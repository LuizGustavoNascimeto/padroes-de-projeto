public class Main {

    interface Forma {
        void desenhar();
    }

    static class Circulo implements Forma {
        @Override
        public void desenhar() {
            System.out.println("Desenhando um círculo.");
        }
    }

    static class Retangulo implements Forma {
        @Override
        public void desenhar() {
            System.out.println("Desenhando um retângulo.");
        }
    }

    // Criador: Classe abstrata com o método de fábrica
    static abstract class FormaFactory {
        public void criarEDesenharForma() {
            Forma forma = criarForma();
            forma.desenhar();
        }

        protected abstract Forma criarForma();
    }

    public static void main(String[] args) {
        // Código principal será adicionado nos próximos commits.
    }
}
