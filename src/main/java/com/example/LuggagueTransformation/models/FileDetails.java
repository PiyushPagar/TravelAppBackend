package com.example.LuggagueTransformation.models;

public class FileDetails {
    private String fileName;
    private String contentType;
    private byte[] data;
    
    
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}

    // getters and setters
}