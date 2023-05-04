package Vectors_and_Matrices;



import org.jetbrains.annotations.NotNull;
import java.util.Scanner;




public class Matrices
{
    private Double[][] matrix;




    public Matrices(Double[][] given_matrix)
    {
        matrix = given_matrix;
    }




    public Matrices(int lines, int rows)
    {
        matrix = new Double[lines][rows];
    }




    public int getLines()
    {
        return matrix.length;
    }




    public int getRows()
    {
        return matrix[0].length;
    }




    public Double getElement(@NotNull int height, @NotNull int width)
    {
        return matrix[height][width];
    }




    public void Fill_Matrix ()
    {
        int     i;
        int     j;
        Scanner Matrix_Scanner = new Scanner(System.in);




        for (i = 0; i < matrix.length; i++)
        {
            for (j = 0; j < matrix[0].length; j++)
            {
                System.out.println("Spalte: " + i + ", " + "Zeile: " + j);


                if (i % 2 == 0)
                {
                    matrix[i][j] = 291.239;
                }
                else
                {
                    matrix[i][j] = 300.5;
                }


                System.out.println("\n");
            }
        }
    }




    public boolean Is_Quadratic()
    {
        if (matrix.length == matrix[0].length)
        {
            return true;
        }
        else
        {
            return false;
        }
    }




    public void Print_Matrix()
    {
        int i, j;
        int Border = matrix[0].length - 1;


        System.out.println(Border);



        for (i = 0; i < matrix.length; i++)
        {
            for (j = 0; j < matrix[0].length; j++)
            {
                System.out.print(matrix[i][j] + " ");
            }


            System.out.println("\n");
        }
    }





    public void setElement (@NotNull int Line, @NotNull int Row, Double Element)
    {
        matrix[Line][Row] = Element;
    }





    public Matrices Mat_Mul (Matrices To_Multiply_Matrix)
    {
        int      i;
        int      j;
        int      k;
        double   Ergebnis = 0;
        Matrices Neue_Matrix = new Matrices(matrix.length, matrix[0].length);




        if (matrix[0].length == To_Multiply_Matrix.getLines())
        {
            for (i = 0; i < matrix.length; i++)
            {
                for (j = 0; j < matrix[0].length; j++)
                {
                    Neue_Matrix.setElement(i, j, 0.0);



                    for (k = 0; k < matrix[0].length; k++)
                    {
                        Neue_Matrix.setElement(i, j, Neue_Matrix.getElement(i, j) + matrix[i][k] * To_Multiply_Matrix.getElement(k, j));
                    }
                }
            }



            return Neue_Matrix;
        }
        else
        {
            System.out.println("Leider ist die Anzahl der Zeilen verschieden von der Anzahl der Spalten.");



            return null;
        }
    }




    /**
     * Function transpose a matrix.
     *
     * @return the transposed matrix.
     */
    public Matrices Transpose_Matrix ()
    {
        int i, j;
        double Result = 0;
        Matrices transposed_Matrix = new Matrices(matrix[0].length, matrix.length);



        for (i = 0; i < matrix.length; i++)
        {
            for (j = 0; j < matrix[0].length; j++)
            {
                transposed_Matrix.setElement(j, i, matrix[i][j]); //Kopiert Element an andere Stelle.
            }
        }



        return transposed_Matrix;
    }




    /**
     * @param to_Multiply_Matrix_Untransposed which is an untransposed matrix.
     *                                        That means it has the same format like
     *                                        the actual matrix.
     * @implNote This way to multiply two matrices
     *           has some performance advantages to the normal multiplication.
     * @return new matrix
    */
    public Matrices Mat_Mul_With_Transposed_Matrix (@NotNull Matrices to_Multiply_Matrix_Untransposed)
    {
        int      i;
        int      j;
        int      k;
        Matrices zwischen_Matrix = new Matrices(to_Multiply_Matrix_Untransposed.getRows(), to_Multiply_Matrix_Untransposed.getLines());
        Matrices neue_Matrix     = new Matrices(matrix.length, matrix[0].length);



        if (matrix[0].length == to_Multiply_Matrix_Untransposed.getRows()) //Checkt ob die eine Matrix die gleiche Breite wie die andere hat.
        {
            for (i = 0; i < to_Multiply_Matrix_Untransposed.getLines(); i++)
            {
                for (j = 0; j < to_Multiply_Matrix_Untransposed.getRows(); j++)
                {
                    zwischen_Matrix.setElement(j, i, matrix[i][j]); //Transponiert Matrix vor Multiplikation.
                }
            }


            for (i = 0; i < matrix.length; i++)
            {
                for (j = 0; j < matrix[0].length; j++)
                {
                    neue_Matrix.setElement(i, j, 0.0);
                    for (k = 0; k < matrix[0].length; k++)
                    {
                        neue_Matrix.setElement(i, j, neue_Matrix.getElement(i, j) + matrix[i][k] * zwischen_Matrix.getElement(k, j));
                    }
                }
            }



            return neue_Matrix;
        }
        else
        {
            System.out.println("Leider sind die Matrizen verschieden, weswegen diese Funktion nicht ausgeführt werden kann.");


            return null;
        }

    }
}
