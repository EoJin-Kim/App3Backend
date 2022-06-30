package com.example.App3Backend.service;

import com.example.App3Backend.repository.MainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MainService {
    private final MainRepository mainRepository;
}
