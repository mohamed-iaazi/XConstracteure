package com.medo.xbuilder.Model;

public class Resource {
    private  int ResourceId ;
    private  String ResourceName ;
    private  String ResourceType ;
    private  String ResourceQuantite ;
    private  String ResourceFournisseur;

    public Resource(int resourceId, String resourceName, String resourceType, String resourceQuantite, String resourceFournisseur) {
        ResourceId = resourceId;
        ResourceName = resourceName;
        ResourceType = resourceType;
        ResourceQuantite = resourceQuantite;
        ResourceFournisseur = resourceFournisseur;
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

    public String getResourceQuantite() {
        return ResourceQuantite;
    }

    public void setResourceQuantite(String resourceQuantite) {
        ResourceQuantite = resourceQuantite;
    }

    public String getResourceFournisseur() {
        return ResourceFournisseur;
    }

    public void setResourceFournisseur(String resourceFournisseur) {
        ResourceFournisseur = resourceFournisseur;
    }
}
