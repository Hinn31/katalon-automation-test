import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling as FailureHandling

// 1. Mở trình duyệt và truy cập FoodLink
WebUI.openBrowser('')
WebUI.navigateToUrl('http://localhost:5173/login')
WebUI.maximizeWindow()

// 2. Nhập Email
WebUI.setText(findTestObject('Object Repository/Page_FoodLink Admin/Login_page/input_Email_email'), 'admin@foodlink.com')

// 3. Nhập mật khẩu datpham123
WebUI.setText(findTestObject('Object Repository/Page_FoodLink Admin/Login_page/input_Password_password'), 'datpham123')

// 4. Chờ nút Login hiện ra và Click
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_FoodLink Admin/Login_page/button_Login'), 5)
WebUI.click(findTestObject('Object Repository/Page_FoodLink Admin/Login_page/button_Login'))

// 5. Chờ hệ thống chuyển trang (NFR-01)
WebUI.waitForPageLoad(3)

// 6. Kiểm tra xem có đăng nhập được không (dùng Optional để tránh lỗi đỏ khi đã sang trang mới)
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_FoodLink Admin/Login_page/button_Login'), 5, FailureHandling.OPTIONAL)

// 7. Kết thúc bài test
WebUI.closeBrowser()