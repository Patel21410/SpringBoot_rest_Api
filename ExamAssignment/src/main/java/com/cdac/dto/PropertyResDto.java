package com.cdac.dto;


import com.cdac.pojo.Property_type;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertyResDto {
	String oname;
	String ptype;
	String address;
	String city;
	int pincode;
	Long price;
	Property_type pt;
}
