package com.example.App3Backend.repository;

import com.example.App3Backend.entity.BoardTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<BoardTable, Integer> {
}
