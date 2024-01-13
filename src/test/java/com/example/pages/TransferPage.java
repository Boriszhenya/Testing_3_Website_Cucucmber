package com.example.pages;

import com.example.context.TestContext;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;

public class TransferPage extends BasePage {
    public static final int NUMBER_ITERATIONS = 6;

    public TransferPage(TestContext context) {
        super(context);
    }

    @FindBy(xpath = "//div[text()='Between my accounts at Bank of America']/..")
    public WebElement buttonBetweenAccounts;

    @FindBy(id = "payFrom")
    public WebElement fieldTransferMoneyFrom;
    @FindBy(xpath = "//div[@id='payFrom']/div/ul/li")
    public List<WebElement> listTransferMoneyFrom;

    @FindBy(id = "payTo")
    public WebElement fieldTransferMoneyTo;
    @FindBy(xpath = "//div[@id='payTo']/div/ul/li")
    public List<WebElement> listTransferMoneyTo;

    @FindBy(id = "payAmount")
    public WebElement fieldAmount;

    @FindBy(id = "payHowOften")
    public WebElement fieldFrequency;
    @FindBy(xpath = "//div[@id='payHowOften']/div/ul/li")
    public List<WebElement> listFrequency;

    @FindBy(xpath = "//button[text()='Next']")
    public WebElement buttonNext;

    @FindBy(xpath = "//a[text()='Transfer']")
    public WebElement buttonTransfer;

    @FindBy(xpath = "//*[@id='mainContent']//span")
    public WebElement result;

    public void toBetweenMyAccount() {
        buttonBetweenAccounts.click();
    }

    public void executionTransfer(String transferValue) {
        fieldTransferMoneyFrom.click();
        listTransferMoneyFrom.getFirst().click();
        fieldTransferMoneyTo.click();
        listTransferMoneyTo.get(1).click();
        for (int i = 0; i <= NUMBER_ITERATIONS; i++) {
            fieldAmount.sendKeys(Keys.BACK_SPACE);
        }
        fieldAmount.sendKeys(transferValue);
        fieldFrequency.click();
        listFrequency.getFirst().click();
        buttonNext.click();
    }

    public void goTransfer() {
        buttonTransfer.click();
    }

    public String textResult() {
        return result.getText();
    }
}
