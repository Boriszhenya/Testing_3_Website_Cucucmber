package com.example.pages;

import com.example.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SecurityDashboardPage extends BasePage {
    public SecurityDashboardPage(TestContext context) {
        super(context);
    }

    @FindBy(xpath = "//div[@class='carousel-caption d-none d-md-block']/p")
    public WebElement textSlider;

    public String getTextSlider() {
        return textSlider.getText();
    }

}
