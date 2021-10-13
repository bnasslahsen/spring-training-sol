package fr.training.samples.spring.shop.infrastructure.item;

import fr.training.samples.spring.shop.domain.item.ItemEntity;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author bnasslahsen
 */
public interface ItemDataJpaRepository extends JpaRepository<ItemEntity, String> {
}