package com.lbg.project.selenium;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@TestMethodOrder(OrderAnnotation.class)
@Sql(scripts = { "classpath:frontend-schema.sql",
		"classpath:frontend-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)

public class ProjectTest {

	private RemoteWebDriver driver;
//	private WebDriverWait wait;

	@LocalServerPort
	private int port;

	@BeforeEach
	void init() {
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@Test
	@Order(1)
//	create buyer

	void testCreateBuyer() {
		this.driver.get("http://localhost:" + this.port);

		WebElement clickBuyer = this.driver
				.findElement(By.cssSelector("#root > div > nav > div > a:nth-child(3) > button"));
		clickBuyer.click();

		WebElement fName = this.driver.findElement(By.cssSelector("#firstName"));
		fName.sendKeys("Lucy");

		WebElement sName = this.driver.findElement(By.cssSelector("#lastName"));
		sName.sendKeys("Yates");

		WebElement register = this.driver
				.findElement(By.cssSelector("#root > div > div > div.col-6 > form > div > div > button"));
		register.click();

		WebElement created = this.driver
				.findElement(By.cssSelector("#root > div > div > div.col-4 > div > div:nth-child(2) > div > p.col"));
		Assertions.assertEquals("Lucy Yates", created.getText());

		WebElement Delete = this.driver.findElement(By
				.cssSelector("#root > div > div > div.col-4 > div > div:nth-child(2) > div > p:nth-child(2) > button"));
		Delete.click();

//		this code failed due to no function in react...

	}

	@Test
	@Order(2)
	void testCreateSeller() {
		this.driver.get("http://localhost:" + this.port);

		WebElement clickSeller = this.driver
				.findElement(By.cssSelector("#root > div > nav > div > a:nth-child(4) > button"));
		clickSeller.click();

		WebElement fNames = this.driver.findElement(By.cssSelector("#firstName"));
		fNames.sendKeys("Craig");

		WebElement sNames = this.driver.findElement(By.cssSelector("#lastName"));
		sNames.sendKeys("Morris");

		WebElement registers = this.driver
				.findElement(By.cssSelector("#root > div > div > div.col-6 > form > div > div > button"));
		registers.click();

		WebElement createdSeller = this.driver
				.findElement(By.cssSelector("#root > div > div > div.col-4 > div > div:nth-child(2) > div > p.col"));
		Assertions.assertEquals("Craig Morris", createdSeller.getText());

		WebElement Deletes = this.driver.findElement(By
				.cssSelector("#root > div > div > div.col-4 > div > div:nth-child(2) > div > p:nth-child(2) > button"));
		Deletes.click();

		// this code failed due to no function in react...

	}

	@Test
	@Order(3)
	void testAddPropety() throws InterruptedException {
		this.driver.get("http://localhost:" + this.port);
		WebElement clickAddProperty = this.driver
				.findElement(By.cssSelector("#root > div > nav > div > a:nth-child(6) > button"));
		clickAddProperty.click();

		WebElement addAddress = this.driver.findElement(By.cssSelector("#address"));
		addAddress.sendKeys("1 main street");

		WebElement addCity = this.driver.findElement(By.cssSelector("#city"));
		addCity.sendKeys("London");

		WebElement clickAddType = this.driver.findElement(By.cssSelector(
				"#root > div > div > form > div.container > div:nth-child(1) > div:nth-child(3) > select > option:nth-child(1)"));
		clickAddType.click();

		WebElement clickSelectFlat = this.driver.findElement(By.cssSelector(
				"#root > div > div > form > div.container > div:nth-child(1) > div:nth-child(3) > select > option:nth-child(6)"));
		clickSelectFlat.click();

		WebElement addPrice = this.driver.findElement(By.cssSelector("#price"));
		addPrice.sendKeys("250000");

		WebElement clickAddBedroom = this.driver.findElement(By.cssSelector(
				"#root > div > div > form > div.container > div:nth-child(2) > div:nth-child(2) > select > option:nth-child(1)"));
		clickAddBedroom.click();

		WebElement clickSelect4 = this.driver.findElement(By.cssSelector(
				"#root > div > div > form > div.container > div:nth-child(2) > div:nth-child(2) > select > option:nth-child(5)"));
		clickSelect4.click();

		WebElement clickAddBathroom = this.driver.findElement(By.cssSelector(
				"#root > div > div > form > div.container > div:nth-child(2) > div:nth-child(3) > select > option:nth-child(1)"));
		clickAddBathroom.click();

		WebElement clickSelect2 = this.driver.findElement(By.cssSelector(
				"#root > div > div > form > div.container > div:nth-child(2) > div:nth-child(3) > select > option:nth-child(3)"));
		clickSelect2.click();

		WebElement clickAddGarden = this.driver.findElement(By.cssSelector(
				"#root > div > div > form > div.container > div:nth-child(3) > div:nth-child(1) > select > option:nth-child(1)"));
		clickAddGarden.click();

		WebElement clickSelectNo = this.driver.findElement(By.cssSelector(
				"#root > div > div > form > div.container > div:nth-child(3) > div:nth-child(1) > select > option:nth-child(3)"));
		clickSelectNo.click();

		WebElement clickAddStatus = this.driver.findElement(By.cssSelector(
				"#root > div > div > form > div.container > div:nth-child(3) > div:nth-child(2) > select > option:nth-child(1)"));
		clickAddStatus.click();

		WebElement clickSelectForSale = this.driver.findElement(By.cssSelector(
				"#root > div > div > form > div.container > div:nth-child(3) > div:nth-child(2) > select > option:nth-child(2)"));
		clickSelectForSale.click();

		WebElement addImage = this.driver.findElement(By.cssSelector("#image"));
		addImage.sendKeys("house");

		WebElement clickSubmit = this.driver
				.findElement(By.cssSelector("#root > div > div > form > div.mt-2 > button"));
		clickSubmit.click();

		WebElement clickSold = this.driver.findElement(By.cssSelector(
				"#root > div > div > div > div > div:nth-child(2) > div > div > div > div > button.btn.btn-warning"));
		this.driver.executeScript("arguments[0].scrollIntoView(true);", clickSold);
		Thread.sleep(500);
		clickSold.click();

		WebElement clickWithdraw = this.driver.findElement(
				By.cssSelector("#root > div > div > div > div > div > div > div > div > div > button.btn.btn-danger"));
		clickWithdraw.click();

		WebElement clickForSale = this.driver.findElement(By
				.cssSelector("#root > div > div > div > div > div > div > div > div > div > button.btn.btn-secondary"));
		clickForSale.click();

		WebElement clickBooking = this.driver.findElement(By
				.cssSelector("#root > div > div > div > div > div:nth-child(1) > div > div > button.btn.btn-success"));
		clickBooking.click();

		WebElement selectDate = this.driver
				.findElement(By.cssSelector("#root > div > div > div.col-6 > form > div > input"));
		selectDate.sendKeys("04-11-2023");

		WebElement selectTime = this.driver.findElement(By
				.cssSelector("#root > div > div > div.col-6 > form > div > select:nth-child(4) > option:nth-child(4)"));
		selectTime.click();

		WebElement selectBuyer = this.driver.findElement(By
				.cssSelector("#root > div > div > div.col-6 > form > div > select:nth-child(6) > option:nth-child(2)"));
		selectBuyer.click();

		WebElement clickSubmitBooking = this.driver
				.findElement(By.cssSelector("#root > div > div > div.col-6 > form > div > button"));
		clickSubmitBooking.click();

		WebElement checkBooking = this.driver
				.findElement(By.cssSelector("#root > div > div > div.col-6 > div > div:nth-child(2) > p:nth-child(1)"));
		Assertions.assertEquals("Buyer: Mike Atkoo", checkBooking.getText());
	}

	@Test
	@Order(4)
	void HomePageTest() throws InterruptedException {
		this.driver.get("http://localhost:" + this.port);
		WebElement homePage = this.driver
				.findElement(By.cssSelector("#root > div > nav > div > a:nth-child(2) > button"));
		homePage.click();

		WebElement changeTheme = this.driver.findElement(By.cssSelector("#root > div > nav > div > button"));
		changeTheme.click();

		WebElement map = this.driver.findElement(By.cssSelector("#root > div > div > div > a > p > b"));
		map.click();

		driver.findElement(By.linkText("B5 4BE - Google Maps")).click();
		WebElement cookies = this.driver.findElement(By.cssSelector(
				"#yDmH0d > c-wiz > div > div > div > div.NIoIEf > div.G4njw > div.AIC7ge > div.CxJub > div.VtwTSb > form:nth-child(2) > div > div > button > div.VfPpkd-RLmnJb"));
		cookies.click();
//		Thread.sleep(2000);
	}
}
