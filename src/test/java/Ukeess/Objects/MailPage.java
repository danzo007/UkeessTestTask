package Ukeess.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class MailPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public MailPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }
    private By writeLetterButton = By.xpath("//button[contains(@class, 'button') and contains(@class, 'primary')]");
    private By toWhomInput = By.xpath("//input[@name='toFieldInput']");
    private By subjectInput = By.xpath("//input[@name='subject']");
    private By bodyMail = By.xpath("//body[@id='tinymce']");
    private By mailIsSent = By.xpath("//div[@class='sendmsg__ads-ready']");
    private By sentMailsButton = By.xpath("(//span[@class='sidebar__list-link-name'])[3]");
    private By sendMailButton = By.xpath("(//button[contains(@class, 'button') and contains(@class, 'send')])[1]");
    private By iFrame = By.xpath("//div[@class='mce-edit-area mce-container mce-panel mce-stack-layout-item mce-last']//iframe");

    public void switchTab(){
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
    }


    public void waitForWriteLetterButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(writeLetterButton));
    }
    public void clickWriteLetterButton(){

        driver.findElement(writeLetterButton).click();
    }
    public void waitForLetterElements(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(toWhomInput));
        wait.until(ExpectedConditions.visibilityOfElementLocated(subjectInput));
        wait.until(ExpectedConditions.visibilityOfElementLocated(iFrame));
        wait.until(ExpectedConditions.visibilityOfElementLocated(sendMailButton));
        wait.until(ExpectedConditions.visibilityOfElementLocated(sentMailsButton));
    }
    public void toWhomInput(String mail){
        driver.findElement(toWhomInput).sendKeys(mail);
    }
    public void subjectInput(String subject){
        driver.findElement(subjectInput).sendKeys(subject);
    }

    public void switchFrameToBodyMail(){
        WebElement editorFrame = driver.findElement(iFrame);
        driver.switchTo().frame(editorFrame);
    }
    public void bodyMailInput(String text){
        driver.findElement(bodyMail).sendKeys(text);
    }

    public void switchFrameToDefaultContent(){
        driver.switchTo().defaultContent();
    }
    public void clickSendMailButton(){
        driver.findElement(sendMailButton).click();
    }
    public void waitForMailIsSent(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(mailIsSent));
    }
    public void clickSentMailsButton(){
        driver.findElement(sentMailsButton).click();
    }
}
