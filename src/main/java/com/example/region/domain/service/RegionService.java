package com.example.region.domain.service;

import com.example.region.domain.entity.Region;

import java.util.List;
import java.util.Optional;

public interface RegionService {
    void createRegion(Region region);
    void updateRegion(Region region);
    void deleteRegion(String id);
    Optional<Region> findRegionById(String id);
    List<Region> findAllCRegions();
    Optional<Region> findRegionByName(String name);
}
