package com.belajar.springrestfullapi.repository;

import com.belajar.springrestfullapi.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {
}