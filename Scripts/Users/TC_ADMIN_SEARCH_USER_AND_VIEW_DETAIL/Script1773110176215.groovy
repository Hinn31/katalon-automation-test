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

WebUI.navigateToUrl('http://localhost:5173/users')

// Wait search box appear
WebUI.waitForElementVisible(
findTestObject('Page_FoodLink Admin/User_page/input_User Management_input'), 10)


// ======================
// TEST SEARCH USER
// ======================

// Enter keyword
WebUI.setText(findTestObject('/Page_FoodLink Admin/User_page/input_User Management_input'
),
'Thu hien')

// Wait result load
WebUI.delay(2)

// Verify user status Active
WebUI.verifyElementPresent(
findTestObject('Page_FoodLink Admin/User_page/span_Active'), 10)


// ======================
// VIEW USER DETAIL
// ======================

// Click User Detail button
WebUI.click(
findTestObject('Page_FoodLink Admin/User_page/button_User Details_btn btn-ghost btn-icon'))

// Wait modal appear
WebUI.waitForElementVisible(findTestObject('Page_FoodLink Admin/User_page/span_EmailValue'), 10)

// ======================
// VERIFY USER INFORMATION
// ======================

// Verify Email
WebUI.verifyElementPresent(
findTestObject('Page_FoodLink Admin/User_page/div_Emailhienvogmail.com'), 10)

// Verify Phone
WebUI.verifyElementPresent(
findTestObject('Page_FoodLink Admin/User_page/div_Phone'), 10)

// Verify Address
WebUI.verifyElementPresent(
findTestObject('Page_FoodLink Admin/User_page/div_Address'), 10)

// Verify ID
WebUI.verifyElementPresent(
findTestObject('Page_FoodLink Admin/User_page/div_ID779b5cd7-3445-4d4a-b5b7-8ce9015df655'), 10)

// Verify Creates\d
WebUI.verifyElementPresent(
findTestObject('Page_FoodLink Admin/User_page/div_Created03092026, 0737 AM'), 10)

// Verify Last Updated
WebUI.verifyElementPresent(
findTestObject('Page_FoodLink Admin/User_page/div_Last Updated03092026, 0844 AM'), 10)

// ======================
// VERIFY PHONE EMPTY CASE
// ======================

String phone = WebUI.getText(
findTestObject('Page_FoodLink Admin/User_page/div_Phone')).trim()

if(phone == '' || phone == '-' || phone == '—') {

    WebUI.comment('Phone is empty')

} else {

    WebUI.verifyMatch(phone, '\\d+', true)

}


// ======================
// CLOSE BROWSER
// ======================

WebUI.closeBrowser()