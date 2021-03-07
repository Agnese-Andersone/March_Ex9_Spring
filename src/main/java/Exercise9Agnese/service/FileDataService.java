package Exercise9Agnese.service;

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

}
