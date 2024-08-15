package com.example.region.aplication;

import com.example.region.domain.entity.Region;
import com.example.region.domain.service.RegionService;

import java.util.Optional;

public class FindRegionByNameUC {
    private final RegionService regionService;

    public FindRegionByNameUC(RegionService regionService) {
        this.regionService = regionService;
    }

    public Optional<Region> execute(String name) { return regionService.findRegionByName(name); }
}
