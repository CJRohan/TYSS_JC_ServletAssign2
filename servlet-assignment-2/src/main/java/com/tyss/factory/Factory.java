package com.tyss.factory;

import com.tyss.dao.DAO;
import com.tyss.dao.DAOImpl;
import com.tyss.service.Service;
import com.tyss.service.ServiceImpl;

public class Factory {

	private Factory() {

	}

	public static DAO getDAO() {
		return new DAOImpl();
	}

	public static Service getService() {
		return new ServiceImpl();
	}

}
