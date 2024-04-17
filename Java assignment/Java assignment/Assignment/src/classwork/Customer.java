package classwork;

public class Customer 
{
	private int custId;
	private String custName;
	private String address;
	
	public Customer() {}
	public Customer( int custId,String custName, String address)
	{
		this.setCustId(custId);
		this.setCustName(custName);
		this.setAddress(address);
	}
	public int getCustId()
	{
		return custId;
	}
	public void setCustId(int custId) 
	{
		this.custId = custId;
	}
	public String getCustName() 
	{
		return custName;
	}
	public void setCustName(String custName)
	{
		this.custName = custName;
	}
	public String getAddress() 
	{
		return address;
	}
	public void setAddress(String address) 
	{
		this.address = address;
	}
	public String toString() 
	{
		return "CustId=" + custId + ", CustName=" + custName + ", Address=" + address;
	}
}
