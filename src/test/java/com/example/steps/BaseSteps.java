package com.example.steps;

import com.example.context.TestContext;
import com.example.pages.*;
import com.example.utils.ConfigurationReader;
import com.example.utils.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BaseSteps {
    TestContext context;
    Scenario scenario;


    @Before
    public void beforeMethod(Scenario scenario) throws MalformedURLException, URISyntaxException {

        context = new TestContext();
        context.driver = DriverFactory.get(scenario);
        context.wait = new WebDriverWait(context.driver,
                Duration.ofSeconds(Long.parseLong(ConfigurationReader.get("timeout"))));
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

    @Given("user is on the maim page")
    public void user_is_home_page() {
        scenario.log("Main page");
    }

    @When("the user will go to the Alert page")
    public void theUserWillGoToTheAlertPage() {
        new MainPage(context).toAlerts();
    }

    @And("will go to the Alert history tab")
    public void willGoToTheAlertHistoryTab() {
        new AlertsPage(context).toAlertHistory();
    }

    @Then("then the list will contain an entry with a specific date")
    public void thenTheListWillContainAnEntryWithASpecificDate() {
        AlertsPage alertsPage = new AlertsPage(context);
        alertsPage.toAlertHistory();
        assertTrue(alertsPage.dateLookupInTable());
    }

    @When("user will go to the Accounts Overview page")
    public void user_will_go_to_the_Accounts_Overview_page() {
        new MainPage(context).toAccountsOverview();
    }

    @When("will go to the Special Offers & Deals tab")
    public void will_go_to_the_special_offers_deals_tab() {
        new AppPage(context).toSpecialOffers();
    }

    @Then("it have text  {string}")
    public void itHaveText(String arg0) {
        assertEquals(arg0, new AppPage(context).getTextSpecialOffers());
    }

    @And("will go to the Customized Cash Rewards Visa Signature")
    public void willGoToTheCustomizedCashRewardsVisaSignature() {
        new AppPage(context).toCustomizedCashRewardsVisaSignature();
    }

    @And("Go to the Accounts tab")
    public void goToTheAccountsTab() {
        new AccountDetailsPage(context).buttonActivity.click();
    }

    @Then("Check if there is a transaction with a balance amount of {string} in the list.")
    public void checkIfThereIsATransactionWithABalanceAmountOfInTheList(String summa) {
        assertTrue(new AccountDetailsPage(context).getTransactionAmount(summa));
    }

    @And("will Go to the Statements & Documents tab")
    public void willGoToTheStatementsDocumentsTab() {
        new AccountDetailsPage(context).gotoStatementsDocuments();
    }

    @Then("Check that there are {int} records in the table")
    public void checkThatThereAreRecordsInTheTable(int recordCount) {
        assertEquals(recordCount, new AccountDetailsPage(context).getSizeListDocuments());
    }

    @And("will go to the Update Profile")
    public void willGoToTheUpdateProfile() {
        new AppPage(context).toUpdateProfile();
    }

    @Then("Check that Primary email contains {string}.")
    public void checkThatPrimaryEmailContains(String email) {
        assertEquals(email, new ContactManagementPage(context).getPrimaryEmail());
    }

    @When("user will go to the Go to Accounts Overview page")
    public void userWillGoToTheGoToAccountsOverviewPage() {
        new MainPage(context).toAccountsOverview();
    }

    @And("user will go to the Pay Transfer page")
    public void userWillGoToThePayTransferPage() {
        new AppPage(context).toPayTransfer();
    }

    @When("Click on the Zelle button")
    public void clickOnTheZelleButton() {
        new TransferActivityHubPage(context).toZelle();
    }

    @And("In the window Send Money make a transfer")
    public void inTheWindowSendMoneyMakeATransfer() {
        SendMoneyOutsidePage sendMoneyOutsidePage = new SendMoneyOutsidePage(context);
        sendMoneyOutsidePage.formFilling();
        sendMoneyOutsidePage.makeTransfer();
    }

    @Then("Check  that in the new window there should be the inscription {string}.")
    public void checkThatInTheNewWindowThereShouldBeTheInscription(String arg0) {
        assertEquals(arg0, new SendMoneyOutsidePage(context).getTextFieldFrom());
    }

    @And("user will go to the Rewards & Deals page")
    public void userWillGoToTheRewardsDealsPage() {
        new AppPage(context).toRewardsDeals();
    }

    @And("Click on the plus sign on the Bayside block")
    public void clickOnThePlusSignOnTheBaysideBlock() {
        new CashBackDealsPage(context).markBayside();
    }

    @Then("Check  if the inscription {string} has appeared")
    public void checkIfTheInscriptionHasAppeared(String arg0) {
        assertEquals(arg0, new CashBackDealsPage(context).getTextResultBayside());
    }

    @When("user will go to the Transfers page")
    public void userWillGoToTheTransfersPage() {
        new MainPage(context).toTransferPage();
    }

    @And("user will go to the Between my accounts at Bank of America")
    public void userWillGoToTheBetweenMyAccountsAtBankOfAmerica() {
        new TransferPage(context).toBetweenMyAccount();
    }

    @When("user will Make a transfer in the amount of {string}")
    public void userWillMakeATransferInTheAmountOf(String arg0) {
        new TransferPage(context).executionTransfer(arg0);
    }

    @And("Click on the Transfer")
    public void clickOnTheTransfer() {
        new TransferPage(context).goTransfer();
    }

    @Then("Check the text: {string} has appeared")
    public void checkTheTextHasAppeared(String arg0) {
        assertEquals(arg0, new TransferPage(context).textResult());
    }

    @Then("Check whether the electricity bill has appeared in the Activity block")
    public void checkWhetherTheElectricityBillHasAppearedInTheActivityBlock() {
        assertTrue(new TransferActivityHubPage(context).searchBillEnergy());
    }

    @And("user will go to the Pay Security Center tab")
    public void userWillGoToThePaySecurityCenterTab() {
        new AppPage(context).toSecurityCenter();
    }

    @Then("Check if there is text in the box {string}")
    public void checkIfThereIsTextInTheBox(String arg0) {
        assertEquals(arg0, new SecurityDashboardPage(context).getTextSlider());
    }
}
