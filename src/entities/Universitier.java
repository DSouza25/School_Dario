package entities;

import enums.Status;

public class Universitier extends Student{
    private Double grade3;

    public Universitier(String name, Double grade1, Double grade2, Double grade3) {
        this.grade3 = grade3;
        super(name, grade1, grade2);
        this.average = calcAverage();
    }

    public Double getGrade3() {
        return grade3;
    }

    public void setGrade3(Double grade3) {
        this.grade3 = grade3;
    }
    
    @Override
    public Double calcAverage(){
        Double average = (getGrade1()+getGrade2()+getGrade3())/3;
        if (average >=6){
             this.status = Status.APPROVED;
        }
        else if (average < 6 && average >= 4) {
            this.status = Status.FINAL_EXAM;
        }
        else{
            this.status = Status.FAILED;
        }
        return average;
    }
}
