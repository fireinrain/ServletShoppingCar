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
        Product product = new Product();
        product.setName("苹果");
        product.setPrice(12.3f);
        product.setId(5);
        new ProductDAO().addProduct(product);
        System.out.println("添加测试数据成功");
    }

    @Test
    public void searchProduct() throws Exception {
        Product product = new ProductDAO().searchProduct(2);
        System.out.println("查找数据成功："+product);
    }

    @Test
    public void editProduct() throws Exception {
        Product product = new Product();
        product.setName("pingguo");
        product.setPrice(23.34f);

        product.setId(2);
        new ProductDAO().editProduct(product);
        System.out.println("修改数据成功");
    }



    @Test
    public void deletProduct() throws Exception {

        new ProductDAO().deletProduct(2);
        System.out.println("删除测试数据成功");
    }

}