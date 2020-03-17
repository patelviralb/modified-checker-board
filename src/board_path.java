import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class board_path {

  private static String filePath = "board.dat";
  private static int matrixDimension;
  private static double[][] costMatrix;
  private static String[][] pathMatrix;

  static double getMinimumCost() {
    return minimumCost;
  }

  private static double minimumCost = Double.MAX_VALUE;

  board_path() {
    this.filePath = "board.dat";
    this.minimumCost = Double.MAX_VALUE;
  }

  board_path(String filePath) {
    this.filePath = filePath;
    this.minimumCost = Double.MAX_VALUE;
  }

  public static void main(String[] args) {

    StringBuilder finalPath = new StringBuilder();

    readFile();
    /*printInputMatrix();*/
    finalPath.insert(0, calculateCostMatrix());
    getFinalPath(finalPath);
    System.out.println(minimumCost + "\n" + finalPath.toString());
  }

  private static void printInputMatrix() {
    System.out.println("Input Matrix");
    for (int i = (matrixDimension - 1); i >= 0; i--) {
      for (int j = 0; j < matrixDimension; j++) {
        System.out.print(costMatrix[i][j] + " ");
      }
      System.out.println();
    }
  }

  static void getFinalPath(StringBuilder finalPath) {
    String startStep = finalPath.toString();

    for (int j = 0; j < (matrixDimension - 1); j++) {
      int nextI = Integer.parseInt(startStep.split(" ")[0]);
      int nextJ = Integer.parseInt(startStep.split(" ")[1]);
      startStep = pathMatrix[nextI][nextJ];
      finalPath.insert(0, startStep + "\n");
    }
  }

  static void readFile() {
    try {
      File inputFile;
      inputFile = new File(filePath);
      Scanner scr = new Scanner(inputFile);

      while (scr.hasNextLine()) {
        String line = scr.nextLine().trim();
        if (line.length() > 0) {
          matrixDimension = Integer.parseInt(line);
          costMatrix = new double[matrixDimension][matrixDimension];
          for (int i = 0; i < matrixDimension; i++) {
            for (int j = 0; j < matrixDimension; j++) {
              costMatrix[i][j] = scr.nextDouble();
            }
          }
        }
      }
    } catch (FileNotFoundException fileException) {
      System.out.println("An error occurred.");
      fileException.printStackTrace();
    }
  }

  static String calculateCostMatrix() {
    double[][] totalCostMatrix = new double[matrixDimension][matrixDimension];
    pathMatrix = new String[matrixDimension][matrixDimension];

    double rootTwo = Math.sqrt(2);

    String startStep = "";

    for (int j = (matrixDimension - 1); j >= 0; j--) {
      totalCostMatrix[matrixDimension - 1][j] = 0;
    }

    for (int i = (matrixDimension - 2); i >= 0; i--) {
      for (int j = (matrixDimension - 1); j >= 0; j--) {
        String southPath = "" + (i + 1) + " " + j;
        String southWestPath = "" + (i + 1) + " " + (j - 1);
        String southEastPath = "" + (i + 1) + " " + (j + 1);
        //System.out.println(southPath + "|" + southWestPath + "|" + southEastPath);

        double southBlock = (((costMatrix[i + 1][j] + costMatrix[i][j]) / 2) + totalCostMatrix[i
            + 1][j]);

        if (j == matrixDimension - 1) {
          double southWestBlock = ((((costMatrix[i + 1][j - 1] + costMatrix[i][j]) / 2) * rootTwo) + totalCostMatrix[i + 1][j - 1]);

          totalCostMatrix[i][j] = Math.min(southBlock, southWestBlock);
          pathMatrix[i][j] = findMinPath(southBlock, southWestBlock, southPath, southWestPath);
        } else {
          double southEastBlock = ((((costMatrix[i + 1][j + 1] + costMatrix[i][j]) / 2) * rootTwo)
              + totalCostMatrix[i + 1][j + 1]);

          if (j == 0) {
            totalCostMatrix[i][j] = Math.min(southBlock, southEastBlock);
            pathMatrix[i][j] = findMinPath(southBlock, southEastBlock, southPath, southEastPath);
          } else {
            double southWestBlock = ((((costMatrix[i + 1][j - 1] + costMatrix[i][j]) / 2) * rootTwo)
                + totalCostMatrix[i + 1][j - 1]);

            totalCostMatrix[i][j] = Math.min(southBlock, Math.min(southWestBlock, southEastBlock));
            pathMatrix[i][j] = findMinPath(
                southBlock, Math.min(southWestBlock, southEastBlock),
                southPath,
                findMinPath(southWestBlock, southEastBlock, southWestPath, southEastPath)
            );
          }
        }

        if (i == 0 && totalCostMatrix[i][j] <= minimumCost) {
          minimumCost = totalCostMatrix[i][j];
          startStep = i + " " + j;
        }
      }
    }

    /*printCostMatrix(totalCostMatrix);*/
    /*printPathMatrix();*/
    return startStep;
  }

  private static void printPathMatrix() {
    System.out.println("Path Matrix");
    for (int i = (matrixDimension - 2); i >= 0; i--) {
      for (int j = 0; j < matrixDimension; j++) {
        System.out.print(pathMatrix[i][j] + " | ");
      }
      System.out.println();
    }
  }

  private static void printCostMatrix(double[][] totalCostMatrix) {
    System.out.println("Cost Matrix");
    /*for (int i = (matrixDimension - 1); i >= 0; i--) {*/
    for (int i = 0; i < matrixDimension; i++) {
      for (int j = 0; j < matrixDimension; j++) {
        System.out.print(String.format("%1.2f ", totalCostMatrix[i][j]));
      }
      System.out.println();
    }
  }

  private static String findMinPath(double blockOne, double blockTwo, String pathOne,
      String pathTwo) {
    double minValue = Math.min(blockOne, blockTwo);
    if (minValue == blockOne) {
      return pathOne;
    }
    return pathTwo;
  }
}