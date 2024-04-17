package assignment1;
import java.util.*;

class Customer
{
	private String name;
	private boolean member = false;
	private String membertype;
	
	Customer(){}
	
	Customer(String name)
	{
		this.name = name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}	
	
	public String getName()
	{
		return name;
	}
	
	public boolean isMember()
	{
		return member;
	}
	
	public void setMember(boolean member)
	{
		this.member = member;
	}
	
	public void setMembertype(String membertype)
	{
		this.membertype = membertype;
	}
	
	public String getMembertype()
	{
		return membertype;
	}
	
	public String toString()
	{
		return "Customer name:"+getName()+"  Membership:"+member+"   Membership Type:"+getMembertype();
	}	
}


class Visit
{
	private Customer c;
	private Date date;
	private double serviceExpenses;
	private double productExpenses;
	
	Visit(Customer name, Date date)
	{
		this.c = name;
		this.date = date;
	}
	
	public String getName()
	{
		return c.getName();
	}
	
	public void setServiceExpenses(double serviceExpenses)
	{
		this.serviceExpenses = serviceExpenses;
	}
	
	public double getServiceExpenses()
	{
		return serviceExpenses;
	}
	
	public void setProductExpenses(double productExpenses) 
	{
		this.productExpenses = productExpenses;
	}
	
	public double getProductExpenses()
	{
		return productExpenses;
	}
	
	public double getTotalExpense()
	{
		double t = (serviceExpenses - (serviceExpenses * DiscountRate.getServiceDiscount(c.getMembertype()))+
		productExpenses -(productExpenses * DiscountRate.getProductDiscount(c.getMembertype())));
	    return t;
	}
	
	public String toString()
	{
		return "Customer name:"+getName()+
				"  Date:"+date+
				"  ServiceExpenses:"+getServiceExpenses()+
				"  ProductExpenses:"+getProductExpenses()+
				"  TotalExpense:"+getTotalExpense();
	}	
		
}


public class DiscountRate 
{
	static double serviceDiscountPremium = 0.2;
	static double serviceDiscountGold = 0.15;
	static double serviceDiscountSilver = 0.5;
	static double productDiscountPremium = 0.1;
	static double productDiscountGold = 0.1;
	static double productDiscountSilver = 0.1;
	//static Customer c;
	
	public static double getServiceDiscount(String s)
	{
		//if(c.isMember()== true)
		//{
			if(s=="Premium") 
			{
				return serviceDiscountPremium;
			}
			else if(s == "Gold")
			{
				return serviceDiscountGold;
			}
			else if(s == "Silver")
			{
				return serviceDiscountSilver;
			}
			else 
			{
				return 0;
			}

		//}
		//else
		//{
		//	System.out.println("No discount");
		//	return 0;
		//}
	}
	
	public static double getProductDiscount(String p)
	{
		
		//if(c.isMember()== true)
		//{
			if(p=="Premium") 
			{
				return productDiscountPremium;
			}
			else if(p == "Gold")
			{
				return productDiscountGold;
			}
			else if(p == "Silver")
			{
				return productDiscountSilver;
			}
			else 
			{
				return 0;
			}
		//}
		//else
		//{
			//System.out.println("No discount");
			//return 0;
		//}
	}
	public static void main(String[] args) 
	{
		Customer c1 = new Customer("Namit");
		c1.setMember(true);
		c1.setMembertype("Gold");
		System.out.println(c1.toString());
		
		Customer c2 = new Customer("John");
		System.out.println(c2.toString());
		
		Visit v1 = new Visit(c1 ,new Date());
		v1.setServiceExpenses(200.3);
		v1.setProductExpenses(2010.44);
		System.out.println(v1.toString());
		
	}

}
