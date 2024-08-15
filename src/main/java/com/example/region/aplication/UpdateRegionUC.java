package com.example.region.aplication;

import com.example.region.domain.entity.Region;
import com.example.region.domain.service.RegionService;

public class UpdateRegionUC {
    private final RegionService regionService;

    public UpdateRegionUC(RegionService regionService) {
        this.regionService = regionService;
    }

    public void execute(Region region) { regionService.updateRegion(region); };
}
