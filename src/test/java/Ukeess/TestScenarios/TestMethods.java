package Ukeess.TestScenarios;

import Ukeess.Objects.LoginPage;
import Ukeess.Objects.MailPage;
import Ukeess.Objects.SentMailsPage;
import Ukeess.Settings.JsonReader;
import Ukeess.Settings.WebDriverSettings;
import org.testng.annotations.Test;

public class TestMethods extends WebDriverSettings {
    JsonReader jsonReader = new JsonReader();


    @Test(priority = 0)
    public void loginOperation(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.switchFrame();
        loginPage.waitForElements();



        loginPage.loginInput(jsonReader.readFromJson("login"));

        loginPage.passwordInput(jsonReader.readFromJson("password"));
        loginPage.clickSubmitButton();
        loginPage.waitMailButton();
        loginPage.clickMailButton();
    }

    @Test (priority = 1)
    public void sendMailOperation() {
        MailPage mailPage = new MailPage(driver);
        mailPage.switchTab();
        mailPage.waitForWriteLetterButton();
        mailPage.clickWriteLetterButton();
        mailPage.waitForLetterElements();
        mailPage.toWhomInput(jsonReader.readFromJson("toWhom"));
        mailPage.subjectInput(jsonReader.readFromJson("subject"));
        mailPage.switchFrameToBodyMail();
        mailPage.bodyMailInput((jsonReader.readFromJson("text")));
        mailPage.switchFrameToDefaultContent();
        mailPage.clickSendMailButton();
        mailPage.waitForMailIsSent();
        mailPage.clickSentMailsButton();

    }

    @Test (priority = 2)
    public void emailVerificationOperation(){
        SentMailsPage sentMailsPage = new SentMailsPage(driver);
        sentMailsPage.waitForLastMail();
        sentMailsPage.verifyLastMailToWhom(jsonReader.readFromJson("toWhom"));
        sentMailsPage.verifyLastMailText(jsonReader.readFromJson("text"));
    }
}
