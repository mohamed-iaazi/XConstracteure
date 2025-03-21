package com.medo.xbuilder.Model;

import java.io.Serializable;

public class Resource  {
    private  int ResourceId ;
    private  String ResourceName ;
    private String ResourceDetail;
    private  String ResourceType ;
    private  int ResourceQuantite ;
    private  String ResourceFournisseur;

    public Resource(int resourceId, String resourceName, String ResourceDetail, String resourceType, int resourceQuantite, String resourceFournisseur) {
        ResourceId = resourceId;
        ResourceName = resourceName;
        ResourceType = resourceType;
        ResourceQuantite = resourceQuantite;
        ResourceFournisseur = resourceFournisseur;
        this.ResourceDetail = ResourceDetail;
    }

    public Resource(String resourceName, String resourceDetail, String resourceType, int resourceQuantite, String resourceFournisseur) {
        ResourceName = resourceName;
        ResourceDetail = resourceDetail;
        ResourceType = resourceType;
        ResourceQuantite = resourceQuantite;
        ResourceFournisseur = resourceFournisseur;
    }

    public String getResourceDetail() {
        return ResourceDetail;
    }

    public void setResourceDetail(String resourceDetail) {
        ResourceDetail = resourceDetail;
    }

    public int getResourceId() {
        return ResourceId;
    }

    public void setResourceId(int resourceId) {
        ResourceId = resourceId;
    }

    public String getResourceName() {
        return ResourceName;
    }

    public void setResourceName(String resourceName) {
        ResourceName = resourceName;
    }

    public String getResourceType() {
        return ResourceType;
    }

    public void setResourceType(String resourceType) {
        ResourceType = resourceType;
    }

    public int getResourceQuantite() {
        return ResourceQuantite;
    }

    public void setResourceQuantite(int resourceQuantite) {
        ResourceQuantite = resourceQuantite;
    }

    public String getResourceFournisseur() {
        return ResourceFournisseur;
    }

    public void setResourceFournisseur(String resourceFournisseur) {
        ResourceFournisseur = resourceFournisseur;
    }

    @Override
    public String toString() {
        return  "name" + ResourceName;
    }
}
