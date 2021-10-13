package fr.training.samples.spring.shop.application;

import java.util.ArrayList;
import java.util.List;

import fr.training.samples.spring.shop.application.item.ItemManagement;
import fr.training.samples.spring.shop.domain.item.ItemEntity;
import fr.training.samples.spring.shop.domain.item.ItemRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

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

		Mockito.when(itemRepository.getAllItems()).thenReturn(entityListMock);
		List<ItemEntity>  itemEntities = itemManagement.getAllItems();
		Assertions.assertTrue(itemEntities.size()==1);
	}

}
