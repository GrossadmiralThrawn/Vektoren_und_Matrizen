package Vectors_and_Matrices;


import org.jetbrains.annotations.NotNull;

import java.util.Scanner;




public class Matrizen_2
{
    private Double[][] Matrix;




    public Matrizen_2(Double[][] matrix)
    {
        Matrix = matrix;
    }




    public Matrizen_2 (int Lines, int Rows)
    {
        Matrix = new Double[Lines][Rows];
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



        for (i = 0; i < 5; i++)
        {
            for (j = 0; j < 5; j++)
            {
                System.out.print(Matrix[i][j] + " ");


                if ((j != 0) && (j % (Matrix[0].length - 1) == 0))
                {
                    System.out.println("\n");
                }
            }
        }
    }





    public void setElement (@NotNull int Line, @NotNull int Row, Double Element)
    {
        Matrix[Line][Row] = Element;
    }





    public Matrizen_2 Mat_Mul (Matrizen_2 To_Multiply_Matrix)
    {
        int i, j, k;
        double Ergebnis = 0;
        Matrizen_2 Neue_Matrix = new Matrizen_2(Matrix.length, Matrix[0].length);




        for (i = 0; i < Matrix.length; i++)
        {
            for (j = 0; j < Matrix[0].length; j++)
            {
                for (k = 0; k < Matrix.length; k++)
                {
                    Ergebnis += Matrix[i][k] * To_Multiply_Matrix.getElement(k, i);
                }


                Neue_Matrix.setElement(i, j, Ergebnis);

                Ergebnis = 0;
            }
        }



        return Neue_Matrix;
    }
}
