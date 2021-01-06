package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class IndexModel {
	public Connection connect;

    public IndexModel() {
        this.connection();
    }

    public void connection() {

        String uRL = "jdbc:sqlserver://;databaseName=QuanLiSach";
        String userName = "sa";
        String password = "123";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.connect = DriverManager.getConnection(uRL, userName, password);
            System.out.println("Ket noi CSDL thanh cong");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Khong ket noi duoc voi CSDL");
        }
    }	
}
