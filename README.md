# App de Calculadora - Java
- Última atualização: `19-06-2025`

## Sobre
Este é um aplicativo simples desenvolvido em JAVA para fins de estudo. Ele simula o funcionamento de uma calculadora com operações padrão, histórico, e testes automatizados.


## Como Executar
1. Clone o repositório.
2. Execute o seguinte comando no console para realizar a `build` do projeto.
```console
javac -d build/classes/java/main -cp src src/domain/.java src/history/.java src/ui/*.java
```
3. Execute o seguinte comando no console para realizar a `execução` do projeto.
```console
java -cp build/classes/java/main ui.CalculatorUI
```
4. Execute o seguinte comando no console para realizar os `testes automatizados` do projeto.
```console
java -jar src/lib/junit-platform-console-standalone-1.10.2.jar execute --class-path "build/classes/java/main;build/classes/java/test" --scan-class-path
```

## Estrutura do Projeto
- `/src`
  - `/domain`: Classes das funcionalidades da calculadora;
  - `/history`: Módulo de histórico;
  - `/test`: Classes dos testes automatizados por funcionalidade usand JUnit;p
  - `/ui`: Implementação da interface da calculadora;

## Tecnologias Utilizadas
- Java
- JUnit 5

## Autor
Ernandes Yosimura, Guilherme Ganim, José Augusto Moura 
