package com.magasinudes.microservice.repositories;

import com.magasinudes.microservice.models.BorrowStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowStatusRepository extends JpaRepository<BorrowStatus, Long> {
}
