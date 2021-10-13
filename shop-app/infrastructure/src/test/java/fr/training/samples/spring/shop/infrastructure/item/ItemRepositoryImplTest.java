package fr.training.samples.spring.shop.infrastructure.item;

import java.util.List;

import fr.training.samples.spring.shop.domain.item.ItemEntity;
import fr.training.samples.spring.shop.domain.item.ItemRepository;
import fr.training.samples.spring.shop.domain.item.ItemVO;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

/**
 * @author bnasslahsen
 */
@DataJpaTest
public class ItemRepositoryImplTest {

	@Autowired
	private ItemRepository itemRepository;

	@Test
	public void testAddItem(){
		ItemVO itemVO = new ItemVO("Desc44", 99);
		ItemEntity itemEntity = new ItemEntity(itemVO);
		ItemEntity result = itemRepository.addItem(itemEntity);
		assertNotNull(result);
	}

	@Test
	public void testgetAllItems(){
		List<ItemEntity> items = itemRepository.getAllItems();
		assertTrue(items.size()==5);
	}
}

