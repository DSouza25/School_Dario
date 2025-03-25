package entities;

import enums.Status;

public class TecStudent extends Student{

    public TecStudent(String name, Double grade1, Double grade2) {
        super(name, grade1, grade2);
        this.average = calcAverage();
    }
    
    @Override
    public Double calcAverage(){
        Double average = (getGrade1()+getGrade2())/2;
        if (average >=5){
             this.status = Status.APPROVED;
        }
        else{
            this.status = Status.FAILED;
        }
        return average;
    }
}
