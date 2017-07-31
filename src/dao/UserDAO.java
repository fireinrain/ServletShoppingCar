package dao;

import bean.User;

import java.sql.*;

/**
 * Created by Administrator on 2017/7/31.
 */
public class UserDAO {

    public UserDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cart?characterEncoding=UTF-8","root","root");
    }

    public User getUser(String name,String password){
        User result = null;
        try{
            Connection connection = getConnection();
            String sql = "select * from  user where name=? and password=?";
            PreparedStatement p = connection.prepareStatement(sql);

            p.setString(1,name);
            p.setString(2,password);
            ResultSet resultSet = p.executeQuery();

            if (resultSet.next()){
                result = new User();
                result.setId(resultSet.getInt(1));
                result.setName(name);
                result.setPassword(password);
            }

            p.close();
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return result;
    }
}
