**Conta Digital API**
========================================================================
O desafio consiste na criação de uma API de conta digital, no qual deverá ser oferecido os
principais serviços encontrados nesse tipo de conta.

**Alguns dos recursos utilizados*

- Git
- Lombok 
- Criando um projeto Spring 
- Maven 
- Spring Boot 
- Api (Rest)
- Swagger 
- JPA (Hibernate) 
- Spring Data 
- MySQL


**COMO CONSTRUIR O AMBIENTE**
========================================================================

Baixar e instalar o Lombok na sua IDE em https://projectlombok.org/download.
Acessar o diretório onde o lombok.jar foi baixado e executar no terminal: java -jar lombok.jar.
Na janela de instalação, especificar o caminho onde se encontra sua IDE e concluir a instalação.

Caso não consiga instalar através da interface, copiar o lombok.jar para o diretório do eclipse e editar o arquivo eclipse.ini e incluir a linha abaixo no final do arquivo:

-javaagent:/DIRETÓRIO_QUE_VOCE_COPIOU_O_LOMBOK.JAR/lombok.jar

**Back-End**

	Primeiramente deve-se clonar o repositório no endereço:
	
	https://github.com/kenneth-de-oliveira/ContaDigital-Rest-API.git
	
	Após o projeto ser clonado, abra o terminal no diretório clonado **ContaDigital-Rest-API**
	e utilize os seguintes comandos:

	
	mvn install
	../ContaDigital-Rest-API/target
	java -jar ContaDigital-Rest-API.war
	
	
**É de suma importância aguardar a execução dos comandos acima citados.**

========================================================================


Para acesso à sua API desenvolvida, utilize o endereço: http://localhost:8080/swagger-ui.html




Configuração do Java e Maven utilizados :
========================================================================
- Java 11
- Maven 3.6.3

Banco de dados
========================================================================

Como acessar o client do MySQL:

    https://www.db4free.net/phpMyAdmin/
	
	JDBC URL: jdbc:mysql://db4free.net:3306/contadigital
    Usuário: contadigital
	Senha: contadigital
