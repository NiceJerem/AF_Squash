import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageTemplate extends Footer{
    public WebElement getHeader() {
        return header;
    }

    public PageTemplate(WebDriver driver )
    {
    	
        super(driver);
        System.out.println("MyPageTemplate");
    }

    @FindBy(tagName="header")
    private WebElement header;

    @FindBy(tagName="idNavIciLink")
    private WebElement btnEnregistrement;

    public void clickerBtnEnregistrement()
    {
        btnEnregistrement.click();
    }

}
