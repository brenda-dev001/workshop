package com.project.workshop.services;

import com.project.workshop.entities.Order;
import com.project.workshop.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> findAll(){
        return repository.findAll();
    }

    public Optional<Order> findById(Long id){
        return repository.findById(id);
    }
}
