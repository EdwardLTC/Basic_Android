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

    public List<students> getList(){
        return listStudents;
    }

    public void  initTempData(){
        listStudents.add(new students("Le Thanh Cong","06/06/2003","Cp08"));
        listStudents.add(new students("Le Thanh Cong","06/06/2003","Cp08"));
        listStudents.add(new students("Le Thanh Cong","06/06/2003","Cp08"));
        listStudents.add(new students("Le Thanh Cong","06/06/2003","Cp08"));

    }

}
