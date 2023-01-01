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





    public Matrizen_2 Mat_Mul (Matrizen_2 To_Multiply_Matrix)
    {
        int i, j, k;
        double Ergebnis = 0;
        Matrizen_2 Neue_Matrix = new Matrizen_2(Matrix.length, Matrix[0].length);




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

                        System.out.println(Neue_Matrix.getElement(i, j));
                    }
                    System.out.println();
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




    public Matrizen_2 Transpose_Matrix ()
    {
        int i, j;
        double Result = 0;
        Matrizen_2 Transposed_Matrix = new Matrizen_2(Matrix[0].length, Matrix.length);



        for (i = 0; i < Matrix.length; i++)
        {
            for (j = 0; j < Matrix[0].length; j++)
            {
                Transposed_Matrix.setElement(j, i, Matrix[i][j]);
            }
        }



        return Transposed_Matrix;
    }




    public Matrizen_2 Mat_Mul_With_Transposed_Matrix (@NotNull Matrizen_2 To_Multiply_Matrix_Untransposed)
    {
        int i, j, k;
        double Ergebnis = 0;
        Matrizen_2 Zwischen_Matrix = new Matrizen_2(To_Multiply_Matrix_Untransposed.getRows(), To_Multiply_Matrix_Untransposed.getLines());
        Matrizen_2 Neue_Matrix = new Matrizen_2(Matrix.length, Matrix[0].length);



        if (Matrix[0].length == To_Multiply_Matrix_Untransposed.getRows())
        {
            for (i = 0; i < To_Multiply_Matrix_Untransposed.getLines(); i++)
            {
                for (j = 0; j < To_Multiply_Matrix_Untransposed.getRows(); j++)
                {
                    Zwischen_Matrix.setElement(j, i, Matrix[i][j]);
                }
            }


            for (i = 0; i < Matrix.length; i++) {
                for (j = 0; j < Matrix[0].length; j++) {
                    for (k = 0; k < Matrix[0].length; k++) {
                        Ergebnis += Matrix[j][k] * Zwischen_Matrix.getElement(k, j);
                    }


                    Neue_Matrix.setElement(i, j, Ergebnis);

                    Ergebnis = 0;
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