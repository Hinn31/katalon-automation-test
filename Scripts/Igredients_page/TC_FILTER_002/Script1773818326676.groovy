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


// ======================
// FUNCTION LẤY STATUS
// ======================
def getStatuses() {
	return WebUiCommonHelper.findWebElements(
		findTestObject('Page_FoodLink Admin/Ingredients/status_badge'), 10)
}


// ======================
// TC016 - FILTER ACTIVE
// ======================
WebUI.selectOptionByLabel(
	findTestObject('Page_FoodLink Admin/Ingredients/dropdown_status'),
	'Active',
	false)

WebUI.delay(2)

List<WebElement> statusesActive = getStatuses()

for (WebElement s : statusesActive) {
	assert s.getText().trim().equalsIgnoreCase('Active')
}


// ======================
// TC017 - FILTER INACTIVE
// ======================
WebUI.selectOptionByLabel(
	findTestObject('Page_FoodLink Admin/Ingredients/dropdown_status'),
	'Inactive',
	false)

WebUI.delay(2)

List<WebElement> statusesInactive = getStatuses()

for (WebElement s : statusesInactive) {
	assert s.getText().trim().equalsIgnoreCase('Inactive')
}


// ======================
// TC018 - RESET FILTER
// ======================

// Apply filter trước
WebUI.selectOptionByLabel(
	findTestObject('Page_FoodLink Admin/Ingredients/dropdown_status'),
	'Active',
	false)

WebUI.delay(2)

// Click reset
WebUI.click(findTestObject('Page_FoodLink Admin/Ingredients/button_reset_filters'))
WebUI.delay(2)

// Lấy text của option đang hiển thị (selected)
String selectedStatus = WebUI.getText(
    findTestObject('Page_FoodLink Admin/Ingredients/dropdown_status_all')
)

// Verify
WebUI.verifyMatch(selectedStatus, 'All statuses', false)


// =====================
// CLOSE BROWSER
// ======================
WebUI.closeBrowser()