package com.filestorage.app.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.filestorage.app.model.DBFile;
import com.filestorage.app.model.FileData;
import com.filestorage.app.payload.UploadFileResponse;
import com.filestorage.app.service.DBFileStorageService;

@RestController
public class FileStorageController {
	
	@GetMapping("/welcome")
	public ModelAndView firstPage(HttpServletRequest request) {
		return new ModelAndView("welcome");
	}
	
	@Autowired
    private DBFileStorageService DBFileStorageService;

    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file,
    									 @RequestParam("comments") String comments,
    									 @RequestParam("appartmentid") String appartmentid,
										 @RequestParam("doctype") String doctype
    									 ) 
    {
        DBFile dbFile = DBFileStorageService.storeFile(file,comments,appartmentid,doctype);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(dbFile.getId())
                .toUriString();

        return new UploadFileResponse(dbFile.getFileName(), fileDownloadUri,
                file.getContentType(), file.getSize());
    }

    @PostMapping("/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files,
    													@RequestParam("comments") String comments,
    													@RequestParam("appartmentid") String appartmentid,
    													@ModelAttribute("fileData") FileData fileData
    													)
    {
    	System.err.println("comment is "+comments);
    	System.err.println("FILE DATA "+fileData.getDocumentType());
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file,comments,appartmentid,"cgdcvc"))
                .collect(Collectors.toList());
    }

    @GetMapping("/downloadFile/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) {
        // Load file from database
        DBFile dbFile = DBFileStorageService.getDocumentByDocId(fileId);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(dbFile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getFileName() + "\"")
                .body(new ByteArrayResource(dbFile.getData()));
    }
}
