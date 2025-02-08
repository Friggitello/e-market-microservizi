package com.givuli.commerce.user.repositories;

import com.givuli.commerce.user.entities.Indirizzo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndirizzoRepository extends JpaRepository<Indirizzo,Long> {
}
