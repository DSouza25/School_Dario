package entities;

import enums.Status;

public class Postgraduate extends Student{
    private Double grade3;
    private Double grade4;

    public Postgraduate(String name, Double grade1, Double grade2, Double grade3, Double grade4) {
        this.grade3 = grade3;
        this.grade4 = grade4;
        super(name, grade1, grade2);
        this.average = calcAverage();
    }

    public Double getGrade3() {
        return grade3;
    }

    public void setGrade3(Double grade3) {
        this.grade3 = grade3;
    }

    public Double getGrade4() {
        return grade4;
    }

    public void setGrade4(Double grade4) {
        this.grade4 = grade4;
    }

    @Override
    public Double calcAverage() {
        Double average = (getGrade1()+getGrade2()+getGrade3()+getGrade4())/4;
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
    public Double calcAverage(String tcc){
        average = 10.0;
        this.status = Status.APPROVED;
        return average;
    }

}
