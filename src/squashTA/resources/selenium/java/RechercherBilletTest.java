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

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDateTime;
import org.hamcrest.core.Is;


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
        PageFactory.initElements(driver,this);
        driver.get("http://www.airfrance.fr/");
    }

    @FindBy(css="#cookiebarAgreeContent > button.cookiebar-agree-button-agree")
    WebElement BtnCookie;
    public void ClickOnBtnCookie(  )
    {
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(BtnCookie));
        Actions actions = new Actions(driver);
        actions.moveToElement(BtnCookie);
        actions.click();
        actions.build().perform();
    }

    @FindBy(id="minibe__oneWay--label")
    WebElement ButtonAllerSimple;
    public void ChoisirAllerSimple(  )
    {
        ButtonAllerSimple.click();
        System.out.println("Apres click sur Aller Simple");

    }

    @FindBy(id="cookiebarModal")
    WebElement cookiePopup;


    @Test
    public void testRechercherBillet() {
        System.out.println("Debut");
        ClickOnBtnCookie();
        ChoisirAllerSimple();
        String  dateDepart ="20180920";
        ChoisirDateDepart(dateDepart);
        Assert.assertThat(true, Is.is(true));
        System.out.println("Fin du traitement");
    }
/*
    @Test
    public void testAcheterBillet() {
        System.out.println("Debut Acheter Billet");
        PageAccueil accueil= new PageAccueil(driver);
        String dateDepart= "20180920";
        String villeDepart="ORY";
        String villeArrivee="NCE";

        accueil.BtnCookieClick();
        accueil.ChoisirAllerSimple();
        accueil.SaisirDepart(villeDepart);
        accueil.SaisirArrivee(villeArrivee);

        accueil.ChoisirDateDepart(dateDepart );

        accueil.rechercher();
        Assert.assertThat(true, Is.is(true));
        System.out.println("Fin du traitement Acheter Billet");
    }
  */  
    @FindBy(id="minibe__button--calendar_out")
    WebElement dateDepart;
    public void ChoisirDateDepart( String  dateD ) //
    {
        //dateD = 20180816
        LocalDateTime now = LocalDateTime.now();
        dateDepart.click();
        //calendar20188
        dateOperation(dateD);
     
    }

    WebElement calendrier;

    public void dateOperation(String date)
    {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("dateD :"+ date);
        String year =date.substring(0,4);

        int yearInt = Integer.parseInt(year);
        System.out.println("year :"+ year);
        System.out.println("dateD :"+ date);
        String month= date.substring(4,6);
        //-------------
        System.out.println("month :"+ month);
        int monthInt = Integer.parseInt(month);
        int actualMonth = now.getMonthValue();
        int actualYear = now.getYear();
        if(monthInt< 10)
        {
            System.out.println("getInteger :"+ month);
            month= String.valueOf(monthInt);
            System.out.println("getInteger apres:"+ month);
        }
        if(actualMonth> monthInt)
        {

        }

        String idCal = year +month;
        System.out.println("idCal :"+ idCal);
        String idCalendrier ="calendar"+idCal;



        Actions actions = new Actions(driver);
        System.out.println("avant Find Element "+idCalendrier);
        calendrier = driver.findElement(By.id(idCalendrier));

        System.out.println("avant wait.until "+idCalendrier);
        actions.moveToElement(calendrier);
        actions.build().perform();
        actions.click();
        actions.build().perform();
        //
        //calendar--20180713
        System.out.println("apres wait.until "+idCalendrier);
        WebDriverWait wait = new WebDriverWait(driver,5);

        String idDate ="calendar--"+date ;
        WebElement tddate =  calendrier.findElement(By.id( idDate));
        wait.until(ExpectedConditions.visibilityOf(tddate));
        actions.moveToElement(tddate);
        actions.build().perform();
        actions.click();
        actions.build().perform();
    }
    @After
    public void tearDown()  {
     //   driver.quit();

    }


}
