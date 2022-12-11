package Vectors_and_Matrices;




import org.jetbrains.annotations.NotNull;
import java.util.Scanner;




public class Matrizen
{
    private Double[][] Matrix;




    public Matrizen(@NotNull int Height, @NotNull int Width)
    {
        Matrix = new Double[Height][Width];
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

                Matrix[i][j] = 291.239;


                System.out.println("\n");
            }
        }
    }




    public Double getElement(@NotNull int Height, @NotNull int Width)
    {
        return Matrix[Height][Width];
    }




    public int getHeight()
    {
        return Matrix.length;
    }




    public int getLength()
    {
        return Matrix[0].length;
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




    public Matrizen Mat_Mul (@NotNull Matrizen Second_Matrix)
    {
        int i, j, k, l;
        double Ergebnis = 0;
        Matrizen Neue_Matrix = new Matrizen(Matrix.length, Matrix[0].length);


        if (Matrix[0].length == Second_Matrix.getHeight())
        {
            for (i = 0; i < Matrix[0].length; i++)
            {
                for (j = 0; j < Matrix.length; j++)
                {
                    for (k = 0; k < Matrix.length; k++)
                    {
                        for (l = 0; l < Matrix[0].length; l++)
                        {
                            Ergebnis += Matrix[k][l] * Second_Matrix.getElement(l, k);
                        }
                    }



                    Neue_Matrix.setMatrixElement(i, j, Ergebnis);



                    Ergebnis = 0.0;
                }
            }


            return Neue_Matrix;
        }
        else
        {
            System.out.println("Leider ist die Anzahl der Zeilen verschieden von der Anzahl von Spalten.");
            return null;
        }
    }




    public void setMatrixElement (@NotNull int Height, @NotNull int Width, Double Element)
    {
        Matrix[Height][Width] = Element;
    }




    public Matrizen Transpose_Matrix ()
    {
        int i, j;
        double Result = 0;
        Matrizen Transponated_Matrix = new Matrizen(Matrix[0].length, Matrix.length);



        for (i = 0; i < Matrix.length; i++)
        {
            for (j = 0; j < Matrix[0].length; j++)
            {
                Transponated_Matrix.setMatrixElement(j, i, Matrix[i][j]);
            }
        }



        return Transponated_Matrix;
    }




    public Matrizen Mat_Mul_With_Transposed_Matrix (@NotNull Matrizen Second_Matrix_Untransposed)
    {
        int i, j, k, l;
        double Ergebnis = 0;
        Matrizen Transposed_Matrix = new Matrizen(Second_Matrix_Untransposed.getLength(), Second_Matrix_Untransposed.getHeight());
        Matrizen Neue_Matrix = new Matrizen(Matrix.length, Matrix[0].length);




        for (i = 0; i < Matrix.length; i++)
        {
            for (j = 0; j < Matrix[0].length; j++)
            {
                Transposed_Matrix.setMatrixElement(j, i, Matrix[i][j]);
            }
        }


        if (Matrix[0].length == Transposed_Matrix.getHeight())
        {
            for (i = 0; i < Matrix[0].length; i++)
            {
                for (j = 0; j < Matrix.length; j++)
                {
                    for (k = 0; k < Matrix.length; k++)
                    {
                        for (l = 0; l < Matrix[0].length; l++)
                        {
                            Ergebnis += Matrix[k][l] * Second_Matrix_Untransposed.getElement(l, k);
                        }
                    }



                    Neue_Matrix.setMatrixElement(i, j, Ergebnis);



                    Ergebnis = 0.0;
                }
            }


            
            return Transposed_Matrix;
        }
        else
        {
            System.out.println("Leider ist die Anzahl der Zeilen verschieden von der Anzahl von Spalten.");



            return null;
        }
    }
}
