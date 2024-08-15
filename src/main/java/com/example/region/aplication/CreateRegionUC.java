package com.example.region.aplication;

import com.example.region.domain.entity.Region;
import com.example.region.domain.service.RegionService;

public class CreateRegionUC {
    private final RegionService regionService;

    public CreateRegionUC(RegionService regionService) {
        this.regionService = regionService;
    }

    public void execute (Region region){
        regionService.createRegion(region);
    }
}
