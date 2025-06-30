package com.udea.graphqludea.service;

import com.udea.graphqludea.entity.InventorySummary;
import com.udea.graphqludea.interfaces.IInventoryService;
import com.udea.graphqludea.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InventoryService implements IInventoryService {

    private final InventoryRepository inventoryRepo;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepo) {
        this.inventoryRepo = inventoryRepo;
    }

    @Override
    public List<InventorySummary> findSummary(LocalDateTime start,
                                                        LocalDateTime end,
                                                        String region) {
        return inventoryRepo.summaryByPeriodAndRegion(start, end, region);
    }
}

