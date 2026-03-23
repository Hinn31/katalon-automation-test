import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


// ======================
// OPEN BROWSER
// ======================

WebUI.openBrowser('')
WebUI.maximizeWindow()

// ======================
// GO TO LOGIN PAGE
// ======================

WebUI.navigateToUrl('http://localhost:5173/login')

// Wait email field appear
WebUI.waitForElementVisible(
findTestObject('Page_FoodLink Admin/Login_page/input_Email_email'), 10)


// ======================
// LOGIN
// ======================

// Enter email
WebUI.setText(
findTestObject('Page_FoodLink Admin/Login_page/input_Email_email'),
'datpham@gmail.com')

// Enter password
WebUI.setText(
findTestObject('Page_FoodLink Admin/Login_page/input_Password_password'),
'vohien123')

// Click Login button
WebUI.click(findTestObject('Page_FoodLink Admin/Login_page/button_Login'))

// ĐỢI LOGIN XONG
WebUI.waitForPageLoad(10)
WebUI.delay(2)

// ======================
// GO TO USERS PAGE
// ======================

WebUI.navigateToUrl('http://localhost:5173/ingredients')

// ======================
// TC020 - CREATE SUCCESS
// ======================
WebUI.click(findTestObject('Page_FoodLink Admin/Ingredients/button_Add New'))
WebUI.setText(findTestObject('Page_FoodLink Admin/Ingredients/input_name'), 'Chicken Test')
WebUI.setText(
	findTestObject('Page_FoodLink Admin/Ingredients/input_category'),
	'Meat')
	
	WebUI.setText(
	findTestObject('Page_FoodLink Admin/Ingredients/input_unit'),
	'g')
WebUI.setText(findTestObject('Page_FoodLink Admin/Ingredients/input_price'), '100')
WebUI.setText(findTestObject('Page_FoodLink Admin/Ingredients/input_stock'), '50')
	

WebUI.setText(
	findTestObject('Page_FoodLink Admin/Ingredients/input_received_date'),
	'03/20/2026'
)

WebUI.setText(
	findTestObject('Page_FoodLink Admin/Ingredients/input_expiration_date'),
	'03/30/2026'
)

WebUI.setText(
	findTestObject('Page_FoodLink Admin/Ingredients/input_image_url'),
	'https://example.com/chicken.jpg'
)

	WebUI.setText(
	findTestObject('Page_FoodLink Admin/Ingredients/input_calories'),
	'200')
	
	WebUI.setText(
	findTestObject('Page_FoodLink Admin/Ingredients/input_protein'),
	'25')
	
	WebUI.setText(
	findTestObject('Page_FoodLink Admin/Ingredients/input_carb'),
	'5')
	
	WebUI.setText(
	findTestObject('Page_FoodLink Admin/Ingredients/input_fat'),
	'12')
WebUI.click(findTestObject('Page_FoodLink Admin/Ingredients/button_create'))


// ======================
// TC025 - DUPLICATE NAME
// ======================
WebUI.click(findTestObject('Page_FoodLink Admin/Ingredients/button_Add New'))
WebUI.setText(findTestObject('Page_FoodLink Admin/Ingredients/input_name'), 'Chicken Breast')
WebUI.setText(findTestObject('Page_FoodLink Admin/Ingredients/input_price'), '100')
WebUI.setText(findTestObject('Page_FoodLink Admin/Ingredients/input_stock'), '50')
WebUI.click(findTestObject('Page_FoodLink Admin/Ingredients/button_create'))
// VERIFY ERROR MESSAGE
WebUI.verifyElementVisible(
findTestObject('Page_FoodLink Admin/Ingredients/text_duplicate_error'))

WebUI.click(findTestObject('Page_FoodLink Admin/Ingredients/button_close'))


// ======================
// DELETE INGREDIENT
// ======================

WebUI.click(
findTestObject('Page_FoodLink Admin/Ingredients/button_delete'))

WebUI.delay(2)


//// CONFIRM DELETE
// chờ alert xuất hiện
WebUI.waitForAlert(5)

// click OK
WebUI.acceptAlert()

WebUI.delay(2)


// VERIFY DELETE

WebUI.verifyElementNotPresent(
findTestObject('Page_FoodLink Admin/Ingredients/Deleted_successfully'),
10)
// ======================
// END
// ======================
WebUI.closeBrowser()