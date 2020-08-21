package com.wellsfargo.fsd.cpk.service;

import java.util.List;

import com.wellsfargo.fsd.cpk.entity.Item;
import com.wellsfargo.fsd.cpk.exception.ImsException;

public interface ItemService {

	Item validateAndAdd(Item item) throws ImsException;

	Item validateAndSave(Item item) throws ImsException;

	boolean deleteItem(int icode) throws ImsException;

	Item getItemById(int icode) throws ImsException;

	List<Item> getAllItems() throws ImsException;
}
