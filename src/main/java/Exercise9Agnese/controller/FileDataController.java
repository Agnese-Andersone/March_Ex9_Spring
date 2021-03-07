package Exercise9Agnese.controller;

import Exercise9Agnese.model.FileData;
import Exercise9Agnese.model.FileDataWrapper;
import Exercise9Agnese.service.FileDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/files-data")
public class FileDataController {
    private final FileDataService fileDataService;

    @GetMapping()
    public FileDataWrapper getAll() {
        return fileDataService.getAll();
    }

    @GetMapping("/{id}")
    public FileData getById(@PathVariable("id") String myFileId) {
        return fileDataService.getById(myFileId);
    }

    @PostMapping
    public ResponseEntity<FileData> createNew(@RequestBody FileData fileData) {
        FileData savedFileData = fileDataService.save(fileData);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .location(URI.create("localhost:8080/api/files-data" + savedFileData.getId()))
                .body(savedFileData);
    }

    @PutMapping("/{id}")
    public FileData updateExisting(@PathVariable("id") String myFileId,
                                   @RequestBody FileData fileData) {
        FileData fileToUpdate = getById(myFileId);
        return fileDataService.update(myFileId, fileData);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEntry(@PathVariable("id") String myFileId,
                                      @RequestBody FileData fileData) {
        try {
            fileDataService.delete(myFileId);
        } catch (EmptyResultDataAccessException ex) {
            return ResponseEntity.status(HttpStatus.OK).body("No such data file exists");
        }
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
