package com.javarush.task.task17.task1711;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();



    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = null;
        if (args.length > 0) {
            switch (args[0]) {
                case "-c": {
                    synchronized (allPeople) {}
                        if (((args.length - 1) % 3 == 0)) {
                            try {
                                for (int i = 0; i < args.length; ) {
                                    String name = args[++i];
                                    String sex = args[++i];
                                    String bd = args[++i];
                                    thread1 = new Thread(new Manager(name, sex, bd));
                                    thread1.start();
                                    thread1.join();
                                }
                            } catch (ArrayIndexOutOfBoundsException e) { }
                        } else System.out.println("Wrong number of parameters!");
                        thread1.join();
                        break;

                }
                case "-u": {
                    synchronized (allPeople) {}
                        if (((args.length - 1) % 4 == 0)) {
                            try {
                                for (int i = 0; i < args.length; ) {
                                    String id = args[++i];
                                    String name = args[++i];
                                    String sex = args[++i];
                                    String bd = args[++i];
                                    thread1 = new Thread(new ManagerU(name, sex, bd, id));
                                    thread1.start();
                                }
                            } catch (ArrayIndexOutOfBoundsException e) { }
                        } else System.out.println("Wrong number of parameters!");
                        thread1.join();
                        break;
                    }
                case "-d": {
                    synchronized (allPeople) {}
                        try {
                            for (int i = 0; i < args.length; i++) {
                                String id = args[i + 1];
                                thread1 = new Thread(new ManagerD(id));
                                thread1.start();
                            }
                        } catch (ArrayIndexOutOfBoundsException e) { }
                        thread1.join();
                        break;

                }
                case "-i": {
                    synchronized (allPeople) {}
                        try {
                            for (int i = 0; i <= args.length-1; i++) {
                                String id = args[i + 1];
                                SimpleDateFormat newDataFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                                String familia = allPeople.get(Integer.parseInt(id)).getName();
                                String sex = allPeople.get(Integer.parseInt(id)).getSex().equals(Sex.MALE) ? "м" : "ж";
                                String date = newDataFormat.format(allPeople.get(Integer.parseInt(id)).getBirthDate());
                                System.out.println(familia + " " + sex + " " + date);
                            }
                        } catch (ArrayIndexOutOfBoundsException e) { }
                        break;

                }
            }

        }
//        for (Person p : allPeople) System.out.println(p.getName());
    }






}


