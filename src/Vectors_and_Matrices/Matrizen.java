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

                Matrix[i][j] = Matrix_Scanner.nextDouble();


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
        int i, j;
        Matrizen Neue_Matrix = new Matrizen(Matrix.length, Matrix[0].length);


        if (Matrix[0].length == Second_Matrix.getHeight())
        {
            for (i = 0; i < Matrix[0].length; i++)
            {
                for (j = 0; j < Matrix.length; j++)
                {
                    Neue_Matrix.setMatrixElement(i, j,  Matrix[i][j] * Second_Matrix.getElement(j, i));
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
        Matrizen Transposed_Matrix = new Matrizen(Second_Matrix_Untransposed.getLength(), Second_Matrix_Untransposed.getHeight());


        Transposed_Matrix = Second_Matrix_Untransposed.Transpose_Matrix()
    }
}
