package org.example;
import java.util.regex.Matcher;

import java.util.regex.Pattern;

public class Function {


    public String nameCase(String name) {

        String[] words = name.split(" ");
        StringBuilder wordCorrection = new StringBuilder();

        for (String word : words) {
            if (word.length() > 0) {
                wordCorrection.append(Character.toUpperCase(word.charAt(0)));
                wordCorrection.append(word.substring(1).toLowerCase());
                wordCorrection.append(" ");
            }
        }

        if (name == null || name.isEmpty()) {
            return name;
        }
        return wordCorrection.toString().trim();
    }

    public String phoneNo(String phoNo) {
        String phoneFormat = phoNo.replaceAll("[^0-9]", "");

        if (phoneFormat.startsWith("370")) {
            phoneFormat = phoneFormat.substring(3);
        } else if (phoneFormat.startsWith("00370")) {
            phoneFormat = phoneFormat.substring(5);
        } else if (phoneFormat.startsWith("8")) {
            phoneFormat = phoneFormat.substring(1);
        }
        if (phoNo == null || phoNo.isEmpty()) {
            return phoNo;
        }
        return phoneFormat;
    }

    public boolean emailCheck(String email) {
        String regex = "^[\\w!#$%&amp;'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&amp;'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(email);
        return match.matches();
    }
}
