package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Manager implements Runnable {
    protected Person person;
    protected String name;
    protected String sex;
    protected String dateIn;
    private SimpleDateFormat dateFormat;
    protected Date date;

    @Override
    public void run() {

                if (checkPerson(sex, dateIn)){
                    makeRecord(sex, name, date);
                    synchronized (Solution.allPeople) {
                        Solution.allPeople.add(person);
                        System.out.println(Solution.allPeople.indexOf(person));
                    }
                }


    }
    public void makeRecord (String sex, String name, Date date){

        if (date!=null) {
            person = sex.equals("м") ? Person.createMale(name, date) : Person.createFemale(name, date);
        }
    }

    public boolean checkPerson (String sex, String dateIn) {

        if (sex.equals("м") || sex.equals("ж")) {
            dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            try {
                date = dateFormat.parse(dateIn);
            } catch (ParseException e) {
                System.out.println("Wrong date format. Correct format is dd/MM/yyyy");
                return false;
            }
            return true;
        } else {
            System.out.println("Incorrect sex");
            return false;
        }
    }

    public Manager(String name, String sex, String date) {
        this.name = name;
        this.sex = sex;
        this.dateIn = date;
    }


}
