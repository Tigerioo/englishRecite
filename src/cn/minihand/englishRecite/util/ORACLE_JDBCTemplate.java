package cn.minihand.englishRecite.util;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

/**
 * JDBC���ݿ�ģ�壬���ж������ɾ�Ĳ�
 * @author Lingq
 *
 */
public class ORACLE_JDBCTemplate {
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/*
	 * add object
	 */
	public void add(Object obj) {
		if (obj == null) {
			return;
		}
		String className = obj.getClass().getSimpleName();
		Connection conn = null;
		Statement stmt = null;
		StringBuffer insertSql = new StringBuffer(); // insert���
		insertSql.append("insert into T_" + className + "(");
		StringBuffer valueSql = new StringBuffer(); // values���
		valueSql.append(" values(seq_" + className.toLowerCase() + ".nextval");

		try {
			Class c1 = obj.getClass(); // ���obj��class
			Field[] fields = c1.getDeclaredFields(); // ��������ֶ�
			AccessibleObject.setAccessible(fields, true); // ���Է���˽�б���
			Method[] methods = c1.getDeclaredMethods(); // ������з���
			HashMap values = this.getValues(obj, fields, methods); // �������Ժ�����Ӧ��ֵ

			// ����SQL���
			for (int i = 0; i < fields.length; i++) {
				String fieldName = fields[i].getName();
				if (i == 0) {// ��һ��
					insertSql.append(fieldName);
				} else if (i == fields.length - 1) {
					insertSql.append("," + fieldName + ")");
					valueSql.append("," + values.get(fieldName) + ")");
				} else {
					insertSql.append("," + fieldName);
					valueSql.append("," + values.get(fieldName));
				}
			}
			String sql = insertSql.toString() + valueSql.toString();
			System.out.println(sql);
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			stmt.execute(sql);

		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(stmt);
			this.close(conn);
		}

	}

	public void delete(Object obj) {

		String className = obj.getClass().getSimpleName(); // get class name
		Connection conn = null;
		Statement stmt = null;
		String sql = "";

		try {
			Class c1 = obj.getClass(); // ���obj��class
			Field[] fields = c1.getDeclaredFields(); // ��������ֶ�
			AccessibleObject.setAccessible(fields, true); // ���Է���˽�б���
			Method[] methods = c1.getDeclaredMethods(); // ������з���
			HashMap values = this.getValues(obj, fields, methods); // �������Ժ�����Ӧ��ֵ

			Iterator iter = values.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry) iter.next();
				Object key = entry.getKey();
				Object value = entry.getValue();
				if ("Integer"
						.equalsIgnoreCase(value.getClass().getSimpleName())) {
					sql = "delete from T_" + className + " where " + key + "="
							+ value;
					System.out.println(sql);
					// �������ݿ⣬��ɾ��
					conn = this.dataSource.getConnection();
					stmt = conn.createStatement();
					System.out.println(sql);
					stmt.execute(sql);
					return;
				}
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(conn);
		}
	}

	public Object findById(Object obj, int id){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		HashMap results = new HashMap();
		Class cl = obj.getClass(); // ���obj��class
		
		try {
			String className = cl.getSimpleName();
			Field[] fields = cl.getDeclaredFields(); // ��������ֶ�
			AccessibleObject.setAccessible(fields, true); // ���Է���˽�б���
			Method[] methods = cl.getDeclaredMethods(); // ������з���
			
			String sql = "select * from T_" + className + " where " + className + "_id=" + id ;
			System.out.println(sql);
			conn = this.dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()){
				for(int i=0; i<methods.length; i++){
					Method method = methods[i];
					String methodName = method.getName();
					if(methodName.startsWith("set")){
						String m1 = methodName.replaceFirst("set", "");
						String temp1 = m1.substring(0,1);
						String temp2 = m1.replaceFirst(temp1, temp1.toLowerCase()); //���set��������
						//ִ��set����,����ֵ
						for(int j=0; j<fields.length; j++){ 
							if(temp2.equalsIgnoreCase(fields[j].getName())){
								if("String".equalsIgnoreCase(fields[j].getType().getSimpleName())){
									String val = rs.getString(temp2);
									if(val != null && !"".equals(val)){
										method.invoke(obj, val);
									}
								}
								if("int".equalsIgnoreCase(fields[j].getType().getSimpleName())){
									int val = rs.getInt(temp2);
									if( !"".equals(val)){
										method.invoke(obj, val);
									}
								}
							}
						}
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
			close(conn);
		}
		return obj;
	}

	public Object findByName(Object obj, String username){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		HashMap results = new HashMap();
		Class cl = obj.getClass(); // ���obj��class
		
		try {
			String className = cl.getSimpleName();
			Field[] fields = cl.getDeclaredFields(); // ��������ֶ�
			AccessibleObject.setAccessible(fields, true); // ���Է���˽�б���
			Method[] methods = cl.getDeclaredMethods(); // ������з���
			
			String sql = "select * from T_" + className + " where username='" + username +"'";
			System.out.println(sql);
			conn = this.dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()){
				for(int i=0; i<methods.length; i++){
					Method method = methods[i];
					String methodName = method.getName();
					if(methodName.startsWith("set")){
						String m1 = methodName.replaceFirst("set", "");
						String temp1 = m1.substring(0,1);
						String temp2 = m1.replaceFirst(temp1, temp1.toLowerCase()); //���set��������
						//ִ��set����,����ֵ
						for(int j=0; j<fields.length; j++){ 
							if(temp2.equalsIgnoreCase(fields[j].getName())){
								if("String".equalsIgnoreCase(fields[j].getType().getSimpleName())){
									String val = rs.getString(temp2);
									if(val != null && !"".equals(val)){
										method.invoke(obj, val);
									}
								}
								if("int".equalsIgnoreCase(fields[j].getType().getSimpleName())){
									int val = rs.getInt(temp2);
									if( !"".equals(val)){
										method.invoke(obj, val);
									}
								}
							}
						}
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
			close(conn);
		}
		return obj;
	}
	
	public void update(Object obj) {
		if (obj == null) {
			return;
		}
		String className = obj.getClass().getSimpleName();
		Connection conn = null;
		Statement stmt = null;
		StringBuffer updateSql = new StringBuffer("update T_"+className+" set "); // insert���
		int id = 0;
		
		try {
			Class c1 = obj.getClass(); // ���obj��class
			Field[] fields = c1.getDeclaredFields(); // ��������ֶ�
			AccessibleObject.setAccessible(fields, true); // ���Է���˽�б���
			Method[] methods = c1.getDeclaredMethods(); // ������з���
			HashMap values = this.getValues(obj, fields, methods); // �������Ժ�����Ӧ��ֵ

			// ����SQL���
			for (int i = 0; i < fields.length; i++) {
				String fieldName = fields[i].getName();
				String temp = className.toLowerCase();
				if(fieldName.contains(temp) && fieldName.contains("id")){
					id = (Integer)values.get(fieldName);
					continue;
				}
				if (i != fields.length-1) {// ��һ��
					updateSql.append(fieldName+"="+values.get(fieldName)+", ");
				}  else {
					updateSql.append(fieldName + "=" + values.get(fieldName) + " where "+className+"_id=" + id);
				}
			}
			String sql = updateSql.toString();
			System.out.println("update sql="+sql);
			conn = this.dataSource.getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);

		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(stmt);
			this.close(conn);
		}

	}
	
	public ArrayList findAll(Object obj){
		ArrayList all = new ArrayList();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		HashMap results = new HashMap();
		Class cl = obj.getClass(); // ���obj��class
		
		try {
			String className = cl.getSimpleName();
			String sql = "select * from T_" + className ;
			System.out.println(sql);
			conn = this.dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				Object newObj = Class.forName(obj.getClass().getName()).newInstance();
				Field[] fields = newObj.getClass().getDeclaredFields(); // ��������ֶ�
				AccessibleObject.setAccessible(fields, true); // ���Է���˽�б���
				Method[] methods = newObj.getClass().getDeclaredMethods(); // ������з���
				for(int i=0; i<methods.length; i++){
					Method method = methods[i];
					String methodName = method.getName();
					if(methodName.startsWith("set")){
						String m1 = methodName.replaceFirst("set", "");
						String temp1 = m1.substring(0,1);
						String temp2 = m1.replaceFirst(temp1, temp1.toLowerCase()); //���set��������
						//ִ��set����,����ֵ
						for(int j=0; j<fields.length; j++){ 
							if(temp2.equalsIgnoreCase(fields[j].getName())){
								if("String".equalsIgnoreCase(fields[j].getType().getSimpleName())){
									String val = rs.getString(temp2);
									if(val != null && !"".equals(val)){
										method.invoke(newObj, val);
										continue;
									}
								}
								if("int".equalsIgnoreCase(fields[j].getType().getSimpleName())){
									int val = rs.getInt(temp2);
									if( !"".equals(val)){
										method.invoke(newObj, val);
									}
								}
							}
						}
					}
				}
				all.add(newObj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
			close(conn);
		}
		return all;
	}
	
	private HashMap getValues(Object obj, Field[] fields, Method[] methods)
			throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException {
		HashMap maps = new HashMap();

		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			String name = method.getName();
			if (name.startsWith("get")) {
				for (int j = 0; j < fields.length; j++) {
					String fieldName = fields[j].getName();
					Class type = fields[j].getType();
					if (name.toLowerCase().contains(fieldName.toLowerCase())) {
						if ("int".equals(type.getSimpleName())
								|| "Date".equals(type.getSimpleName())) {
							maps.put(fieldName, method.invoke(obj, null));
						} else {
							maps.put(fieldName, "'" + method.invoke(obj, null)
									+ "'");
						}
					}
				}
			}
		}
		return maps;
	}

	private void close(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void close(PreparedStatement pstmt) {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void close(Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void close(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
