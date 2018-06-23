package com.hj.callable_statement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import com.hj.base.DBUtils;

public class CallableTest {
	public static void main(String[] args) {
		Connection connection = null;
		CallableStatement callableStatement = null;
		CallableStatement callableStatement2 = null;
		try {
			connection = DBUtils.getConnection();
			
			//in
			//根据员工编号更新工资
			String sql = "{call update_sal(?,?)}";
			callableStatement = connection.prepareCall(sql);
			callableStatement.setInt(1, 7369);
			callableStatement.setObject(2, 888.888, Types.DECIMAL);
			callableStatement.execute();
			
			//in, out
			//求指定部门的平均工资
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
