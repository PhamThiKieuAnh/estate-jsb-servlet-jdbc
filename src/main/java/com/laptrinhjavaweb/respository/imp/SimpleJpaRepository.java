package com.laptrinhjavaweb.respository.imp;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.laptrinhjavaweb.annotation.Column;
import com.laptrinhjavaweb.annotation.Table;
import com.laptrinhjavaweb.mapper.ResultSetMapper;
import com.laptrinhjavaweb.mapper.RowMapper;
import com.laptrinhjavaweb.respository.EntityManagerFactory;
import com.laptrinhjavaweb.respository.JpaRepository;

public class SimpleJpaRepository<T> implements JpaRepository<T> {
	private Class<T> zClass;//khai boa class , null chua cos gia tri
	// khi goi hamaf Simple... thif ZClass phair co gia tri 
	//su dung contructor 
	@SuppressWarnings("unchecked")
	public SimpleJpaRepository() {
		Type type = getClass().getGenericSuperclass();
		ParameterizedType parameterizedType = (ParameterizedType) type;
		zClass= (Class<T>) parameterizedType.getActualTypeArguments()[0];
	}
	@Override
	public List<T> findAll( Map<String , Object> params ,Object ... where) {
	
		ResultSetMapper<T> resultSetMapper = new ResultSetMapper();
		Connection connection = EntityManagerFactory.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String tableName = "";
		if(connection != null) {
			try {
				if(zClass.isAnnotationPresent(Table.class)) {
					Table table = zClass.getAnnotation(Table.class);
					tableName = table.name();
					
				}
				StringBuilder sql = new StringBuilder( "select * from "+tableName+" A where 1=1");
				sql =createSQLfindAllCommon(sql, params);
				if(where != null && where.length == 1) {
					sql.append(where[0]);
				}
			statement =connection.prepareStatement(sql.toString());
			resultSet = statement.executeQuery();

			return resultSetMapper.mapRow(resultSet, zClass);
			
			}catch(SQLException e) {
				System.out.println(e.getMessage());
				return new ArrayList<>();
			}finally {
				try {
				if(connection != null) {
					connection.close();
				}
				if(statement != null) {
					statement.close();
				}
				if(resultSet != null) {
					resultSet.close();
				}
				}catch(SQLException e) {
					System.out.print(e.getMessage());
					return new ArrayList<>();
				}
			}
			
		}
		return new ArrayList<>();
	}
	protected StringBuilder createSQLfindAllCommon(StringBuilder sql, Map<String, Object> params) {
		if(params != null &&params.size() >0) {
			//tao 2 mang , key va value
			String[] keys = new String[params.size()];
			Object [] values = new Object [params.size()];
			int i = 0;
			for (Map.Entry<String, Object> item : params.entrySet()) {
				keys[i] = item.getKey();
				values[i] = item.getValue();
				i++;
			}
				//xu ly tu dong
			//chay vong lap de lay key , con values laf ga tri tuown ung cap di kem , chay vong lap trong key la duwoc
				for (int i1 = 0 ;i1 < keys.length ; i1++) {
					if(values[i1] instanceof String ) {
						if(StringUtils.isNotBlank(values[i1].toString())) {
							// cach and 
							sql.append("  AND A."+keys[1]+" like '%"+values[i1] +"%'");
						}
					}
					else {
						if(values[i1] != null) {
							sql.append(" AND A."+keys[1]+" = "+values[i1] +"");
						
						}
					}
				}
		}
		return sql;
	}
	@Override
	public void insert(String sql ,Object ... objects) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
		connection = EntityManagerFactory.getConnection();
		connection.setAutoCommit(false);
		statement = connection.prepareStatement(sql);
			int index = 1;
		for(Object object : objects) {
			statement.setObject(index, object);
			index ++;
		}
		statement.executeUpdate();
		connection.commit();
		
		}catch(SQLException e) {
			if(connection != null) {
				try {
				connection.rollback();
				}catch(SQLException e1) {
					System.out.println(e1.getMessage());
				}
			}
			System.out.println(e.getMessage());
		}finally {
			try {
			if(connection != null) {
				connection.close();
			}
			if(statement != null) {
				statement.close();
			}
			}catch(SQLException e2) {
				System.out.println(e2.getMessage());
			}
		}
		
	}
	@Override
	public void insert(Object object) {
		String sql = createSQLInsert();
		Connection connection = null;
		PreparedStatement statement = null;
		try {
		connection = EntityManagerFactory.getConnection();
		connection.setAutoCommit(false);
		statement = connection.prepareStatement(sql);
		Class<?> aClass = object.getClass();
		int index = 1;
		for(Field aField : aClass.getDeclaredFields()) {
			statement.setObject(index, aField.get(object));
			index ++;
		}
		statement.executeUpdate();
		connection.commit();
		
		}catch(SQLException | IllegalAccessException e) {
			if(connection != null) {
				try {
				connection.rollback();
				}catch(SQLException e1) {
					System.out.println(e1.getMessage());
				}
			}
			System.out.println(e.getMessage());
		}finally {
			try {
			if(connection != null) {
				connection.close();
			}
			if(statement != null) {
				statement.close();
			}
			}catch(SQLException e2) {
				System.out.println(e2.getMessage());
			}
		}
		
	}
	private String createSQLInsert() {
		String tableName="";
		
		if(zClass.isAnnotationPresent(Table.class)) {
			Table table = zClass.getAnnotation(Table.class);
			tableName = table.name();
			
		}
		StringBuilder fields = new StringBuilder("");
		StringBuilder params = new StringBuilder("");
		for(Field field : zClass.getDeclaredFields()) {
			//abc,abc,abc
			if(fields.length() >1) {
				fields.append(",");
				params.append(",");
				
			}
			if(field.isAnnotationPresent(Column.class)) {
				Column column = field.getAnnotation(Column.class);
			fields.append(column.name());
			params.append("?");
			}
		}
		String sql ="INSERT INTO "+tableName+" ("+fields.toString()+") VALUES() ";
		return null;
	}
	@Override
	public List<T> findAll(String sql, Object... where) {
		ResultSetMapper<T> resultSetMapper = new ResultSetMapper();
		Connection connection = EntityManagerFactory.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		
		if(connection != null) {
			try {
				
				
				//StringBuilder sql = new StringBuilder( "select * from "+tableName+"");
				StringBuilder builder = new StringBuilder(sql);
				if(where != null && where.length==1) {
					builder.append(where[0]);
				}
			//statement =connection.prepareStatement(builder.toString());
				statement = connection.createStatement();
			resultSet = statement.executeQuery(builder.toString());

			return resultSetMapper.mapRow(resultSet, zClass);
			
			}catch(SQLException e) {
				System.out.println(e.getMessage());
				return new ArrayList<>();
			}finally {
				try {
				if(connection != null) {
					connection.close();
				}
				if(statement != null) {
					statement.close();
				}
				if(resultSet != null) {
					resultSet.close();
				}
				}catch(SQLException e) {
					System.out.print(e.getMessage());
					return new ArrayList<>();
				}
			}
			
		}
		return new ArrayList<>();
	
	}
	

}
