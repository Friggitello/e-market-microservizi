package com.givuli.commerce.user.repositories;

import com.givuli.commerce.user.entities.Comune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComuneRepository extends JpaRepository<Comune,Long> {
}
