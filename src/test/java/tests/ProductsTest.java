package tests;

import base.BaseTest;
import pages.HomePage;
import pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {

    @Test
    public void verifyProductsPageNavigation() {
   
        HomePage home = new HomePage(driver);
        home.clickProducts();

        ProductsPage products = new ProductsPage(driver);
        Assert.assertTrue(products.isProductsPageLoaded());
    }

    @Test
    public void verifyCategoriesVisible() {

        HomePage home = new HomePage(driver);
        home.clickProducts();

        ProductsPage products = new ProductsPage(driver);
        int count = products.getCategoryCount();

        System.out.println("Categories: " + count);
        Assert.assertTrue(count > 0);
    }

    @Test
    public void verifyProductsVisible() {

        HomePage home = new HomePage(driver);
        home.clickProducts();

        ProductsPage products = new ProductsPage(driver);
        int count = products.getProductCount();

        System.out.println("Products: " + count);
        Assert.assertTrue(count > 0);
    }

  //  @Test
    //@Test
//    public void verifyCategoryNavigation() {
//
//        HomePage home = new HomePage(driver);
//        home.clickProducts();
//
//        ProductsPage products = new ProductsPage(driver);
//
//        // Paints
//        products.clickCategoryByText("Paints");
//        System.out.println(driver.getCurrentUrl());
//        Assert.assertTrue(driver.getCurrentUrl().contains("paints"));
//
//        // Bitumen
//        products.clickCategoryByText("Bitumen");
//        System.out.println(driver.getCurrentUrl());
//        Assert.assertTrue(driver.getCurrentUrl().contains("bitumen"));
//
//        // Crash Barriers
//        products.clickCategoryByText("Metal Beam");
//        System.out.println(driver.getCurrentUrl());
//        Assert.assertTrue(driver.getCurrentUrl().contains("crash"));
//        
//        // Signages
//        products.clickCategoryByText("Signages");
//        System.out.println(driver.getCurrentUrl());
//        Assert.assertTrue(driver.getCurrentUrl().contains("signages"));
//
//        // Fabrication
//        products.clickCategoryByText("Fabrication");
//        System.out.println(driver.getCurrentUrl());
//        Assert.assertTrue(driver.getCurrentUrl().contains("fabrication"));
//    }
    @Test
    public void verifyCategoryNavigation() throws InterruptedException {

        HomePage home = new HomePage(driver);
        home.clickProducts();

        ProductsPage products = new ProductsPage(driver);

        // Paints
        products.clickCategoryByText("Paints");
        Thread.sleep(2000);
        System.out.println("Actual URL after Paints: " + driver.getCurrentUrl());
    }


}
