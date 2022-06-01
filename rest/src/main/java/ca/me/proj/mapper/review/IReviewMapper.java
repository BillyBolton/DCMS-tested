package ca.me.proj.mapper.review;


import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ca.me.proj.dtos.review.ReviewDTO;
import ca.me.proj.entity.review.ReviewEntity;
import ca.me.proj.mapper.base.IBaseMapper;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IReviewMapper extends IBaseMapper<ReviewDTO, ReviewEntity> {

    // ReviewDTO entityToDto(ReviewEntity entity);

    // ReviewEntity dtoToEntity(ReviewDTO dto);

}
