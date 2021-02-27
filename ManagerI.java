package com.javarush.task.task17.task1711;


import java.text.SimpleDateFormat;
import java.util.Locale;

public class ManagerI extends ManagerD {
    public String id;

    public ManagerI(String id) {
        super(id);
        this.id = id;
    }

    @Override
    public void run() {
        if (checkId(id)) {
            SimpleDateFormat newDataFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            String familia = Solution.allPeople.get(Integer.parseInt(id)).getName();
            String sex = Solution.allPeople.get(Integer.parseInt(id)).getSex().equals(Sex.MALE) ? "м" : "ж";
            String date = newDataFormat.format(Solution.allPeople.get(Integer.parseInt(id)).getBirthDate());
            System.out.println(familia + " " + sex + " " + date);
        }

    }


}
