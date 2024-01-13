package com.example.pages;

import com.example.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    public MainPage(TestContext context) {
        super(context);
    }

    @FindBy(xpath = "//a[text()='Alerts']")
    public WebElement buttonAlerts;

    @FindBy(xpath = "//a[text()='Accounts Overview']")
    public WebElement buttonAccountsOverview;

    @FindBy(xpath = "//a[text()='Transfers']")
    public WebElement buttonTransfers;

      @FindBy(xpath = "//button[text()='Remind me later']")
    public WebElement buttonCloseWindow;

    public void toAlerts() {
        buttonAlerts.click();
    }

    public void toAccountsOverview() {
        buttonAccountsOverview.click();
        buttonCloseWindow.click();
    }

        public void toTransferPage() {
        buttonTransfers.click();
    }
}
