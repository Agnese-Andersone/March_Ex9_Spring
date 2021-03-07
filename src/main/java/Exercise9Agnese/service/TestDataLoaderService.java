package Exercise9Agnese.service;

import Exercise9Agnese.model.FileData;
import Exercise9Agnese.repository.FileDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestDataLoaderService implements CommandLineRunner {
    private final FileDataRepository fileDataRepository;
    @Override
    public void run(String... args) throws Exception {
        fileDataRepository.saveAll(
                List.of(
                        FileData.builder().fileName("One").build(),
                        FileData.builder().fileName("Two").build(),
                        FileData.builder().fileName("Three").build()
                )
        );
    }
}