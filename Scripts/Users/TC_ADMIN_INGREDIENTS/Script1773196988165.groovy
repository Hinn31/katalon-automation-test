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
'hienvo@gmail.com')

// Enter password
WebUI.setText(
findTestObject('Page_FoodLink Admin/Login_page/input_Password_password'),
'hienvo@123')

// Click Login button
WebUI.click(
findTestObject('Page_FoodLink Admin/Login_page/button_Login'))

// Wait page load
WebUI.waitForPageLoad(10)


// ======================
// GO TO USERS PAGE
// ======================

WebUI.navigateToUrl('http://localhost:5173/ingredients')

WebUI.waitForElementVisible(
findTestObject('Page_FoodLink Admin/Ingredients/title_page'),10)


// ======================
// CHECK TOTAL INGREDIENT
// ======================

//// Wait element hiển thị
WebUI.waitForElementVisible(
findTestObject('Page_FoodLink Admin/Ingredients/text_total'),
10)

// Lấy text
String totalText = WebUI.getText(
findTestObject('Page_FoodLink Admin/Ingredients/text_total'))

println("Total text: " + totalText)

// Lấy số từ text "Total 6 ingredients"
def totalNumber = totalText.replaceAll("[^0-9]", "")

println("Total number: " + totalNumber)


// ======================
// ADD INGREDIENT
// ======================

WebUI.click(
findTestObject('Page_FoodLink Admin/Ingredients/button_Add New'))
WebUI.waitForElementVisible(
	findTestObject('Page_FoodLink Admin/Ingredients/input_name'),10)
WebUI.setText(
findTestObject('Page_FoodLink Admin/Ingredients/input_name'),
'Test Beef')

WebUI.setText(
findTestObject('Page_FoodLink Admin/Ingredients/input_category'),
'Meat')

WebUI.setText(
findTestObject('Page_FoodLink Admin/Ingredients/input_unit'),
'g')

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

WebUI.click(
findTestObject('Page_FoodLink Admin/Ingredients/button_create'))

WebUI.delay(3)

WebUI.waitForElementNotVisible(
	findTestObject('Page_FoodLink Admin/Ingredients/modal_overlay'),
	10)



// ======================
// EDIT INGREDIENT
// ======================

WebUI.click(
findTestObject('Page_FoodLink Admin/Ingredients/button_edit_test_beef'))

WebUI.waitForElementVisible(
findTestObject('Page_FoodLink Admin/Ingredients/input_name'),10)

WebUI.clearText(
findTestObject('Page_FoodLink Admin/Ingredients/input_name'))

WebUI.setText(
findTestObject('Page_FoodLink Admin/Ingredients/input_name'),
'Test Beef Updated')

WebUI.click(
findTestObject('Page_FoodLink Admin/Ingredients/button_update'))

WebUI.delay(3)



//// ======================
//// SEARCH INGREDIENT
//// ======================

WebUI.setText(
findTestObject('Page_FoodLink Admin/Ingredients/input_search'),
'Test Beef Updated')

WebUI.verifyElementPresent(
findTestObject('Page_FoodLink Admin/Ingredients/row_test_beef_updated'),
10)



// ======================
// DELETE INGREDIENT
// ======================

WebUI.click(
findTestObject('Page_FoodLink Admin/Ingredients/button_delete_test_beef_updated'))

WebUI.delay(2)


//// CONFIRM DELETE
// chờ alert xuất hiện
WebUI.waitForAlert(5)

// click OK
WebUI.acceptAlert()

WebUI.delay(2)


// VERIFY DELETE

WebUI.verifyElementNotPresent(
findTestObject('Page_FoodLink Admin/Ingredients/row_test_beef_updated'),
10)


// ======================
// CLOSE BROWSER
// ======================

WebUI.closeBrowser()