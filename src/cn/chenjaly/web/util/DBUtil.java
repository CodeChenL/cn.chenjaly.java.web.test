package cn.chenjaly.web.util;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBUtil<T> {

	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	//连接数据库
	public Connection getConnection() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/class1?characterEncoding=utf-8", "root",
					"1234");
		return conn;
	}
	
	public int update(String sql,Object...obj){
		int row = 0;
		try {
			//如果不调用getConnection方法，conn是null
			pst = getConnection().prepareStatement(sql);
			//根据占位符对应参数的个数进行循环,如果没有参数则不循环
			for (int i = 0; i < obj.length; i++) {
				pst.setObject(i+1, obj[i]);
			}
			row = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.getClose(rs, pst, conn);
		}
		return row;
	}
	
	//使用反射实现结果集的处理
	public List<T> query(String sql,Object...obj){
		List<T> list = new ArrayList<>();
		try {
			//如果不调用getConnection方法，conn是null
			pst = getConnection().prepareStatement(sql);
			//根据占位符对应参数的个数进行循环,如果没有参数则不循环
			for (int i = 0; i < obj.length; i++) {
				pst.setObject(i+1, obj[i]);
			}
			rs = pst.executeQuery();
			//获取到rs中的整个结构
			ResultSetMetaData rmd = rs.getMetaData();
			//从表结构中获取到表明,来拼接出类名
			String str = "cn.chenjaly.web.bean."+rmd.getTableName(1).substring(0, 1).toUpperCase()+rmd.getTableName(1).substring(1);
			//加载类名成为一个类
			Class clazz = Class.forName(str);
			int count = rmd.getColumnCount();  //获取到属性的个数
			while(rs.next()){
				//通过类反射生产对象
				T t = (T) clazz.newInstance();
				//处理每个列赋值给属性
				for(int i=0;i<count;i++){
					//获取到列名
					String cname = rmd.getColumnName(i+1);
					//通过列名获取到属性
					Field f = clazz.getDeclaredField(cname);
					//忽略属性权限
					f.setAccessible(true);
					//为属性赋值
					f.set(t, rs.getObject(i+1));
				}
				//将对象保存在集合
				list.add(t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			this.getClose(rs, pst, conn);
		}
		return list;
	}
	
	public void getClose(ResultSet rs,PreparedStatement pst,Connection conn){
		try {
			if (rs != null)
				rs.close();
			if(pst!=null)
				pst.close();
			if(conn!=null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
