package com.softserve.edu.repositories.routes;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.softserve.edu.model.City;
import com.softserve.edu.model.PriceCategory;
import com.softserve.edu.model.User;
import com.softserve.edu.model.routes.Place;

public interface PlaceRepository extends PagingAndSortingRepository<Place, Integer> {



	public List<Place> findByOwnerNot(User owner);

    public List<Place> findByCity(City city);
	
	public List<Place> findByOwner(User owner);
	
	public List<Place> findByPriceCategory(PriceCategory priceCategory);
	
	public List<Place> findByWebsite(String website);
}
