package com.udea.graphqludea.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "package_table")
public class PackageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="owner_user_id", nullable = false)
    private UserEntity ownerUser;

    @ManyToOne
    @JoinColumn(name="status_id", nullable = false)
    private PackageStatusEntity status;

    @Column(name = "tracking_code", updatable = false, nullable = false, unique = true)
    private String trackingCode;

    private String description;

    @Column(nullable = false, updatable = false)
    private LocalDateTime registeredAt;

    @Column(nullable = false)
    private String origin;

    @Column(nullable = false)
    private String destination;

    @OneToMany(mappedBy = "packageEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LocationEntity> locationEntities;

    @OneToMany(mappedBy = "packageEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AlertEntity> alertEntities;

    // TODO: Revisar la Pre Persistencia
    @PrePersist
    public void prePersist() {
        if (trackingCode == null) {
            trackingCode = UUID.randomUUID().toString();
        }
        if (registeredAt == null) {
            registeredAt = LocalDateTime.now();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getOwnerUser() {
        return ownerUser;
    }

    public void setOwnerUser(UserEntity ownerUser) {
        this.ownerUser = ownerUser;
    }

    public PackageStatusEntity getStatus() {
        return status;
    }

    public void setStatus(PackageStatusEntity status) {
        this.status = status;
    }

    public String getTrackingCode() {
        return trackingCode;
    }

    public void setTrackingCode(String trackingCode) {
        this.trackingCode = trackingCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(LocalDateTime registeredAt) {
        this.registeredAt = registeredAt;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public List<LocationEntity> getLocationEntities() {
        return locationEntities;
    }

    public void setLocationEntities(List<LocationEntity> locationEntities) {
        this.locationEntities = locationEntities;
    }

    public List<AlertEntity> getAlertEntities() {
        return alertEntities;
    }

    public void setAlertEntities(List<AlertEntity> alertEntities) {
        this.alertEntities = alertEntities;
    }
}
