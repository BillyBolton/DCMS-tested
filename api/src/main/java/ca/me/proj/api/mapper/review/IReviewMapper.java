package ca.me.proj.api.mapper.review;


import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ca.me.proj.api.dtos.review.ReviewDTO;
import ca.me.proj.api.entity.review.ReviewEntity;
import ca.me.proj.api.mapper.base.IBaseMapper;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IReviewMapper extends IBaseMapper<ReviewDTO, ReviewEntity> {

    // ReviewDTO entityToDto(ReviewEntity entity);

    // ReviewEntity dtoToEntity(ReviewDTO dto);

}
