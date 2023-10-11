package com.Yury.Food_Delivery.repository;

import com.Yury.Food_Delivery.models.Distributor;
import com.Yury.Food_Delivery.services.Impl.DistributorServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistributorRepository extends JpaRepository<Distributor, Long> {

}
