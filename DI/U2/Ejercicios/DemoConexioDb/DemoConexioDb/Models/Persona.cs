using System;
using System.Collections.Generic;

namespace DemoConexioDb.Models;

public partial class Persona
{
    public long PersonaId { get; set; }

    public string Nombre { get; set; } = null!;

    public virtual ICollection<Gasto> Gastos { get; set; } = new List<Gasto>();
}
