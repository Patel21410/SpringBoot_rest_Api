package com.cdac.pojo;

import java.util.List;

import jakarta.annotation.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Setter
@Getter
@NoArgsConstructor
public class Property {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@NotEmpty
	String oname;
	@NotEmpty
	String ptype;
	@NotEmpty
	String address;
	@NotEmpty
	String city;
	@NotNull
	int pincode;
	@NotNull
	Long price;
	@Enumerated(EnumType.STRING)
	Property_type pt;
	@Override
	public String toString() {
		return "Property [id=" + id + ", oname=" + oname + ", ptype=" + ptype + ", address=" + address + ", city="
				+ city + ", pincode=" + pincode + ", price=" + price + ", pt=" + pt + "]";
	}	
}

