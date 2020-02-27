package io.testoftiramisu.booktour.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RegionTest {

  // ToDo: rewrite to parametrized test, add missing cases
  @ParameterizedTest(name = "Label: {0}. Region: {1}")
  @MethodSource("argumentsForRegionTest")
  public void findByLabel(String label, Region region) {
    assertThat(Region.findByLabel(label)).isEqualTo(region);
  }

  @Test
  public void labelNotFoundTest() {
    assertThat(Region.findByLabel("label")).isEqualTo(null);
  }

  @ParameterizedTest(name = "Label: {0}. Region: {1}")
  @MethodSource("argumentsForRegionTest")
  public void getLabel(String label, Region region) {
    assertThat(region.getLabel()).isEqualTo((label));
  }

  static Stream<Arguments> argumentsForRegionTest() {
    return Stream.of(
            Arguments.of("Central Coast", Region.Central_Coast),
            Arguments.of("Southern California", Region.Southern_California),
            Arguments.of("Northern California", Region.Northern_California),
            Arguments.of("Varies", Region.Varies)
    );
  }
}
