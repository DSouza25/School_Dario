package entities;

import enums.Status;

public abstract class Student {
    private String name;
    private Double grade1;
    private Double grade2;
    protected Double average;
    protected Status status;
    
    public Student(String name, Double grade1, Double grade2) {
        this.name = name;
        this.grade1 = grade1;
        this.grade2 = grade2;
        this.average = calcAverage();
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Double getGrade1() {
        return grade1;
    }
    
    public void setGrade1(Double grade1) {
        this.grade1 = grade1;
    }
    
    public Double getGrade2() {
        return grade2;
    }
    
    public void setGrade2(Double grade2) {
        this.grade2 = grade2;
    }
    
    public Double getAverage() {
        return average;
    }

    public Status getStatus() {
        return status;
    }

    public abstract Double calcAverage();
}
