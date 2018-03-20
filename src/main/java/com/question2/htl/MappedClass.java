package com.question2.htl;

import org.apache.sling.scripting.sightly.pojo.Use;


import javax.script.Bindings;
import java.util.HashMap;
import java.util.Map;

public class MappedClass implements Use {

    private Map<String, String> map;

    @Override
    public void init(Bindings bindings) {

        map = new HashMap<String, String>();

        map.put("1", "Abhishek");
        map.put("2" , "Utkarsh");
        map.put("3" , "Varnika");
        map.put("4" , "Varun");
        map.put("5" , "Kanika");
        map.put("6" , "Astha");


    }

    public Map<String, String> getMap() {
        return map;
    }
}
