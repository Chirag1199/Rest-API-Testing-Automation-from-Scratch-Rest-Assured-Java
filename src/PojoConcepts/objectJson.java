package PojoConcepts;

public class objectJson {

	// 1st Initialize all the {key:value} -> key variables and assign private access modifiers. 
	
	private String instructor;
	private String url;
	private String services;
	private String expertise;
	private nestedJson courses; // Return type is not String. The data from the course are coming from nestedJson Class.
	private String linkedIn;
	
	// Create getter and setter method for the KEY variables. [ ALT + SHIFT + S ] 
	
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
	public String getExpertise() {
		return expertise;
	}
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	public nestedJson getCourses() {
		return courses;
	}
	public void setCourses(nestedJson courses) {
		this.courses = courses;
	}
	public String getLinkedIn() {
		return linkedIn;
	}
	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}
	
	
	
	
	
}
