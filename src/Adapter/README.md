# Padrão de projeto `Adapter`

O padrão Adapter é um padrão de design estrutural que permite que objetos com interfaces incompatíveis trabalhem juntos. Ele atua como uma ponte entre duas interfaces incompatíveis, encapsulando uma classe existente com uma nova interface.

## Inteção Oficial

Converter a interface de uma classe em outra interface esperada pelos clientes. O adapter permite que certas classes trabalhem em conjunto, pois de outra forma seria impossível por causa de suas interfaces incompatíveis.

## Qual Problema ele soluciona

1. Incompatibilidade de interfaces: Permite que classes com interfaces diferentes trabalhem juntas sem precisar alterá-las.
2. Reutilização de código existente: Integra classes legadas ou bibliotecas externas ao sistema atual.
3. Flexibilidade na integração: Facilita a conexão de novos componentes ao sistema sem modificações significativas.

## Quando Usar

1. Você quer usar uma classe existente, mas sua interface não corresponde à que você precisa.
2. Você quer criar uma classe reutilizável que coopere com classes não relacionadas ou imprevistas, ou seja, classes que não necessariamente têm interfaces compatíveis.
3. Você precisa converter a interface de uma classe em outra interface que um cliente espera.
4. Você quer usar várias subclasses existentes, mas é impraticável adaptar suas interfaces por meio de subclassificação de cada uma. Um adaptador de objeto pode adaptar a interface de sua classe pai.

## Pros e Contras
### Pros

- Permite que dois ou mais objetos incompatíveis interajam.
- Aumenta a reutilização de classes existentes.
- Fornece uma maneira de usar código legado com interfaces modernas.

### Contras

- Pode tornar o código mais complexo devido à introdução de classes adicionais.
- Pode levar a uma sobrecarga de desempenho devido ao nível extra de indireção.

### UML

Na pasta `uml`, podem ser encontrados dois arquivos PNG:

- **`generic.png`**: apresenta uma demonstração genérica do funcionamento do padrão.  
- **`example.png`**: ilustra o mesmo exemplo implementado no código localizado em `example.cpp`.
