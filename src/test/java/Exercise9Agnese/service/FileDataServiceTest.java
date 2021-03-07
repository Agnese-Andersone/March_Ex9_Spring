package Exercise9Agnese.service;


import Exercise9Agnese.model.FileData;
import Exercise9Agnese.model.FileDataWrapper;
import Exercise9Agnese.repository.FileDataRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class FileDataServiceTest {

    private FileDataService fileDataService;
    private FileDataRepository mockRepo;

    @BeforeEach
    void setUp() {
        mockRepo = Mockito.mock(FileDataRepository.class);
        fileDataService = new FileDataService(mockRepo);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAll() {
        List<FileData> listOfFiles = List.of(
                FileData.builder().fileName("1").build()
        );
        FileDataWrapper expected = new FileDataWrapper(
                listOfFiles
        );
        when(mockRepo.findAll()).thenReturn(listOfFiles);
        FileDataWrapper result = fileDataService.getAll();
        assertEquals(expected, result);
    }






}
