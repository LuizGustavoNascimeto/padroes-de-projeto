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

    static abstract class FormaFactory {
        public void criarEDesenharForma() {
            Forma forma = criarForma();
            forma.desenhar();
        }

        protected abstract Forma criarForma();
    }

    // Criador Concreto 1: Fábrica de Círculos
    static class CirculoFactory extends FormaFactory {
        @Override
        protected Forma criarForma() {
            return new Circulo();
        }
    }

    // Criador Concreto 2: Fábrica de Retângulos
    static class RetanguloFactory extends FormaFactory {
        @Override
        protected Forma criarForma() {
            return new Retangulo();
        }
    }

    public static void main(String[] args) {
        // Código principal será adicionado nos próximos commits.
    }
}
