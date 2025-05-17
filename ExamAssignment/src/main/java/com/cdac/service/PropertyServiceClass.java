package com.cdac.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdac.dao.PropertDao;
import com.cdac.dto.PropertyResDto;
import com.cdac.pojo.Property;
import com.cdac.pojo.Property_type;

import lombok.AllArgsConstructor;


@Service
@Transactional
@AllArgsConstructor

public class PropertyServiceClass implements PropertyInterface {

    private ModelMapper modelMapper;
	
	@Autowired
	PropertDao propertyDao;
	
	@Override
	public PropertyResDto addProperty(PropertyResDto ppt) {
		Property saveProperty = propertyDao.save(modelMapper.map(ppt, Property.class));
		PropertyResDto s=modelMapper.map(saveProperty, PropertyResDto.class);
		return s;
	}

	@Override
	public List<PropertyResDto> fetchallProperty() {
		List<Property> allData = propertyDao.findAll();
		@SuppressWarnings("unchecked")
		List<PropertyResDto> newMap = allData.stream()
		.map(str->modelMapper.map(str, PropertyResDto.class)).collect(Collectors.toList());
		return newMap;
	}

	@Override
	public List<Property> matchByType(Property_type ptype) {
		List<Property> byPropertylist = propertyDao.findAllBypt(ptype);
		return byPropertylist;
	}

	@Override
	public int updateByprice(Long price,String name) {
		// TODO Auto-generated method stub
//		propertyDao.findByPrice(price,name);
//		propertyDao.findAllByPrice(price);
		int updateint = propertyDao.updateCityById(name,price);
		return updateint;
	}

	@Override
	public List<Property> searchbyCIty(String city) {
		List<Property> searchbyPropertylist = propertyDao.findAllBycity(city);
		return searchbyPropertylist;
	}

	@Override
	public String deleteByid(Long id) {
		propertyDao.deleteById(id);
		return "deleteed";
	}

	@Override
	public List<Property> findsAllByPrice(Long price) {
		List<Property> allByPrice = propertyDao.findAllByprice(price);
		return allByPrice;
	}

	
	
}
