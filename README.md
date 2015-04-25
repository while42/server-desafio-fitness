# server-treino-fitness
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

	

