package ru.neoflex.ec.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import ru.neoflex.ec.project.entity.ProductEntity;

@Component
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    @Modifying
    @Query(value = "select * from public.product p where p.count > 0", nativeQuery = true)
    void findByAvailable();

    @Modifying
    @Query(value = "select p.count from public.product p where p.id = :idProduct", nativeQuery = true)
    void findByCount(@Param("idProduct") Long id);
}
