package test;


import com.company.annlas.exceptions.IllegalProductArgumentException;
import com.company.annlas.model.Product;
import org.junit.Test;

public class ProductTest {

    @Test(expected = IllegalProductArgumentException.class)
    public void createProductWithNullName() {
        new Product(null, 15);
    }

    @Test(expected = IllegalProductArgumentException.class)
    public void createProductWithNegativePrice() {
        new Product("Pieczarki", -15);
    }

    @Test
    public void createProductWithProperParameters() {
        new Product("Pomidorki", 30);
    }


}
