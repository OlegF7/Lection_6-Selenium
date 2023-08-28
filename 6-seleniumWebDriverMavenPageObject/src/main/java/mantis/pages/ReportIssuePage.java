package mantis.pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

public class ReportIssuePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "[class*='menu-icon fa fa-edit']")
    private WebElement reportIssue;

    @FindBy(id = "summary")
    private WebElement summary;

    @FindBy(id = "description")
    private WebElement description;

    @FindBy(xpath = "//*[@class='btn btn-primary btn-white btn-round']")
    private WebElement btnSubmit;

    @FindBy(xpath = "//*[@id='buglist']//td[4]")
    private WebElement idIssue;

    @FindBy(xpath = "//*[@value='Delete']")
    private WebElement deleteIssue;

    @FindBy (xpath = "//*[@id='buglist']//td[11]")
    private WebElement summaryEndtest;


    public ReportIssuePage(WebDriver driver) {

        wait = new WebDriverWait(driver, 30, 1);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickReportIssue() {
        reportIssue.click();
    }

    public void summary() {
        summary.sendKeys("Summary 26.08.23");
    }

    public void description() {
        description.click();
        description.sendKeys("Test 27.08.2023");
    }

    public void btnSubmit() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = btnSubmit;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        btnSubmit.click();
        }
    public void clickIdIssue() {
        idIssue.click();
    }
    public void clickDeleteIssue() {
        deleteIssue.click();
    }
    public String getSummaryEndTest() {
        summaryEndtest.getText();
        return summaryEndtest.getText();
    }
}

