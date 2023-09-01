package mantis.tests;

import mantis.pages.MantisSite;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import java.time.Duration;


public class ReportIssueTest extends BaseTest {
    private MantisSite mantisSite;

    @Test
    public void reportIssueTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        SoftAssert asert = new SoftAssert();

        mantisSite = new MantisSite(driver);
        mantisSite.login("admin", "admin20");
        mantisSite.getMainPage().clickReportIssue();
        mantisSite.getMainPage().summary();

        String currentUrl = driver.getCurrentUrl();
        asert.assertEquals("https://academ-it.ru/mantisbt/bug_report.php?posted=1", currentUrl);
        String currentUrlBugReport = driver.getCurrentUrl();
        asert.assertEquals("https://academ-it.ru/mantisbt/bug_report.php?posted=1", currentUrlBugReport);
        mantisSite.getMainPage().clickIdIssue();
        mantisSite.getMainPage().clickDeleteIssue();
        String currentUrl1 = driver.getCurrentUrl();
        asert.assertEquals("https://academ-it.ru/mantisbt/bug_actiongroup_page.php", currentUrl1);
        driver.findElement(By.xpath("//*[@value='Delete Issues']")).click();

        String s1 = "Summary 26.08.23";
        asert.assertNotEquals(mantisSite.getMainPage().getSummaryEndTest(), s1, "Assert Failed as the two string are EQUAL");
        asert.assertAll();
        System.out.println("Test passed");
    }

}
