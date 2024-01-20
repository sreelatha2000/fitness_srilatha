package com.membershipservice.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.membershipservice.entity.Membership;
import com.membershipservice.repository.MembershipRepository;

@Service
public class MembershipServiceImpl implements MembershipService {

	@Autowired
	MembershipRepository membershipRepository;

	@Override
	public void save(Membership membership) {
		membershipRepository.save(membership);

	}

	@Override
	public Membership get(Long paymentId) {
		
		return membershipRepository.findById(paymentId).orElseThrow(
				() -> new IllegalArgumentException("Patient not found with id-" + paymentId));
	}

	@Override
	public Membership deleteById(Long paymentId) {
		
		return null;	

}



	 
	 @Transactional
public void updateEntity(Long paymentId, String paymentMode) {
	Membership membership = membershipRepository.findById(paymentId).orElse(null);
	if(membership!=null)
	{
	//membership.setPaymentMode(paymentMode);
	membershipRepository.save(membership);
	}
	
}
}
