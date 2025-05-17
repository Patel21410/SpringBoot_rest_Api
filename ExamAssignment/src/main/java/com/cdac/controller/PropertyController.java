package com.cdac.controller;

import java.util.List;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.dto.PropertyResDto;
import com.cdac.pojo.Property;
import com.cdac.pojo.Property_type;
import com.cdac.service.PropertyInterface;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@RestController
public class PropertyController {
	private PropertyInterface serviceProvider;
	
		@GetMapping("/allproperty")
		public ResponseEntity<?> getAllProperty(){
			List<PropertyResDto> fetchallProperty = serviceProvider.fetchallProperty();
			return ResponseEntity.ok(fetchallProperty);
		}
		@PostMapping("/insertproperty")
		public ResponseEntity<?> insertproperty(@RequestBody PropertyResDto pyr){
			PropertyResDto propertys = serviceProvider.addProperty(pyr);
			return ResponseEntity.ok(propertys);
		}
		@GetMapping("/findAllByPrice/{price}")
		public ResponseEntity<?> finbByPrice(@PathVariable Long price){
			List<Property> findsAllByPrices = serviceProvider.findsAllByPrice(price);
			return ResponseEntity.ok(findsAllByPrices);
		}
		@GetMapping("/allpropertybyCategory/{catgory}")
		public ResponseEntity<?> allPropertybyCategory(@PathVariable Property_type catgory){
			List<Property> matchByType = serviceProvider.matchByType(catgory);
			return ResponseEntity.ok(matchByType);
		}
		@GetMapping("/allpropertybycity/{city}")
		public ResponseEntity<?> allPropertybyCategory(@PathVariable String city){
			List<Property> searchbyCItys = serviceProvider.searchbyCIty(city);
			return ResponseEntity.ok(searchbyCItys);
		}
		@PutMapping("/update/{price}/{name}")
		public ResponseEntity<?> updatePlayer(@PathVariable Long price, @PathVariable String name){
			int updatevariable = serviceProvider.updateByprice(price, name);
			return ResponseEntity.ok(updatevariable);
		}
		@DeleteMapping("/deletedata/{id}")
		public ResponseEntity<?> updatePlayer(@PathVariable Long id){
			String deletePlayer = serviceProvider.deleteByid(id);
			return ResponseEntity.ok(deletePlayer);
		}
}
