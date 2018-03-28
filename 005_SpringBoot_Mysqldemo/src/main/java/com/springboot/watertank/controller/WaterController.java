package com.springboot.watertank.controller;


	import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RestController;


	@RestController
	@RequestMapping("/water")
	public class WaterController {
		
		@Autowired
		private WaterRepository waterRepository;
		
		@RequestMapping("/welcome")
		public String welcome() {
			return "Welcome to FREE Water at CTS!!!";
		}
		
		@RequestMapping("/welcome/free")
		public String welcomefree() {
			return "You win 1 ltr of free cocktail!!!";
		}
		
		@RequestMapping(value="/add", method=RequestMethod.POST)
		public String addWater(@RequestBody UseWater usewater) {
			
			waterRepository.save(usewater);
			return "Saved the water in water tank: " + usewater.getQuantity() + " " + usewater.getContainer();
			
		}
		
		@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
		public String deleteWater(@PathVariable Integer id) {
			
			waterRepository.deleteById(id);
			return "Emptied water in water tank";
			
		}
		
		@RequestMapping("/getallwater")
		public List<UseWater> getAllWater(){
		 List<UseWater> allwater=new ArrayList<>();
		waterRepository.findAll().forEach(allwater::add);
	
		return allwater;
		}
		
		@RequestMapping(method=RequestMethod.POST, value="/update/{id}")
		public String update(@RequestBody UseWater uw,@PathVariable Integer id) {
			//waterRepository.save(new UseWater(id,uw.getContainer(),uw.getQuantity()));
			uw.setId(id);
			uw.setContainer(uw.getContainer());
			uw.setQuantity(uw.getQuantity());
			waterRepository.save(uw);
			return "details are updated" + uw.getContainer() + " "+uw.getId() +" "+ uw.getQuantity();
		}
	}
