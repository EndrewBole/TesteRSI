package base;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

import pages.HomePage;


public class BaseTests {
	private static WebDriver driver;
	protected HomePage homePage;
	
	
	
	@BeforeAll
	public static void inicializar() {
		System.setProperty("webdriver.chrome.driver", "Chromedriver\\88\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@BeforeEach
	public void carregarPaginaInicial() {
		driver.get("http://advantageonlineshopping.com/#/");
		homePage = new HomePage(driver);
	}
	
	public void capturarTelaCadastro() {
		TakesScreenshot camera = (TakesScreenshot) driver;
		File capturaDeTela = camera.getScreenshotAs(OutputType.FILE);
		try {
			Files.move(capturaDeTela, new File("target/screenshots/testCadastro"+ "Evidencia" +".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public void capturarTelaLogin() {
		TakesScreenshot camera = (TakesScreenshot) driver;
		File capturaDeTela = camera.getScreenshotAs(OutputType.FILE);
		try {
			Files.move(capturaDeTela, new File("resources/CapturasDeTela/testLogin"+ "Evidencia" +".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	@AfterAll
	public static void finalizar() {
		driver.quit();
	}
}
