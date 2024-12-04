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

    static class CirculoFactory extends FormaFactory {
        @Override
        protected Forma criarForma() {
            return new Circulo();
        }
    }

    static class RetanguloFactory extends FormaFactory {
        @Override
        protected Forma criarForma() {
            return new Retangulo();
        }
    }

    public static void main(String[] args) {
        // Criar e desenhar um círculo
        FormaFactory fabricaCirculo = new CirculoFactory();
        fabricaCirculo.criarEDesenharForma();

        // Criar e desenhar um retângulo
        FormaFactory fabricaRetangulo = new RetanguloFactory();
        fabricaRetangulo.criarEDesenharForma();
    }
}
