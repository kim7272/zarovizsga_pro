package hu.nive.ujratervezes.zarovizsga.digitscounter;

import java.util.HashSet;
import java.util.Set;

public class DigitsCounter {

    public int getCountOfDigits(String s) {
        Set<Character> digits = new HashSet<>();
        if (s == null || s.isBlank()){
            return 0;
        }
        for (char c: s.toCharArray()) {
            if (Character.isDigit(c)){
                digits.add(c);
            }
        }
        return digits.size();
    }
}
