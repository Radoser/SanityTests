package instabeat.pages;

import java.util.HashMap;
import java.util.Map;

import instabeat.utils.MainPagesFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GetStartedPage extends MainPagesFunc {

	public GetStartedPage(WebDriver driver) {
		super(driver);
		createRandomUser();
		createRandomNumbers(100, 250);
		map.put(parameters.FirstNameField, "TestAuto");
		map.put(parameters.LastNameField, "User");
		map.put(parameters.EmailField, randomUser);
		map.put(parameters.PasswordField, parameters.UserPassword);
		map.put(parameters.ConfirmNewPasswordField, parameters.UserPassword);
		map.put(parameters.DateOfBirthField, "5/5/2000");
		map.put(parameters.HeightField, randomNumbers);
		map.put(parameters.WeightField, randomNumbers);
	}

	private Map<String, String> map = new HashMap();

	public void typeUserValues() {
		for (String key : map.keySet()) {
			values(By.id(key), map.get(key));
		}
	}

	public GetSartedFirstStep clickOnSignUpButton() {
		SignUpButton.click();
//		click(By.xpath(parameters.SignUpButton));
		return PageFactory.initElements(driver, GetSartedFirstStep.class);
	}

	public void randomUserValues() {
		driver.findElement(By.id("firstName")).sendKeys(randomValues);
	}

}
