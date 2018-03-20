package Htl;


import org.apache.sling.api.resource.*;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


import java.util.*;

@Component(service = Author.class, immediate = true)
public class AuthorImplementation implements Author {

    ResourceResolver resourceResolver = null;


    @Reference
    private ResourceResolverFactory resolverFactory;

//    @Override
//    public String getPath(String resourcePath) {
//
//        String path = "";
//
//        try {
//
//            Map<String, Object> param = new HashMap<String, Object>();
//            param.put(ResourceResolverFactory.SUBSERVICE, "Author");
//
//            resourceResolver = resolverFactory.getResourceResolver(param);
//            Resource res = resourceResolver.getResource(resourcePath);
//
//            ValueMap valueMap = res.adaptTo(ValueMap.class);
//            path = valueMap.get("path", "default");
//
//            resourceResolver.close();
//
//        } catch (LoginException e) {
//            e.printStackTrace();
//        }
//        return path;
//    }

    @Override
    public List getChilds(String resourcePath) {
        List<Resource> childrenList = new ArrayList<>();
        try {


            Map<String, Object> param = new HashMap<String, Object>();
            param.put(ResourceResolverFactory.SUBSERVICE, "Author");

            resourceResolver = resolverFactory.getServiceResourceResolver(param);
            Resource res = resourceResolver.getResource(resourcePath);

            Iterator<Resource> resourceIterator = res.listChildren();

            while (resourceIterator.hasNext()) {
                childrenList.add(resourceIterator.next());

            }


            return childrenList;


        } catch (LoginException e) {
            e.printStackTrace();
        } finally {
            resourceResolver.close();
        }
        return childrenList;
    }
}
