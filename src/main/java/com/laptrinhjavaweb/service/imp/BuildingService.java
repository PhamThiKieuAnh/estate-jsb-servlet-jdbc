package com.laptrinhjavaweb.service.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.respository.IBuildingRepository;
import com.laptrinhjavaweb.respository.imp.BuildingRepository;
import com.laptrinhjavaweb.service.IBuildingService;

public class BuildingService implements IBuildingService{
	private IBuildingRepository buildingRepository = new BuildingRepository();
	private BuildingConverter buildingConverter = new BuildingConverter();
	@Override
	public List<BuildingDTO> findAll(BuildingSearchBuilder builder) {
		
		List<BuildingDTO> results = new ArrayList<>();
		Map<String , Object> params  = new HashMap<>();
		params.put("name", builder.getName());
		params.put("district", builder.getDistrict());
		params.put("numberofbasement", 
				StringUtils.isNotBlank(builder.getNumberOfBasement())? Integer.parseInt(builder.getNumberOfBasement()) : null);
		params.put("floorarea", 
				StringUtils.isNotBlank(builder.getFloorArea()) ? Integer.parseInt(builder.getFloorArea()) : null);
		
		List<BuildingEntity> entities = buildingRepository.findAll(params, builder);
		//java 7
		for(BuildingEntity item : entities) {
			BuildingDTO dto = buildingConverter.convertEntityToDTO(item);
			results.add(dto);
		}
		//java8
		//List<BuildingDTO> results = entities.stream().map(item -> buildingConverter.convertEntityToDTO(item)).collect(Collectors.toList());

			return results;
	}
	
	
}
