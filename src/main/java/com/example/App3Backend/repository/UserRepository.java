package com.example.App3Backend.repository;

import com.example.App3Backend.entity.BoardTable;
import com.example.App3Backend.entity.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserTable, Integer> {
}
