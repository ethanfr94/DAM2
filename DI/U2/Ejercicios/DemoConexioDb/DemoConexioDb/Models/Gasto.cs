using System;
using System.Collections.Generic;

namespace DemoConexioDb.Models;

public partial class Gasto
{
    public long GastoId { get; set; }

    public decimal Importe { get; set; }

    public DateOnly? Fecha { get; set; }

    public long PersonaId { get; set; }

    public virtual Persona Persona { get; set; } = null!;
}
