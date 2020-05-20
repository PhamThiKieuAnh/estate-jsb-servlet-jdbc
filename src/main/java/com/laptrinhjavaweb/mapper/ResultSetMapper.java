package com.laptrinhjavaweb.mapper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.laptrinhjavaweb.annotation.Column;
import com.laptrinhjavaweb.annotation.Entity;

public class ResultSetMapper<T> {
	// zClass : su dung class de mo se lay tung gia tri trong class
	//zClass cung gan nhu T , Zclass cungx laf cais dung chung
	public List<T> mapRow(ResultSet rs , Class<T> zClass){
		List<T> results = new ArrayList<>();
		try {
			
				//truoc khi dung phai ktra zclass duoc truyen vao do co phai la annotation hay khong
				if(zClass.isAnnotationPresent(Entity.class)) {
					//doi tuong resultsetmatadata giup control duoc cac thanh phaan trong resultset qua getMetadata
					ResultSetMetaData resultSetMetaData = rs.getMetaData();
					//de laays all field su dung javareflection-field 
					//field la cac doi tuong dai dien cho 1 thuoc tinh cua lop DUOC DUYET VA LAY RA TU CLASS OBJECT CUA LOP
					Field[]  fields = zClass.getDeclaredFields();	
					while(rs.next()) {
						T object = zClass.newInstance();	
						// su dung for vo tung column trong row
						for(int i = 0 ; i< resultSetMetaData.getColumnCount(); i++) {
							//lay ten column duoi database
							String columnName = resultSetMetaData.getColumnName(i+1);
							//lay giatri duoi database
							Object columnValue = rs.getObject(i+1);
							for(Field field : fields) {
								if(field.isAnnotationPresent(Column.class)) {
									Column column = field.getAnnotation(Column.class);
									if(column.name().equals(columnName)) {
										//convert tu dong su dung thu vienbeanUtil
									
										BeanUtils.setProperty(object, columnName, columnValue);
										break;
									
									}
								}
							}
						}
						results.add(object);
				}
				
			}
				
		}catch(SQLException |  IllegalAccessException |  InstantiationException | InvocationTargetException e) //su dung muiltiple catch
		{
			System.out.println(e.getMessage());
			return null;
	}
		return results;
	}
}
