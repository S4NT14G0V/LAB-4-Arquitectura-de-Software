package com.udea.graphqludea.dto;

import lombok.Data;

@Data
public class PackageCountByUserDTO {
    private Long userId;
    private Long packageCount;

    public PackageCountByUserDTO(){
    }

    public PackageCountByUserDTO(Long userId, Long packageCount) {
        this.userId = userId;
        this.packageCount = packageCount;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPackageCount() {
        return packageCount;
    }

    public void setPackageCount(Long packageCount) {
        this.packageCount = packageCount;
    }
}
