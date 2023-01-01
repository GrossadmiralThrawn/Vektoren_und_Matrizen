package Main_Package;


import Vectors_and_Matrices.Matrizen;
import Vectors_and_Matrices.Matrizen_2;
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
        Matrizen_2 New_Matrix     = new Matrizen_2(2, 2);
        Matrizen_2 New_Matrix_2   = new Matrizen_2(2, 2);
        Matrizen_2 New_Matrix_3   = new Matrizen_2(500, 1000);
        Matrizen_2 Matrix_Produkt = new Matrizen_2(60, 40);



        New_Matrix.setElement(0, 0, 1.0);
        New_Matrix.setElement(0, 1, 2.0);
        New_Matrix.setElement(1, 0, 3.0);
        New_Matrix.setElement(1, 1, 4.0);



        New_Matrix_2.setElement(0, 0, 4.0);
        New_Matrix_2.setElement(0, 1, 3.0);
        New_Matrix_2.setElement(1, 0, 2.0);
        New_Matrix_2.setElement(1, 1, 1.0);



        //New_Matrix_3.Fill_Matrix();



        long Beginn = System.currentTimeMillis();

        Matrix_Produkt = New_Matrix.Mat_Mul(New_Matrix_2);

        long Ende   = System.currentTimeMillis();



        long Dauer = Ende - Beginn;


        System.out.println(Dauer);


        Matrix_Produkt.Print_Matrix();



        /*Beginn = System.currentTimeMillis();

        Matrix_Produkt = New_Matrix.Mat_Mul_With_Transposed_Matrix(New_Matrix_3);

        Ende   = System.currentTimeMillis();


        Dauer = Ende - Beginn;


        System.out.println(Dauer);*/

    }
}
