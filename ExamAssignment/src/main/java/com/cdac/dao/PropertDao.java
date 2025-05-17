package com.cdac.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cdac.pojo.Property;
import com.cdac.pojo.Property_type;

public interface PropertDao extends JpaRepository<Property, Long>{

	List<Property>findAllBypt(Property_type ptype);
	List<Property> findAllBycity(String city);
	List<Property>findAllByprice(Long price);
//	@Query("update property p set name=:fname where price=:olprice");
//	String updateNamebyprice(String fname,Long olprice);
	
	// @Query("UPDATE Property p SET p.oname = :fname WHERE p.price = :olprice")
	 //int updateNameByPrice(@Param("fname") String fname, @Param("olprice") Long olprice);
	
	 
	 @Modifying
	 @Query("UPDATE Property p SET p.city = :city WHERE p.id = :id")
	 int updateCityById(@Param("city") String city, @Param("id") Long id);
}
