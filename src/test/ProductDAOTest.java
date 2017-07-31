package test;

import bean.Product;
import dao.ProductDAO;
import org.junit.Test;

import java.util.List;


/**
 * Created by Administrator on 2017/7/31.
 */
public class ProductDAOTest {
    @Test
    public void listProduct() throws Exception {
        List<Product> products = new ProductDAO().listProduct();
        System.out.println(products.toString());
    }

    @Test
    public void addProduct() throws Exception {
    }

    @Test
    public void editProduct() throws Exception {
    }

    @Test
    public void searchProduct() throws Exception {
    }

    @Test
    public void deletProduct() throws Exception {
    }

}