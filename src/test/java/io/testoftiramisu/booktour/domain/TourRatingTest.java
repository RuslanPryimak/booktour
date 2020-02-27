package io.testoftiramisu.booktour.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

// ToDo: Increase test coverage
public class TourRatingTest {

    private Tour tour =
            new Tour(
                    "title",
                    "description",
                    "blurb",
                    50,
                    "1 day",
                    "bullet",
                    "keywords",
                    new TourPackage("CC", "name"),
                    Difficulty.Difficult,
                    Region.Central_Coast);

    @Test
    void testTourRatingComment() {
        TourRating rating = new TourRating(tour, 1, 1, "comment");
        assertThat(rating.getComment()).isEqualTo("comment");
    }

    @ParameterizedTest(name = "Score: {0}. Comment: {1}")
    @MethodSource("argumentsForTourRatingAutoComment")
    void testTourRatingAutoComment(int score, String comment) {
        TourRating rating = new TourRating(tour, 1, score);
        assertThat(rating.getComment()).isEqualTo(comment);
    }

    static Stream<Arguments> argumentsForTourRatingAutoComment() {
        return Stream.of(
                Arguments.of(1, "Terrible"),
                Arguments.of(2, "Poor"),
                Arguments.of(3, "Fair"),
                Arguments.of(4, "Good"),
                Arguments.of(5, "Great"),
                Arguments.of(6, "6")
        );
    }

    @Test
    void testConstructor() {
        TourRating rating = new TourRating(tour, 1, 1);
        assertThat(rating.getId()).isNull();
        assertThat(rating.getTour()).isEqualTo(tour);
        assertThat(rating.getScore()).isEqualTo(1);
        assertThat(rating.getCustomerId()).isEqualTo(1);
    }

    @Test
    void testConstructorWithCommentAndSetters() {
        TourRating rating = new TourRating(tour, 1, 1, "comment");
        assertThat(rating.getComment()).isEqualTo("comment");

        rating.setTour(tour);//???

        rating.setCustomerId(5);
        rating.setScore(5);
        rating.setComment("new comment");
        assertThat(rating.getCustomerId()).isEqualTo(5);
        assertThat(rating.getScore()).isEqualTo(5);
        assertThat(rating.getComment()).isEqualTo("new comment");

    }

    @Test
    void testEmptyConstructor() {
        TourRating rating = new TourRating();
    }

    @Test
    public void equalsHashcodeVerify() {
        TourRating rating1 = new TourRating(tour, 1, 1, "comment");
        TourRating rating2 = new TourRating(tour, 1, 1, "comment");

        assertThat(rating1).isEqualTo(rating2);
        assertThat(rating1.hashCode()).isEqualTo(rating2.hashCode());
    }
}
