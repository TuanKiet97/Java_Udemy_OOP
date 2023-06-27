package com.tuankiet.employees;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analyst extends Employee implements IEmployee, Apple {
    private int projectCount = 0;
    String analystRegex = "\\w+=(?<locpd>\\w+),\\w+=(?<yoe>\\w+),\\w+=(?<iq>\\w+)";
    Pattern analystPat = Pattern.compile(analystRegex);

    public Analyst(String personText) {
	super(personText);
	    Matcher analystMat = analystPat.matcher(peopleMat.group("details"));
	    if (analystMat.find()) {
		this.projectCount = Integer.parseInt(analystMat.group("projectCount"));
	    }
	}

    public int getSalary() {
	return 2500 + projectCount * 2;
    }
}
