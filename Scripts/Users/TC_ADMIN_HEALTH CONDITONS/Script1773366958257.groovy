import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// ======================
// TEST DATA
// ======================

String code = 'AST'
String name = 'Asthma'

// ======================
// OPEN BROWSER
// ======================

WebUI.openBrowser('')
WebUI.maximizeWindow()

// ======================
// GO TO LOGIN PAGE
// ======================

WebUI.navigateToUrl('http://localhost:5173/login')

WebUI.waitForElementVisible(
findTestObject('Page_FoodLink Admin/Login_page/input_Email_email'),10)


// ======================
// LOGIN
// ======================

WebUI.setText(
findTestObject('Page_FoodLink Admin/Login_page/input_Email_email'),
'hienvo@gmail.com')

WebUI.setText(
findTestObject('Page_FoodLink Admin/Login_page/input_Password_password'),
'hienvo@123')

WebUI.click(
findTestObject('Page_FoodLink Admin/Login_page/button_Login'))

WebUI.waitForPageLoad(10)


// ======================
// GO TO HEALTH CONDITIONS PAGE
// ======================

WebUI.navigateToUrl('http://localhost:5173/health-conditions')

WebUI.waitForPageLoad(10)


// ======================
// VERIFY CREATE BUTTON DISABLED WHEN FORM EMPTY
// ======================

WebUI.click(
findTestObject('Page_FoodLink Admin/Health conditions/button_Add New'))

WebUI.waitForElementVisible(
findTestObject('Page_FoodLink Admin/Health conditions/input_Code_input'),10)

WebUI.verifyElementNotClickable(
findTestObject('Page_FoodLink Admin/Health conditions/button_Create'))

WebUI.click(
findTestObject('Page_FoodLink Admin/Health conditions/button_close_modal'))

WebUI.waitForElementNotVisible(
findTestObject('Page_FoodLink Admin/Health conditions/input_Code_input'),10)


// ======================
// ADD HEALTH CONDITION SUCCESS
// ======================

WebUI.click(
findTestObject('Page_FoodLink Admin/Health conditions/button_Add New'))

WebUI.waitForElementVisible(
findTestObject('Page_FoodLink Admin/Health conditions/input_Code_input'),10)

WebUI.setText(
findTestObject('Page_FoodLink Admin/Health conditions/input_Code_input'),
code)

WebUI.setText(
findTestObject('Page_FoodLink Admin/Health conditions/input_Name_input'),
name)

WebUI.waitForElementClickable(
findTestObject('Page_FoodLink Admin/Health conditions/button_Create'),10)

WebUI.click(
findTestObject('Page_FoodLink Admin/Health conditions/button_Create'))

// chờ modal đóng
WebUI.waitForElementNotVisible(
findTestObject('Page_FoodLink Admin/Health conditions/input_Code_input'),10)


// ======================
// VERIFY CREATED
// ======================

WebUI.verifyElementPresent(
findTestObject('Page_FoodLink Admin/Health conditions/row_AST'),10)


// ======================
// ADD DUPLICATE HEALTH CONDITION
// ======================

WebUI.click(
findTestObject('Page_FoodLink Admin/Health conditions/button_Add New'))

WebUI.waitForElementVisible(
findTestObject('Page_FoodLink Admin/Health conditions/input_Code_input'),10)

WebUI.setText(
findTestObject('Page_FoodLink Admin/Health conditions/input_Code_input'),
code)

WebUI.setText(
findTestObject('Page_FoodLink Admin/Health conditions/input_Name_input'),
name)

WebUI.click(
findTestObject('Page_FoodLink Admin/Health conditions/button_Create'))

WebUI.verifyTextPresent("already exists", false)

WebUI.click(
findTestObject('Page_FoodLink Admin/Health conditions/button_close_modal'))

//WebUI.waitForElementNotVisible(
//findTestObject('Page_FoodLink Admin/Health conditions/input_Code_input'),10)


// ======================
// EDIT INGREDIENT
// ======================

WebUI.click(
findTestObject('Page_FoodLink Admin/Health conditions/button_edit'))

WebUI.waitForElementVisible(
findTestObject('Page_FoodLink Admin/Health conditions/edit_Code_input'),10)
WebUI.clearText(
findTestObject('Page_FoodLink Admin/Health conditions/edit_Code_input'))

WebUI.setText(
findTestObject('Page_FoodLink Admin/Health conditions/edit_Code_input'),
'ATHSS')

WebUI.click(
findTestObject('Page_FoodLink Admin/Health conditions/button_update'))


WebUI.delay(5)

// ======================
// EDIT DUPLICATE INGREDIENT
// ======================


WebUI.click(
	findTestObject('Page_FoodLink Admin/Health conditions/button_edit2'))
	
	WebUI.waitForElementVisible(
	findTestObject('Page_FoodLink Admin/Health conditions/edit_Code_input2'),10)
	WebUI.clearText(
	findTestObject('Page_FoodLink Admin/Health conditions/edit_Code_input2'))
	
	WebUI.setText(
	findTestObject('Page_FoodLink Admin/Health conditions/edit_Code_input2'),
	'ATHSS')
	
	WebUI.click(
	findTestObject('Page_FoodLink Admin/Health conditions/button_update'))
	
WebUI.verifyTextPresent("Code 'ATHSS' already exists", false)
	
	WebUI.click(
	findTestObject('Page_FoodLink Admin/Health conditions/button_close_modal'))
	
	WebUI.delay(3)
	
// ======================
// SEARCH HEALTH CONDITION
// ======================
	
	WebUI.setText(
	findTestObject('Page_FoodLink Admin/Health conditions/input_search'),
	code)
	
	WebUI.verifyElementPresent(
	findTestObject('Page_FoodLink Admin/Health conditions/row_AST'),10)

// ======================
// DELETE HEALTH CONDITION
// ======================

WebUI.waitForElementClickable(
findTestObject('Page_FoodLink Admin/Health conditions/button_delete_AST'),10)

WebUI.click(
findTestObject('Page_FoodLink Admin/Health conditions/button_delete_AST'))

WebUI.waitForAlert(5)

WebUI.acceptAlert()


// ======================
// VERIFY DELETE
// ======================

WebUI.verifyElementNotPresent(
findTestObject('Page_FoodLink Admin/Health conditions/row_AST'),10)


// ======================
// CLOSE BROWSER
// ======================

WebUI.closeBrowser()// 