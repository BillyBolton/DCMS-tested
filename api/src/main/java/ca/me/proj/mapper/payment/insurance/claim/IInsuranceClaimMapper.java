package ca.me.proj.mapper.payment.insurance.claim;

import org.mapstruct.Mapper;
import ca.me.proj.dtos.payment.insurance.claim.InsuranceClaimDTO;
import ca.me.proj.entity.payment.insurance.claim.InsuranceClaimEntity;
import ca.me.proj.mapper.base.IBaseMapper;

@Mapper
public interface IInsuranceClaimMapper
        extends IBaseMapper<InsuranceClaimDTO, InsuranceClaimEntity> {

}
