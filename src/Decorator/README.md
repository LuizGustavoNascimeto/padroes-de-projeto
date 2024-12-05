# Padrão de Projeto: Decorator

## O Conceito do Padrão
O **Decorator** é um padrão de projeto estrutural que permite adicionar comportamentos a objetos de forma dinâmica, sem alterar suas classes originais. Ele utiliza uma abordagem baseada em composição, onde objetos são "envolvidos" (wrapped) por outros objetos que adicionam funcionalidades adicionais.

---

## Problema que ele Resolve
Imagine que você tem uma classe básica que realiza notificações por e-mail. Se precisar adicionar notificações por SMS, Slack ou outros canais, criar subclasses específicas para todas as combinações possíveis se tornaria inviável. O Decorator resolve isso permitindo que novos comportamentos sejam adicionados dinamicamente, evitando a explosão de subclasses e tornando o código mais flexível.

---

## Quando Usar o Padrão
- Quando você precisa adicionar ou modificar o comportamento de objetos em tempo de execução.
- Quando herança não é viável ou desejável, por exemplo, em classes marcadas como `final`.
- Quando diferentes combinações de comportamentos precisam ser aplicadas a um objeto de forma modular.

---

## Diagrama UML do Decorator

```
classDiagram
    direction LR
    class Component {
        +operation()
    }
    class ConcreteComponent {
        +operation()
    }
    class Decorator {
        -component : Component
        +operation()
    }
    class ConcreteDecoratorA {
        +operation()
    }
    class ConcreteDecoratorB {
        +operation()
    }
    Component <|-- ConcreteComponent
    Component <|-- Decorator
    Decorator <|-- ConcreteDecoratorA
    Decorator <|-- ConcreteDecoratorB
    Decorator --> Component

Exemplo de Código-Fonte: exemplo.java

## Vantagens
- Extensibilidade Dinâmica: Permite adicionar comportamentos sem alterar o código existente.
- Reutilização: Combinando diferentes decoradores, você pode criar comportamentos personalizados sem duplicação de código.
- Princípio de Responsabilidade Única: Divide funcionalidades em classes menores e independentes.

## Desvantagens
- Complexidade Adicional: Pode aumentar a complexidade do código, especialmente com muitas camadas de decoradores.
- Dependência da Ordem: O comportamento final pode depender da ordem em que os decoradores são aplicados.
- Debugging Difícil: Pode ser complicado rastrear problemas devido ao encadeamento de decoradores.

O padrão Decorator é uma ferramenta poderosa quando aplicado corretamente. Ele resolve problemas de extensão de funcionalidades de maneira modular e elegante, mas é importante usá-lo com parcimônia para evitar um código excessivamente complexo.
