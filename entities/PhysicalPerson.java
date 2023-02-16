package entities;

public class PhysicalPerson extends Person{
	
	private Double healthSpending;
	
	public PhysicalPerson() {
		
	}
	
	public PhysicalPerson(String name, Double annualIncome, Double healthSpending) {
		super(name, annualIncome);
		this.healthSpending = healthSpending;
	}

    public Double getHealthSpending() {
		return healthSpending;
	}

	public void setHealthSpending(Double healthSpending) {
		this.healthSpending = healthSpending;
	}

	@Override
	public double tax() {
		double v = 0.0;
		if(getAnnualIncome() <= 20000.00 ) {
			v = (getAnnualIncome() * 0.15) - (getHealthSpending() * 0.50); 
		}
		else {
			v = (getAnnualIncome() * 0.25) - (getHealthSpending() * 0.50);
		}
	
		return v;
	}

}
