package dao;

/**
 * Created by Administrator on 2017/7/30.
 */

import bean.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public ProductDAO() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

    }

    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cart?characterEncoding=UTF-8","root","root");
    }

    //获得总数
    public int getTotal(){
        int total = 0;
        try(Connection c = getConnection(); Statement s = c.createStatement()){
            String sql = "select count(*) from product";

            ResultSet resultSet = s.executeQuery(sql);
            while (resultSet.next()){
                total = resultSet.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return total;
    }

    //查询所有结果
    public List<Product> listProduct(){
        List<Product> products = new ArrayList <>();

        try{

            Connection c = getConnection();

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
                products.add(product);

            }
            ps.close();
            c.close();


        }catch (SQLException e){
            e.printStackTrace();
        }

        return products;


    }

    //增加产品
    public void addProduct(Product  p){
        String name = p.getName();
        float price = p.getPrice();
        int id = p.getId();

        try{

            Connection c = getConnection();

            String sql = "INSERT INTO product VALUES (?,?,?)";

            PreparedStatement ps = c.prepareStatement(sql);

            ps.setInt(1,id);
            ps.setString(2,name);
            ps.setFloat(3,price);
            ps.execute();


            ps.close();
            c.close();


        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //修改产品
    public void editProduct(Product product){
        try{

            Connection c = getConnection();

            String sql = "UPDATE product SET name=?,price=? where id="+product.getId();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1,product.getName());
            ps.setFloat(2,product.getPrice());
            ps.execute();


            ps.close();
            c.close();


        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //查找产品
    public Product searchProduct(int id){
        try{

            Connection c = getConnection();

            String sql = "SELECT name,price from product where id ="+id;

            PreparedStatement ps = c.prepareStatement(sql);
            int p_id = id;
            ResultSet resultSet = ps.executeQuery();
            Product product = new Product();
            while (resultSet.next()){


                String name = resultSet.getString(1);
                float price = resultSet.getFloat(2);

                product.setId(p_id);
                product.setName(name);
                product.setPrice(price);



            }


            ps.close();
            c.close();

            return product;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    //删除产品
    public void deletProduct(int id){
        try{

            Connection c = getConnection();

            String sql = "DELETE from product where id ="+id;

            PreparedStatement ps = c.prepareStatement(sql);

            ps.execute();


            ps.close();
            c.close();


        }catch (SQLException e){
            e.printStackTrace();
        }

    }



}
