# API_WSM
Api desenvolvida para cuidar dos produtos referentes a mercado da aula de Web.

## Descrição

A Api foi construída em Java de maneira simples para ser utilizada em integração com a aula de web, contendo duas tabelas (Categoria e Produto) no banco de dados Oracle e contendo os principais verbos (GET, POST, PUT, DELETE).

## UML

![image](https://github.com/gustavocarvalho1997/API_WSM/assets/79180740/987fafd1-2f65-46d7-b9dc-42c4c0a8b0a5)

## Arquitetura

![image](https://github.com/gustavocarvalho1997/API_WSM/assets/79180740/7d366131-56cd-4537-a503-3d257a3d37af)

A Api foi dividida em camadas, de forma que as requisições HTTP são recebidas pelas Classes contidas no pacote Resource, então o Resource encaminha as devidas solicitações para a camada Service que irá aplicar as regras de negócio e as relações para logo em seguida encaminhar a solicitação para a camada Dao. Na camada Dao é feita a parte de interação com o banco de dados Oracle, onde irá ocorrer os SELECTS, INSERTS e afins.
Para as explicações das camadas e pacotes, será utilizado como exemplo a Categoria, uma vez que ela contêm menos atributos e sua codificação é um pouco mais simplificada em relação a Produto, facilitando a explicação.

## Models

Para que a camada Dao consiga realizar as interações com o banco de dados, ela utiliza os modelos dos objetos em questão, contendo os atributos que serão encontrados no banco de dados. Para simplificação do código dos modelos, foi utilizada a biblioteca Java chamada Lombok, tornando possível a criação dos getters, setters e toString por meio de Annotations.

![image](https://github.com/gustavocarvalho1997/API_WSM/assets/79180740/06f2f8d9-f66a-4739-87ba-55f080d54c13)

## Data Access Object (DAO)

Camada responsável pelo acesso dos dados no banco de dados Oracle, contendo variáveis privadas que armazenam os Statements utilizados nas funções. As funções que contêm no Dao são as de cadastrar, listar os itens do banco, procurar um item pelo id, atualizar e deletar. A seguir um exemplo tanto da variável quanto da função:

![image](https://github.com/gustavocarvalho1997/API_WSM/assets/79180740/2f4be3ad-63ee-4dd4-801d-1a732f27394b)

![image](https://github.com/gustavocarvalho1997/API_WSM/assets/79180740/e112b964-6b41-4a67-ba71-a2540b918ef2)

## Service

A camada Service fica responsável por aplicar as relações, regras de negócio e algumas verificações que irão assegurar a integridade do banco e de suas informações. Como exemplo será mostrada a função atualizar que verifica se as informações recebidas em JSON, veio alguma nula ou contrária a regras do banco e, caso necessário, lança a exceção. Também é nessa camada que se tem contato com a Factory responsável por obter a conexão com o banco.

![image](https://github.com/gustavocarvalho1997/API_WSM/assets/79180740/73d5c38c-ef59-4fe8-9eb6-d63bf8b566aa)

## Resource

É nessa camada que são recebidas as requisições HTTP e então, conforme as regras de funcionamento da api, são produzidas e consumidas as informações. Caso em algum momento seja lançado uma exceção, é aqui que é devolvida a respectiva resposta com seu devido código.

![image](https://github.com/gustavocarvalho1997/API_WSM/assets/79180740/ab5ac0fa-7da7-4de6-99d7-61aae4a5bde7)

## Exception

Em alguns momentos se tornou interessante a criação de uma Exception que representasse melhor o erro que ocorreu, para assim, retornar de forma mais assertiva o motivo da falha pra quem fez o request na api. Onde a BadInfoException foi utilizada, principalmente, quando um dado foi encaminhado de maneira incorreta ou nula e isso geraria um problema no banco. Já a IdNotFoundException foi utilizada para requisições que em algum momento seria necessária a busca de um item no banco pelo seu id, e o id informado não foi localizado no banco.

![image](https://github.com/gustavocarvalho1997/API_WSM/assets/79180740/1a00bcdb-43df-492f-8dcc-6b7de027bfcf)

## Factory

Foi criado esse pacote para conter a ConnectionFactory que fica responsável por coletar as credenciais do banco e criar a conexão para ser utilizada pela Api.

![image](https://github.com/gustavocarvalho1997/API_WSM/assets/79180740/bc2e5430-a81b-4e96-9f46-90301cd20ecf)

## Interface

A interface aqui funciona como um contrato para garantir que os Daos estão implementando os métodos conforme especificado nela, contendo os tipos de retorno, argumentos e lançamentos de exceções.

![image](https://github.com/gustavocarvalho1997/API_WSM/assets/79180740/f478cbea-713a-49c9-9fe2-4cf131823648)

## SQL

Na pasta SQL do repositório contem os scripts DDL e DML, onde serão criadas as tabelas utilizadas na api e populando-as caso seja desejado na hora de testar a api.

![image](https://github.com/gustavocarvalho1997/API_WSM/assets/79180740/202ae033-8276-4d4a-a242-81f5815121ba)

![image](https://github.com/gustavocarvalho1997/API_WSM/assets/79180740/e20813a3-7b72-49c5-924c-6310bbbdbc03)
