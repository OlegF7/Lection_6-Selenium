package mantis.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "span.user-info")
    private WebElement userName;

    @FindBy(css = "a[href='/mantisbt/view_all_bug_page.php']")
    private WebElement viewIssuesPageButton;

    @FindBy(css = "[class*='menu-icon fa fa-edit']")
    private WebElement reportIssue;

    @FindBy(id = "summary")
    private WebElement summary;

    @FindBy(id = "description")
    private WebElement description;

    @FindBy(xpath = "//*[@class='btn btn-primary btn-white btn-round']")
    private WebElement btnSubmit;

    @FindBy(css = "#buglist > tbody > tr:nth-child(1) > td.column-id > a")
    private WebElement idIssue;

    @FindBy(xpath = "//*[@value='Delete']")
    private WebElement deleteIssue;

    @FindBy(xpath = "//*[@id='buglist']//td[11]")
    private WebElement summaryEndtest;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 500);
        PageFactory.initElements(driver, this);
    }

    public String getUserName() {
        return userName.getText();
    }

    public void goToViewIssuesPage() {
        viewIssuesPageButton.click();
    }

    public void clickReportIssue() {
        reportIssue.click();
    }

    public void summary() {
        summary.sendKeys("Summary 26.08.23");
        description.click();
        description.sendKeys("Test 27.08.2023");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = btnSubmit;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        btnSubmit.click();
    }

    public void clickIdIssue() {idIssue.click();}

    public void clickDeleteIssue() {
        deleteIssue.click();
    }

    public String getSummaryEndTest() {
        return summaryEndtest.getText();
    }
}
