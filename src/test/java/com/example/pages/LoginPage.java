package com.example.pages;

import com.example.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//h3[@data-test='error']")
    public WebElement loginMessageContainer;

    @FindBy(css = "#user-name")
    public WebElement usernameInput;

    @FindBy(css = "#password")
    public WebElement passwordInput;

    @FindBy(css = "#login-button")
    public WebElement loginButton;

    public LoginPage(TestContext context){
        super(context);
    }
}