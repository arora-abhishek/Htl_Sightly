package com.htl.practice;

import Htl.Author;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.scripting.SlingScriptHelper;
import org.apache.sling.scripting.sightly.pojo.Use;


import javax.script.Bindings;
import java.util.ArrayList;
import java.util.List;

public class Application implements Use {

    private String str;
    List children = new ArrayList();

    @Override
    public void init(Bindings bindings) {
        try {

            Resource resource = (Resource) bindings.get("resource");
            String path = (String) resource.getValueMap().get("path");

            SlingScriptHelper slingScriptHelper = (SlingScriptHelper) bindings.get("sling");
            Author author = slingScriptHelper.getService(Author.class);
            //      str = author.getPath(path);
            children = author.getChilds(path);


            //         str = path;

        } catch (Exception e) {
            System.out.println(e);
        }

    }


    public List getChildren() {
        return children;
    }

}
