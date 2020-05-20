package com.laptrinhjavaweb.respository.imp;


import java.util.List;
import java.util.Map;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.respository.IBuildingRepository;

public class BuildingRepository extends SimpleJpaRepository<BuildingEntity> implements IBuildingRepository {

	

	@Override
	public List<BuildingEntity> findAll( Map <String , Object > params ,BuildingSearchBuilder builder) {
		StringBuilder result = new StringBuilder("select * from building A where 1=1");
		result = this.createSQLfindAllCommon(result , params);
		return this.findAll(result.toString());
		
	}

//	private StringBuilder createSQLfindAllCommon(StringBuilder sql, Map <String , Object > params ) {
////		if(builder.getName() != null) {
////			sql.append(" and b.name like '%"+ builder.getName()+"%'");
////		}
////		if(builder.getDistrict() != null) {
////			sql.append(" and b.name like '%"+ builder.getDistrict()+"%'");
////		}
////		if(builder.getNumberOfBasement() != null) {
////			sql.append(" and b.name like '%"+ builder.getNumberOfBasement()+"%'");
////		}
////			
////		if(builder.getFloorArea() != null) {
////			sql.append(" and b.name like '%"+ builder.getFloorArea()+"%'");
////		}
//		/// lay ra 2 giatri key vaf value de put vo mang keys vaf values 
//		if(params != null &&params.size() >0) {
//			//tao 2 mang , key va value
//			String[] keys = new String[params.size()];
//			Object [] values = new Object [params.size()];
//			int i = 0;
//			for (Map.Entry<String, Object> item : params.entrySet()) {
//				keys[i] = item.getKey();
//				values[i] = item.getValue();
//				i++;
//			}
//				//xu ly tu dong
//			//chay vong lap de lay key , con values laf ga tri tuown ung cap di kem , chay vong lap trong key la duwoc
//				for (int i1 = 0 ;i1 < keys.length ; i1++) {
//					if(values[i1] instanceof String ) {
//						if(StringUtils.isNotBlank(values[i1].toString())) {
//							// cach and 
//							sql.append("  AND b."+keys[1]+" like '%"+values[i1] +"%'");
//						}
//					}
//					else {
//						if(values[i1] != null) {
//							sql.append(" AND b."+keys[1]+" = "+values[i1] +"");
//						
//						}
//					}
//				}
//				
//				
//				
//			
//		}
//		return sql;
//	}





	
}
	

