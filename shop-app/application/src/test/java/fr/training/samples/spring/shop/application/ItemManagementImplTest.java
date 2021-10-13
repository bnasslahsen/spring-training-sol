package fr.training.samples.spring.shop.application;

import java.util.ArrayList;
import java.util.List;

import fr.training.samples.spring.shop.application.item.ItemManagement;
import fr.training.samples.spring.shop.domain.item.ItemEntity;
import fr.training.samples.spring.shop.domain.item.ItemRepository;
import fr.training.samples.spring.shop.domain.item.ItemVO;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

/**
 * @author bnasslahsen
 */
@SpringBootTest
public class ItemManagementImplTest {

	@Autowired
	private ItemManagement itemManagement;

	@MockBean
	private ItemRepository itemRepository;

	@Test
	public void testGetAllItems(){
		List<ItemEntity> entityListMock = new ArrayList<>();
		ItemEntity itemEntity = new ItemEntity();
		entityListMock.add(itemEntity);

		when(itemRepository.getAllItems()).thenReturn(entityListMock);
		List<ItemEntity>  itemEntities = itemManagement.getAllItems();
		assertTrue(itemEntities.size()==1);
	}


	@Test
	void addItem() {
		ItemVO itemVO = new ItemVO("DESC99", 99);
		ItemEntity itemEntity = new ItemEntity(itemVO);
		when(itemRepository.addItem(itemEntity)).thenReturn(itemEntity);

		ItemEntity itemResultEntity = itemManagement.addItem(itemEntity);
		assertNotNull(itemResultEntity);
		assertEquals("DESC99", itemResultEntity.getItemVO().getDescription());
	}

}
