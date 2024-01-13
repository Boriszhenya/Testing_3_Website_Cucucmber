package com.example.pages;

import com.example.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SendMoneyOutsidePage extends BasePage {
    public static final int POSITION = 1;

    public SendMoneyOutsidePage(TestContext context) {
        super(context);
    }

    @FindBy(id = "payFrom")
    public WebElement fieldFrom;

    @FindBy(id = "payTo")
    public WebElement fieldTo;

    @FindBy(id = "payAmount")
    public WebElement fieldAmount;

    @FindBy(id = "payNote")
    public WebElement fieldNote;

    @FindBy(xpath = "//button[text()='Continue transfer']")
    public WebElement buttonContinueTransfer;

    @FindBy(xpath = "//a[text()='Make Transfer']")
    public WebElement buttonMakeTransfer;

    @FindBy(xpath = "//strong[text()='From:']/../span")
    public WebElement fieldFromRez;


    public void formFilling() {
        Select select = new Select(fieldFrom);
        fieldFrom.click();
        select.selectByIndex(POSITION);
        fieldTo.click();
        fieldAmount.click();
        fieldNote.sendKeys("test");
        buttonContinueTransfer.click();
    }

    public void makeTransfer() {
        buttonMakeTransfer.click();
    }

    public String getTextFieldFrom() {
        return fieldFromRez.getText();
    }
}
