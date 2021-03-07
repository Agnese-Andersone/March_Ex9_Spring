package Exercise9Agnese.controller;

import Exercise9Agnese.model.FileDataWrapper;
import Exercise9Agnese.service.FileDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/files-data")
public class FileDataController {
    private final FileDataService fileDataService;

    @GetMapping()
    public FileDataWrapper getAll(){
        return fileDataService.getAll();
    }
}
