package aula11.ex2;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SimpleGradeCalculator implements IGradeCalculator{
    @Override
    public double calculate(List<Double> grades) {
        double result = 0.0;
        for(Double grade : grades){
            result += grade;
        }
        result = result / grades.size();
        return result;
    }
}
