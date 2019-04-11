package com.filestorage.app.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "files")
public class DBFile {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    @Column(name="appartment_id")
    private String appartmentId;

    @Column(name="document")
    private String fileName;

    @Column(name="mime_type")
    private String fileType;
    
    @Column(name="upload_date")
    private LocalDateTime date;
    
    @Column(name="doc_type")
    private String docType;
    
    @Column(name="comments")
    private String comments;

    @Lob
    private byte[] data;

    public DBFile() {

    }

    public DBFile(String fileName, String fileType, byte[] data, String comments, String appartmentId,String doctype) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
        this.date=LocalDateTime.now();
        this.comments=comments;
        this.appartmentId=appartmentId;
        this.docType=doctype;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getAppartmentId() {
		return appartmentId;
	}

	public void setAppartmentId(String appartmentId) {
		this.appartmentId = appartmentId;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
    
    
}
