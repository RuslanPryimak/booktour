package io.testoftiramisu.booktour.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// ToDo: Increase test coverage
public class TourPackageTest {
  @Test
  public void testGetCode() {
    TourPackage p = new TourPackage("CC", "name");
    assertThat(p.getCode()).isEqualTo("CC");
  }

  @Test
  public void testGetName() {
    TourPackage p = new TourPackage("CC", "name");
    assertThat(p.getName()).isEqualTo("name");
  }

  @Test
  public void equalsHashcodeVerify() {
    TourPackage p1 = new TourPackage("CC", "name");
    TourPackage p2 = new TourPackage("CC", "name");

    assertThat(p1).isEqualTo(p2);
    assertThat(p1.hashCode()).isEqualTo(p2.hashCode());
  }

  @Test
  public void testToString() {
    TourPackage p = new TourPackage("CC", "name");
    assertThat(p.toString()).isEqualTo("TourPackage{code='CC', name='name'}");
  }

  @Test
  public void testEmptyConstructor() {
    TourPackage p = new TourPackage();
  }
}
