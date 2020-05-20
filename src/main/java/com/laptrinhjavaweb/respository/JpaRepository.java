package com.laptrinhjavaweb.respository;

import java.util.List;
import java.util.Map;

import com.laptrinhjavaweb.mapper.RowMapper;



public interface JpaRepository<T> {
	//List<T> findAll( );
	List<T> findAll(Map<String , Object> params ,Object ... where);
	List<T> findAll(String sql , Object ... where);
	void insert(String sql ,Object ... objects);
	void insert(Object object);
}
