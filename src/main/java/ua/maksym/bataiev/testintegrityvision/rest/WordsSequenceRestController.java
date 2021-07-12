package ua.maksym.bataiev.testintegrityvision.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.maksym.bataiev.testintegrityvision.model.WordsContainer;
import ua.maksym.bataiev.testintegrityvision.util.WordsContainerUtil;

@RestController
@RequestMapping("/api/game")
public class WordsSequenceRestController {

  @PostMapping
  public WordsContainer check(@RequestBody WordsContainer compareWords) {
    return WordsContainerUtil.checkWordsSequence(compareWords);
  }

}
