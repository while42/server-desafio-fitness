# server-treino-fitness

# Etapas para configurar o ambiente:

* Executar o comando no terminal: mvn spring-boot:run
* Dentro do Eclipse: Clique inverso no projeto -> Maven -> Update Project
* Fazer download do seguinte arquivo: https://projectlombok.org/downloads/lombok.jar
* Executar o seguinte comando no terminal: java -jar lombok.jar
* Pod ser necessario colocar no diretorio onde esta instalado o Eclipse
* Reiniciar o Eclipse (sem usar atalhos criados)
* Dentro do Eclipse: Menu -> Project -> Clean -> Clean all project -> Ok
* Dentro do Eclipse: Na aba "Problems" do Selecione os erros e apague
* Reiniciar o Eclipse (sem usar atalhos criados)


# Para iniciar a aplicacao:
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

	

