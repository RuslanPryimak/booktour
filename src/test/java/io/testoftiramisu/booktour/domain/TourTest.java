package io.testoftiramisu.booktour.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// ToDo: Increase test coverage
public class TourTest {
  private TourPackage tourPackage = new TourPackage("CC", "name");
  private Tour tour =
      new Tour(
          "title",
          "description",
          "blurb",
          50,
          "1 day",
          "bullet",
          "keywords",
          tourPackage,
          Difficulty.Difficult,
          Region.Central_Coast);

  @Test
  public void testConstructorAndGetters() {
    assertThat(tour.getId()).isNull();
    assertThat(tour.getTitle()).isEqualTo("title");
    assertThat(tour.getDescription()).isEqualTo("description");
    assertThat(tour.getBlurb()).isEqualTo("blurb");
    assertThat(tour.getPrice()).isEqualTo(50);
    assertThat(tour.getDuration()).isEqualTo("1 day");
    assertThat(tour.getBullets()).isEqualTo("bullet");
    assertThat(tour.getKeywords()).isEqualTo("keywords");
    assertThat(tour.getTourPackage()).isEqualTo(tourPackage);
    assertThat(tour.getDifficulty()).isEqualTo(Difficulty.Difficult);
    assertThat(tour.getRegion()).isEqualTo(Region.Central_Coast);
  }

  @Test
  public void testEmptyConstructor() {
    Tour tour = new Tour();
  }

  @Test
  public void equalsHashcodeVerify() {
    TourPackage p = new TourPackage("CC", "name");
    Tour tour2 =
        new Tour(
            "title",
            "description",
            "blurb",
            50,
            "1 day",
            "bullet",
            "keywords",
            p,
            Difficulty.Difficult,
            Region.Central_Coast);

    assertThat(tour).isEqualTo(tour2);
  }

  @Test
  public void testToString() {
    assertThat(tour.toString()).isEqualTo("Tour{" +
            "id=null, " +
            "title='title', " +
            "description='description', " +
            "blurb='blurb', " +
            "price=50, " +
            "duration='1 day', " +
            "bullets='bullet', " +
            "keywords='keywords', " +
            "tourPackage=TourPackage{code='CC', name='name'}, " +
            "difficulty=Difficult, " +
            "region=Central_Coast}");
  }
}
