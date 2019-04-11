package com.filestorage.app.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.filestorage.app.exception.FileStorageException;
import com.filestorage.app.exception.MyFileNotFoundException;
import com.filestorage.app.model.DBFile;
import com.filestorage.app.repository.DBFileRepository;

@Service
public class DBFileStorageService {

    @Autowired
    private DBFileRepository dbFileRepository;

    public DBFile storeFile(MultipartFile file,String Comments, String appartmentid,String doctype) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            DBFile dbFile = new DBFile(fileName, 
            		file.getContentType(), file.getBytes(),Comments,appartmentid,doctype);

            return dbFileRepository.save(dbFile);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    //To retrieve document by docId
    public DBFile getDocumentByDocId(String docId) {
        return dbFileRepository.findById(docId)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + docId));
    }
    
    public List<DBFile> getAllFiles() {
        return dbFileRepository.findAll();
    }
    
    
}
