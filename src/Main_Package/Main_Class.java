package Main_Package;


import Vectors_and_Matrices.Matrizen;
import Vectors_and_Matrices.Vector;

public class Main_Class
{
    public static void main(String[] args)
    {
        int i, j;
        Double Array[]        = {1.0, 2.0};
        Double Array_2[]      = {3.0, 4.0};
        Double Skalar_Produkt = 0.0;
        Vector Neuer_Vektor   = new Vector(Array);
        Vector Skalar_Vektor  = new Vector(Array_2);
        Matrizen  New_Matrix  = new Matrizen(5, 5);




        Skalar_Produkt = Neuer_Vektor.Dot_Product(Skalar_Vektor);


        System.out.println(Skalar_Produkt);



        New_Matrix.Fill_Matrix();

        New_Matrix.Print_Matrix();


        System.out.println(New_Matrix.Is_Quadratic());
    }
}
