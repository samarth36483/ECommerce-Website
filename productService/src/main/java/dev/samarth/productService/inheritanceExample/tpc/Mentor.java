package dev.samarth.productService.inheritanceExample.tpc;

import jakarta.persistence.Entity;

@Entity(name = "tpc_mentor")
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
