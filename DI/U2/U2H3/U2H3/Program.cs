
internal class Figuras
{
    protected double b {  get; set; }
    protected double h {  get; set; }

    public Figuras(double b, double h)
    {
        this.b = b;
        this.h = h;
    }
    

}

class rectangulo : Figuras
{
    public rectangulo(double b, double h) : base(b, h)
    {
    }

    public double Area()
    {
        return b * h;
    }
}

class triangulo : Figuras
{
    public triangulo(double b, double h) : base(b, h)
    {
    }

    public double Area()
    {
        return b * h / 2;
    }
}

class  Rombo 
{
    
}

class Cuadrado : Figuras
{
    public Cuadrado(double b, double h) : base(b, h)
    {
    }

    public double Area()
    {
        return b * h;
    }
}
