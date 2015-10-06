package com.wbl.tests.ui;

import com.wbl.base.BaseWebTest;
import com.wbl.pages.HomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by svelupula on 8/14/2015.
 */
public class HomePageTest extends BaseWebTest {

    private HomePage _hp;

    @BeforeClass
    public void beforeClass() {
        _hp = new HomePage(driver);
    }

    @Test(priority = 1, alwaysRun = true)
    public void testSlidesCount() {
        assertEquals(8, _hp.getSliderItemsCount());
    }

    @Test
    public void validateHomePageComponents(){
        assertHomePageComponents(_hp.getSliderItemsCount() == 8, "Sliders count check");
        assertHomePageComponents(_hp.isContactInfoPresentInFooter(),"Contact Info at Footer");
        assertHomePageComponents(_hp.isFooterPresent(),"Footer");
        assertHomePageComponents(_hp.isLatestNewsSectionPresent(),"Latest News");
        assertHomePageComponents(_hp.isPromoSectionPresent(),"Promo Section");
        assertHomePageComponents(_hp.isRecentClassesSectionsPresent(),"Recent Classes");
        assertHomePageComponents(_hp.isTestimonialsSectionPresent(),"Testimonial Section");
        assertHomePageComponents(_hp.isVideoSectionPresent(),"Testimonial Section");
    }

    public void assertHomePageComponents(boolean status, String componentName){
        assertTrue(status, "Failed to validate "+componentName);
    }


}
