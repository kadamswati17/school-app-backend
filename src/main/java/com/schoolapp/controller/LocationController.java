package com.schoolapp.controller;

import org.springframework.web.bind.annotation.*;

import com.schoolapp.dao.CityResponseDto;
import com.schoolapp.dao.TalukaResponseDto;
import com.schoolapp.entity.City;
import com.schoolapp.entity.District;
import com.schoolapp.entity.State;
import com.schoolapp.entity.Taluka;
import com.schoolapp.service.LocationService;

//import com.Crmemp.dto.request.CityResponseDto;
//import com.Crmemp.dto.request.TalukaResponseDto;
//import com.Crmemp.entity.City;
//import com.Crmemp.entity.District;
//import com.Crmemp.entity.State;
//import com.Crmemp.entity.Taluka;
//import com.Crmemp.services.LocationService;

import java.util.List;

@RestController
@RequestMapping("/api/location")
@CrossOrigin(origins = "*")
public class LocationController {

	private final LocationService service;

	public LocationController(LocationService service) {
		this.service = service;
	}

	// ================= GET =================

	@GetMapping("/states")
	public List<State> getStates() {
		return service.getStates();
	}

	// ✅ FILTERED GET (IMPORTANT)
	@GetMapping("/districts/{stateId}")
	public List<District> getDistrictsByState(@PathVariable Long stateId) {
		return service.getDistrictsByState(stateId);
	}
	

//	@GetMapping("/talukas/{districtId}")
//	public List<Taluka> getTalukasByDistrict(@PathVariable Long districtId) {
//		return service.getTalukasByDistrict(districtId);
//	}

	@GetMapping("/cities/{talukaId}")
	public List<City> getCitiesByTaluka(@PathVariable Long talukaId) {
		return service.getCitiesByTaluka(talukaId);
	}


	
	// ================= GET ALL (MASTER) =================

	@GetMapping("/districts")
	public List<District> getAllDistricts() {
		return service.getAllDistricts();
	}

	@GetMapping("/talukas")
	public List<Taluka> getAllTalukas() {
		return service.getAllTalukas();
	}

	@GetMapping("/cities")
	public List<CityResponseDto> getAllCities() {
	    return service.getAllCitiesDto();
	}

	@GetMapping("/cities/by-taluka/{talukaId}")
	public List<CityResponseDto> getCitiesByTalukaDto(
	        @PathVariable Long talukaId) {
	    return service.getCitiesByTalukaDto(talukaId);
	}


	// ================= POST =================

	@PostMapping("/states")
	public State saveState(@RequestBody State state) {
		return service.saveState(state);
	}

	@PostMapping("/districts/{stateId}")
	public District saveDistrict(@PathVariable Long stateId, @RequestBody District district) {
		return service.saveDistrict(stateId, district);
	}
	@PutMapping("/cities/{id}/{talukaId}")
	public City updateCity(
	        @PathVariable Long id,
	        @PathVariable Long talukaId,
	        @RequestBody City city) {

	    return service.updateCity(id, talukaId, city);
	}

	@PutMapping("/districts/{id}/{stateId}")
	public District updateDistrict(
	        @PathVariable Long id,
	        @PathVariable Long stateId,
	        @RequestBody District district) {

	    return service.updateDistrict(id, stateId, district);
	}

	@PutMapping("/talukas/{id}/{districtId}")
	public Taluka updateTaluka(
	        @PathVariable Long id,
	        @PathVariable Long districtId,
	        @RequestBody Taluka taluka) {

	    return service.updateTaluka(id, districtId, taluka);
	}

	@PostMapping("/talukas/{districtId}")
	public Taluka saveTaluka(@PathVariable Long districtId, @RequestBody Taluka taluka) {
		return service.saveTaluka(districtId, taluka);
	}

//	@PostMapping("/cities/{talukaId}")
//	public City saveCity(@PathVariable Long talukaId, @RequestBody City city) {
//		return service.saveCity(talukaId, city);
//	}
	@PostMapping("/cities/{talukaId}")
	public City saveCity(
	        @PathVariable Long talukaId,
	        @RequestBody City city) {
	    return service.saveCity(talukaId, city);
	}
	
	@GetMapping("/talukas/{districtId}")
	public List<TalukaResponseDto> getTalukasByDistrict(@PathVariable Long districtId) {
	    return service.getTalukasByDistrictDto(districtId);
	}
}


