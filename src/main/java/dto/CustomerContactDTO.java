package dto;

public class CustomerContactDTO {
	
	private String companyName;
	private String contactName;
	public CustomerContactDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	@Override
	public String toString() {
		return "CustomerContactDTO [companyName=" + companyName + ", contactName=" + contactName + "]";
	}
	
	
	

}
