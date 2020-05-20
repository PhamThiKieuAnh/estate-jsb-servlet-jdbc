package com.laptrinhjavaweb.respository;

import java.util.List;
import java.util.Map;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.entity.BuildingEntity;

public interface IBuildingRepository extends JpaRepository<BuildingEntity>{
	//void insert (NewEntity entity);
	List<BuildingEntity> findAll(Map<String , Object> params , BuildingSearchBuilder builder);
}
