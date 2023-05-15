package com.felipe.myapplication;

public class Version {

    private String codeName,version,apiLevel,descripcion;
    private Boolean expandible;

    public Boolean getExpandible() {
        return expandible;
    }

    public void setExpandible(Boolean expandible) {
        this.expandible = expandible;
    }

    public Version(String codeName, String version, String apiLevel, String descripcion) {
        this.codeName = codeName;
        this.version = version;
        this.apiLevel = apiLevel;
        this.descripcion = descripcion;
         this.expandible=false;
    }




    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getApiLevel() {
        return apiLevel;
    }

    public void setApiLevel(String apiLevel) {
        this.apiLevel = apiLevel;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Version{" +
                "codeName='" + codeName + '\'' +
                ", version='" + version + '\'' +
                ", apiLevel='" + apiLevel + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
