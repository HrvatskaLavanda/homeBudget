package pl.glozaaleksandra.homebudget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.glozaaleksandra.homebudget.entities.MarketEntity;

@Repository
public interface MarketRepository extends JpaRepository<MarketEntity, Integer> {
}

