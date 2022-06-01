package ca.me.proj.api.mapper.payment.insurance.claim;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ca.me.proj.api.dtos.payment.insurance.claim.InsuranceClaimDTO;
import ca.me.proj.api.entity.payment.insurance.claim.InsuranceClaimEntity;
import ca.me.proj.api.mapper.base.IBaseMapper;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IInsuranceClaimMapper
        extends IBaseMapper<InsuranceClaimDTO, InsuranceClaimEntity> {

}
