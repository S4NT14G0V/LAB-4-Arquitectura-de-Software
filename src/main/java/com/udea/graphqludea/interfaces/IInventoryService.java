package com.udea.graphqludea.interfaces;

import com.udea.graphqludea.entity.InventorySummary;

import java.time.LocalDateTime;
import java.util.List;

public interface IInventoryService {
    List<InventorySummary> findSummary(LocalDateTime start,
                                                 LocalDateTime end,
                                                 String region);
}
