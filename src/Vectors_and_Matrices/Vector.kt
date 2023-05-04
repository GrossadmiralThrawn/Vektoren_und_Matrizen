package Vectors_and_Matrices




class Vector(private var vektor_Array: Array<Double>)
{
    fun Add_Element(To_Add_Element: Double)
    {
        vektor_Array.plus(To_Add_Element)
    }




    fun getElement(Position: Int): Double
    {
        return vektor_Array[Position]
    }




    fun getSize(): Int
    {
        return vektor_Array.size
    }


    /**
     * Function calculates the dot product of a vector.
     *
     * @param:  Element of type vector
     * @return: Dot product
     */
    fun Dot_Product(second_Vector: Vector): Double
    {
        var i:              Int    = 0
        var skalar_Produkt: Double = 0.0
        var position:       Int    = 0



        if (vektor_Array.size == second_Vector.getSize())
        {
            for (i in vektor_Array)
            {
                skalar_Produkt += (i * second_Vector.getElement(position))


                position++
            }


            return skalar_Produkt
        }
        else
        {
            return 1.0
        }
    }
}