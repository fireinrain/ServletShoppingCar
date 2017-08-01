package dao;

import bean.Order;

import java.sql.*;

/**
 * Created by Administrator on 2017/8/1.
 */
public class OrderDAO {
    public OrderDAO() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cart?characterEncoding=UTF-8","root","root");
    }

    public void insert(Order order){
        try {
            Connection connection = getConnection();

            String sql = "insert into order_ values(null,?)";

            PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, order.getUser().getId());

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                order.setId(id);
            }

            ps.close();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
