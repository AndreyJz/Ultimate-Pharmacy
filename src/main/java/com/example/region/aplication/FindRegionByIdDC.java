package com.example.region.aplication;

import com.example.region.domain.entity.Region;
import com.example.region.domain.service.RegionService;

import java.util.Optional;

public class FindRegionByIdDC {
    private final RegionService regionService;

    public FindRegionByIdDC(RegionService regionService) {
        this.regionService = regionService;
    }

    public Optional<Region> execute(String id) { return regionService.findRegionById(id); }
}
