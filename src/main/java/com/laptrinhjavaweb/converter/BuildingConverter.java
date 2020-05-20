package com.laptrinhjavaweb.converter;

import org.modelmapper.ModelMapper;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
public class BuildingConverter {
	private ModelMapper modelMapper = new ModelMapper();
		
	public BuildingDTO convertEntityToDTO(BuildingEntity entity) {
		BuildingDTO buildingDTO = modelMapper.map(entity, BuildingDTO.class);
		return buildingDTO;
	}
	public BuildingEntity convertDTOToEntity(BuildingDTO dto) {
		BuildingEntity buildingEntity = modelMapper.map(dto, BuildingEntity.class);
		return buildingEntity;
	}
}
