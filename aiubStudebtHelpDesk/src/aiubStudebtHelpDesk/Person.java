package aiubStudebtHelpDesk;


class Person
{

	private String name, address, phone, email, catagory, course;

	
	public void setName(String name) {
		this.name = name; 
	}
	
	public void setCourse(String course) {
		this.course = course; 
	}
	
	public void setAddress(String address) {
		this.address = address; 
	}
	
	public void setPhone(String phone) {
		this.phone = phone; 
	}

	public void setEmail(String email) {
		this.email = email; 
	}
    
    
    public void setCatagory(String catagory) {
		this.catagory = catagory; 
	}


	public String getName() {
		return (this.name); 
	}
	
	public String getAddress() {
		return (this.address); 
	}

	public String getPhone() {
		return (this.phone); 
	}

	public String getEmail() {
		return (this.email); 
	}

    public String getCatagory() {
		return (this.catagory); 
	}
    
    public String getCourse() {
		return (this.course); 
	}
}