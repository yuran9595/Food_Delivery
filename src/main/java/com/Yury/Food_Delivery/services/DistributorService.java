package com.Yury.Food_Delivery.services;

import com.Yury.Food_Delivery.dto.DistributorDTORequest;
import com.Yury.Food_Delivery.dto.DistributorDTOResponse;

public interface DistributorService {
    DistributorDTOResponse createDistributor(DistributorDTORequest distributorDTO);
}
