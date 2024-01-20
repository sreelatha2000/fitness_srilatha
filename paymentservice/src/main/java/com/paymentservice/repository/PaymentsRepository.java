package com.paymentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.paymentservice.entity.Payments;

@Repository
@EnableJpaRepositories
public interface PaymentsRepository extends JpaRepository<Payments, Long> {

	//void updateById(Payments payments);

}
