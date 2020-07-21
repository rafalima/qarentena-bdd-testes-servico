# BDD para Testes de Serviço

Esse repositório se refere ao código criado durante a meetup do QArentena.

## Apresentação QArentena

* [Vídeo](https://www.youtube.com/watch?v=a-hmqwwgzug)
* [Slides](https://drive.google.com/file/d/1TpqfxzJZjT4W3046paAoWPO9PZRleqIQ/view?usp=sharing)

## Referêncicas

* [Artigo do Aslak, Criador do Cucumber](https://cucumber.io/blog/collaboration/the-worlds-most-misunderstood-collaboration-tool/)
* [Cucumber](https://cucumber.io/docs/installation/)
* [RestAssured](https://github.com/rest-assured/rest-assured/wiki/GettingStarted)

## Código

### Requisitos

* Java 8 ou superior
* Ter o gradle instalado
* [Docker Desktop](https://www.docker.com/products/docker-desktop)
* IDE (recomendo usar o [IntelliJ Community](https://www.jetbrains.com/idea/download))
* Lombok (siga [esse passo a passo](https://www.baeldung.com/lombok-ide) para poder usar no IntelliJ ou Eclipse)

### Rodando os testes

* Subir a aplicação - `docker run  --name petstore -d -p 12345:8080 swaggerapi/petstore3:unstable`
    * mais detalhes no repositório do [swagger-petstore](https://github.com/swagger-api/swagger-petstore)
    
* Criar o gradle wrapper (*necessário estar na raiz do projeto*)
    * `gradle wrapper`
    
* Rodar os testes (*necessário estar na raiz do projeto*)
     * Mac/Linux - `./gradlew tests`
     * Windows - `gradlew.bat tests`
     
* Relatório de execução - build/reports/feature.html

### Estrutura do Projeto

* src/test/resources
    * **features** - contém os arquivos .feature do cucumber com o Cenários

* src/test/java
    * **steps** 
        * contém classes java que mapeam e implementam os passos dos Cenários descritos nos arquivos .features
        * também contém classe Config.java para os [hooks](https://cucumber.io/docs/cucumber/api/#hooks) do cucumber
    * **suporte**
        * **api** - possui classes que mapeam as diversas apis do sistema (semelhante a um Page Object)
        * **dominio** - possui classes que mapeam o domínio da aplicação (quais campos um animal ou usuario possuem)
    * **Testes Cucumber** - [Executável Cucumber Junit](https://cucumber.io/docs/cucumber/api/#junit) que contém 
    configuração de relatórios e tags. 
    
