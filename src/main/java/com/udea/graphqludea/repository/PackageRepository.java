package com.udea.graphqludea.repository;

import com.udea.graphqludea.dto.PackageCountByUserDTO;
import com.udea.graphqludea.entity.PackageEntity;
import com.udea.graphqludea.entity.PackageStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface PackageRepository extends JpaRepository<PackageEntity, Long> {

    Optional<PackageEntity> findByTrackingCode(String trackingCode);

    List<PackageEntity> findByRegisteredAtBetween(LocalDateTime startDate, LocalDateTime endDate);

    List<PackageEntity> findByRegisteredAtAfter(LocalDateTime startDate);

    List<PackageEntity> findByRegisteredAtBefore(LocalDateTime endDate);

    @Query("SELECT new com.udea.graphqludea.dto.PackageCountByUserDTO(p.ownerUser.id, COUNT(p)) " +
            "FROM PackageEntity p WHERE p.ownerUser.id = :userId " +
            "GROUP BY p.ownerUser.id")
    PackageCountByUserDTO findCountByUserId(@Param("userId") Long userId);

    @Query(value = """
            SELECT new com.udea.graphqludea.dto.PackageCountByUserDTO(
                p.ownerUser.id, COUNT(p))
            FROM PackageEntity p
            GROUP BY p.ownerUser.id
            """)
    List<PackageCountByUserDTO> findCountByAllUsers();

    List<PackageEntity> findByStatusIn(List<PackageStatusEntity> packageStatusEntities);

    List<PackageEntity> findAllByOwnerUser_Id(Long ownerUserId);

    List<PackageEntity> findAllByDestination(String destination);

    List<PackageEntity> findAllByOrigin(String origin);

    List<PackageEntity> findAllByOriginAndDestination(String origin, String destination);
}
