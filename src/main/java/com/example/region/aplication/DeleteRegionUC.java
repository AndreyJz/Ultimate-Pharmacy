package com.example.region.aplication;

import com.example.region.domain.service.RegionService;

public class DeleteRegionUC {
    private final RegionService regionService;

    public DeleteRegionUC(RegionService regionService) {
        this.regionService = regionService;
    }

    public void execute(String id) { regionService.deleteRegion(id); }
}
