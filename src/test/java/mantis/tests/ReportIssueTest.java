package mantis.tests;

import mantis.pages.MantisSite;
import org.junit.jupiter.api.Test;
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
        mantisSite.reportIssuePage().clickReportIssue();
        mantisSite.reportIssuePage().createIssue("Summary 26.08.23", "Test 27.08.2023");

        String currentUrl = driver.getCurrentUrl();
        asert.assertEquals("https://academ-it.ru/mantisbt/bug_report.php?posted=1", currentUrl);
        String currentUrlBugReport = driver.getCurrentUrl();
        asert.assertEquals("https://academ-it.ru/mantisbt/bug_report.php?posted=1", currentUrlBugReport);
        mantisSite.reportIssuePage().clickIdIssue();
        mantisSite.reportIssuePage().clickDeleteIssue();
        mantisSite.reportIssuePage().clickDeleteIssueFinal();

        String s1 = "Summary 26.08.23";
        asert.assertNotEquals(mantisSite.reportIssuePage().getSummaryEndTest(), s1, "Assert Failed as the two string are EQUAL");
        asert.assertAll();
        System.out.println("Test passed");
    }
}
