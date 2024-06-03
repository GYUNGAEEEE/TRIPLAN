package com.triplan.planner.tour.repository;

import com.triplan.planner.tour.dto.Api;
import com.triplan.planner.tour.dto.Attraction;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TourMapper {
    public void insertTourList(Api api);
    public List<Attraction> tourList(List<String> areaCode);
}
