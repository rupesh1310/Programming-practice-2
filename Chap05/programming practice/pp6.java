public class pp6{

  private class Cell {

    public double dValue;
    public Cell below;
    public Cell right;

    Cell() {};

    Cell(double dValue) {
      this.dValue = dValue;
    }

  }
  
  private class Matrix {

    private Cell topLeft;

    public Rows rows = new Rows();
    public Columns columns = new Columns();

    // Constructor
    Matrix(int rows, int columns) {

      // check rows and columns > 1
      if (rows < 1 || columns < 1) {
        System.err.println("Matrix must be at least 1 x 1 in size.");
        return;
      }

      // create topLeft
      topLeft = new Cell();

      // create other cells, looping through rows then columns
      Cell above = null;
      Cell left = null;
      Cell startOfRow = null;
      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < columns; j++) {
          Cell newCell = new Cell();
          if (i == 0 && j == 0) {
            topLeft = newCell;
          }
          if (j == 0) {
            startOfRow = newCell;
          }
          if (left != null) {
            left.right = newCell;
          }
          left = newCell;
          if (above != null) {
            above.below = newCell;
            above = above.right;
          }
        }
        left = null;
        above = startOfRow;
      }
    }

    public Cell getCell(int row, int col) {
      Cell foo = topLeft;
      for (int i = 1; i < row; i++) {
        foo = foo.below;
      }
      for (int i = 1; i < col; i++) {
        foo = foo.right;
      }
      return foo;
    }

    public void display() {

      final int CELL_WIDTH = 9;

      System.out.printf("Matrix:\n");

      // print column headings
      System.out.printf("%" + CELL_WIDTH + "s","");
      int i = 1;
      for (Cell foo = topLeft; foo != null; foo = foo.right) {
        String s = String.format("%d", i++);
        System.out.printf("%" + CELL_WIDTH + "s", "COL " + s);
      }
      System.out.println();

      // print row headings and cells, looping through rows then columns
      Cell firstOfRow = topLeft;
      i = 1;
      for (Cell foo = topLeft; foo != null; foo = foo.below) {
        System.out.printf("ROW %-" + (CELL_WIDTH - 4) + "d", i++);
        for (Cell bar = firstOfRow; bar != null; bar = bar.right) {
          System.out.printf("%" + (CELL_WIDTH) + ".1f", bar.dValue);
        }
        firstOfRow = firstOfRow.below;
        System.out.println();
      }

    }

    private class Rows {

      public void insert(int afterRow) {

        Cell above = topLeft;
        for (int i = 1; i < afterRow - 1; i++) {
          above = above.below;
        }
        Cell prevCell = null;
        for (Cell foo = above; foo != null; foo = foo.right) {
          Cell newCell = new Cell();
          newCell.below = foo.below;
          if (afterRow != 0) {
            foo.below = newCell;
          }
          if (prevCell != null) {
            prevCell.right = newCell;
          }
          prevCell =  newCell;
        }
      }

      public void delete(int row) {
        if (row == 1) {
          Matrix.this.topLeft = topLeft.below;
        }
        Cell above = Matrix.this.topLeft;
        for (int i = 1; i < row - 1; i++) {
          above = above.below;
        }
        for (Cell foo = above; foo != null; foo = foo.right) {
          foo.below = foo.below.below;
        }

      }
    }

    class Columns {

      public void insert(int afterCol) {

        Cell left = topLeft;
        for (int i = 1; i < afterCol - 1; i++) {
          left = left.right;
        }
        Cell prevCell = null;
        for (Cell foo = left; foo != null; foo = foo.below) {
          Cell newCell = new Cell();
          newCell.right = foo.right;
          if (afterCol != 0) {
            foo.right = newCell;
          }
          if (prevCell != null) {
            prevCell.below = newCell;
          }
          prevCell =  newCell;
        }
      }

      public void delete(int row) {
        if (row == 1) {
          Matrix.this.topLeft = topLeft.right;
        }
        Cell above = Matrix.this.topLeft;
        for (int i = 1; i < row - 1; i++) {
          above = above.right;
        }
        for (Cell foo = above; foo != null; foo = foo.below) {
          foo.right = foo.right.right;
        }

      }

    }

  }

  public static void main(String[] args) {
    // Create matrix
    final int ROWS = 3;
    final int COLUMNS = 4;
    pp6 app = new pp6();
    Matrix matrix = app.new Matrix(ROWS, COLUMNS);

    // display matrix
    matrix.display();

    // getCell
    System.out.println("getCell");
    matrix.getCell(2, 2).dValue = 22.0;
    matrix.getCell(3, 3).dValue = 33.0;
    matrix.display();

    // rows
    System.out.printf("\n\nInsert row after 2\n");
    matrix.rows.insert(2);
    matrix.display();
    System.out.printf("\n\nDelete row 4\n");
    matrix.rows.delete(4);
    matrix.display();

    // columns
    System.out.printf("\n\nInsert column after 2\n");
    matrix.columns.insert(2);
    matrix.display();
    System.out.printf("\n\nDelete column 3\n");
    matrix.columns.delete(0);
    matrix.display();

    // display matrix
  }
}
