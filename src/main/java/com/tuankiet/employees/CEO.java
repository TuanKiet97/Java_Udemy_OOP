package com.tuankiet.employees;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CEO extends Employee implements IEmployee, Apple {
    private int avgStockPrice = 0;
    private final String ceoRegex = "\\w+=(?<avgStockPrice>\\w+),\\w+=(?<dr>\\w+)";
    private final Pattern ceoPat = Pattern.compile(ceoRegex);

    public CEO(String personText) {
	super(personText);
	    Matcher ceoMat = ceoPat.matcher(peopleMat.group("details"));
	    if (ceoMat.find()) {
		this.avgStockPrice = Integer.parseInt(ceoMat.group("avgStockPrice"));
	    }
    }

    public int getSalary() {
	return 5000 * avgStockPrice;
    }
}
