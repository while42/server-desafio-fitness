# server-treino-fitness

Para que o projeto funcione no Eclipse executar alguns passos:
1.) Fazer download do seguinte arquivo: https://projectlombok.org/downloads/lombok.jar
2.) Executar o seguinte comando no terminal: java -jar lombok.jar
    - O programa ira perguntar o diretorio onde esta instalado o Eclipse

Para iniciar a aplicacao:
$ mvn spring-boot:run


# [Exemplo] Adicionar uma nova academia

POST
 localhost:8080/api/academia/

HEADER
	Content-Type application/json
	
BODY
	{"nome": "Academia Fogo de Palha"}
	
	

# [Exemplo] Editar uma nova academia

POST
 localhost:8080/api/academia/

HEADER
	Content-Type application/json
	
BODY
	{"id" : 2, "nome": "Academia Fogo de Palha"}
	
# [Exemplo] Deletar uma academia

DELETE
 localhost:8080/api/academia/1

	

