# PI-Calculadora-Java

Calculadora gráfica em Java com histórico de operações, desenvolvida para fins acadêmicos.

## Pré-requisitos

- **Java JDK 11 ou superior**
- **Gradle** (pode ser instalado facilmente no Windows com Chocolatey)

## Instalação do Gradle no Windows

### Usando Chocolatey (recomendado)

1. Abra o PowerShell como Administrador.
2. Instale o Chocolatey, se ainda não tiver:
   ```powershell
   Set-ExecutionPolicy Bypass -Scope Process -Force; [System.Net.ServicePointManager]::SecurityProtocol = [System.Net.ServicePointManager]::SecurityProtocol -bor 3072; iex ((New-Object System.Net.WebClient).DownloadString('https://community.chocolatey.org/install.ps1'))
   ```
3. Instale o Gradle:
   ```powershell
   choco install gradle -y
   ```

### Alternativa: Instalação manual

Baixe o Gradle em: https://gradle.org/releases/ e siga as instruções do site.

## Como compilar e executar o projeto

1. Abra o terminal na pasta do projeto (`PI-Calculadora-Java`).
2. Para compilar:
   ```powershell
   gradle build
   ```
3. Para executar a calculadora:
   ```powershell
   gradle run
   ```
   Ou, se preferir, execute o JAR diretamente:
   ```powershell
   java -jar build/libs/PI-Calculadora-Java.jar
   ```

## Como rodar os testes

1. Para executar todos os testes automatizados:
   ```powershell
   gradle test
   ```
2. Os relatórios de teste podem ser visualizados em:
   - `build/reports/tests/test/index.html`

## Estrutura do Projeto

- `src/main/java/` — Código-fonte principal
- `src/test/java/` — Testes automatizados (JUnit)
- `build.gradle` — Configuração do Gradle

## Observações
- Caso o comando `gradle` não seja reconhecido, reinicie o terminal ou adicione o Gradle ao PATH do Windows.
- O projeto utiliza apenas dependências padrão do Java e JUnit para testes.

---

Desenvolvido para fins acadêmicos na PUC.
