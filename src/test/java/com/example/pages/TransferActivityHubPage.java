package com.example.pages;

import com.example.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TransferActivityHubPage extends BasePage {
    public TransferActivityHubPage(TestContext context) {
        super(context);
    }

    @FindBy(xpath = "//h5[text()='Zelle®']/../..")
    public WebElement buttonZelle;

    @FindBy(xpath = "//strong[contains(text(),'Energy')]")
    public WebElement activityEnergy;


    public void toZelle() {
        buttonZelle.click();
    }

    public boolean searchBillEnergy() {
        try {
            return activityEnergy.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;

        }
    }
}
