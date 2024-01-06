package com.example.steps;

import com.example.context.TestContext;
import com.example.pages.CartPage;
import com.example.pages.LoginPage;
import com.example.pages.MainPage;
import com.example.utils.ConfigurationReader;
import com.example.utils.DriverFactory;
import io.cucumber.java.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExampleSteps {
    TestContext context;

    Scenario scenario;

    @Before
    public void beforeMethod(Scenario scenario) {
        context = new TestContext();
        context.driver = DriverFactory.get();
        context.wait = new WebDriverWait(context.driver, Duration.ofSeconds(Long.parseLong(ConfigurationReader.get("timeout"))));
        context.actions = new Actions(context.driver);
        context.js = (JavascriptExecutor) context.driver;
        context.driver.get(ConfigurationReader.get("base_url"));
        this.scenario = scenario;
    }

    @After
    public void afterMethod(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) context.driver;

            byte[] src = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(src, "image/png", "screenshot");
        }
        if (context.driver != null) {
            context.driver.quit();
        }
    }

    @BeforeStep
    public void beforeEveryStep() {
        scenario.log("Current URL: " + context.driver.getCurrentUrl());
    }

    @Given("user enter login page")
    public void user_enter_login_page() {
        scenario.log("Entered login page");
    }

    @When("user enters valid credentials")
    public void user_enters_valid_credentials() {
        LoginPage lp = new LoginPage(context);
        lp.usernameInput.sendKeys(ConfigurationReader.get("standard_login"));
        lp.passwordInput.sendKeys(ConfigurationReader.get("password"));
    }

    @When("clicks login button")
    public void clicks_login_button() {
        LoginPage lp = new LoginPage(context);
        lp.loginButton.click();
    }

    @When("user adds first product to the cart")
    public void user_adds_first_product_to_the_cart() {
        MainPage mp = new MainPage(context);
        mp.addToCartButtons.getFirst().click();
    }

    @When("user adds product with name {string} to the cart")
    public void user_adds_product_with_name_to_the_cart(String expectedText) {
        MainPage mp = new MainPage(context);
        mp.addToCartByPartialName(expectedText);
    }

    @Then("amount of products in the cart is {int}")
    public void amount_of_products_in_the_cart_is(Integer amount) {
        assertEquals(Integer.parseInt(new MainPage(context).shoppingCartLink.getText()), amount);
    }

    @Then("cart page opens")
    public void cart_page_opens() {
        CartPage cp = new CartPage(context);
        MainPage mp = new MainPage(context);
        mp.buttonCart.click();
        assertTrue(cp.headerCartPage.isDisplayed());
    }

    @Then("check the product name in the cart")

    public void check_the_product_name_in_the_cart() {
        CartPage cp = new CartPage(context);
        assertTrue(cp.nameProduct.getText().contains("Onesie"));
    }

    @Then("main page opens")
    public void main_page_opens() {
        MainPage mp = new MainPage(context);
        assertTrue(mp.firstDescriptionContainer.isDisplayed());
    }

    @Then("it have text in footer {string}")
    public void it_have_text_in_footer(String expectedText) {
        MainPage mp = new MainPage(context);
        assertTrue(mp.footer.getText().contains(expectedText));
    }

    @When("user enters login {word} and password {string}")
    public void userEntersLoginAndPassword(String login, String password) {
        LoginPage lp = new LoginPage(context);
        lp.usernameInput.sendKeys(login);
        lp.passwordInput.sendKeys(password);
    }

    @Then("error message contains text {string}")
    public void errorMessageContainsText(String expectedErrorMessage) {
        String actualText = new LoginPage(context).loginMessageContainer.getText();
        scenario.log(String.format("expectedText: %s;\r\nactualText: %s", expectedErrorMessage, actualText));
        assertTrue(actualText.contains(expectedErrorMessage));
    }
}
