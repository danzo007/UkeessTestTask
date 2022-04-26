package Ukeess.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SentMailsPage {
    private WebDriver driver;
    private WebDriverWait wait;
    public SentMailsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }
    private By lastMail = By.xpath("(//tbody//tr)[1]");
    private By lastMailToWhom = By.xpath("(//tbody//tr)[1]//a//span");
    private By lastMailText = By.xpath("((//tbody//tr)[1]//a)[3]//strong");


    public void waitForLastMail (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastMail));
    }
    public void verifyLastMailToWhom(String toWhom){
        Assert.assertTrue(driver.findElement(lastMailToWhom).getText().equals(toWhom));
    }
    public void verifyLastMailText(String text){
        Assert.assertTrue(driver.findElement(lastMailText).getText().equals(" "+ text));
    }


}
