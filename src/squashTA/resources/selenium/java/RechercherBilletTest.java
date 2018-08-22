import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RechercherBilletTest {
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		// First session of WebDriver
		String path = "C:\\Users\\Jerem\\Documents\\SQUASHTA\\example\\my.squash.ta.project\\src\\squashTA\\resources\\selenium\\java";
		System.setProperty("webdriver.chrome.driver", path+"\\chromedriver.exe");
		driver = new ChromeDriver();
	
		driver.get("http://www.airfrance.fr/");
	}
	  
	@FindBy(css="#cookiebarAgreeContent > button.cookiebar-agree-button-agree")
	WebElement BtnCookie;
	public void BtnCookieClick(  )
	{
	    BtnCookie.click();
	}

    @FindBy(id="minibe__oneWay--label")
    WebElement ButtonAllerSimple;
    public void ChoisirAllerSimple(  )
    {
        ButtonAllerSimple.click();
    }
   
    
	@Test
	public void testRechercherBillet() {
        //  BtnCookieClick();
		  // PageAccueil accueil= new PageAccueil(driver);
		  System.out.println("AVANT CHOISIR ALLER");
		//  ChoisirAllerSimple();
		  System.out.println("Apres choisir aller");
	}

	@After
	public void tearDown()  {
		//driver.quit();
	
	}


}
