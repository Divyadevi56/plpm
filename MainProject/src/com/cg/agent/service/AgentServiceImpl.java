package com.cg.agent.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.agent.bean.InsuredBean;
import com.cg.agent.dao.AgentDaoImpl;
import com.cg.agent.dao.IAgentDao;
import com.cg.agent.exception.InsuredException;


public class AgentServiceImpl implements IAgentService{

	@Override
	public int insertInsuredDetails(InsuredBean insuredBean) throws ClassNotFoundException, IOException, SQLException {
		IAgentDao agentDao=new AgentDaoImpl();
		int insure=0;
		insure=agentDao.insertInsuredDetails(insuredBean);
		return insure;
	}

	public void validateInsured(InsuredBean insuredBean) throws InsuredException {
  
List<String> validationErrors=new ArrayList<String>();
 
/*if(!isValidName(insuredBean.getInsuredName()))
{
	validationErrors.add("\n Insured Name should be in Alphabets and minimum 3 characters long\n");
	
}
		
		if(!isValidName(insuredBean.getUserName()))
		{
			validationErrors.add("\n User Name should be in Alphabets and minimum 3 characters long\n");
			
		}
		/*if(!(isValidStreet(insuredBean.getInsuredStreet())))
		{
			validationErrors.add("Street should be alphabet");
			
		}
		if(!(isValidCity(insuredBean.getInsuredCity())))
		{
			validationErrors.add(" City should be alphabet");
			
		}
		if(!(isValidState(insuredBean.getInsuredState())))
		{
			validationErrors.add("State should be alphabet");
			
		}*/
		if(!(isValidZip(insuredBean.getInsuredZip())))
		{
			validationErrors.add("Zip should be in 6 digits");
		}
	

		
	/*	if(!(ValidId(bean.getDonorId())))
		{
			validationErrors.add("enter valid id");
		}*/
		if(!validationErrors.isEmpty())
		{
			throw new InsuredException(validationErrors+"");
		}

		
	}

	
	private boolean isValidZip(int insuredZip) {
		
		
String s=Integer.toString(insuredZip);
     return s.length()==6;
}

	/*private boolean isValidState(String insuredState) {

		Pattern p=Pattern.compile("[A-Za-z]{10,}");
		Matcher matcher1=p.matcher(insuredState);
		return false;
	}

	private boolean isValidCity(String insuredCity) {
		Pattern p=Pattern.compile(".*");
		Matcher matcher1=p.matcher(insuredCity);
		return false;
	}

	private boolean isValidStreet(String insuredStreet) {
		Pattern p=Pattern.compile("[A-Za-z]{10,}");
		Matcher matcher1=p.matcher(insuredStreet);
		return false;
	}

	private boolean isValidName(String userName) {
		Pattern p=Pattern.compile("[A-Za-z]{3,}$");
		Matcher phoneMatcher=p.matcher(userName);

		return false;*/
	}

	

	