package dev.samarth.productService.inheritanceExample.st;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class Mentor extends User {
	private int numberOfSessions;
	private int numberOfMentees;
	
	public int getNumberOfSessions() {
		return numberOfSessions;
	}
	public void setNumberOfSessions(int numberOfSessions) {
		this.numberOfSessions = numberOfSessions;
	}
	public int getNumberOfMentees() {
		return numberOfMentees;
	}
	public void setNumberOfMentees(int numberOfMentees) {
		this.numberOfMentees = numberOfMentees;
	}

}
