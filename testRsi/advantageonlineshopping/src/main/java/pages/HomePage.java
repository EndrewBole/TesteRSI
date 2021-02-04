package pages;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	private WebDriver driver;
	
	private By iconeLogin = By.id("menuUserSVGPath");
	private By linkCadastro = By.linkText("CREATE NEW ACCOUNT");
	private By nomeLogado = By.cssSelector("nav ul li #menuUserLink span");
	private By campoUserName = By.name("username");
	private By campoPassword = By.name("password");
	private By botaoSigIn = By.id("sign_in_btnundefined");
	

	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	public void clicarInoneLogin() {
		driver.findElement(iconeLogin).click();
	}
	
	public String verfificarSeEstaLogadoERegistrado() {
		FluentWait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(nomeLogado));
		
		return driver.findElement(nomeLogado).getText();
	}
	
	public CreateAccountPage identificarModalEClicarCriarNovaConta() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(linkCadastro));
		
		driver.findElement(linkCadastro).click();
		
		return new CreateAccountPage(driver);
	}
	
	public void selecionaCampoUsuarioEInsereUsuario(String texto) {
		driver.findElement(campoUserName).click();
		driver.findElement(campoUserName).sendKeys(texto);
	}
	public void selecionaCampoPasswordEInserePassword(String texto) {
		driver.findElement(campoPassword).click();
		driver.findElement(campoPassword).sendKeys(texto);
		
	}
	public void carregarPaginaInicial() {
		driver.get("http://advantageonlineshopping.com/#/");
	}
	public void carregarPaginaInicial2() {
		driver.get("http://advantageonlineshopping.com/#/");
	}
	public String obterTituloPagina() {
		return driver.getTitle();
	}
	public void clicarBotaoLogin() {
		driver.findElement(botaoSigIn).click();
	}
	
}
