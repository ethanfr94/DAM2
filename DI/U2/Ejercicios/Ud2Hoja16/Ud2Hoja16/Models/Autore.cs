using System;
using System.Collections.Generic;

namespace Ud2Hoja16.Models;

public partial class Autore
{
    public int Id { get; set; }

    public string Nombre { get; set; } = null!;

    public string Apellidos { get; set; } = null!;

    public string? Nacionalidad { get; set; }

    public virtual ICollection<Libro> Libros { get; set; } = new List<Libro>();
}
