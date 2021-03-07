package Exercise9Agnese.service;

import Exercise9Agnese.exception.SdaException;
import Exercise9Agnese.model.FileData;
import Exercise9Agnese.model.FileDataWrapper;
import Exercise9Agnese.repository.FileDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileDataService {
    private final FileDataRepository fileDataRepository;

    public FileDataWrapper getAll() {
        return new FileDataWrapper(fileDataRepository.findAll());
    }
    public FileData getById(String myFileId){
        return fileDataRepository.findById(myFileId)
                .orElseThrow(()-> new SdaException("There is no such file"));
    }

    public FileData save(FileData fileData) {
        return fileDataRepository.save(fileData);
    }

    public FileData update(String myFileId, FileData fileData) {
        FileData fileToUpdate = getById(myFileId);
        return fileDataRepository.save(fileData);
    }

    public void delete(String myFileId) {
        fileDataRepository.deleteById(myFileId);
    }
}
