package com.pulawskk.dbsfood.repository;

import com.pulawskk.dbsfood.domain.Burger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BurgerRepository extends JpaRepository<Burger, Long> {

    Optional<Burger> findBurgerByName(String name);
}
