package com.triplan.planner.tour.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.triplan.planner.tour.dto.Attraction;

import java.net.URISyntaxException;
import java.util.List;

public interface TourService {

    public void saveTour(String contentId)throws URISyntaxException, JsonProcessingException;

    public List<Attraction> tourList(List<String> areaCode);
}
