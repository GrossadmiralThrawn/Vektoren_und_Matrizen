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
        Matrix = new Double[lines][rows];
    }




    public int getLines()
    {
        return Matrix.length;
    }




    public int getRows()
    {
        return Matrix[0].length;
    }




    public Double getElement(@NotNull int Height, @NotNull int Width)
    {
        return Matrix[Height][Width];
    }




    public void Fill_Matrix ()
    {
        int i, j;
        Scanner Matrix_Scanner = new Scanner(System.in);




        for (i = 0; i < Matrix.length; i++)
        {
            for (j = 0; j < Matrix[0].length; j++)
            {
                System.out.println("Spalte: " + i + ", " + "Zeile: " + j);


                if (i % 2 == 0)
                {
                    Matrix[i][j] = 291.239;
                }
                else
                {
                    Matrix[i][j] = 300.5;
                }


                System.out.println("\n");
            }
        }
    }




    public boolean Is_Quadratic()
    {
        if (Matrix.length == Matrix[0].length)
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
        int Border = Matrix[0].length - 1;


        System.out.println(Border);



        for (i = 0; i < Matrix.length; i++)
        {
            for (j = 0; j < Matrix[0].length; j++)
            {
                System.out.print(Matrix[i][j] + " ");
            }


            System.out.println("\n");
        }
    }





    public void setElement (@NotNull int Line, @NotNull int Row, Double Element)
    {
        Matrix[Line][Row] = Element;
    }





    public Matrices Mat_Mul (Matrices To_Multiply_Matrix)
    {
        int i, j, k;
        double Ergebnis = 0;
        Matrices Neue_Matrix = new Matrices(Matrix.length, Matrix[0].length);




        if (Matrix[0].length == To_Multiply_Matrix.getLines())
        {
            for (i = 0; i < Matrix.length; i++)
            {
                for (j = 0; j < Matrix[0].length; j++)
                {
                    Neue_Matrix.setElement(i, j, 0.0);



                    for (k = 0; k < Matrix[0].length; k++)
                    {
                        Neue_Matrix.setElement(i, j, Neue_Matrix.getElement(i, j) + Matrix[i][k] * To_Multiply_Matrix.getElement(k, j));
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




    public Matrices Transpose_Matrix ()
    {
        int i, j;
        double Result = 0;
        Matrices Transposed_Matrix = new Matrices(Matrix[0].length, Matrix.length);



        for (i = 0; i < Matrix.length; i++)
        {
            for (j = 0; j < Matrix[0].length; j++)
            {
                Transposed_Matrix.setElement(j, i, Matrix[i][j]); //Kopiert Element an andere Stelle.
            }
        }



        return Transposed_Matrix;
    }




    public Matrices Mat_Mul_With_Transposed_Matrix (@NotNull Matrices To_Multiply_Matrix_Untransposed)
    {
        int i, j, k;
        double Ergebnis = 0;
        Matrices Zwischen_Matrix = new Matrices(To_Multiply_Matrix_Untransposed.getRows(), To_Multiply_Matrix_Untransposed.getLines());
        Matrices Neue_Matrix = new Matrices(Matrix.length, Matrix[0].length);



        if (Matrix[0].length == To_Multiply_Matrix_Untransposed.getRows()) //Checkt ob die eine Matrix die gleiche Breite wie die andere hat.
        {
            for (i = 0; i < To_Multiply_Matrix_Untransposed.getLines(); i++)
            {
                for (j = 0; j < To_Multiply_Matrix_Untransposed.getRows(); j++)
                {
                    Zwischen_Matrix.setElement(j, i, Matrix[i][j]); //Transponiert Matrix vor Multiplikation.
                }
            }


            for (i = 0; i < Matrix.length; i++)
            {
                for (j = 0; j < Matrix[0].length; j++)
                {
                    Neue_Matrix.setElement(i, j, 0.0);
                    for (k = 0; k < Matrix[0].length; k++)
                    {
                        Neue_Matrix.setElement(i, j, Neue_Matrix.getElement(i, j) + Matrix[i][k] * Zwischen_Matrix.getElement(k, j));
                    }
                }
            }



            return Neue_Matrix;
        }
        else
        {
            System.out.println("Leider sind die Matrizen verschieden, weswegen diese Funktion nicht ausgeführt werden kann.");


            return null;
        }

    }
}
