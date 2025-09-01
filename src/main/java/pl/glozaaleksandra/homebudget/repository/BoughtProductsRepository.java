package pl.glozaaleksandra.homebudget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.glozaaleksandra.homebudget.entities.BoughtProductsEntity;

public interface BoughtProductsRepository extends JpaRepository<BoughtProductsEntity, Integer> {
}
