package ca.me.proj.mapper.payment.patient.billing;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ca.me.proj.dtos.payment.patient.billing.PatientBillingDTO;
import ca.me.proj.entity.payment.patient.billing.PatientBillingEntity;
import ca.me.proj.mapper.base.IBaseMapper;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IPatientBillingMapper
                extends IBaseMapper<PatientBillingDTO, PatientBillingEntity> {

}
