package ca.me.proj.service.payment.insurance.claim;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ca.me.proj.dtos.payment.insurance.claim.InsuranceClaimDTO;
import ca.me.proj.mapper.payment.insurance.claim.IInsuranceClaimMapper;
import ca.me.proj.repository.payment.insurance.claim.IInsuranceClaimRepository;

@Service
public class InsuranceClaimService {

    @Autowired
    private IInsuranceClaimMapper mapper;

    @Autowired
    private IInsuranceClaimRepository repository;

    public List<InsuranceClaimDTO> findAll() {
        return mapper.entityToDto(repository.findAll());
    }

    public InsuranceClaimDTO save(InsuranceClaimDTO dto) {
        return mapper.entityToDto(repository.save(mapper.dtoToEntity(dto)));
    }

}
