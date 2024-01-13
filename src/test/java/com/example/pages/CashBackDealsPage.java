package com.example.pages;

import com.example.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CashBackDealsPage extends BasePage {
    public CashBackDealsPage(TestContext context) {
        super(context);
    }

    @FindBy(xpath = "//span[text()='Hide Deal']/..")
    public WebElement buttonBaysidePlus;

    @FindBy(xpath = "//div[@class='ready-to-use']/p[3]")
    public WebElement textBaysidePlus;

    public void markBayside() {
        buttonBaysidePlus.click();
    }

    public String getTextResultBayside() {
        return textBaysidePlus.getText();
    }
}
