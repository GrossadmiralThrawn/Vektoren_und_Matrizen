package Vectors_and_Matrices




class Vector(private var Vektor_Array: Array<Double>)
{
    fun Add_Element(To_Add_Element: Double)
    {
        Vektor_Array.plus(To_Add_Element)
    }




    fun getElement(Position: Int): Double
    {
        return Vektor_Array[Position]
    }




    fun getSize(): Int
    {
        return Vektor_Array.size
    }




    fun Dot_Product(Second_Vector: Vector): Double
    {
        var i:              Int    = 0
        var Skalar_Produkt: Double = 0.0
        var Position:       Int    = 0



        if (Vektor_Array.size == Second_Vector.getSize())
        {
            for (i in Vektor_Array)
            {
                Skalar_Produkt += (i * Second_Vector.getElement(Position))


                Position++
            }
            return Skalar_Produkt
        }
        else
        {
            return 1.0
        }
    }
}