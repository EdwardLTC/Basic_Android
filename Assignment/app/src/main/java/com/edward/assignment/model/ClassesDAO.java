package com.edward.assignment.model;

import java.util.ArrayList;
import java.util.List;

public class ClassesDAO {
    List<Classes> listClass = new ArrayList<>();
    public ClassesDAO(){
        initTempData();
    }
    public void addClass(Classes Class){
        listClass.add(Class);
    }

    public List<Classes> getList(){
        return listClass;
    }

    public void initTempData(){
        listClass.add(new Classes("cp17308","Computer Dev"));
        listClass.add(new Classes("cp17309","Computer Dev"));
        listClass.add(new Classes("cp17310","Computer Dev"));
        listClass.add(new Classes("cp17311","Computer Dev"));

    }


}
