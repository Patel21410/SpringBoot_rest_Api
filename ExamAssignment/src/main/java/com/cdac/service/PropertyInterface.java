package com.cdac.service;

import java.util.List;

import com.cdac.dto.PropertyResDto;
import com.cdac.pojo.Property;
import com.cdac.pojo.Property_type;

public interface PropertyInterface {
	/*
	 * add property
	 * fetch all property
	 * fetch matche type property
	 * update property by price
	 * search property by city
	 * 
	 * payload validation
	 * proper responese code
	 * error handliang
	 * All entity they have
	 * */
	PropertyResDto addProperty(PropertyResDto ppt);
	List<PropertyResDto> fetchallProperty();
	List<Property> matchByType(Property_type ptype);
	int updateByprice(Long price,String name);
	List<Property> searchbyCIty(String city);
	String deleteByid(Long id);
	List<Property>findsAllByPrice(Long price);
}
