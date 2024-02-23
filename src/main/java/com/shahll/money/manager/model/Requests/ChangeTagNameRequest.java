package com.shahll.money.manager.model.Requests;

public class ChangeTagNameRequest {
    private String oldName;
    private String newName;

    public ChangeTagNameRequest() {
    }

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }
}
