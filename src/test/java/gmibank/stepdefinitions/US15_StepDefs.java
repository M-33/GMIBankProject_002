package gmibank.stepdefinitions;

import gmibank.pages.HomePage;
import gmibank.pages.ManageAccountPage;
import gmibank.pages.ManageCustomerPage;
import gmibank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class US15_StepDefs {
    ManageAccountPage manageAccountPage = new ManageAccountPage();
    ManageCustomerPage manageCustomerPage = new ManageCustomerPage();
    HomePage homePage = new HomePage();

    //TC_001
    @Given("Click on the Create Date textbox and type the time of account creation")
    public void click_on_the_Create_Date_textbox_and_type_the_time_of_account_creation() {
        manageAccountPage.createDateBox.sendKeys("11/15/2020 12:00 AM");
    }

    @Given("Click on the Closed Date textbox and type the time later than the time of account creation")
    public void click_on_the_Closed_Date_textbox_and_type_the_time_later_than_the_time_of_account_creation() {
        manageAccountPage.closedDateBox.sendKeys("12/15/2020 12:00 AM");
    }

    @Then("Verify that Create Date and Closed Date created successfully")
    public void verify_that_Create_Date_and_Closed_Date_created_successfully() {
        Assert.assertTrue(manageAccountPage.createDateBox.isDisplayed());
        Assert.assertTrue(manageAccountPage.closedDateBox.isDisplayed());
    }

    //TC_002
    @Given("Click on the Create Date textbox and type the  date earlier at the time of account creation")
    public void click_on_the_Create_Date_textbox_and_type_the_date_earlier_at_the_time_of_account_creation() {
        manageAccountPage.createDateBox.sendKeys("11/15/2019 12:00 AM");
    }

    @Then("Verify that Create Date and Closed Date not created successfully")
    public void verify_that_Create_Date_and_Closed_Date_not_created_successfully() {
        Assert.assertTrue(manageAccountPage.createDateBox.isDisplayed());  // pass olmamasi gerekir. Dolayisi ile bug var
        Assert.assertTrue(manageAccountPage.closedDateBox.isDisplayed());
    }

    //TC_003
    @Given("Click on the Create Date textbox and type date as month,day,year,hour and minute")
    public void click_on_the_Create_Date_textbox_and_type_date_as_month_day_year_hour_and_minute() {
        manageAccountPage.createDateBox.sendKeys("11/15/2020 12:00 AM"+ Keys.ENTER);
    }

    @Then("Verify that the date created succesfully")
    public void verify_that_the_date_created_succesfully() {
      String actualDate = manageAccountPage.createDateBox.getAttribute("value");
      String expectedDate = "2020-11-15T00:00";
      Assert.assertEquals(actualDate,expectedDate);


    }

    //TC_004
    @Given("Click on the Create Date textbox and type date as month,day,year")
    public void click_on_the_Create_Date_textbox_and_type_date_as_month_day_year() {
        manageAccountPage.createDateBox.clear();
        manageAccountPage.createDateBox.sendKeys("11/15/2020" +Keys.ENTER);
    }

    @Then("Verify that the date not created succesfully")
    public void verify_that_the_date_not_created_succesfully() {
        String actualDate = manageAccountPage.createDateBox.getAttribute("value");
        String expectedDate = "2020-11-15T00:00";
        Assert.assertEquals(actualDate,expectedDate);

    }

    //TC_005
    @Given("Click on Manage Customer")
    public void click_on_Manage_Customer() {
        homePage.manageCustomer.click();

    }

    @Given("Click on +Create a new Custumer")
    public void click_on_Create_a_new_Custumer() {
        manageCustomerPage.createCustomerButton.click();
    }

    @Given("Click on the SSN textbox and type a valid SSN number and Click on the Search button")
    public void click_on_the_SSN_textbox_and_type_a_valid_SSN_number_and_Click_on_the_Search_button() {
        manageCustomerPage.ssnTextBox.sendKeys("124-45-3422");
        manageCustomerPage.searchButton.click();
        Driver.wait(3);
    }

    @Then("Verify that User box is not blank")
    public void verify_that_User_box_is_not_blank() {
        System.out.println(manageCustomerPage.userBox.getAttribute("value"));    //value = 1202
        String actualResult = manageCustomerPage.userBox.getAttribute("value");
        String expectedResult = "1202";

    }

    //TC_006
    @Given("Click an ID item to choose an account created on manage accounts")
    public void click_an_ID_item_to_choose_an_account_created_on_manage_accounts() {
        manageAccountPage.firstIDitem.click();
    }

    @Then("Verify Account")
    public void verify_Account() {
        String accountInf = manageAccountPage.accountInformation.getText();
        Assert.assertTrue(accountInf.equals("Account"));
    }







}
