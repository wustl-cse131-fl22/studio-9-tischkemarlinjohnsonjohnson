package studio9;

import java.util.HashMap;
import java.util.Map;

import assignment7.Student;

public class UniversityDatabase {
	private Map<String, Student> studentMap = new HashMap<>();
	
	public void UniversityDatabase (Map<String, Student> student) {
		this.studentMap = student;
	}

	public void addStudent(String accountName, Student student) {
		studentMap.put(accountName, student);
	}

	public int getStudentCount() {
		return studentMap.size();
	}

	public String lookupFullName(String accountName) {
		if (studentMap.get(accountName) != null) {
			return studentMap.get(accountName).getFullName();}
		else {
			return null;}
	}

	public double getTotalBearBucks() {
		double total = 0.0;
		for (Student test: studentMap.values()) {
			total += test.getBearBucksBalance();
		}
		return total;
	}
}
