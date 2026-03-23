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



// =======================
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
// CLICK EDIT
// ======================
WebUI.click(findTestObject('Page_FoodLink Admin/Ingredients/button_edit_first'))

// ======================
// UPDATE DATA
// ======================
WebUI.clearText(findTestObject('Page_FoodLink Admin/Ingredients/input_name'))
WebUI.setText(findTestObject('Page_FoodLink Admin/Ingredients/input_name'), 'Beef')

WebUI.clearText(findTestObject('Page_FoodLink Admin/Ingredients/input_price'))
WebUI.setText(findTestObject('Page_FoodLink Admin/Ingredients/input_price'), '100')

WebUI.clearText(findTestObject('Page_FoodLink Admin/Ingredients/input_stock'))
WebUI.setText(findTestObject('Page_FoodLink Admin/Ingredients/input_stock'), '100')

WebUI.clearText(findTestObject('Page_FoodLink Admin/Ingredients/input_image_url'))
WebUI.setText(findTestObject('Page_FoodLink Admin/Ingredients/input_image_url'), 
'https://fohlafood.vn/cdn/shop/articles/bap-bo-fohla-250g-202303220833529244_ab39106e-3bc3-424b-88b5-1229e4be0bea.webp?v=1734778534')

// ======================
// FIX LỖI CLICK (QUAN TRỌNG)
// ======================

// Chờ modal hiện hoàn toàn
WebUI.waitForElementVisible(findTestObject('Page_FoodLink Admin/Ingredients/button_update'), 10)

// Chờ overlay biến mất (nếu có)
WebUI.waitForElementNotVisible(findTestObject('Common/modal_overlay'), 10, FailureHandling.OPTIONAL)

// Scroll tới button
WebUI.scrollToElement(findTestObject('Page_FoodLink Admin/Ingredients/button_update'), 5)

// Chờ clickable
WebUI.waitForElementClickable(findTestObject('Page_FoodLink Admin/Ingredients/button_update'), 10)

// Click
WebUI.click(findTestObject('Page_FoodLink Admin/Ingredients/button_update'))

// ======================
// VERIFY
// ======================
WebUI.verifyTextPresent('Updated successfully', false)

// ======================
// CLOSE BROWSER
// ======================
WebUI.closeBrowser()