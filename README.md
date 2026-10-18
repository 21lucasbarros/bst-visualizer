# BST-Visualizer

Aplicação educacional em Java para visualizar e estudar o funcionamento de
Árvores Binárias de Busca (BST, do inglês *Binary Search Tree*).

O projeto processa operações de inserção, busca e remoção de nós e exibe a
estrutura da árvore em tempo real. A primeira versão utiliza uma interface de
linha de comando (CLI), com evolução planejada para uma interface gráfica
completa usando JavaFX.

## Funcionalidades

- Inserção de um ou vários valores inteiros.
- Busca de valores com exibição do caminho percorrido na árvore.
- Remoção de nós, incluindo os casos de folha, um filho e dois filhos.
- Visualização textual da árvore com conectores.
- Percursos:
  - In-Order;
  - Pre-Order;
  - Post-Order.
- Consulta da altura da árvore.
- Consulta do menor e do maior valor.
- Ignora valores duplicados durante a inserção.

## Tecnologias

- Java 26
- Maven
- Interface de linha de comando (CLI)

## Pré-requisitos

- JDK 26 ou superior configurado no `PATH`.
- Maven 3.8 ou superior.

Confira as instalações com:

```bash
java -version
mvn -version
```

## Como executar

Clone o repositório e acesse a pasta do projeto:

```bash
git clone https://github.com/21lucasbarros/bst-visualizer.git
cd bst-visualizer
```

Compile o projeto:

```bash
mvn clean package
```

Execute a aplicação:

```bash
java -cp target/classes com.lucasbarros.Main
```

Também é possível compilar sem limpar os artefatos anteriores:

```bash
mvn compile
```

## Uso

Ao iniciar a aplicação, um menu interativo será exibido:

```text
1 - Inserir (um ou vários: 13 23 32)
2 - Buscar (passo a passo)
3 - Remover
4 - In-Order
5 - Pre-Order
6 - Post-Order
7 - Altura
8 - Menor / Maior
9 - Mostrar árvore
0 - Sair
```

Para inserir vários valores, informe-os separados por espaços. Por exemplo:

```text
Valores: 50 30 70 20 40 60 80
```

O projeto exibirá uma representação textual semelhante a:

```text
       50
     ┌──┴──┐
    30    70
   ┌┴┐   ┌┴┐
  20 40 60 80
```

## Estrutura do projeto

```text
src/
└── main/
    └── java/
        └── com/lucasbarros/
            ├── Main.java
            ├── model/
            │   ├── BinarySearchTree.java
            │   └── Node.java
            └── view/
                ├── Block.java
                └── TreePrinter.java
```

- `Main`: controla o menu e a interação com o usuário.
- `BinarySearchTree`: implementa as operações e os percursos da BST.
- `Node`: representa um nó da árvore e suas referências para os filhos.
- `TreePrinter`: gera a visualização textual da árvore.
- `Block`: estrutura auxiliar utilizada na composição da visualização.

## Complexidade

Para uma árvore com altura `h`:

| Operação | Complexidade |
| --- | --- |
| Inserção | `O(h)` |
| Busca | `O(h)` |
| Remoção | `O(h)` |
| Percursos | `O(n)` |
| Altura | `O(n)` |

Em uma árvore balanceada, `h` é aproximadamente `log(n)`. No pior caso,
quando a árvore se comporta como uma lista, `h` é `n`.

## Próximos passos

- Criar uma interface gráfica com JavaFX.
- Animar inserções, buscas e remoções.
- Destacar visualmente o caminho percorrido durante uma busca.
- Adicionar opções para gerar árvores de exemplo e comparar diferentes
  formatos de árvore.
- Criar testes automatizados para as operações da BST.

## Licença

Este projeto ainda não possui uma licença definida.