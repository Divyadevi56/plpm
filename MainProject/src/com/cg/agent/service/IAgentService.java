package com.cg.agent.service;

import java.io.IOException;
import java.sql.SQLException;

import com.cg.agent.bean.InsuredBean;

public interface IAgentService {
	public int insertInsuredDetails(InsuredBean insuredBean) throws ClassNotFoundException, IOException, SQLException;

	


}
