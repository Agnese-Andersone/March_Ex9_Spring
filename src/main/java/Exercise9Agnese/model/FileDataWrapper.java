package Exercise9Agnese.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class FileDataWrapper {
    private List<FileData> all;
}
