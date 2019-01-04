package com.cg.agent.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cg.agent.bean.InsuredBean;
import com.cg.agent.util.DBConnection;

public class AgentDaoImpl implements IAgentDao{

	@Override
	public int insertInsuredDetails(InsuredBean insuredBean) throws ClassNotFoundException, IOException, SQLException {
	Connection con=DBConnection.getConnection();
	PreparedStatement pst=null;

	
	

	try {
	
	 pst=con.prepareStatement("insert into account values(?,?,?,?,?,?,?,?)");
	 pst.setLong(1,insuredBean.getAccountNumber());
	 pst.setString(2,insuredBean.getInsuredName());
	 pst.setString(3,insuredBean.getInsuredStreet());
	 pst.setString(4,insuredBean.getInsuredCity());
	 pst.setString(5,insuredBean.getInsuredState());
	 pst.setInt(6,insuredBean.getInsuredZip());
	 pst.setString(7,insuredBean.getBusinessSegment());
	 pst.setString(8,insuredBean.getUserName());
	// pst.setInt(9,bean.getAgentId());
    pst.executeUpdate();
	
	}catch(SQLException sql)
	{
		System.out.println(sql);
	}
	
		return 1;
	

	}

}
