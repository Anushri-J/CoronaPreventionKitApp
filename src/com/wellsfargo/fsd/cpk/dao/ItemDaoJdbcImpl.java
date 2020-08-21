package com.wellsfargo.fsd.cpk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.wellsfargo.fsd.cpk.entity.Item;
import com.wellsfargo.fsd.cpk.exception.ImsException;
import com.wellsfargo.fsd.cpk.dao.ConnectionFactory;

public class ItemDaoJdbcImpl implements ItemDao {

	public static final String INS_ITEM_QRY = "INSERT INTO items(icode,title,unit,price) values(?,?,?,?)";
	public static final String UPD_ITEM_QRY = "UPDATE items SET title=?,unit=?,price=? WHERE icode=?";
	public static final String DEL_ITEM_QRY = "DELETE FROM items WHERE icode=?";
	public static final String SEL_ITEM_QRY_BY_ID = "SELECT icode,title,unit,price FROM items WHERE icode=?";
	public static final String SEL_ALL_ITEMS_QRY = "SELECT icode,title,unit,price FROM items";

	@Override
	public Item add(Item item) throws ImsException {
		if (item != null) {
			try (Connection con = ConnectionFactory.getConnection();
					PreparedStatement pst = con.prepareStatement(INS_ITEM_QRY)) {

				pst.setInt(1, item.getIcode());
				pst.setString(2, item.getTitle());
				pst.setString(3, item.getUnit());
				pst.setDouble(4, item.getPrice());

				pst.executeUpdate();

			} catch (SQLException | NamingException exp) {
				exp.printStackTrace();
				throw new ImsException("Saving the item failed!");
			}
		}
		return item;
	}

	@Override
	public Item save(Item item) throws ImsException {
		if (item != null) {
			try (Connection con = ConnectionFactory.getConnection();
					PreparedStatement pst = con.prepareStatement(UPD_ITEM_QRY)) {

				pst.setString(1, item.getTitle());
				pst.setString(2, item.getUnit());
				pst.setDouble(3, item.getPrice());
				pst.setInt(4, item.getIcode());

				pst.executeUpdate();

			} catch (SQLException | NamingException exp) {
				exp.printStackTrace();
				throw new ImsException("Saving the item failed!");
			}
		}
		return item;
	}

	@Override
	public boolean deleteById(Integer icode) throws ImsException {
		boolean isDeleted = false;
		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement pst = con.prepareStatement(DEL_ITEM_QRY)) {

			pst.setInt(1, icode);

			int rowsCount = pst.executeUpdate();

			isDeleted = rowsCount > 0;

		} catch (SQLException | NamingException exp) {
			exp.printStackTrace();
			throw new ImsException("Deleting the item failed!");
		}

		return isDeleted;
	}

	@Override
	public Item getById(Integer icode) throws ImsException {
		Item item = null;

		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement pst = con.prepareStatement(SEL_ITEM_QRY_BY_ID)) {

			pst.setInt(1, icode);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				item = new Item();
				item.setIcode(rs.getInt(1));
				item.setTitle(rs.getString(2));
				item.setUnit(rs.getString(3));
				item.setPrice(rs.getDouble(4));
			}

		} catch (SQLException | NamingException exp) {
			exp.printStackTrace();
			throw new ImsException("Retrival the item failed!");
		}

		return item;
	}

	@Override
	public List<Item> getAll() throws ImsException {
		List<Item> items = new ArrayList<>();

		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement pst = con.prepareStatement(SEL_ALL_ITEMS_QRY)) {

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Item item = new Item();
				item.setIcode(rs.getInt(1));
				item.setTitle(rs.getString(2));
				item.setUnit(rs.getString(3));
				item.setPrice(rs.getDouble(4));
				
				
				items.add(item);
			}
			
			if(items.isEmpty()) {
				items=null;
			}
		} catch (SQLException | NamingException exp) {
			exp.printStackTrace();
			throw new ImsException("Retrival the item failed!");
		}
		return items;
	}

}
