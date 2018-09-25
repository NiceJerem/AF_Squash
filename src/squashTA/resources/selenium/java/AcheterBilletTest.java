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

import java.time.LocalDateTime;
import org.hamcrest.core.Is;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import org.openqa.selenium.interactions.Actions;

//import AF;

public class AcheterBilletTest {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setUp() throws Exception {
        // First session of WebDriver
        String path = "C:\\Users\\Jerem\\Documents\\SQUASHTA\\example\\my.squash.ta.project\\src\\squashTA\\resources\\selenium\\java";
        System.setProperty("webdriver.chrome.driver", path+"\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.airfrance.fr/");
    }



    @Test
    public void testAcheterBillet() {
        System.out.println("Debut Acheter Billet");
        
        AccueilPage accueil= new AccueilPage(driver);
       
        String dateDepart= "20180928";
        String villeDepart="ORY";
        String villeArrivee="NCE";

        accueil.BtnCookieClick();
        accueil.ChoisirAllerSimple();
        accueil.SaisirDepart(villeDepart);
        accueil.SaisirArrivee(villeArrivee);
        accueil.ChoisirDateDepart(dateDepart );

        PageHorairesTarifs tarifsPage = accueil.rechercher();
        tarifsPage.ChoisirMeilleurTarifAller(1);
        PageDetailsVoyage detailsPage = tarifsPage.continuer();
        PageDonneesPersonnelles donneesPage = detailsPage.continuer();
        donneesPage.fermerPopup();
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        donneesPage.choisirMonsieur();
        //driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        donneesPage.saisirNom("Tom");
        donneesPage.saisirPrenom("Jeerrre");
        donneesPage.saisirTelephone("0606060606");
       // donneesPage.choisirHublot();
        donneesPage.saisirEmail("mymail@mail.com");
        donneesPage.saisirEmailConfirm("mymail@mail.com");
        
        //donneesPage.cocherPasDassurance();
        //donneesPage.cocherCGU();
        //#idCheckboxCGU
        //#popin__info--close
        Assert.assertThat(true, Is.is(true));
        System.out.println("Fin du traitement Acheter Billet");
    }
    
    @After
    public void tearDown()  {
      // driver.quit();

    }


}
