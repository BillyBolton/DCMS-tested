package ca.me.proj.api.mapper.payment.patient.billing;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ca.me.proj.api.dtos.payment.patient.billing.PatientBillingDTO;
import ca.me.proj.api.entity.payment.patient.billing.PatientBillingEntity;
import ca.me.proj.api.mapper.base.IBaseMapper;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IPatientBillingMapper
        extends IBaseMapper<PatientBillingDTO, PatientBillingEntity> {

}
