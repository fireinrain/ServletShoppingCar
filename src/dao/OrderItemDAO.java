package dao;

import bean.Order;
import bean.OrderItem;

import java.sql.*;

/**
 * Created by Administrator on 2017/8/1.
 */
public class OrderItemDAO {
    public OrderItemDAO() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cart?characterEncoding=UTF-8","root","root");
    }

    public void insert(OrderItem orderi){
        try {
            Connection connection = getConnection();

            String sql = "insert into orderitem values(null,?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,orderi.getProduct().getId());
            preparedStatement.setInt(2,orderi.getNum());
            preparedStatement.setInt(3,orderi.getOrder().getId());
            preparedStatement.execute();


            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
