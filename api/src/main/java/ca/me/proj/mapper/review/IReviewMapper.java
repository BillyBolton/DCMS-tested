package ca.me.proj.mapper.review;


import java.util.List;
import org.mapstruct.Mapper;

import ca.me.proj.dtos.review.ReviewDTO;
import ca.me.proj.entity.review.ReviewEntity;


@Mapper
public interface IReviewMapper {
    
    ReviewDTO entityToDto(ReviewEntity entity);

    ReviewEntity dtoToEntity(ReviewDTO dto);

    List<ReviewEntity> dtoToEntity(Iterable<ReviewDTO> dtos);

    List<ReviewDTO> entityToDto(Iterable<ReviewEntity> entities);
}
