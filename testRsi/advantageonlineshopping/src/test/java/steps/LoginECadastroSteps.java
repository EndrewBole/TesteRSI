package steps;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pages.CreateAccountPage;
import pages.HomePage;

public class LoginECadastroSteps {
	private static WebDriver driver;
	private HomePage homePage = new HomePage(driver);
	private CreateAccountPage createAccountPage = new CreateAccountPage(driver);
	
	
	@Before
	public static void inicializar() {
		System.setProperty("webdriver.chrome.driver", "Chromedriver\\88\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Dado("que estou na pagina inicial")
	public void que_estou_na_pagina_inicial() {
		homePage.carregarPaginaInicial();
	}

	
	@Quando("nao estou logado clico no icone de login")
	public void nao_estou_logado_clico_no_icone_de_login() {
		homePage.clicarInoneLogin();
	}

	@Quando("nao estou logado e clico no icone de login")
	public void nao_estou_logado() {
		homePage.clicarInoneLogin();
	}
	
	@Entao("insiro meu usuario")
	public void insiro_meu_usuario() {
		homePage.selecionaCampoUsuarioEInsereUsuario("endrew");
	}
	
	@Quando("insito minha senha")
	public void insito_minha_senha() {
		homePage.selecionaCampoPasswordEInserePassword("Testando123");
	}

	@Entao("clico no botao de SigIn")
	public void clico_no_botao_de_sig_in() {
	    homePage.clicarBotaoLogin();
	}
	
	
	@After()
	public static void finalizar() {
		driver.quit();
	}
	
	@Dado("que entrei pagina inicial")
	public void que_entrei_pagina_inicial() {
		homePage.carregarPaginaInicial2();
	}
	@Quando("nao estou lado clico no icone de login")
	public void nao_estou_lado_clico_no_icone_de_login() {
	    homePage.clicarInoneLogin();
	}

	@Entao("clico no link Create new Account")
	public void clico_no_link_create_new_account() {
	    homePage.identificarModalEClicarCriarNovaConta();
	}

	@Dado("que estou na pagina de cadastro")
	public void que_estou_na_pagina_de_cadastro() {
	   
	}

	@Entao("insiro usuario senha confirmo a senha e email")
	public void insiro_usuario_senha_confirmo_a_senha_e_email() {
	    createAccountPage.clicarCampoUsuarioEInserirUserName("testador000");
	    createAccountPage.clicarCampoEmailEInserirEmail("testandotestardor5@teste.com");
	    createAccountPage.clicarNoCampoPasswordEInserirPassword("Testando123");
	    createAccountPage.clicarNoCampoConfirmPasswordEInserirPassword("Testando123");
	    
	    
	}

	@Entao("insiro meu primeiro nome meu ultimo nome e meu numero de telefone")
	public void insiro_meu_primeiro_nome_meu_ultimo_nome_e_meu_numero_de_telefone() {
		createAccountPage.clicarNoCampoFirstNameEInserirFirstName("Endrew");
		createAccountPage.clicarNoCampoLastNameEInserirLastName("Bole");
		createAccountPage.clicarNoCampoPhoneNumberEInserirPhoneNumber("11999999999");
	}

	@Entao("seleciono meu pais insiro minha cidade estado e codigo postal")
	public void seleciono_meu_pais_insiro_minha_cidade_estado_e_codigo_postal() {
		createAccountPage.clicarNoDropboxESelecionarCountry();
		createAccountPage.clicaNoCampoCityEInserirCity("Poá");
		createAccountPage.clicaNoCampoAddressEInserirAddress("Rua Presidente Rodrigues Alves 313");
		createAccountPage.clicarNoCampoStateEInserirState("SP");
		createAccountPage.clicarNoCampoPostalCodeEInserirPostalCode("08553520");
	}

	@Entao("clico no box de igree para aceitar os termos")
	public void clico_no_box_de_igree_para_aceitar_os_termos() {
		createAccountPage.selecionaCheckBoxIAgree();
	}

	@Entao("clico no botao de registrar")
	public void clico_no_botao_de_registrar() {
		createAccountPage.clicarBotaoRegister();
	}
	
	@After(order = 1)
	public void capturarTela(Scenario scenario) {
		TakesScreenshot camera = (TakesScreenshot) driver;
		File capturaDeTela = camera.getScreenshotAs(OutputType.FILE);
		System.out.println(scenario.getId());
		
		String scenarioId = scenario.getId().substring(scenario.getId().lastIndexOf(".feature:") + 9 );
		
		String nomeArquivo = "resources/CapturasDeTela/" + scenario.getName() + "_" +scenarioId + "_" + scenario.getStatus() + ".png";
		System.out.println(nomeArquivo);
		
		try {
			Files.move(capturaDeTela, new File(nomeArquivo));
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	
	@After(order = 0)
	public static void fecharAba() {
		driver.quit();
	}

}
