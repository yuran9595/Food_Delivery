package com.Yury.Food_Delivery.transformers;

import com.Yury.Food_Delivery.dto.DistributorDTOResponse;
import com.Yury.Food_Delivery.dto.UserDTOResponse;
import com.Yury.Food_Delivery.models.Distributor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
@RequiredArgsConstructor
@Component
public class DistributorToDistributorDTOResponseTransformer extends Transformer<DistributorDTOResponse, Distributor>{
    private final UserToUserDTOResponseTransformer userToUserDTOResponseTransformer;
    @Override
    public DistributorDTOResponse transform(Distributor distributor) {
        DistributorDTOResponse distributorDTOResponse = (DistributorDTOResponse) userToUserDTOResponseTransformer.transform(distributor);
        distributorDTOResponse.setName(distributor.getName());
        return distributorDTOResponse;
    }
}
