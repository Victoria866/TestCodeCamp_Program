package Konga;

import Search.SearchPage;
import Setup.SetupTest;
import org.testng.annotations.Test;

import java.util.Random;

public class KongaTest extends SetupTest {
    @Test
    public void testLoginPage()
        {
            int addToCartButtonID = 1, numberOfItems = 1;
            String userId = "enter email", password = "enter password" , item = "Apple MacBooks",
                    cardNumber = "3434 4545 5656 4564", date = "12/21", cvv = "232";
            //Instantiate random class
            Random random = new Random();

            try {//Sign in to Konga website
                //Replaced the class type name 'LoginPage' with 'var'
                var loginPage = welcomePage.clickLoginSignUpButton();
                //Replace the username and password string with valid user details
                loginPage.enterUsername(userId);
                loginPage.enterPassword(password);
                //Click on Login Button
                loginPage.clickLoginButton();
                //Select any of the categories and subcategory
                var subCategoryPage =welcomePage.clickCategoryAndSub();
                //Use the search box, search for an item
                subCategoryPage.searchForAnItem(item);
                SearchPage searchPage = subCategoryPage.clickSearchButton();
                //Click on the add to cart button
                searchPage.clickOnAddToCart(addToCartButtonID);
                //Click on the My Cart Menu
                var addToCartPage = searchPage.clickMyCartButton();
                //Click on checkout
                var checkOutPage = addToCartPage.clickCheckOut();
                //Click "Pay Now" to enable “Continue to Payment” button - the user must have preselected pick up method
                checkOutPage.clickOnPayNow();
                //Click on the “Continue to Payment” button
                checkOutPage.clickContinueToPayment();
                //Select the “CARD” payment method
                checkOutPage.clickOnPaymentType();
                //Input a wrong card number, date, CVV
                checkOutPage.enterCardDetails(cardNumber, date , cvv);

                //Print out the error message for the card number field.
                System.out.println(checkOutPage.invalid_message());
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }