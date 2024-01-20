package com.membershipservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.membershipservice.entity.Membership;
import com.membershipservice.entity.Membership;

@Repository
@EnableJpaRepositories
public interface MembershipRepository extends JpaRepository<Membership, Long> {

	//void updateById(Payments payments);

}
