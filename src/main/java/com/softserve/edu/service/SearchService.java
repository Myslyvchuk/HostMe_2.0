package com.softserve.edu.service;

import java.util.List;

import com.softserve.edu.entity.Hosting;
import com.softserve.edu.utils.Search;

/**
 * Created by john_darkwood on 28.07.2014.
 */
public interface SearchService {
    public List<Hosting> getList(Search... parameters);
    public List<Hosting> getAll();

}