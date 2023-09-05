package mantis.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ReportIssuePage {
    private final WebDriver driver;
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

    @FindBy(xpath = "//*[@id='action-group-div']//div[2]/input")
    private WebElement deleteIssueFinal;

    @FindBy(xpath = "//*[@id='buglist']/tbody/tr[1]/td[11]")
    private WebElement summaryEndtest;

    public ReportIssuePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickReportIssue() {
        reportIssue.click();
    }

    public void createIssue(String KeysToSend, String descriptionKeysToSend) {
        summary.sendKeys(KeysToSend);
        description.click();
        description.sendKeys(descriptionKeysToSend);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = btnSubmit;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        btnSubmit.click();
    }

    public void clickIdIssue() {
        idIssue.click();}

    public void clickDeleteIssue() {
        deleteIssue.click();
    }
    public void clickDeleteIssueFinal() {
        deleteIssueFinal.click();
    }
    public String getSummaryEndTest() {
        return summaryEndtest.getText();
    }
}
