/**
 * 
 */
package net.sourceforge.smokestack.jdbc.ex03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author KAHBZB
 *
 */

public class PSSelect{
	public static void main(String[] args) throws Exception{
		Connection conn = null;
		Class.forName("org.h2.Driver");
		conn = DriverManager.getConnection("jdbc:h2:mem:inmemory");
        Statement stat = conn.createStatement();
        stat.execute("create table message(id long primary key, message varchar(255))");
        stat.close();

        String sql = "SELECT id,message FROM message WHERE id >= ?";
		PreparedStatement pst = conn.prepareStatement(sql);
		pst.setInt(1,1);
		ResultSet rs = pst.executeQuery();
		while (rs.next()){
			Long id = rs.getLong(1);
			String msg = rs.getString(2);
			System.out.println(id + "\t" + "- " + msg);
		}
		rs.close();
		pst.close();
		conn.close();
	}
}
