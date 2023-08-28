package mantis.tests;

import mantis.pages.MantisSite;
import mantis.pages.ReportIssuePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class ReportIssueTest extends BaseTest {
    private MantisSite mantisSite;
    private ReportIssuePage reportIssuePage;


    @Test
    public void reportIssueTest() throws InterruptedException {

        SoftAssert asert = new SoftAssert();

        reportIssuePage = new ReportIssuePage(driver);
        mantisSite = new MantisSite(driver);
        mantisSite.login("admin", "admin20");
        mantisSite.getReportIssuePage().clickReportIssue();
        reportIssuePage.summary();
        reportIssuePage.description();
        reportIssuePage.btnSubmit();


        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://academ-it.ru/mantisbt/bug_report.php?posted=1", currentUrl);
        Thread.sleep(5000);
        String currentUrlBugReport = driver.getCurrentUrl();
        asert.assertEquals("blablablablabla", currentUrlBugReport); //softAssert не работает

        reportIssuePage.clickIdIssue();
        reportIssuePage.clickDeleteIssue();
        String currentUrl1 = driver.getCurrentUrl();
        Assertions.assertEquals("https://academ-it.ru/mantisbt/bug_actiongroup_page.php", currentUrl1);
        driver.findElement(By.xpath("//*[@value='Delete Issues']")).click();


        String s1 = "Summary 26.08.23";
        Assertions.assertNotEquals(reportIssuePage.getSummaryEndTest(),s1,"Assert Failed as the two string are EQUAL");
        System.out.println("Test passed");
    }

}
