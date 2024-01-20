package com.branchservice.service;

import com.branchservice.entity.Branch;

public interface BranchService {

	void save(Branch branch);

	Branch get(Long paymentId);

	Branch deleteById(Long paymentId);

	//void update(Payments payments);

	

	void updateEntity(Long paymentId, String paymentMode);

}
