public class Main {
        interface Forma {
            void desenhar();
        }

        // Produto Concreto 1: Círculo
        static class Circulo implements Forma {
            @Override
            public void desenhar() {
                System.out.println("Desenhando um círculo.");
            }
        }

        // Produto Concreto 2: Retângulo
        static class Retangulo implements Forma {
            @Override
            public void desenhar() {
                System.out.println("Desenhando um retângulo.");
            }
        }

        public static void main(String[] args) {
            // Código principal será adicionado nos próximos commits.
        }
    }
