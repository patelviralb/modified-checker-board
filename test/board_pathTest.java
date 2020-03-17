import static org.junit.Assert.*;

import org.junit.Test;

public class board_pathTest {
  private board_path testPath;
  private StringBuilder finalPath;
  private StringBuilder expectedPath;
  double expectedMinimumCost;

  @Test
  public void testBoardOne() {
    this.testPath = new board_path("test/board1.dat");
    this.finalPath = new StringBuilder();
    this.expectedPath = new StringBuilder("3 0\n2 0\n1 0\n0 0");

    board_path.readFile();
    this.finalPath.insert(0, board_path.calculateCostMatrix());
    board_path.getFinalPath(this.finalPath);
    assertEquals(this.expectedPath.toString(), this.finalPath.toString());
    this.expectedMinimumCost = 3.0;
    assertEquals(this.expectedMinimumCost, board_path.getMinimumCost(), 0);
  }

  @Test
  public void testBoardTwo() {
    testPath = new board_path("test/board2.dat");
    this.finalPath = new StringBuilder();
    this.expectedPath = new StringBuilder("3 2\n2 2\n1 2\n0 2");

    board_path.readFile();
    this.finalPath.insert(0, board_path.calculateCostMatrix());
    board_path.getFinalPath(this.finalPath);
    assertEquals(this.expectedPath.toString(), this.finalPath.toString());
    this.expectedMinimumCost = 3.0;
    assertEquals(this.expectedMinimumCost, board_path.getMinimumCost(), 0);
  }

  @Test
  public void testBoardThree() {
    testPath = new board_path("test/board3.dat");
    this.finalPath = new StringBuilder();
    this.expectedPath = new StringBuilder("3 3\n2 2\n1 1\n0 0");

    board_path.readFile();
    this.finalPath.insert(0, board_path.calculateCostMatrix());
    board_path.getFinalPath(this.finalPath);
    assertEquals(this.expectedPath.toString(), this.finalPath.toString());
    this.expectedMinimumCost = 4.242640687119285;
    assertEquals(this.expectedMinimumCost, board_path.getMinimumCost(), 5);
  }

  @Test
  public void testBoardFour() {
    testPath = new board_path("test/board4.dat");
    this.finalPath = new StringBuilder();
    this.expectedPath = new StringBuilder("3 2\n2 1\n1 2\n0 1");

    board_path.readFile();
    this.finalPath.insert(0, board_path.calculateCostMatrix());
    board_path.getFinalPath(this.finalPath);
    assertEquals(this.expectedPath.toString(), this.finalPath.toString());
    this.expectedMinimumCost = 4.242640687119285;
    assertEquals(this.expectedMinimumCost, board_path.getMinimumCost(), 5);
  }

  @Test
  public void testBoardFive() {
    testPath = new board_path("test/board5.dat");
    this.finalPath = new StringBuilder();
    this.expectedPath = new StringBuilder("3 2\n2 1\n1 2\n0 2");

    board_path.readFile();
    this.finalPath.insert(0, board_path.calculateCostMatrix());
    board_path.getFinalPath(this.finalPath);
    assertEquals(this.expectedPath.toString(), this.finalPath.toString());
    this.expectedMinimumCost = 3.9784271247461898;
    assertEquals(this.expectedMinimumCost, board_path.getMinimumCost(), 5);
  }

  @Test
  public void testBoardSix() {
    testPath = new board_path("test/board6.dat");
    this.finalPath = new StringBuilder();
    this.expectedPath = new StringBuilder("7 3\n6 2\n5 3\n4 4\n3 4\n2 3\n1 3\n0 2");

    board_path.readFile();
    this.finalPath.insert(0, board_path.calculateCostMatrix());
    board_path.getFinalPath(this.finalPath);
    assertEquals(this.expectedPath.toString(), this.finalPath.toString());
    this.expectedMinimumCost = 9.071067811865476;
    assertEquals(this.expectedMinimumCost, board_path.getMinimumCost(), 5);
  }

  @Test
  public void testBoardSeven() {
    testPath = new board_path("test/board7.dat");
    this.finalPath = new StringBuilder();
    this.expectedPath = new StringBuilder("7 2\n6 2\n5 3\n4 3\n3 3\n2 3\n1 3\n0 2");

    board_path.readFile();
    this.finalPath.insert(0, board_path.calculateCostMatrix());
    board_path.getFinalPath(this.finalPath);
    assertEquals(this.expectedPath.toString(), this.finalPath.toString());
    this.expectedMinimumCost = 8.32842712474619;
    assertEquals(this.expectedMinimumCost, board_path.getMinimumCost(), 5);
  }
}