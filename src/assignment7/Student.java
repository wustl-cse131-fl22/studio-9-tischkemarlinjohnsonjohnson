package assignment7;

public class Student {
	
	private String firstName;
	private String lastName;
	private int id;
	private int totalAttemptedCredits;
	private int totalPassingCredits;
	private double totalGradeQualityPoints;
	private int credits;
	private double bearBucksBalance;
	
	/**
	 * constructor
	 * 
	 * @param string firstName, string lastName, int id
	 */
	public Student(String firstName, String lastName, int id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
	}
	
	/**
	 * getter method for the full name of student
	 * 
	 */
	public String getFullName() {
		return firstName + " " + lastName;
	}
	
	/**
	 * getter method for the student id
	 * 
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * calculates grade
	 * 
	 * @param grade between 1-4, credits taken
	 */
	public void submitGrade(double grade, int credits) {
		this.credits = credits;
		totalGradeQualityPoints += credits * grade;
		totalAttemptedCredits += credits;
		if(grade >= 1.7) {
			totalPassingCredits += credits;
		}
	}
	
	/**
	 * getter method for the attempted credits
	 * 
	 */
	public int getTotalAttemptedCredits() {
		return totalAttemptedCredits;
	}
	
	/**
	 * getter method for the total passing credits
	 * 
	 */
	public int getTotalPassingCredits() {
		return totalPassingCredits;
	}
	
	/**
	 * calculates gpa
	 * 
	 * @return gpa
	 */
	public double calculateGradePointAverage() {
		double gpa = totalGradeQualityPoints / totalAttemptedCredits;
		return gpa;
	}
	
	/**
	 * calculates class standing
	 * 
	 * @return class standing
	 */
	public String getClassStanding() {
		if (totalPassingCredits < 30) {
			return "First Year";
		}
		else if (totalPassingCredits >= 30 && totalPassingCredits < 60) {
			return "Sophomore";
		}
		else if (totalPassingCredits >=60 && totalPassingCredits < 90) {
			return "Junior";
		}
		else {
			return "Senior";
		}
	}
	
	/**
	 * determines if the student is eligible for phi beta kappa
	 * 
	 * @return true or false for eligibility
	 */
	public boolean isEligibleForPhiBetaKappa() {
		if (credits >= 98 && calculateGradePointAverage() >= 3.60 || credits >=75 && calculateGradePointAverage() >= 3.80) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * deposits amount in bear bucks
	 * 
	 * @param amount deposited
	 */
	public void depositBearBucks(double amount) {
		this.bearBucksBalance += amount;
	}
	
	/**
	 * deducts amount from bear bucks
	 * 
	 * @param amount deducted
	 */
	public void deductBearBucks(double amount) {
		this.bearBucksBalance -= amount;
	}
	
	/**
	 * getter method for bear bucks balance
	 * 
	 * @return bear bucks balance
	 */
	public double getBearBucksBalance() {
		return bearBucksBalance;
	}
	
	/**
	 * calculates cash out of bear bucks and sets balance to 0
	 * 
	 * @return cash out value of bear bucks
	 */
	public double cashOutBearBucks() {
		if (bearBucksBalance <= 10.0) {
			bearBucksBalance = 0.0;
			return 0.0;
		}
		else {
			double cashOut = bearBucksBalance - 10.0;
			bearBucksBalance = 0.0;
			return cashOut;
		}
	}
	
	/**
	 * calculates bear bucks of a legacy student
	 * 
	 * @param String of new firstName, another Student, boolean if last name is hyphenated, int new student id
	 * @return student with new bear bucks balance
	 */
	public Student createLegacy(String firstName, Student other, boolean isHyphenated, int id) {
		if (isHyphenated == true) {
			Student legacy = new Student(firstName, (this.lastName + "-" + other.lastName), id);
			legacy.bearBucksBalance += (this.cashOutBearBucks() + other.cashOutBearBucks());
			return legacy;
		}
		else {
			Student legacy = new Student(firstName, this.lastName, id);
			legacy.bearBucksBalance += (this.cashOutBearBucks() + other.cashOutBearBucks());
			return legacy;
		}
		
	}
	
	/**
	 * returns toString
	 * 
	 */
	public String toString() {
		return firstName + " " + lastName + " " + id;
	}
	
}
