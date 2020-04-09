package Com.homedepot.auto.BootCamp;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class HomeDepot_locat {
		
		public static WebDriver driver=null;
		
		@FindBy (linkText="My Account")
		WebElement myAccountLink;
		
		@FindBy (linkText="Register")
		WebElement registerButton;
		
		@FindBy (xpath="//input[@id='email']")
		WebElement emailField;
		
		@FindBy (xpath="//input[@id='password-input-field']")
		WebElement passwordField;
		
		@FindBy(id="showPasswordCheck")
		WebElement showPassword;
		
		@FindBy (id="zipCode")
		WebElement zipCodeField;
		
		@FindBy (id="phone")
		WebElement phoneNumberField;
		
		@FindBy (xpath="//label[@for='verify-phone-checkbox']")
		WebElement phoneNumberVerifyCheck;
		
		@FindBy (xpath="//button[@data-automation-id='registrationCreateAnAccountButton']")
		WebElement accountRegisterButton;
		
		public HomeDepot_locat(WebDriver driver) {
			HomeDepot_locat.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		public void myAccountClick() {
			myAccountLink.click();		
		}
		public void registerClick() {
			registerButton.click();
		}
		public void emailFill(String email) {
			//driver.switchTo().alert();
			emailField.sendKeys(email);
		}
		public void passwordFill(String pass) {
			passwordField.sendKeys(pass);
		}
		public void showPasswordClick() {
			showPassword.click();
		}
		public void zipCodeFill(String zip) {
			zipCodeField.sendKeys(zip);
		}
		public void phoneNumberFil(String phone) {
			phoneNumberField.sendKeys(phone);
			}
		public void phoneNumberVerifyClick() {
			phoneNumberVerifyCheck.click();
		}
		public void accountRegisterBtnClick() {
			accountRegisterButton.click();
		}
		public void refreshPage() {
			driver.navigate().refresh();
		}
		
	}

