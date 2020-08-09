package test;

import com.company.annlas.ShoppingCart;
import com.company.annlas.exceptions.IllegalDiscountArgumentException;
import com.company.annlas.model.Product;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ShoppingCartTest {

    @Test
    public void countDiscountForTwoDivisibleElements() {

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setProductList(Arrays.asList(
                new Product("Product1", 1500),
                new Product("Product2", 500)
        ));
        shoppingCart.countDiscount(100);
        assertEquals(75, shoppingCart.getDiscountedProductsList().get(0).getDiscount(), 0);
        assertEquals(25, shoppingCart.getDiscountedProductsList().get(1).getDiscount(), 0);

    }

    @Test
    public void countDiscountForOneZeroElement() {

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setProductList(Arrays.asList(
                new Product("Product1", 1500),
                new Product("Product2", 0)
        ));
        shoppingCart.countDiscount(100);
        assertEquals(100, shoppingCart.getDiscountedProductsList().get(0).getDiscount(), 0);
        assertEquals(0, shoppingCart.getDiscountedProductsList().get(1).getDiscount(), 0);

    }

    @Test
    public void countDiscountForOneElement() {

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addProduct(new Product("Product1", 1500));
        shoppingCart.countDiscount(100);
        assertEquals(100, shoppingCart.getDiscountedProductsList().get(0).getDiscount(), 0);


    }

    @Test
    public void countDiscountForZeroDiscountValue() {

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addProduct(new Product("Product1", 1500));
        shoppingCart.countDiscount(0);
        assertEquals(0, shoppingCart.getDiscountedProductsList().get(0).getDiscount(), 0);


    }

    @Test(expected = IllegalDiscountArgumentException.class)
    public void countDiscountForNegativeDiscountValue() {

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addProduct(new Product("Product1", 1500));
        shoppingCart.countDiscount(-10);

    }

    @Test
    public void countDiscountForThreeNonDivisibleElements() {

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setProductList(Arrays.asList(
                new Product("Product1", 1000),
                new Product("Product2", 1000),
                new Product("Product3", 1000)
        ));
        shoppingCart.countDiscount(100);
        assertEquals(33.33, shoppingCart.getDiscountedProductsList().get(0).getDiscount(), 0);
        assertEquals(33.33, shoppingCart.getDiscountedProductsList().get(1).getDiscount(), 0);
        assertEquals(33.34, shoppingCart.getDiscountedProductsList().get(2).getDiscount(), 0);

    }

    @Test
    public void countDiscountFoCartSumLowerThanDiscount() {

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setProductList(Arrays.asList(
                new Product("Product1", 30),
                new Product("Product2", 1000),
                new Product("Product3", 60)
        ));
        shoppingCart.countDiscount(2000);

        assertEquals(30, shoppingCart.getDiscountedProductsList().get(0).getDiscount(), 0);
        assertEquals(1000, shoppingCart.getDiscountedProductsList().get(1).getDiscount(), 0);
        assertEquals(60, shoppingCart.getDiscountedProductsList().get(2).getDiscount(), 0);

    }

    @Test
    public void ForFiveElements() {

        ShoppingCart shoppingCart = new ShoppingCart();


        shoppingCart.setProductList(Arrays.asList(
                new Product("Product1", 930),
                new Product("Product2", 1000),
                new Product("Product3", 1060),
                new Product("Product4", 940),
                new Product("Product5", 60)));

        shoppingCart.countDiscount(500);
        assertEquals(116.54, shoppingCart.getDiscountedProductsList().get(0).getDiscount(), 0);
        assertEquals(125.31, shoppingCart.getDiscountedProductsList().get(1).getDiscount(), 0);
        assertEquals(132.83, shoppingCart.getDiscountedProductsList().get(2).getDiscount(), 0);
        assertEquals(117.79, shoppingCart.getDiscountedProductsList().get(3).getDiscount(), 0);
        assertEquals(7.53, shoppingCart.getDiscountedProductsList().get(4).getDiscount(), 0);
    }

    @Test
    public void ForFiveElementsWithSmallDiscount() {

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setProductList(Arrays.asList(
                new Product("Product1", 1000),
                new Product("Product2", 1000),
                new Product("Product3", 999),
                new Product("Product4", 1000),
                new Product("Product5", 1000)));

        shoppingCart.countDiscount(0.01);
        assertEquals(0, shoppingCart.getDiscountedProductsList().get(0).getDiscount(), 0);
        assertEquals(0, shoppingCart.getDiscountedProductsList().get(1).getDiscount(), 0);
        assertEquals(0, shoppingCart.getDiscountedProductsList().get(2).getDiscount(), 0);
        assertEquals(0, shoppingCart.getDiscountedProductsList().get(3).getDiscount(), 0);
        assertEquals(0.01, shoppingCart.getDiscountedProductsList().get(4).getDiscount(), 0);
    }


}
