package io.testoftiramisu.booktour.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

// ToDo: Increase test coverage
public class RegionConverterTest {
  private RegionConverter converter = new RegionConverter();

  @ParameterizedTest(name = "Region: {1}")
  @MethodSource("argumentsForRegionConverterTest")
  public void convertsToDatabaseColumn(String label, Region region) {
    assertThat(converter.convertToDatabaseColumn(region))
        .isEqualTo(region.getLabel());
  }

  @ParameterizedTest(name = "Label: {0}")
  @MethodSource("argumentsForRegionConverterTest")
  public void convertToEntityAttribute(String label) {
    assertThat(converter.convertToEntityAttribute(label))
            .isEqualTo(Region.findByLabel(label));
  }

  static Stream<Arguments> argumentsForRegionConverterTest() {
    return Stream.of(
            Arguments.of("Central Coast", Region.Central_Coast),
            Arguments.of("Southern California", Region.Southern_California),
            Arguments.of("Northern California", Region.Northern_California),
            Arguments.of("Varies", Region.Varies)
    );
  }
}
