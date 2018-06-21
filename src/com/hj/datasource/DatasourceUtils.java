package com.hj.datasource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/*
 * C3P0需要导入c3p0.jar和配置文件c3p0-config.xml
 * DBCP需要导入commons-dbcp-1.4.jar, commons-pool-1.5.6.jar
 * 以及配置文件dbcpconfig.properties
 * 
 * 根据需求修改配置文件
 * 配置文件需要放在src或WEB-INF目录下, 一般放在src目录下
 * */

public class DatasourceUtils {
	private static DataSource dpcpDataSource;
	
	private static DataSource c3p0DataSource = new ComboPooledDataSource();
	
	static {
		//dpcp
		InputStream inputStream = DatasourceUtils.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
		Properties properties = new Properties();
		try {
			properties.load(inputStream);
			dpcpDataSource = BasicDataSourceFactory.createDataSource(properties);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static DataSource getDataSource() {
		return dpcpDataSource;
//		return c3p0DataSource;
	}
}
