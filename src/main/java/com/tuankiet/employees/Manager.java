package com.tuankiet.employees;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Manager extends Employee implements IEmployee, Apple {
    private int orgSize = 0;
    private final String mgrRegex = "\\w+=(?<orgSize>\\w+),\\w+=(?<dr>\\w+)";
    private final Pattern mgrPat = Pattern.compile(mgrRegex);
    private int directReport = 0;
    public Manager(String personText) {
	super(personText);
	    Matcher mgrMat = mgrPat.matcher(peopleMat.group("details"));
	    if (mgrMat.find()) {
		this.orgSize = Integer.parseInt(mgrMat.group("orgSize"));
		this.directReport = Integer.parseInt(mgrMat.group("dr"));
	    }
    }

    public int getSalary() {
	return 3500 + orgSize * directReport;
    }
}
