package HW4;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HW4Class11 {
WebDriver driver;
WebDriverWait Ex;

@BeforeTest
public void setup() {
System.setProperty("webdriver.chrome.driver","chromedriver.exe");
driver=new ChromeDriver ();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
Ex=new WebDriverWait(driver, 6);
}
	    
@Test (priority=0)
public void openurl() {
driver.get("http://automationpractice.com/index.php");	 
}
	    
@Test (priority=1, dependsOnMethods= {"openurl"})
public void signin() {
driver.findElement(By.className("login")).click(); 
String ExpectedURL="http://automationpractice.com/index.php?controller=authentication&back=my-account";
String ActualURL=driver.getCurrentUrl();
Assert.assertEquals(ActualURL, ExpectedURL);
System.out.println("Welcome to HomeWork 4!!!");
System.out.println("Signin Assertion Passed! Yes!!");
}

@Test (priority=2, dependsOnMethods= {"signin"})
public void enteremailaddress() {
driver.findElement(By.id("email_create")).sendKeys("sam1000000000000000000@gmail.com");
String ExpectedForm="create-account_form";
String ActualForm=driver.findElement(By.id("create-account_form")).getAttribute("id");
Assert.assertEquals(ActualForm, ExpectedForm);
System.out.println("Form was found");
driver.findElement(By.id("email_create")).clear();
driver.findElement(By.id("email_create")).sendKeys("sam1000000000000000000@gmail.com");
}
@Test (priority=3, dependsOnMethods= {"enteremailaddress"})
public void clicksubmit() {
WebElement SubmitCreate = driver.findElement(By.xpath("//button[@id='SubmitCreate']"));
SubmitCreate.click();
Assert.assertEquals(true, SubmitCreate.isEnabled());
System.out.println("SubmitCreate Button isEnabled Assert Passed");
}

@Test(priority=4,dependsOnMethods= {"clicksubmit"})
public void personalinfo() {
String ExpectedURL="http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation";
Ex.until(ExpectedConditions.urlToBe(ExpectedURL));
String ExpectedForm="account-creation_form";
String ActualForm=driver.findElement(By.id("account-creation_form")).getAttribute("id");
Assert.assertEquals(ActualForm, ExpectedForm);
System.out.println("Form was found");
}

@Test(priority=5, dependsOnMethods= {"personalinfo"})
public void selectMr() {
WebElement mr= driver.findElement(By.cssSelector("#id_gender1"));
mr.click();
Assert.assertEquals(true, mr.isSelected());
System.out.println("-----Mr Button is selected!!");
}

@Test(priority=6, dependsOnMethods= {"selectMr"})
public void firstName() {
WebElement Fname= driver.findElement(By.xpath("//input[@id='customer_firstname']"));
Fname.sendKeys("Sam");
Assert.assertEquals(true, Fname.isDisplayed());
System.out.println("-----First Name is Displayed!!");
}

@Test(priority=7, dependsOnMethods= {"firstName"})
public void lastName() {
WebElement Lname=	driver.findElement(By.xpath("//input[@id='customer_lastname'][@type='text']"));
Lname.sendKeys("Smith");
Assert.assertEquals(true, Lname.isDisplayed());
System.out.println("-----Last Name is Displayed!!");
}

@Test(priority=8, dependsOnMethods= {"lastName"})
public void Password() {
WebElement pass=driver.findElement(By.cssSelector("input[type$='rd']"));
pass.sendKeys("A123$bc00");
Assert.assertEquals(true, pass.isDisplayed());
System.out.println("-----Password is Displayed!!");
}

@Test(priority=9, dependsOnMethods= {"Password"})
public void selectdays(){
WebElement drpdays= driver.findElement(By.cssSelector("select[id='days']"));
drpdays.click();
Select Days = new Select (drpdays);
Days.selectByVisibleText("29  ");
String Option=Days.getFirstSelectedOption().getText();
Assert.assertEquals("29  ",Option);
System.out.println("-----Day is Selected!!");
}

@Test(priority=9, dependsOnMethods= {"selectdays"})
public void selectmonths(){
WebElement drpMonths=driver.findElement(By.cssSelector("select#months"));
drpMonths.click();
Select months=new Select(drpMonths);
months.selectByVisibleText("May ");
String Option= months.getFirstSelectedOption().getText();
Assert.assertEquals("May ",Option);
System.out.println("-----Month is Selected!!");
}

@Test(priority=10, dependsOnMethods= {"selectmonths"})
public void selectYears(){
WebElement drpYear= driver.findElement(By.xpath("//select[starts-with(@id,'years') or (@name='years')]"));
drpYear.click();
Select year=new Select(drpYear);
year.selectByVisibleText("2020  ");
String Option= year.getFirstSelectedOption().getText();
Assert.assertEquals("2020  ",Option);
System.out.println("-----Year is Selected!!");
}

@Test(priority=11, dependsOnMethods= {"selectYears"})
public void selectsignupnewsletter(){
WebElement newsletter=driver.findElement(By.cssSelector("#newsletter"));
newsletter.click();
Assert.assertEquals(true, newsletter.isSelected());
System.out.println("-----Newsletter Button is selected!!");
}

@Test(priority=12, dependsOnMethods= {"selectsignupnewsletter"})
public void selectspecialoffer(){
WebElement specialoffer=driver.findElement(By.cssSelector("input[id*='optin']"));
specialoffer.click();
Assert.assertEquals(true, specialoffer.isSelected());
System.out.println("-----Receive special offer Button is selected!!");
}

@Test(priority=13, dependsOnMethods= {"selectspecialoffer"})
public void Companyname(){
WebElement Comname=driver.findElement(By.cssSelector("input[id^='comp']"));
Comname.sendKeys("BB&C Co");
Assert.assertEquals(true, Comname.isDisplayed());
System.out.println("-----Company Name is Displayed!!");
}

@Test(priority=14, dependsOnMethods= {"Companyname"})
public void Address(){
WebElement ComAddress= driver.findElement(By.xpath("//*[@id='address1' or @name='address1']"));
ComAddress.sendKeys("123 ABCD ST");
Assert.assertEquals(true, ComAddress.isDisplayed());
System.out.println("-----Company Address is Displayed!!");
}
@Test(priority=15, dependsOnMethods= {"Address"})
public void City(){
WebElement city=driver.findElement(By.cssSelector("input[name$='ty']"));
city.sendKeys("Bangla City");
Assert.assertEquals(true, city.isDisplayed());
System.out.println("-----Company City is Displayed!!");
}
@Test(priority=16, dependsOnMethods= {"City"})
public void State(){
WebElement drpState=driver.findElement(By.cssSelector("select[id='id_state']"));
drpState.click();
Select State=new Select(drpState);
State.selectByVisibleText("Virginia");
String Option= State.getFirstSelectedOption().getText();
Assert.assertEquals("Virginia",Option);
System.out.println("-----State is Selected!!");	
}

@Test(priority=17, dependsOnMethods= {"State"})
public void ZipCode(){
WebElement zip=driver.findElement(By.xpath("//input[@id='postcode'][@name='postcode']"));
zip.sendKeys("12345");
Assert.assertEquals(true, zip.isDisplayed());
System.out.println("-----ZipCode is Displayed!!");
}

@Test(priority=17, dependsOnMethods= {"ZipCode"})
public void Additionalinfo(){
WebElement addinfo=driver.findElement(By.cssSelector("textarea[id='other']"));
addinfo.sendKeys("N/A");
Assert.assertEquals(true, addinfo.isDisplayed());
System.out.println("-----Additionalinfo note is Displayed!!");
}

@Test(priority=17, dependsOnMethods= {"Additionalinfo"})
public void PhoneNumber(){
WebElement homeph=driver.findElement(By.cssSelector("input[name^='pho']"));
homeph.sendKeys("703-000-0000");
Assert.assertEquals(true, homeph.isDisplayed());
System.out.println("-----Home Phone Number is Displayed!!");
}

@Test(priority=18, dependsOnMethods= {"PhoneNumber"})
public void MobileNumber(){
WebElement mobileph=driver.findElement(By.xpath("//input[starts-with(@name,'phone_mobile') or (@id='phone_mobile')]"));
mobileph.sendKeys("571-000-0000");
Assert.assertEquals(true, mobileph.isDisplayed());
System.out.println("-----Home Phone Number is Displayed!!");
}

@Test(priority=19, dependsOnMethods= {"MobileNumber"})
public void Assignanaddressforfuturereference(){
WebElement aliasAddress=driver.findElement(By.cssSelector("input[id='alias']"));
aliasAddress.sendKeys("SamLoveJoy@yahoo.gov");
Assert.assertEquals(true, aliasAddress.isDisplayed());
System.out.println("-----Assign an address alias an email Address is Displayed!!");
aliasAddress.clear();
aliasAddress.sendKeys("SamLoveJoy@yahoo.gov");
}

@AfterTest
public void closeTab() {
driver.close();
}
}
