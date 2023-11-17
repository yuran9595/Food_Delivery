package com.Yury.Food_Delivery.transformers;

import com.Yury.Food_Delivery.dto.DistributorDTOResponse;
import com.Yury.Food_Delivery.models.Distributor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
@RequiredArgsConstructor
@Component
public class DistributorToDistributorDTOResponseTransformer extends Transformer<DistributorDTOResponse, Distributor>{
    @Override
    public DistributorDTOResponse transform(Distributor distributor) {
        DistributorDTOResponse distributorDTOResponse = new DistributorDTOResponse();
        distributorDTOResponse.setId(distributor.getId());
        distributorDTOResponse.setName(distributor.getName());
        distributorDTOResponse.setActive(distributor.getActive());
        distributorDTOResponse.setUserRole(distributor.getUserRoles());
        return distributorDTOResponse;
    }
}
