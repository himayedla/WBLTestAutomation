package com.wbl.tests.ui;

import com.wbl.base.BaseWebTest;
import com.wbl.pages.HomePage;
import com.wbl.pages.LoginPage;
import java.util.Map;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.wbl.pages.RegisterPage;

import static org.testng.Assert.assertTrue;

/**
 * Created by bindunani on 10/5/15.
 */
public class RegisterPageTest extends BaseWebTest {

    private LoginPage _lp;
    private RegisterPage _rp;
    private HomePage _hp;

    @DataProvider(name = "register-user-data")
    public Object[][] getUsers() throws Exception {
        Object[][] data = excelUtils.getComplexExcelData(driver._configuration.FilePath);
        return data;
    }

    @Test(dataProvider = "register-user-data")
    public void testRegisterUser(Map<String,String> testData) throws InterruptedException
    {
        _hp = new HomePage(driver);
        _lp = _hp.clickLogin();
        _rp = _lp.clickOnRegisterButton();
        _rp.fillRegistrationForm(testData.get("fullName"),testData.get("phone"),testData.get("address"),testData.get("city"),
                testData.get("zip"),testData.get("country"));
        assertTrue(_rp.isRegistrationCompleted(), "Registration Failed");
    }


}
