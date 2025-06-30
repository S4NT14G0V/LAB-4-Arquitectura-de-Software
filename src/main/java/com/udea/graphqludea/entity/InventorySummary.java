package com.udea.graphqludea.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InventorySummary {

    private String region;
    private Long inTransit;
    private Long delivered;
    private Long pending;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Long getInTransit() {
        return inTransit;
    }

    public void setInTransit(Long inTransit) {
        this.inTransit = inTransit;
    }

    public Long getDelivered() {
        return delivered;
    }

    public void setDelivered(Long delivered) {
        this.delivered = delivered;
    }

    public Long getPending() {
        return pending;
    }

    public void setPending(Long pending) {
        this.pending = pending;
    }
}
