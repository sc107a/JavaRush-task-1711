package com.javarush.task.task17.task1711;

public class ManagerD implements Runnable {
    String id;

    public ManagerD(String id) {
        this.id = id;
    }

    @Override
    public void run() {
        if (checkId(id)){
            synchronized (Solution.allPeople){
                Person person = Solution.allPeople.get(Integer.parseInt(id));
                person.setBirthDate(null);
                person.setName(null);
                person.setSex(null);
                Solution.allPeople.set(Integer.parseInt(id),person);
            }
        }
    }
    public boolean checkId (String id){
        if (Integer.parseInt(id)<=Solution.allPeople.size()) return true;
        else System.out.println("Incorrect ID.");
        return false;
    }
}
