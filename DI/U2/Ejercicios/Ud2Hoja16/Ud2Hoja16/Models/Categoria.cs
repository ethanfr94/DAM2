using System;
using System.Collections.Generic;

namespace Ud2Hoja16.Models;

public partial class Categoria
{
    public int Id { get; set; }

    public string Categoria1 { get; set; } = null!;

    public virtual ICollection<Libro> Libros { get; set; } = new List<Libro>();
}
