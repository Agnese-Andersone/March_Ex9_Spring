package Exercise9Agnese;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity(name="files_data")
public class FileData {

    @Id
    @GeneratedValue
    private UUID id;

    private String fileName;
    private String extension;
    private Long sizeInKb;
    private String content;
}
