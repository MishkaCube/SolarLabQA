package steps;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import pages.SearchPage;
import pages.SuppliersPage;

import java.time.LocalDate;

public class Steps {

    private WebDriver driver;
    private MainPage mainPage;
    private SuppliersPage supPage;
    private SearchPage searchPage;


    @Given("Пользователь запускает браузер")
    public void launchBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mishka\\Documents\\chromedriver.exe");
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        supPage = new SuppliersPage(driver);
        searchPage = new SearchPage(driver);
    }

    @When("Пользователь открывает сайт Тендора")
    public void openUrl() {
        driver.get("https://www.rts-tender.ru/");
    }

    @Then("Пользователь нажимает кнопку поставщикам")
    public void clickSuppliersBtn() {
        mainPage.supplierButtonClick();
    }

    @Then("Пользователь нажимает кнопку Расширенный поиск")
    public void clickSearchAdvancedBtn() {
        supPage.userPressButton();
    }

    @Then("Пользователь нажимает кнопку Настройка поиска")
    public void userClickSearchSettingBtn() throws InterruptedException {
        searchPage.searchSettingsBtnClick();
    }

    @Then("Пользователь исключает совместные закупки")
    public void userNotIncludeCoopBuy() {
        searchPage.includeBtnClick();
    }

    @Then("Пользователь нажимает кнопку регион поставки")
    public void userChoseRegion() {
        searchPage.regionBtnClick();
    }

    @Then("Пользователь выбирает Алтайский край")
    public void userChoseAltay() {
        searchPage.altayBtnClick();
    }

    @Then("Пользователь нажимает кнопку Фильтры по датам")
    public void dateFilterClick(){
        searchPage.dateBtnClick();
    }

    @Then("Пользователь настраивает даты подачи заявок")
    public void setDate() {
        searchPage.setDateNow();
    }

    @Then("Пользователь указывает сегодняшнюю дату")
    public void setNowDate() {
        searchPage.dateNowButtonClick();
    }

    @Then("Пользователь октлючает активные закупки")
    public void disabeActiveSupplie() throws InterruptedException {
        searchPage.activeCheckboxClick();
        Thread.sleep(5000);
    }

    @Then("Пользователь нажимает кнопку Найти")
    public void userStartSearching() throws InterruptedException {
        searchPage.findButtonClick();
        Thread.sleep(5000);
    }

    @Then("Сохранение данных в файл")
    public void saveDataToFile() {
        searchPage.saveToFile();
    }




    @After
    public void end(){
        System.out.println("Bye QA!");
        driver.close();
        driver.quit();
    }



}
