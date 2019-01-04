package com.cg.agent.ui;



import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;


import com.cg.agent.bean.InsuredBean;
import com.cg.agent.exception.InsuredException;
import com.cg.agent.service.AgentServiceImpl;
import com.cg.agent.service.IAgentService;




public class ClientMain {
	
	static Scanner sc;
	 static AgentServiceImpl serviceImpl;
	public static void main(String[] args) throws InsuredException, ClassNotFoundException, IOException, SQLException {
		IAgentService service=null;
           serviceImpl =null;
		InsuredBean bean = new InsuredBean();
		InsuredBean insuredBean=null;
		
		
		boolean role=true;
		while(role) {
			System.out.println("*---*---*----*---*---*---*---*-");
			System.out.println("---*-Welcome to Home page--*---");
			System.out.println("*---*---*----*---*---*---*---*-");
			System.out.println("   1. Insured User             ");
			System.out.println("   2. Insurance Agent          ");
			System.out.println("   3. UnderWriter or Admin     ");
			System.out.println("                               ");
			System.out.println("--*---*-Choose your role--*----");
			
			sc = new Scanner(System.in);
			int option;
			System.out.println(" choose your role...");
			option = sc.nextInt();
			
			while(true) {
				switch(option) {
				case 1:
					System.out.println("--*---*---*---*---*---*---*--*---");
					System.out.println("     Welcome Insured User        ");
					System.out.println("*---*---*----*---*---*---*---*---");
					System.out.println("  1. Search schemes              ");
					System.out.println("  2. View existing Schemes       ");
					System.out.println("  3. Request for Scheme          ");
					System.out.println("  4. Exit                        ");
					System.out.println("                                 ");
					System.out.println("--*---*-Choose your option--*----");
					boolean opt = true;
					while(opt) {
						int option1=0;
						System.out.println(" ");
						option1 = sc.nextInt();
						switch(option1) {
							case 1:
								System.out.println(" show schemes ");
								break;
							case 2:
								System.out.println(" view schemes of user");
								break;
							case 3:
								System.out.println(" enter details and get scheme");
						       break;
							case 4:
								System.exit(0);
							default:
								System.out.println("enter valid option.....");
								break;
						}
						opt=false;
					}
					break;
					
				case 2:
					
					System.out.println("--*---*---*---*---*---*---");
					System.out.println("  Welcome Insurance Agent ");
					System.out.println("--*---*---*---*---*--*---*");
					System.out.println("  1. Create Account as requested ");
					System.out.println("  2. View Customer Details(corresponding) ");
					System.out.println("  3. Exit                        ");
					System.out.println("                                 ");
					System.out.println("--*---*-Choose your option--*----");
					
					int option2=0;
					System.out.println(" enter option    ");
					option2 = sc.nextInt();
					boolean opt2 = true;
					
					
					
					while(opt2) {
						switch(option2) {
						
							case 1:	int ret=0;	
								
								while(insuredBean==null)
							{
								
								insuredBean=populateInsuredBean();
							}
								service = new AgentServiceImpl();
								
								try{
								
								ret = service.insertInsuredDetails(insuredBean);
								System.out.println(ret);
								System.out.println("inserted");
								}
								catch(SQLException e)
								{
									System.out.println(e);
								}
							
								
							System.out.println(" take details from user and create account   ");
								break;
							case 2:
								System.out.println(" get details of particulat agent             ");
								break;
							case 3:
								System.exit(0);
							default:
								System.out.println("..oops ...wrong option........");
								break;
						}
						opt2 = false;
					}
					break;
					
				case 3:
					System.out.println("--*---*---*---*---*---*---*---*--");
					System.out.println("        Welcome Admin            ");
					System.out.println("                                 ");
					System.out.println("*---*---*----*---*---*---*---*---");
					System.out.println("  1. Search schemes              ");
					System.out.println("  2. View existing Schemes       ");
					System.out.println("  3. Request for Scheme          ");
					System.out.println("  4. Create Account as requested ");
					System.out.println("  5. View Customer Details(corresponding) ");
					System.out.println("  6. Create scheme               ");
					System.out.println("  7. Generate Report             ");
					System.out.println("  8. Exit                        ");
					System.out.println("                                 ");
					System.out.println("--*---*-Choose your option--*----");
					
					int option3 = 0;
					System.out.println(" enter option from above menu    ");
					option3 = sc.nextInt();
					boolean opt3 = true;
					
					while(opt3) {
						switch(option3) {
							case 1:
								System.out.println(" show schemes ");
								break;
							case 2:
								System.out.println(" view schemes of user");
								break;
							case 3:
								System.out.println(" enter details and get scheme");
								break;
							case 4:
								System.out.println(" take details from user and create account   ");
								break;
							case 5:
								System.out.println(" get details of particulat agent             ");
								break;     
							case 6:
								System.out.println(" Created new schemes           ");
								break;
							case 7:
								System.out.println(" Generated report              ");
								break;
							case 8:System.out.println("exit");
						    	System.exit(0);
							default:
								System.out.println(" enter valid option ");
								break;
						}
						opt3=false;
					}
					break;
				case 4:
					System.exit(0);
				default:System.out.println("enter valid option    ");
				   break;
				}
			}
		}
		role = false;
	}
	private static InsuredBean populateInsuredBean() throws InsuredException {
		InsuredBean insuredBean=new InsuredBean();
		System.out.println("enter insured name");
		insuredBean.setInsuredName(sc.next());
		System.out.println("enter insured Street");
		insuredBean.setInsuredStreet(sc.next());
		System.out.println("enter insured city");
		insuredBean.setInsuredCity(sc.next());
	
		System.out.println("enter insured State");
		insuredBean.setInsuredState(sc.next());
		System.out.println(" enter user name ");
		insuredBean.setUserName(sc.next());
		System.out.println("enter insured zip");
		insuredBean.setInsuredZip(sc.nextInt());
		System.out.println("enter Business Segment");
		try {
			insuredBean.setBusinessSegment(sc.next());
		}
		catch(InputMismatchException ime)
		{
			sc.nextLine();
			System.out.println("please enter a numeric value for Business Segment,try again");
		}
		
		System.out.println("enter Account Number");
		try {
			insuredBean.setAccountNumber(sc.nextLong());
		}
		catch(InputMismatchException ime)
		{
			sc.nextLine();
			System.out.println("please enter a numeric value for account number,try again");
		}

		
     serviceImpl=new AgentServiceImpl();
		
		try 
		{
			serviceImpl.validateInsured(insuredBean);
			return insuredBean;
		}
		catch(Exception insuredException)
		{
			
			System.err.println("invalid data");
			System.err.println(insuredException.getMessage()+"\n try again");
			System.exit(0);
			insuredException.printStackTrace();
		}
		

		
			
		return insuredBean;
	
	
		
		
	}
}