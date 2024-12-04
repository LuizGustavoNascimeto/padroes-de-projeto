// Interface comum para o componente e os decoradores
public interface Notificador {
    void enviar(String mensagem);
}

// Classe base concreta
public class NotificadorEmail implements Notificador {
    @Override
    public void enviar(String mensagem) {
        System.out.println("Enviando e-mail: " + mensagem);
    }
}

// Classe decorador base
public abstract class NotificadorDecorator implements Notificador {
    protected Notificador wrappee;

    public NotificadorDecorator(Notificador wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public void enviar(String mensagem) {
        wrappee.enviar(mensagem);
    }
}

// Decorador para notificações por SMS
public class NotificadorSMS extends NotificadorDecorator {
    public NotificadorSMS(Notificador wrappee) {
        super(wrappee);
    }

    @Override
    public void enviar(String mensagem) {
        super.enviar(mensagem);
        System.out.println("Enviando SMS: " + mensagem);
    }
}

// Decorador para notificações via Slack
public class NotificadorSlack extends NotificadorDecorator {
    public NotificadorSlack(Notificador wrappee) {
        super(wrappee);
    }

    @Override
    public void enviar(String mensagem) {
        super.enviar(mensagem);
        System.out.println("Enviando mensagem no Slack: " + mensagem);
    }
}

// Exemplo de uso
public class Main {
    public static void main(String[] args) {
        Notificador notificador = new NotificadorEmail();

        // Adiciona notificações via SMS
        notificador = new NotificadorSMS(notificador);

        // Adiciona notificações via Slack
        notificador = new NotificadorSlack(notificador);

        // Envia mensagem
        notificador.enviar("Sistema fora do ar!");
    }
}
