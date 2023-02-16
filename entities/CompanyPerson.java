package entities;

public class CompanyPerson extends Person {
	
	private Integer working;
	
	public CompanyPerson() {
		super();
	}

	public CompanyPerson(String name, Double annualIncome, Integer working) {
		super(name, annualIncome);
		this.working = working;
	}

	public Integer getWorking() {
		return working;
	}

	public void setWorking(Integer working) {
		this.working = working;
	}

	@Override
	public double tax() {
		double v = 0.0;
		if(working>10) {
			v = getAnnualIncome() * 0.14 ;
		}
		else {
			v = getAnnualIncome() * 0.16 ;
		}
		return v  ;
		 
	}

}
