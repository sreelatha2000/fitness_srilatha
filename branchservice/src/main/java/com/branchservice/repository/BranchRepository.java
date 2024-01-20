package com.branchservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.branchservice.entity.Branch;

@Repository
@EnableJpaRepositories
public interface BranchRepository extends JpaRepository<Branch, Long> {

	//void updateById(Payments payments);

}
