package com.Yury.Food_Delivery.services.Impl;

import com.Yury.Food_Delivery.controllers.ProductCategoryController;
import com.Yury.Food_Delivery.dto.DistributorDTORequest;
import com.Yury.Food_Delivery.dto.DistributorDTOResponse;
import com.Yury.Food_Delivery.models.Distributor;
import com.Yury.Food_Delivery.repository.DistributorRepository;
import com.Yury.Food_Delivery.repository.UserRepository;
import com.Yury.Food_Delivery.services.DistributorService;
import com.Yury.Food_Delivery.transformers.DistributorDTOToDistributorTransformer;
import com.Yury.Food_Delivery.transformers.DistributorToDistributorDTOResponseTransformer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DistributorServiceImpl implements DistributorService {
    private final DistributorDTOToDistributorTransformer distributorDTOToDistributorTransformer;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final DistributorRepository distributorRepository;
    private final DistributorToDistributorDTOResponseTransformer distributorToDistributorDTOResponseTransformer;
    @Override
    public DistributorDTOResponse createDistributor(DistributorDTORequest distributorDTO) {
        Distributor distributor = distributorDTOToDistributorTransformer.transform(distributorDTO);
        distributor.setPassword(passwordEncoder.encode(distributor.getPassword()));
        Distributor save = distributorRepository.save(distributor);
        log.info("Добавлен новый дистрибьютер " + save.getLogin());
        return distributorToDistributorDTOResponseTransformer.transform(save);
    }
}
