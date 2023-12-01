package com.deb.qbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;

import com.deb.qbe.model.Customers;

@Repository
public interface CustomerRepository extends JpaRepository<Customers, Long>{

    @Query(value = "SELECT * FROM customers WHERE balance>=:min and balance<=:max", nativeQuery = true)
    List<Customers> getBalanceBetween(@Param("min")Long min, @Param("max")Long max);

}
