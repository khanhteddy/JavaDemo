package com.example.demo.mapper;

import com.example.demo.dto.response.BookResponse;
import com.example.demo.entity.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mappings({
            //@Mapping(target = "id", source = "id")
            //@Mapping(target = "authorName", ignore = true)
    })
    BookResponse toResponse(BookEntity bookEntity);

    @Mappings({
            @Mapping(target = "isbn", constant = "xxx")
    })
    BookEntity toEntity(BookResponse bookResponse);

    List<BookResponse> map(List<BookEntity> bookEntityList);
}
