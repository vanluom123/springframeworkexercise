package com.pvanluom.springframeworkexercise.repository;

import com.pvanluom.springframeworkexercise.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill, String> {
}