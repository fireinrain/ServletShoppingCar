package dao;

/**
 * Created by Administrator on 2017/7/30.
 */
import bean.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {


    //查询所有结果
    public List<Product> listProduct(){
        List<Product> products = new ArrayList <>();

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cart?characterEncoding=UTF-8","root","root");

            String sql = "select * from product order by id desc";

            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()){
                Product product = new Product();

                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                float price = resultSet.getFloat(3);

                product.setId(id);
                product.setName(name);
                product.setPrice(price);


            }
            ps.close();
            c.close();

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return products;


    }

    //增加产品
    public void addProduct(Product  p){

    }


}
