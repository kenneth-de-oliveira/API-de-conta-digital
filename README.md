**API de conta digital**
========================================================================
O desafio consiste na criação de uma API de conta digital, no qual deverá ser oferecido os principais serviços, tais como: cadastro de uma conta, login na conta e menu da conta.

**Alguns dos recursos utilizados**

- Git
- Lombok
- Spring Security  
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

**Instruções**

	Primeiramente deve-se clonar o repositório no endereço:
	
	https://github.com/kenneth-de-oliveira/API-de-conta-digital.git
	
	Após o projeto ser clonado, abra o terminal no diretório clonado **API-de-conta-digital**
	e utilize os seguintes comandos:

	cd API-de-conta-digital
	mvn install
	
	
**É de suma importância aguardar a execução dos comandos acima citados.**

========================================================================

Configuração do projeto
========================================================================

**Como acessar a aplicação:**

URL: http://localhost:8080/swagger-ui.html
	
JDBC URL: jdbc:mysql://db4free.net:3306/contadigital
Usuário: contadigital
Senha: contadigital
	
**Credenciais do spring security:**

Usuário: admin

Senha: admin


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

**EXEMPLOS DE EXECUÇÃO**

Criando um novo cliente **POST**: localhost:8080/rest/cliente/create
```json
{
    "id": null,
    "nome": "Fernanda Isabel Eloá Carvalho",
    "cpf": "35515388593",
    "email": "iffernandaisabeleloacarvalho@gmail.com",
    "endereco": "Rua Rita Ludolf",
    "numeroCelular": "(21)99738-1197",
    "ativo": true,
    "observacoes": "Tipo Sanguineo B-"
}
```

Criando uma nova conta **POST**: localhost:8080/rest/conta/create
```json
{
   "id": null,
   "agencia": "128",
   "numero": "128128",
   "saldo": 600,
   "senha": "isadora",
   "cliente": {
   	"id": "NUMERO DE ID DO CLIENTE"
   	"nome": "Fernanda Isabel Eloá Carvalho",
    	"cpf": "35515388593",
    	"email": "iffernandaisabeleloacarvalho@gmail.com",
    	"endereco": "Rua Rita Ludolf",
    	"numeroCelular": "(21)99738-1197",
    	"ativo": true,
    	"observacoes": "Tipo Sanguineo B-"
   }
}
```

Realizando uma recarga **POST**: localhost:8080/rest/conta/recarga
```json
{
   "agencia": "127",
   "numero": "127127",
   "numeroCelular": "(95)98711-1656",
   "valor" : 10
}
```

Realizando uma transferência **POST**: localhost:8080/rest/conta/transferencia
```json
{
    "agenciaOrigem": "127",
    "numeroContaOrigem" : "127127",
    "agenciaDestino": "123",
    "numeroContaDestino" : "123123",
    "valor" : 15
}
```

Consultando extrato bancário de todos os clientes **GET**: localhost:8080/rest/conta/extrato
```json
{
   "id": 9,
   "tipoDaTransacao": "RECARGA",
   "valorDescontado": -10.0,
   "dataEhoraDaTransacao": "terça-feira, 16 de fevereiro de 2021 às 18:57:05 Hora padrão de Brasília",
   "numeroDeOrigemDaRecarga": "(51)99893-8696",
   "conta": {
      "id": 1,
      "agencia": "121",
      "numero": "121121",
      "saldo": 40.0,
      "senha": "",
      "cliente": {
      	"id": 1,
      	"nome": "Sabrina Emanuelly Nina Cardoso",
      	"cpf": "25073902807",
      	"email": "sabrinaemanuellyninacardoso@balaiofilmes.com",
      	"numeroCelular": "(51)99893-8696",
      	"endereco": "Rua Joaquim Araújo Filho",
	"ativo": true,
	"observacoes": "Tipo Sanguineo AB+"
       }
     }
 }
```
