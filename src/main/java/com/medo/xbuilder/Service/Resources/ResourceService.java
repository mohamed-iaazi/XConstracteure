package com.medo.xbuilder.Service.Resources;


import com.medo.xbuilder.Model.Resource;
import java.util.List;

public interface ResourceService {

    boolean AddNewResource(Resource resource);
    boolean DeleteResource(int id);
    List<Resource> DisplayALLResource();
    Resource DisplayResourceById(int id);
    boolean UpdateResource(Resource resource);
}

