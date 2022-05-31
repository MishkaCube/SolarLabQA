package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class SearchPage {

    public WebDriver driver;
    Logger log = Logger.getLogger(SearchPage.class.getName());


    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class=\"main-search__settings\"]")
    private WebElement searchSettingsBtn;

    @FindBy(xpath = "//div[text()='Регион поставки']")
    private WebElement regionBtn;

    @FindBy(xpath = "//label[text()='Исключить совместные закупки']")
    private WebElement includeCoopBuy;

    @FindBy(xpath = "//label[text()='Алтайский край']")
    private WebElement altayBtn;

    @FindBy(xpath = "//div[text()='Фильтры по датам']")
    private WebElement dateBtn;

    @FindBy(xpath = "//*[@id=\"ftfbn-portal\"]/div[2]/div/div/div/div[1]/div[5]/div[12]/div[2]/div/div/div[1]/div[2]/div[3]/div/div/input")
    private WebElement inputDateField;

    @FindBy(xpath = "//div[@aria-label=\"Choose суббота, 28 мая 2022 г.\"]")
    private WebElement dateNowBtn;

    @FindBy(xpath = "//*[@id=\"ftfbn-portal\"]/div[2]/div/div/div/div[1]/div[5]/div[3]/div[2]/a[1]")
    private WebElement activeCheckbox;

    @FindBy(xpath = "//button[@class=\"search__btn fromModalButtonSearch\"]")
    private WebElement findButton;


    public void searchSettingsBtnClick() {
        searchSettingsBtn.click();
    }
    public void includeBtnClick() {
        includeCoopBuy.click();
    }
    public void regionBtnClick() {
        regionBtn.click();
    }
    public void altayBtnClick() {
        altayBtn.click();
    }
    public void dateBtnClick() { dateBtn.click(); }
    public void setDateNow() {
        inputDateField.click();
    }
    public void dateNowButtonClick() {
        dateNowBtn.click();
    }
    public void activeCheckboxClick() {
        activeCheckbox.click();
    }
    public void findButtonClick() {
        findButton.click();
    }
    public void saveToFile() {

        try (FileWriter writer = new FileWriter("data.txt", false)) {

            List<WebElement> list_price = driver.findElements(By.xpath("//div[@itemprop=\"price\"]"));
            List<WebElement> list_card = driver.findElements(By.xpath("//div[@class='card-item']"));

            int sum = 0;
            for(int i = 0; i < list_price.size(); i++) {
                writer.write("Цена " + i + " товара - " + list_price.get(i).getText() + "\n");
                System.out.println("Цена " + i + " товара - " + list_price.get(i).getText());
                String price = list_price.get(i).getText();

                int counter = Integer
                        .parseInt(price
                            .substring(0, price.length() - 5)
                            .replaceAll(" ", ""));

                sum += counter;
                log.info(String.valueOf(sum));
            }

            writer.write("Количество закупок - " + list_card.size());



        }

        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
