package com.edward.assignment.model;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    List<students> listStudents = new ArrayList<>();
    public  StudentDAO(){
        initTempData();
    }
    public  void  addStudent (students student){
        listStudents.add(student);
    }

    public  boolean removeObj(String obj){
        for (int i = 0; i < listStudents.size(); i++) {
            if (obj.equals(listStudents.get(i).getFullName())){
                listStudents.remove(i);
                return true;
            }
        }
        return false;
    }
    public List<students> getList(){
        return listStudents;
    }

    public void  initTempData(){
        listStudents.add(new students("Le Thanh Mai","06/06/2003","Cp08"));
        listStudents.add(new students("Le Thanh Dung","06/06/2003","Cp08"));
        listStudents.add(new students("Le Thanh Y","06/06/2003","Cp08"));
        listStudents.add(new students("Le Thanh Vy","06/06/2003","Cp08"));

    }

}
