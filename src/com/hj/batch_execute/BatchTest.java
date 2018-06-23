package com.hj.batch_execute;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.hj.base.DBUtils;

/*******
 * 批量处理
 * 
 * ********/
public class BatchTest {
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtils.getConnection();
			String sql = "insert into t_test(username, password) values(?,?)";
			preparedStatement = connection.prepareStatement(sql);
			for (int i = 1; i <= 10000; i++) {
				preparedStatement.setObject(1, "小明"+i);
				preparedStatement.setObject(2, "123abc");
				//添加批量处理
				preparedStatement.addBatch();  
				//批量处理,每次处理1000条数据
				if (i % 1000 ==0) {
					//执行批量处理
					preparedStatement.executeBatch();
					//一定要清空
					preparedStatement.clearBatch();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(preparedStatement, connection);
			preparedStatement = null;
			connection = null;
		}
	}
}
