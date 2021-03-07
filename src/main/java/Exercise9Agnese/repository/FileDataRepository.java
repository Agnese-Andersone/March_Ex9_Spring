package Exercise9Agnese.repository;

import Exercise9Agnese.model.FileData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileDataRepository extends JpaRepository<FileData, String> {

}
