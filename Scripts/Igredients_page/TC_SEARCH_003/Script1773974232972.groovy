import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebElement
import com.kms.katalon.core.webui.common.WebUiCommonHelper

// ======================
// OPEN BROWSER
// ======================
WebUI.openBrowser('')
WebUI.maximizeWindow()

// ======================
// LOGIN
// ======================
WebUI.navigateToUrl('http://localhost:5173/login')

WebUI.waitForElementVisible(
	findTestObject('Page_FoodLink Admin/Login_page/input_Email_email'), 10)

WebUI.setText(
	findTestObject('Page_FoodLink Admin/Login_page/input_Email_email'),
	'datpham@gmail.com')

WebUI.setText(
	findTestObject('Page_FoodLink Admin/Login_page/input_Password_password'),
	'vohien123')

WebUI.click(findTestObject('Page_FoodLink Admin/Login_page/button_Login'))

WebUI.waitForPageLoad(10)
WebUI.delay(2)

// ======================
// GO TO INGREDIENT PAGE
// ======================
WebUI.navigateToUrl('http://localhost:5173/ingredients')
WebUI.delay(2)

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI



// ======================
// TC011 - SEARCH BY NAME
// ======================
WebUI.setText(
	findTestObject('Page_FoodLink Admin/Ingredients/input_search'),
	'Chicken'
)

WebUI.delay(2)

// verify result contains Chicken
WebUI.verifyTextPresent('Chicken', false)


// ======================
// TC012 - SEARCH BY CATEGORY
// ======================
WebUI.clearText(findTestObject('Page_FoodLink Admin/Ingredients/input_search'))

WebUI.setText(
	findTestObject('Page_FoodLink Admin/Ingredients/input_search'),
	'Meat'
)

WebUI.delay(2)

WebUI.verifyTextPresent('Meat', false)


// ======================
// TC013 - PARTIAL SEARCH
// ======================
WebUI.clearText(findTestObject('Page_FoodLink Admin/Ingredients/input_search'))

WebUI.setText(
	findTestObject('Page_FoodLink Admin/Ingredients/input_search'),
	'Chick'
)

WebUI.delay(2)

WebUI.verifyTextPresent('Chicken', false)


// ======================
// TC014 - INVALID SEARCH
// ======================
WebUI.clearText(findTestObject('Page_FoodLink Admin/Ingredients/input_search'))

WebUI.setText(
	findTestObject('Page_FoodLink Admin/Ingredients/input_search'),
	'xyz123'
)

WebUI.delay(2)

// verify no data message
WebUI.verifyTextPresent('No ingredients found', false)



// ======================
// END
// ======================
WebUI.closeBrowser()



