package Ukeess.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    private By loginInput = By.id("id-input-login");
    private By passwordInput = By.id("id-input-password");
    private By submitButton = By.xpath("//button[@class='form__submit']");
    private By mailButton = By.xpath("//a[@class='service__entry service__entry_mail']");
    private By iFrame = By.xpath("//iframe[@name='mail widget']");

    public void waitForElements(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginInput));
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        wait.until(ExpectedConditions.visibilityOfElementLocated(submitButton));
    }
    public void switchFrame(){
        WebElement editorFrame = driver.findElement(iFrame);
        driver.switchTo().frame(editorFrame);
    }
    public void loginInput(String login){
        driver.findElement(loginInput).sendKeys(login);
    }
    public void passwordInput(String password){
        driver.findElement(passwordInput).sendKeys(password);
    }
    public void clickSubmitButton(){
        driver.findElement(submitButton).click();
    }
    public void waitMailButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(mailButton));
    }
    public void clickMailButton(){
        driver.findElement(mailButton).click();
    }
}
