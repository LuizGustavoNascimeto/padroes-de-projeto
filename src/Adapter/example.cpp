/*
Cenário de exemplo:
Imagine que você tem um sistema antigo que trabalha com XML mas precisa por os
dados em um novo sistema que trabalha com JSON. Para isso, você pode criar um
adaptador que converte os dados de JSON para XML.
*/

#include <iostream>
#include <string>

// Sistema antigo que trabalha com XML
class XMLReader {
public:
  std::string readXML(const std::string &filepath) {
    // Apenas simula a leitura do XML
    return "XML Analisado: " + filepath;
  }
};

// Interface esperada pelo sistema moderno (JSON), isso pode ser transformado em
// um cabeçalho separado, mas por simplicidade, está tudo aqui.
class JSONData {
public:
  virtual std::string parseJSON(const std::string filepath) = 0;
  virtual ~JSONData() = default;
};

// Adapter que converte XML para JSON
class XMLToJSONAdapter : public JSONData {
private:
  XMLReader *oldParser; // Composição
public:
  XMLToJSONAdapter(XMLReader *parser) : oldParser(parser) {}

  // Implementa a interface JSON redirecionando a chamada para o XML
  std::string parseJSON(const std::string filepath) override {
    // Pega os dados em XML
    std::string xmlData = oldParser->readXML(xmlData);
    // Converte os dados de XML para JSON
    std::string jsonData = convertXMLToJSON(xmlData);
    return jsonData;
  }
  std::string convertXMLToJSON(const std::string &xmlData) {
    // Apenas simula a conversão de XML para JSON
    return "JSON Gerado: " + xmlData;
  }
};

// Sistema moderno que trabalha com JSON
class JSONClient {
private:
  JSONData *parser; // Uso da interface moderna
public:
  JSONClient(JSONData *parser) : parser(parser) {}

  void processJSON(const std::string &jsonData) {
    std::string result = parser->parseJSON(jsonData);
    std::cout << result << "\n";
  }
};

// Exemplo de uso
int main() {
  // Instância do sistema antigo
  XMLReader oldParser;

  // Adapter conectando o sistema antigo à nova interface
  XMLToJSONAdapter adapter(&oldParser);

  // Cliente moderno usa a interface JSON
  JSONClient client(&adapter);

  // Cliente processa JSON (internamente convertido para XML)
  client.processJSON("{\"name\": \"Alice\", \"age\": 25}");

  return 0;
}
