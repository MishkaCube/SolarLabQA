package pages;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuppliersPage {

    public WebDriver driver;

    public SuppliersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[text()='Расширенный поиск']")
    private WebElement searchButton;

    public void userPressButton() {
        searchButton.click();
    }
}
