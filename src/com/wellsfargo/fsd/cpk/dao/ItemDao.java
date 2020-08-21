package com.wellsfargo.fsd.cpk.dao;

import java.util.List;

import com.wellsfargo.fsd.cpk.entity.Item;
import com.wellsfargo.fsd.cpk.exception.ImsException;

public interface ItemDao {

	Item add(Item item) throws ImsException;
	Item save(Item item) throws ImsException;
	boolean deleteById(Integer icode) throws ImsException;
	
	Item getById(Integer icode) throws ImsException;
	List<Item> getAll() throws ImsException;
	
}
