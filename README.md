# microservices

Este repositório contém o código fonte de 3 microserviços que acessam as bases de dados A, B e C, além de um serviço de borda que recebe as requisições de usuários e um servidor de descoberta responsável pela interligação entre os serviços. Também são fornecidos scripts de configuração para o deploy da aplicação em containers Docker em um cluster Fargate no serviço AWS ECS.

## Dependências

* [jq](https://github.com/stedolan/jq), ferramenta de JSON para shell
* [aws-cli](https://docs.aws.amazon.com/cli/latest/userguide/install-cliv2.html)
* [ecs-cli](https://docs.aws.amazon.com/AmazonECS/latest/developerguide/ECS_CLI_installation.html)
* [mvn](https://maven.apache.org/download.cgi) (opcional, caso se deseje recriar os executáveis)

## Antes do deploy

Para que a estrutura ECS seja criada na AWS, é necessário possuir as credenciais de um usuário root ou com permissões para criar, ler e modificar recursos EC2 e ECS. As credenciais são configuradas no arquivo *aws-credentias-config*. Basta modificar os campos indicados.

Os microserviços que acessam bancos de dados assumem a presença um banco de dados MySQL no host dos containers. Se um teste mais profundo for necessário, pode-se alterar o arquivo *application.properties* nos projetos SistemaA,SistemaB e SistemaC para refletir a nova string de conexão.
**Se esta ou qualquer outra modificação for efetuada, os executáveis *.jar* e as imagens Docker precisam ser recriados através dos comandos:**
```
cd SistemaA/
mvn package
docker build .
cd ../SistemaB/
mvn package
docker build .
cd  ../SistemaC/
mvn package
docker build .
```

As novas imagens Docker deverão ser publicadas em um repositório público; para instruções de como fazê-lo, ver [este link](https://docs.docker.com/engine/reference/commandline/push/). A seguir, a imagem no repositório público deve ser referenciada no arquivo *docker-compose.yml* nos campos marcados com o nome *image*.


## Executando os scripts

O usuário deverá rodar o script *run.sh*, que executa todos os demais. Para executá-lo, basta utilizar os comandos:
```
chmod +x run.sh
./run.sh
```

Os scripts de configuração serão utilizados e os resultados serão impressos no terminal.


## Descrição da solução

A arquitetura de microserviços foi utilizada por ser adequada aos parâmetros do projeto: independência de serviços, separação dos dados e facilidade de escalonamento e manutenção. Com esta arquitetura, cada um dos serviços pode ser escalonado individualmente, sem necessidade de interferir nos demais serviços, o que incorre em uma otimização dos custos dos serviços de nuvem.

Em cada um dos serviços foi utilizado o framework **Spring Boot**, largamente utilizado por desenvolvedores web, em conjunto com o **Hibernate** para a camada de persistência. Cada serviço possui uma simples API definida em um Controller, que deve retornar um JSON. Enquanto o Controller é responsável pelo tratamento da requisição, um Service é utilizado para a implementação das regras de negócio e para ativar a camada de persistência, representado pelas interfaces Repository. Por fim, no pacote Model estão definidas as entidades que formam o banco de dados, descritas por atributos sugeridos pelo desenvolvedor.

Os microserviços são independentes entre si e do serviço de borda. Para que possa haver comunicação, os 3 microserviços e o serviço de borda se registram em um servidor de descoberta de serviços (Eureka). Após fazê-lo, o serviço de borda pode consultar o Eureka para encontrar o endereço dos microserviços que necessitar.

O serviço de borda ainda é responsável pela autorização e autenticação de usuários, através das regras definidas no Controller e em SecurityConfig. Os microserviços confiam no serviço de borda para a implementação de segurança, e assim não possuem filtros de autenticação. Porém, na configuração dos containers, algumas regras são definidas para permitir o acesso aos microserviços somente de dentro do cluster.

--- 

Para realizar o deploy para a nuvem, optou-se por utilizar containers Docker, uma solução intuitiva para a arquitetura de microserviços, já que é mais eficiente do que contratar instâncias completas para realizar tarefas tão simples. Além disso, a utilização de containers simplifica a implementação da segurança na nuvem, visto que é preciso definir apenas uma porta de entrada para a rede externa enquanto os containers conversam livremente entre si.

A tecnologia utilizada foi o Elastic Container Service (ECS), que oferece maior flexibilidade que o Elastic Beanstalk para esse modelo de arquitetura. Dentro do ECS, optou-se por utilizar o Fargate em detrimento de instâncias EC2, pois a estrutura serverless permite otimizar os custos enquanto fornece a mesma flexibilidade de escalonamento para lidar com picos de acesso.

Para criar essa estrutura, um arquivo Docker compose foi criado para descrever os serviços e definir as comunicações entre eles e a rede externa.