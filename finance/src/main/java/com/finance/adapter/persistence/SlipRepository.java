package com.finance.adapter.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlipRepository extends JpaRepository<Slip, String> {
}
