/**
 * O subsistema pode aceitar solicitações diretamente da fachada ou do cliente.
 * Em qualquer caso, para o subsistema, a fachada é apenas mais um cliente e
 * não faz parte do subsistema.
 */
class Subsystem1 {
 public:
  std::string Operation1() const {
    return "Subsystem1: Pronto!\n";
  }
  // ...
  std::string OperationN() const {
    return "Subsystem1: Vai!\n";
  }
};

/**
 * Algumas fachadas podem trabalhar com múltiplos subsistemas ao mesmo tempo.
 */
class Subsystem2 {
 public:
  std::string Operation1() const {
    return "Subsystem2: Preparar!\n";
  }
  // ...
  std::string OperationZ() const {
    return "Subsystem2: Fogo!\n";
  }
};

/**
 * A classe Facade fornece uma interface simples para a lógica complexa de um 
 * ou vários subsistemas. A Facade delega as solicitações dos clientes aos 
 * objetos apropriados dentro do subsistema.
 */
class Facade {
 protected:
  Subsystem1 *subsystem1_;
  Subsystem2 *subsystem2_;

  /**
   * Dependendo das necessidades da sua aplicação, você pode fornecer à Facade 
   * objetos de subsistemas já existentes ou deixá-la criar esses objetos por conta própria.
   */
 public:
  Facade(
      Subsystem1 *subsystem1 = nullptr,
      Subsystem2 *subsystem2 = nullptr) {
    this->subsystem1_ = subsystem1 ?: new Subsystem1;
    this->subsystem2_ = subsystem2 ?: new Subsystem2;
  }
  ~Facade() {
    delete subsystem1_;
    delete subsystem2_;
  }

  /**
   * Os métodos da Facade são atalhos convenientes para a funcionalidade 
   * sofisticada dos subsistemas.
   */
  std::string Operation() {
    std::string result = "Facade inicializa subsistemas:\n";
    result += this->subsystem1_->Operation1();
    result += this->subsystem2_->Operation1();
    result += "Facade ordena os subsistemas a executarem a ação:\n";
    result += this->subsystem1_->OperationN();
    result += this->subsystem2_->OperationZ();
    return result;
  }
};

/**
 * O código do cliente trabalha com subsistemas complexos através de uma interface 
 * simples fornecida pela Facade.
 */
void ClientCode(Facade *facade) {
  // ...
  std::cout << facade->Operation();
  // ...
}

int main() {
  Subsystem1 *subsystem1 = new Subsystem1;
  Subsystem2 *subsystem2 = new Subsystem2;
  Facade *facade = new Facade(subsystem1, subsystem2);
  ClientCode(facade);

  delete facade;

  return 0;
}
