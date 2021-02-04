#language:pt
Funcionalidade: Fazer login como um usuario ainda não logado 
e deve Clicar no icone de login entao clicar no link de cadastrar nova conta e inserir os dados

@Login
  Cenario: Deve mostrar um modal de login ao clicar no icone e apos a inserção de dados efetuar o login
    Dado que estou na pagina inicial
    Quando nao estou logado clico no icone de login
    E insiro meu usuario
    E insito minha senha
    Entao clico no botao de SigIn


@Cadastro

 Cenario: Deve direcionar a uma pagina de cadastro de usuario assim que clicar em create new account
 	Dado que entrei pagina inicial
 	Quando nao estou lado clico no icone de login
 	Entao clico no link Create new Account 
 	Entao insiro usuario senha confirmo a senha e email
 	Entao insiro meu primeiro nome meu ultimo nome e meu numero de telefone
 	Entao seleciono meu pais insiro minha cidade estado e codigo postal
 	Entao clico no box de igree para aceitar os termos
 	E clico no botao de registrar