package ua.maksym.bataiev.testintegrityvision.util;

import java.util.ArrayList;
import java.util.List;
import ua.maksym.bataiev.testintegrityvision.model.WordsContainer;

public class WordsContainerUtil {

  private WordsContainerUtil() {

  }

  public static WordsContainer checkWordsSequence(WordsContainer checked) {
    List<String> result = new ArrayList<>();

    if (checked.getWords().isEmpty() || checked.getWords().get(0).trim().length() == 0) {
      return new WordsContainer((result));
    }

    result.add(checked.getWords().get(0).trim());

    for (int i = 0; i < checked.getWords().size() - 1; i++) {
      var string = checked.getWords().get(i).trim();
      var nextString = checked.getWords().get(i + 1).trim();
      if (string.length() == 0 || nextString.length() == 0) {
        break;
      }
      if ((string.charAt(string.length() - 1) != nextString.charAt(0))) {
        break;
      }
      result.add(nextString);
    }
    return new WordsContainer(result);
  }

}
