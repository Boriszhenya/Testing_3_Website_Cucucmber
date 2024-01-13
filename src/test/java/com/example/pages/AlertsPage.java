package com.example.pages;

import com.example.context.TestContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class AlertsPage extends BasePage {

    final int DELTA = 11;
    public AlertsPage(TestContext context) {
        super(context);
    }

    @FindBy(xpath = "//a[text()='Alert history']")
    public WebElement buttonAlertHistory;

    @FindBy(xpath = "//table//tr/td")
    public List<WebElement> listDateAlerts;

    public void toAlertHistory() {
        buttonAlertHistory.click();
    }

    public boolean dateLookupInTable() {
        YearMonth currentYearMonth = YearMonth.now();
        int daysCurrentMonth =currentYearMonth.lengthOfMonth();
        LocalDate newDate = LocalDate.now().minusDays(daysCurrentMonth+DELTA);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/d/yyyy");
        String formattedDate = newDate.format(formatter);
        for (WebElement al : listDateAlerts) {
            if (al.getText().equals(formattedDate)) {
                return true;
            }
        }
        return false;
    }
}
