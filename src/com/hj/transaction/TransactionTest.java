package com.hj.transaction;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.hj.base.DBUtils;

public class TransactionTest {
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		try {
			connection= DBUtils.getConnection();
			statement = connection.createStatement();
			
			//1.关闭自动提交事务, 默认自动提交
			connection.setAutoCommit(false);
			//2.设置事务隔离的级别
			//一般使用可重复读取级别,repeatable_read
			connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
			
			String sql1 = "update t_account set balance=balance+168 where id=1";
			String sql2 = "update t_account set balance=balance+666 where id=2";
			statement.executeUpdate(sql1);
			int i = 1/0;//发生异常
			statement.executeUpdate(sql2);
			
			//3.提交事务
			//如果在此之前执行的数据库相关操作过程中发生了异常,就不会走到这一步
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//执行操作过程中发生了异常
			//回滚
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			DBUtils.close(statement, connection);
			statement = null;
			connection = null;
		}
	}
}
