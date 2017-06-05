package io.jdbc;

/* Created by AMXPC on 2017/5/28. */

import java.sql.*;

import com.github.lwhite1.tablesaw.api.Table;
import com.github.lwhite1.tablesaw.io.jdbc.SqlResultSetReader;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class TestSqlResultSetReader {
    private Connection connection = null;

    private class DatabaseConnection {
        private static final String DBDRIVER = "com.mysql.jdbc.Driver";
        private static final String DBURL = "jdbc:mysql://100.64.11.43:3306";
        private static final String DBuser = "wsh36530660@163.com";
        private static final String DBPASSWORD = "3878233";
        private Connection conn = null;

        public DatabaseConnection() throws Exception {
            try {
                Class.forName(DBDRIVER);// 加载驱动程序
                conn = DriverManager.getConnection(DBURL, DBuser, DBPASSWORD);// 连接数据库
            } catch (ClassNotFoundException e) {
                System.out.println("jdbc Driver cannot found.");
                e.printStackTrace();
                throw e;
            } catch (SQLException e) {
                System.out.println("DB connection failed.");
                e.printStackTrace();
                throw e;
            }
        }

        public Connection getConnection() { // 取得数据库连接
            return this.conn;
        }

        public void close() throws Exception {  // 数据库关闭操作
            if (this.conn != null) {
                this.conn.close();
            }
        }
    }

    @Before
    public void setUp() {
        DatabaseConnection dbc;
        try {
            dbc = new DatabaseConnection();
            connection = dbc.getConnection();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testRead() {
        ResultSet rs = null;
        Table table;
        String sql = "SELECT * FROM jdbc_testing.fruit WHERE preferance > ?";
        try {
            connection.setAutoCommit(false);
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, 4);
            rs = pstmt.executeQuery();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        if(rs != null) {
            try {
                table = SqlResultSetReader.read(null, "fruit");
                PreparedStatement pstmt = connection.prepareStatement(sql);
                pstmt.setInt(1, 4);
                rs = pstmt.executeQuery();
                if (rs != null) {
                    int row = 0;
                    while (rs.next()) {
                        for (int col = 0; col < 4; col++) {
                            assertThat(table.get(col, row), is(rs.getString(col + 1)));
                        }
                        row++;
                    }
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}
