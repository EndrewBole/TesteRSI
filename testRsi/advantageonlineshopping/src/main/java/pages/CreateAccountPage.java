package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccountPage {
	private WebDriver driver;
	
	private By inserirUserName = By.name("usernameRegisterPage");
	private By inserirEmail = By.name("emailRegisterPage");
	private By inserirPassword = By.name("passwordRegisterPage");
	private By inserirConfirmPassword = By.name("confirm_passwordRegisterPage");
	private By inserirFirstName = By.name("first_nameRegisterPage");
	private By inserirLastName= By.name("last_nameRegisterPage");
	private By inserirPhoneNumber = By.name("phone_numberRegisterPage");
	private By selecionaCountry = By.name("countryListboxRegisterPage");
	private By inserirCity = By.name("cityRegisterPage");
	private By inserirAddress = By.name("addressRegisterPage");
	private By inserirState = By.name("state_/_province_/_regionRegisterPage");
	private By inserirPostalCode = By.name("postal_codeRegisterPage");
	private By checkBoxIAgree = By.name("i_agree");
	private By botaoRegister = By.id("register_btnundefined");

	
	public CreateAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clicarCampoUsuarioEInserirUserName(String texto) {
		driver.findElement(inserirUserName).click();
		driver.findElement(inserirUserName).sendKeys(texto);
	}
	
	public void clicarCampoEmailEInserirEmail(String texto) {
		driver.findElement(inserirEmail).click();
		driver.findElement(inserirEmail).sendKeys(texto);
	}
	
	public void clicarNoCampoPasswordEInserirPassword(String texto) {
		driver.findElement(inserirPassword).click();
		driver.findElement(inserirPassword).sendKeys(texto);
	}
	public void clicarNoCampoConfirmPasswordEInserirPassword(String texto) {
		driver.findElement(inserirConfirmPassword).click();
		driver.findElement(inserirConfirmPassword).sendKeys(texto);
	}
	public void clicarNoCampoFirstNameEInserirFirstName(String texto) {
		driver.findElement(inserirFirstName).click();
		driver.findElement(inserirFirstName).sendKeys(texto);
	
	}
	public void clicarNoCampoLastNameEInserirLastName(String texto) {
		driver.findElement(inserirLastName).click();
		driver.findElement(inserirLastName).sendKeys(texto);
	}
	public void clicarNoCampoPhoneNumberEInserirPhoneNumber(String texto) {
		driver.findElement(inserirPhoneNumber).click();
		driver.findElement(inserirPhoneNumber).sendKeys(texto);
	}
	public void clicarNoDropboxESelecionarCountry() {
		WebElement dropBox = driver.findElement(selecionaCountry);
		dropBox.sendKeys("Brazil");
	}
	public void clicaNoCampoCityEInserirCity(String texto) {
		driver.findElement(inserirCity).click();
		driver.findElement(inserirCity).sendKeys(texto);
	}
	public void clicaNoCampoAddressEInserirAddress(String texto) {
		driver.findElement(inserirAddress).click();
		driver.findElement(inserirAddress).sendKeys(texto);

	}
	public void clicarNoCampoStateEInserirState(String texto) {
		driver.findElement(inserirState).click();
		driver.findElement(inserirState).sendKeys(texto);
	}
	public void clicarNoCampoPostalCodeEInserirPostalCode(String texto) {
		driver.findElement(inserirPostalCode).click();
	driver.findElement(inserirPostalCode).sendKeys(texto);
	}
	public void selecionaCheckBoxIAgree() {
		driver.findElement(checkBoxIAgree).click();
	}
	
	public HomePage clicarBotaoRegister() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(botaoRegister));
		driver.findElement(botaoRegister).click();
		
		return new HomePage(driver);
	}
}

