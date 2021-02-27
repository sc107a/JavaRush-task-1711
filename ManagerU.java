package com.javarush.task.task17.task1711;

public class ManagerU extends Manager {
    public String id;

    public ManagerU (String name, String sex, String date, String id) {
        super(name, sex, date);
        this.id = id;
    }

    @Override
    public void run() {
        if (checkPerson(sex, dateIn) && checkId(id)){
            makeRecord(sex, name, date);
            synchronized (Solution.allPeople) {
                Solution.allPeople.set(Integer.parseInt(id), person);
            }
        }
    }
    public boolean checkId (String id){
        if (Integer.parseInt(id)<=Solution.allPeople.size()) return true;
        else System.out.println("Incorrect ID.");
        return false;
    }
}
