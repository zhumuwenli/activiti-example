package com.ftu.act;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class H2Test {

    @Test
    public void h2test() throws ClassNotFoundException, SQLException {
        System.out.println("start");
        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.getConnection("jdbc:h2:c:/tmp/test", "sa", "");
        // add application code here
        Statement stmt = conn.createStatement();
        // ResultSet rs = stmt.executeQuery("SELECT * FROM TEST ");
        ResultSet rs = stmt.executeQuery("SELECT * FROM information_schema.tables ");
        System.out.println("============================");
        while (rs.next()) {
            int col = rs.getMetaData().getColumnCount();
            for (int i = 1; i <= col; i++) {
                System.out.print(rs.getString(i) + "\t");
                if ((i == 2) && (rs.getString(i).length() < 8)) {
                    System.out.print("\t");
                }
            }
            System.out.println("");
        }
        System.out.println("============================");
        conn.close();
        System.out.println("end");
    }
}
