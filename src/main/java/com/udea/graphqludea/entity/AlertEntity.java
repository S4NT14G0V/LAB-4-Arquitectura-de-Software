package com.udea.graphqludea.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="alert")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AlertEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name="package_id", nullable = false)
    private PackageEntity packageEntity;

    @ManyToOne
    @JoinColumn(name="alert_type_id", nullable = false)
    private AlertTypeEntity alertTypeEntity;

    private String description;

    @Column(nullable = false, updatable = false)
    private LocalDateTime registeredAt;

    // TODO: Revisar la Pre Persistencia
    @PrePersist
    public void prePersist() {
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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public PackageEntity getPackageEntity() {
        return packageEntity;
    }

    public void setPackageEntity(PackageEntity packageEntity) {
        this.packageEntity = packageEntity;
    }

    public AlertTypeEntity getAlertTypeEntity() {
        return alertTypeEntity;
    }

    public void setAlertTypeEntity(AlertTypeEntity alertTypeEntity) {
        this.alertTypeEntity = alertTypeEntity;
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
}
