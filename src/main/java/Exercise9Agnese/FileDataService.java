package Exercise9Agnese;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class FileDataService {
    private final FileDataRepository fileDataRepository;

    public FileDataWrapper getAll() {
        return  new FileDataWrapper((List<FileData>) fileDataRepository.findAll());
    }
}
