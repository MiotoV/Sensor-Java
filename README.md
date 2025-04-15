```markdown
# 🌡️ Sistema de Monitoramento Serial com Java & SQLite

Este projeto é uma aplicação Java desenvolvida para ler dados ambientais (umidade, temperatura e precipitação) a partir de sensores conectados via porta serial. Os dados são armazenados em um banco de dados SQLite e exibidos automaticamente em uma interface gráfica com `JDialog`.

---

## 📦 Dependências

Antes de executar o projeto, certifique-se de que você tem os seguintes requisitos instalados:

### ✅ Tecnologias e bibliotecas utilizadas:

- **Java SE 8+**
- **[jSerialComm](https://fazecast.github.io/jSerialComm/)** (comunicação serial)
- **SQLite JDBC Driver** (`sqlite-jdbc-<versão>.jar`)
- **Swing** (interface gráfica - já incluso no JDK)

---

## 🔌 Configuração do Ambiente

1. **Adicione os JARs ao classpath:**
   - `jSerialComm.jar`
   - `sqlite-jdbc.jar`

2. **Configure a porta serial** no código:
   ```java
   SerialPort comPort = SerialPort.getCommPort("COM6"); // ou /dev/ttyUSB0 no Linux
   ```

3. **Banco de dados SQLite:**
   - O banco `leituras.db` será criado automaticamente na primeira execução (caso não exista).
   - A tabela `leituras` deve conter:
     ```sql
     CREATE TABLE IF NOT EXISTS leituras (
         id INTEGER PRIMARY KEY AUTOINCREMENT,
         umidade TEXT,
         temperatura TEXT,
         precipitacao TEXT,
         data_hora DATETIME DEFAULT CURRENT_TIMESTAMP
     );
     ```
