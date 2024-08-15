package com.example.region.aplication;

import com.example.region.domain.entity.Region;
import com.example.region.domain.service.RegionService;

import java.util.List;

public class ListRegionsUC {
    private final RegionService regionService;

    public ListRegionsUC(RegionService regionService) {
        this.regionService = regionService;
    }

    public List<Region> execute() { return regionService.findAllCRegions(); }
}
