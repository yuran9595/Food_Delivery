package com.Yury.Food_Delivery.transformers;

import com.Yury.Food_Delivery.dto.DistributorDTORequest;
import com.Yury.Food_Delivery.enums.UserRole;
import com.Yury.Food_Delivery.models.Distributor;
import org.springframework.stereotype.Component;

@Component
public class DistributorDTOToDistributorTransformer extends Transformer<Distributor, DistributorDTORequest> {
    @Override
    public Distributor transform(DistributorDTORequest distributorDTO) {
        Distributor distributor = new Distributor();
        distributor.setName(distributorDTO.getNameOfDistributorCompany());
        distributor.setPassword(distributorDTO.getPassword());
        distributor.setLogin(distributorDTO.getLogin());
        distributor.setActive(false);
        distributor.getUserRoles().add(UserRole.ROLE_DISTRIBUTOR);
        return distributor;
    }
}
