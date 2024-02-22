package com.compassuol.sp.challenge.msaddress.domain.repository;

import com.compassuol.sp.challenge.msaddress.domain.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
