package com.danieldjam.ecomer.models.dto;

public class RolesDTO {

    private String rolId;
    private String name;
    private String description;

    public RolesDTO() {
    }

    public RolesDTO(String rolId, String name, String description) {
        this.rolId = rolId;
        this.name = name;
        this.description = description;
    }

    public String getRolId() {
        return rolId;
    }

    public void setRolId(String rolId) {
        this.rolId = rolId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
