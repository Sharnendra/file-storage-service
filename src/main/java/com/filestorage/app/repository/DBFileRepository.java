package com.filestorage.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.filestorage.app.model.DBFile;

@Repository
public interface DBFileRepository extends JpaRepository<DBFile, String> {

}
