package ua.maksym.bataiev.testintegrityvision.rest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ua.maksym.bataiev.testintegrityvision.model.WordsContainer;

@SpringBootTest
class WordsSequenceRestControllerTest {

  @Autowired
  private WordsSequenceRestController controller;
  private WordsContainer container;

  @BeforeEach
  void setUp() {
    container = new WordsContainer();
  }

  @Test
  void checkFullSequence() {
    container.setWords(Arrays.asList(
        "fish",
        "horse",
        "egg",
        "goose",
        "eagle"
    ));
//    assertEquals(controller.check(container), container);
    fail();
  }

  @Test
  void checkEmptySequence() {
    assertEquals(controller.check(container), container);
  }

  @Test
  void checkSyntaxError() {
    container.setWords(Arrays.asList(
        "fish",
        "hors",
        "egg",
        "goose",
        "eagle"
    ));
    assertEquals(controller.check(container),
        new WordsContainer(Arrays.asList("fish", "hors")));
  }

  @Test
  void checkEmptyNotFirstElement() {
    container.setWords(Arrays.asList(
        "fish",
        "horse",
        "",
        "goose",
        "eagle"
    ));
    assertEquals(controller.check(container),
        new WordsContainer(Arrays.asList("fish", "horse")));
  }

  @Test
  void checkEmptyFirstElement() {
    container.setWords(Arrays.asList(
        "",
        "horse",
        "egg",
        "goose",
        "eagle"
    ));
    assertEquals(controller.check(container),
        new WordsContainer(Collections.emptyList()));
  }
}