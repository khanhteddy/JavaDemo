package com.example.demo.repository;

import com.example.demo.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookEntity,Long> {
    List<BookEntity> findByBookName(String bookName);


    @Query(value = "select * from books where book_name= :bookName", nativeQuery = true  )
    List<BookEntity> findPhucTap(String bookName);
}
