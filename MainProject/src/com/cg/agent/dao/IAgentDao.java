package com.cg.agent.dao;

import java.io.IOException;
import java.sql.SQLException;

import com.cg.agent.bean.InsuredBean;

public interface IAgentDao {
	
	public int insertInsuredDetails(InsuredBean insuredBean) throws ClassNotFoundException, IOException, SQLException;

}
