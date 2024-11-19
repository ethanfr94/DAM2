using System;
using System.Collections.Generic;

namespace Ud2Hoja16.Models;

public partial class Libro
{
    public int Id { get; set; }

    public string Titulo { get; set; } = null!;

    public DateOnly? Fecha { get; set; }

    public int AutorId { get; set; }

    public int CategoriaId { get; set; }

    public virtual Autore Autor { get; set; } = null!;

    public virtual Categoria Categoria { get; set; } = null!;
}
