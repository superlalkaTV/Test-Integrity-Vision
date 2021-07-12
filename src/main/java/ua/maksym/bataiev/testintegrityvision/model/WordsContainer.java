package ua.maksym.bataiev.testintegrityvision.model;

import java.util.Collections;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class WordsContainer {

  private List<String> words = Collections.emptyList();

}
