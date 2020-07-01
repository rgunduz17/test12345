package Tests.VehicleFuelLogs;

import Tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AccessVehicleFuelLogTest extends TestBase {

    /*ı

9.As an authorized user I should be able to access Vehicle Fuel logs

"1.Verify that only authorized user can access Vehicle Fuel logs (Note: authorized user:
truck driver and admin )
2.Verify that non authorized user should not be able to access Vehicle Fuel Logs(Non authorized
user : Store manager, Sales manager)"

     */

   // User Acceptance Criteria 1:

    @Test(dataProvider = "getData1" , priority = 1)
    public void TruckDriversAccessToVehicleFuelLogs(String username, String password) throws InterruptedException {

     extentLogger = report.createTest(" Validate Truck Drivers Access to Vehicle Fuel Logs ");

     extentLogger.info("Checking Truck drivers Access to Vehicles Fuel Logs ");

     driver.findElement(By.id("prependedInput")).sendKeys(username);
     extentLogger.info("Username entered");

     driver.findElement(By.id("prependedInput2")).sendKeys(password);
     extentLogger.info("Password entered");

     WebElement loginButton = driver.findElement(By.id("_submit"));
     loginButton.click();
     extentLogger.info("Clicked login button");

     Actions actions =new Actions(driver);

     WebElement fleetDropdown = driver.findElement(By.linkText("Fleet"));
     actions.moveToElement(fleetDropdown).build().perform();
     extentLogger.info("Move to Fleet dropdown and panel will be open");
     Thread.sleep(1000);


     WebElement vehiclesFuelLogsLink = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/div/div/ul/li[7]/a"));
     vehiclesFuelLogsLink.click();
     extentLogger.info("Clicked on Vehicles Fuel Logs Link");

     Thread.sleep(3000);

     String expected = driver.getTitle();
     String actual = "Vehicle Fuel Logs - Entities - System - Car - Entities - System";
     Assert.assertEquals(expected,actual);
     extentLogger.info("Validating successfully accessed to Vehicle Fuel Logs");

    }

    @DataProvider
    public Object  [][] getData1() {
     return new Object [][]{
      {"user22", "UserUser123"},
      {"user23", "UserUser123"}
     };
    }

    // User Acceptance Criteria 2:

    @Test(dataProvider = "getData2" , priority = 2)
    public void AdminsAccessToVehicleFuelLogs(String username, String password) throws InterruptedException {

        extentLogger = report.createTest(" Validate Admins Access to Vehicle Fuel Logs ");

        extentLogger.info("Checking Admins Access to Vehicles Fuel Logs ");

        driver.findElement(By.id("prependedInput")).sendKeys(username);
        extentLogger.info("Username entered");

        driver.findElement(By.id("prependedInput2")).sendKeys(password);
        extentLogger.info("Password entered");

        WebElement loginButton = driver.findElement(By.id("_submit"));
        loginButton.click();
        extentLogger.info("Clicked login button");

        Actions actions =new Actions(driver);

        WebElement fleetDropdown = driver.findElement(By.linkText("Fleet"));
        actions.moveToElement(fleetDropdown).build().perform();
        extentLogger.info("Move to Fleet dropdown and panel will be open");
        Thread.sleep(1000);

        WebElement vehiclesFuelLogsLink = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[7]/a"));
        vehiclesFuelLogsLink.click();
        extentLogger.info("Clicked on Vehicles Fuel Logs Link");


        Thread.sleep(3000);
        // if test fails, check the flash message holder
        // //*[@id="flash-messages"]/div/div
        String expected = driver.findElement(By.xpath("//*[@id=\"flash-messages\"]/div/div/div[2]/div")).getText();
        String actual = "You do not have permission to perform this action.";
        Assert.assertEquals(expected,actual);
        extentLogger.info("Validating Admins should not be able to access to Vehicle Fuel Logs");

    }



    @DataProvider
    public Object  [][] getData2() {
        return new Object [][]{
                {"storemanager65","UserUser123"},
                {"storemanager66","UserUser123"},
                {"salesmanager122","UserUser123"},
                {"salesmanager123","UserUser123"},
                {"salesmanager124","UserUser123"},

        };
    }

}
