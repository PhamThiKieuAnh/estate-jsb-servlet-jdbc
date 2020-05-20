package com.laptrinhjavaweb;

import java.util.List;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.service.IBuildingService;
import com.laptrinhjavaweb.service.imp.BuildingService;

public class EstateApplication {
	public static void main(String[] args) {
		//gia data để test
		String name= "tower";
		String district = "QUAN_1";
		String [] types = new String[] { "TANG_TRET","NGUYEN_CAN"};
		String rentAreaFrom = "300";
		String rentAreaTo = "500";
		String rentCostFrom = "1";
		String rentCostTo = "2";
		String numberOfBasement ="2";
		String floorArea = "500";
		BuildingSearchBuilder builder  = new BuildingSearchBuilder.Builder()
				.setName(name) .setDistrict(district).setNumberOfBasement(numberOfBasement)
				.setFloorArea(floorArea)
				.build();
		IBuildingService buildingService = new BuildingService();
		List<BuildingDTO> result= buildingService.findAll(builder);
		System.out.println(result);
	}
}
