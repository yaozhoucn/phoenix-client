package com.atguigu.phoenix;


import org.apache.phoenix.queryserver.client.ThinClientUtil;

import java.sql.*;

/**
 * Created by WXHang on HANG at 2021/3/11 11:38
 */
public class PhoenixClient {
    public static void main(String[] args) throws SQLException {

        //获取jdbc连接
        String url = ThinClientUtil.getConnectionUrl("hadoop100", 8765);
        System.out.println(url);
        Connection connection = DriverManager.getConnection(url);

        //根据url获取链接
        PreparedStatement statement = connection.prepareStatement("select * from student");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getString(1)+ "\t"
            + resultSet.getString(2));
        }

    }
}
