# API_WSM
Api desenvolvida para cuidar dos produtos referentes a mercado da aula de Web.

## Descrição

A Api foi construída em Java de maneira simples para ser utilizada em integração com a aula de web, contendo duas tabelas (Categoria e Produto) no banco de dados Oracle e contendo os principais verbos (GET, POST, PUT, DELETE).

## UML

![image](https://github.com/gustavocarvalho1997/API_WSM/assets/79180740/88c9a66c-88eb-436f-9541-c65a5e15c5c8)

## Arquitetura

![image](https://github.com/gustavocarvalho1997/API_WSM/assets/79180740/17fa4ec6-26a5-47c5-ad1f-db2bfcfa2cd0)

A Api foi dividida em camadas, de forma que as requisições HTTP são recebidas pelas Classes contidas no pacote Resource, então o Resource encaminha as devidas solicitações para a camada Service que irá aplicar as regras de negócio e as relações para logo em seguida encaminhar a solicitação para a camada Dao. Na camada Dao é feita a parte de interação com o banco de dados Oracle, onde irá ocorrer os SELECTS, INSERTS e afins.
Para as explicações das camadas e pacotes, será utilizado como exemplo a Categoria, uma vez que ela contêm menos atributos e sua codificação é um pouco mais simplificada em relação a Produto, facilitando a explicação.

## Models

Para que a camada Dao consiga realizar as interações com o banco de dados, ela utiliza os modelos dos objetos em questão, contendo os atributos que serão encontrados no banco de dados. Para simplificação do código dos modelos, foi utilizada a biblioteca Java chamada Lombok, tornando possível a criação dos getters, setters e toString por meio de Annotations.

![image](https://github.com/gustavocarvalho1997/API_WSM/assets/79180740/6e51a3b5-ed16-4330-b4e6-899b5b495c66)

## Data Access Object (DAO)

Camada responsável pelo acesso dos dados no banco de dados Oracle, contendo variáveis privadas que armazenam os Statements utilizados nas funções. As funções que contêm no Dao são as de cadastrar, listar os itens do banco, procurar um item pelo id, atualizar e deletar. A seguir um exemplo tanto da variável quanto da função:

![image](https://github.com/gustavocarvalho1997/API_WSM/assets/79180740/f63ace42-0529-4fd3-9082-b743ba1349e6)

![image](https://github.com/gustavocarvalho1997/API_WSM/assets/79180740/881ef098-6b91-4113-8f45-dd994719d5d2)

## Service

A camada Service fica responsável por aplicar as relações, regras de negócio e algumas verificações que irão assegurar a integridade do banco e de suas informações. Como exemplo será mostrada a função atualizar que verifica se as informações recebidas em JSON, veio alguma nula ou contrária a regras do banco e, caso necessário, lança a exceção. Também é nessa camada que se tem contato com a Factory responsável por obter a conexão com o banco.

![image](https://github.com/gustavocarvalho1997/API_WSM/assets/79180740/db46ae20-8be0-42b2-be9a-677e00138e14)

## Resource

É nessa camada que são recebidas as requisições HTTP e então, conforme as regras de funcionamento da api, são produzidas e consumidas as informações. Caso em algum momento seja lançado uma exceção, é aqui que é devolvida a respectiva resposta com seu devido código.

![image](https://github.com/gustavocarvalho1997/API_WSM/assets/79180740/c4f05fa8-9846-4ac4-ae88-f370c150a1e9)

## Exception

Em alguns momentos se tornou interessante a criação de uma Exception que representasse melhor o erro que ocorreu, para assim, retornar de forma mais assertiva o motivo da falha pra quem fez o request na api. Onde a BadInfoException foi utilizada, principalmente, quando um dado foi encaminhado de maneira incorreta ou nula e isso geraria um problema no banco. Já a IdNotFoundException foi utilizada para requisições que em algum momento seria necessária a busca de um item no banco pelo seu id, e o id informado não foi localizado no banco.

![image](https://github.com/gustavocarvalho1997/API_WSM/assets/79180740/ea0aa09a-90ca-4224-89b0-1106c2960f2c)

## Factory

Foi criado esse pacote para conter a ConnectionFactory que fica responsável por coletar as credenciais do banco e criar a conexão para ser utilizada pela Api.

![image](https://github.com/gustavocarvalho1997/API_WSM/assets/79180740/82ae19a8-ffd1-40c5-a062-79f3f2c89f36)

## Interface

A interface aqui funciona como um contrato para garantir que os Daos estão implementando os métodos conforme especificado nela, contendo os tipos de retorno, argumentos e lançamentos de exceções.

![image](https://github.com/gustavocarvalho1997/API_WSM/assets/79180740/619d5025-6512-4fd7-85d8-c608b1beac48)

## SQL

Na pasta SQL do repositório contem os scripts DDL e DML, onde serão criadas as tabelas utilizadas na api e populando-as caso seja desejado na hora de testar a api.

![image](https://github.com/gustavocarvalho1997/API_WSM/assets/79180740/aa3e1ce1-2e55-4d0f-b0cb-44521a7fc73b)

![image](https://github.com/gustavocarvalho1997/API_WSM/assets/79180740/4e0cb5a5-2efa-49a7-89ed-5cc5d6e96b29)
