package com.udacity.jwdnd.course1.cloudstorage.model;

import java.sql.Blob;

public class FileForm {

    private File fileUpload;
    private String userName;

    public File getFileUpload() {
        return fileUpload;
    }

    public void setFileUpload(File fileUpload) {
        this.fileUpload = fileUpload;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
