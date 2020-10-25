package com.model;

public class HomeForm {
    private FileForm fileForm;
    private CredentialForm credentialForm;
    private NoteForm noteForm;

    public FileForm getFileForm() {
        return fileForm;
    }

    public void setFileForm(FileForm fileForm) {
        this.fileForm = fileForm;
    }

    public CredentialForm getCredentialForm() {
        return credentialForm;
    }

    public void setCredentialForm(CredentialForm credentialForm) {
        this.credentialForm = credentialForm;
    }

    public NoteForm getNoteForm() {
        return noteForm;
    }

    public void setNoteForm(NoteForm noteForm) {
        this.noteForm = noteForm;
    }
}
