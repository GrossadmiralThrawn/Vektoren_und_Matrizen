package Main_Package;


import Vectors_and_Matrices.Matrizen;
import Vectors_and_Matrices.Vector;

public class Main_Class
{
    public static void main(String[] args)
    {
        int i, j;
        Double   Array[]        = {1.0, 2.0};
        Double   Array_2[]      = {3.0, 4.0};
        Double   Skalar_Produkt = 0.0;
        Vector   Neuer_Vektor   = new Vector(Array);
        Vector   Skalar_Vektor  = new Vector(Array_2);
        Matrizen New_Matrix     = new Matrizen(60, 40);
        Matrizen New_Matrix_2   = new Matrizen(60, 40);
        Matrizen New_Matrix_3   = new Matrizen(60, 40);
        Matrizen Matrix_Produkt = new Matrizen(40, 60);




        New_Matrix.Fill_Matrix();


        New_Matrix_2.Fill_Matrix();


        New_Matrix_3.Fill_Matrix();



        long Beginn = System.currentTimeMillis();

        Matrix_Produkt = New_Matrix.Mat_Mul(New_Matrix_2);

        long Ende   = System.currentTimeMillis();


        long Dauer = Ende - Beginn;


        System.out.println(Dauer);



        /*Beginn = System.currentTimeMillis();

        Matrix_Produkt = New_Matrix.Mat_Mul_With_Transposed_Matrix(New_Matrix_3);

        Ende   = System.currentTimeMillis();


        Dauer = Ende - Beginn;


        System.out.println(Dauer);*/

    }
}
