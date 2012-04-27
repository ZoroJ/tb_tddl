/*(C) 2007-2012 Alibaba Group Holding Limited.	

import java.sql.Connection;
import java.sql.Statement;

import javax.sql.DataSource;

import com.taobao.tddl.interact.rule.bean.DBType;
import com.taobao.tddl.jdbc.group.DataSourceWrapper;
import com.taobao.tddl.jdbc.group.TGroupDataSource;

/**
 * 
 * @author yangzhu
 *
 */
public class DBHelper {
	//ɾ����������crud�������м�¼
	public static void deleteAll() throws Exception {
		DataSource ds1 = DataSourceFactory.getMySQLDataSource(1);
		DataSource ds2 = DataSourceFactory.getMySQLDataSource(2);
		DataSource ds3 = DataSourceFactory.getMySQLDataSource(3);

		Connection conn = null;
		Statement stmt = null;

		TGroupDataSource ds = new TGroupDataSource();
		DataSourceWrapper dsw = new DataSourceWrapper("db1", "rw", ds1, DBType.MYSQL);
		ds.init(dsw);

		conn = ds.getConnection();
		stmt = conn.createStatement();
		stmt.executeUpdate("delete from crud");
		stmt.close();
		conn.close();

		ds = new TGroupDataSource();
		dsw = new DataSourceWrapper("db2", "rw", ds2, DBType.MYSQL);
		ds.init(dsw);
		conn = ds.getConnection();
		stmt = conn.createStatement();
		stmt.executeUpdate("delete from crud");
		stmt.close();
		conn.close();

		ds = new TGroupDataSource();
		dsw = new DataSourceWrapper("db3", "rw", ds3, DBType.MYSQL);
		ds.init(dsw);
		conn = ds.getConnection();
		stmt = conn.createStatement();
		stmt.executeUpdate("delete from crud");
		stmt.close();
		conn.close();
	}

}