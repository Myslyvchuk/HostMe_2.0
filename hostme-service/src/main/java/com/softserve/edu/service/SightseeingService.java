package com.softserve.edu.service;

import java.util.List;

import com.softserve.edu.dto.SightseeingDto;
import com.softserve.edu.model.Sightseeing;

public interface SightseeingService {

	public boolean haveSight(int id);

	List<SightseeingDto> getAllSightseeings();

	List<SightseeingDto> getSightseeingsDtoList(List<Sightseeing> sightseeings);

	List<Sightseeing> getSightseeingsLike(String search);

	Sightseeing findOne(Integer id);

	void deleteSightseeing(Sightseeing sightseeing);

	void saveSightseeing(Sightseeing sightseeing);
}
