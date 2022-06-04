package com.edward.assignment.model;

import java.util.ArrayList;
import java.util.List;

public class ClassesDAO {
    ArrayList<Classes> listClass = new ArrayList<>();
    public ClassesDAO(){
        initTempData();
    }
    public void addClass(Classes Class){
        listClass.add(Class);
    }

    public ArrayList<Classes> getList(){
        return listClass;
    }

    public void initTempData(){
        listClass.add(new Classes("cp17308","Computer Dev"));
        listClass.add(new Classes("cp17309","Tester"));
        listClass.add(new Classes("cp17310","UDPM"));
        listClass.add(new Classes("cp17311","TKDH"));

    }


}
