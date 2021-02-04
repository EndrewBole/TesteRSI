package tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

import base.BaseTests;
import pages.CreateAccountPage;

public class Tests extends BaseTests{

	//@Test
	public void testValidarLoginEDirecionarParaTeladeCadastro() {
		
		homePage.clicarInoneLogin();
		homePage.identificarModalEClicarCriarNovaConta();
	}
	CreateAccountPage createAccountPage;
	@Test
	public void testValidarPageCreateAccountEEfetuarCadastro() {
		testValidarLoginEDirecionarParaTeladeCadastro();
		createAccountPage = homePage.identificarModalEClicarCriarNovaConta();
		createAccountPage.clicarCampoUsuarioEInserirUserName("testador5");
		createAccountPage.clicarCampoEmailEInserirEmail("testandotestando@testando.com");
		createAccountPage.clicarNoCampoPasswordEInserirPassword("Testando123");
		createAccountPage.clicarNoCampoConfirmPasswordEInserirPassword("Testando123");
		capturarTelaCadastro();
		createAccountPage.clicarNoCampoFirstNameEInserirFirstName("Endrew");
		createAccountPage.clicarNoCampoLastNameEInserirLastName("Bole");
		createAccountPage.clicarNoCampoPhoneNumberEInserirPhoneNumber("11999999999");
		capturarTelaCadastro();
		createAccountPage.clicarNoDropboxESelecionarCountry();
		createAccountPage.clicaNoCampoCityEInserirCity("Poá");
		createAccountPage.clicaNoCampoAddressEInserirAddress("Rua Presidente Rodrigues Alves 313");
		createAccountPage.clicarNoCampoStateEInserirState("São Paulo");
		createAccountPage.clicarNoCampoPostalCodeEInserirPostalCode("08553520");
		createAccountPage.selecionaCheckBoxIAgree();
		capturarTelaCadastro();
		createAccountPage.clicarBotaoRegister();
		
		assertThat(homePage.verfificarSeEstaLogadoERegistrado(), is ("testador5"));
		capturarTelaCadastro();
	}
	
	@Test
	public void testEfetuarLogin() {
		homePage.clicarInoneLogin();
		homePage.selecionaCampoUsuarioEInsereUsuario("endrew");
		homePage.selecionaCampoPasswordEInserePassword("Testando123");
		homePage.clicarBotaoLogin();
		assertThat(homePage.verfificarSeEstaLogadoERegistrado(), is ("endrew"));
		capturarTelaLogin();
	}
	
}
