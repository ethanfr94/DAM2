using DemoConexioDb.Models; //se deben de meter a mano
using Microsoft.EntityFrameworkCore; //se deben meter a mano

namespace DemoConexioDb
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btnCarga_Click(object sender, EventArgs e)
        {
            using (var context = new DemoContext())
            {
                var personas = context.Personas.Include(p => p.Gastos).ToList();
                listBox.Items.Clear();
                foreach (var person in personas)
                {
                    foreach (var gasto in person.Gastos)
                    {
                        string fecha = gasto.Fecha.HasValue ? gasto.Fecha.Value.ToShortDateString() : "Fecha no disponible";
                        listBox.Items.Add($"{person.Nombre} - Importe: {gasto.Importe} - Fecha: {fecha}");
                    }
                }

                if (!personas.Any())
                {
                    MessageBox.Show("No hay personas en la base de datos.");
                }
            }


        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            // Verificar si se ha introducido el nombre
            if (string.IsNullOrWhiteSpace(txtNombre.Text))
            {
                MessageBox.Show("Por favor, ingrese un nombre.");
                return;
            }

            // Verificar si se ha introducido un importe
            if (!decimal.TryParse(txtImporte.Text, out decimal importe))
            {
                MessageBox.Show("Por favor, ingrese un importe válido.");
                return;
            }

            // Verificar si la fecha seleccionada es válida
            if (dtpFecha.Value == DateTime.MinValue)
            {
                MessageBox.Show("Por favor, seleccione una fecha válida.");
                return;
            }

            // Crear nueva persona y gasto
            using (var context = new DemoContext())
            {
                var nuevaPersona = new Persona
                {
                    Nombre = txtNombre.Text
                };

                context.Personas.Add(nuevaPersona);
                context.SaveChanges();

                // Crear nuevo gasto
                var nuevoGasto = new Gasto
                {
                    Importe = importe,
                    Fecha = DateOnly.FromDateTime(dtpFecha.Value),  // Convertir DateTime a DateOnly
                    PersonaId = nuevaPersona.PersonaId
                };

                context.Gastos.Add(nuevoGasto);
                context.SaveChanges();
            }

            MessageBox.Show("Persona y gasto agregados correctamente.");
            btnCarga.PerformClick(); // Actualizar la lista de personas
        }

        private void btnActualizar_Click(object sender, EventArgs e)
        {
            if (listBox.SelectedItem == null)
            {
                MessageBox.Show("Por favor, seleccione una persona de la lista.");
                return;
            }

            if (string.IsNullOrWhiteSpace(txtNombre.Text))
            {
                MessageBox.Show("Por favor, ingrese un nombre.");
                return;
            }

            var seleccionado = listBox.SelectedItem.ToString();
            var id = int.Parse(seleccionado.Split('-')[0].Trim());

            using (var context = new DemoContext())
            {
                var persona = context.Personas.FirstOrDefault(p => p.PersonaId == id);
                if (persona != null)
                {
                    persona.Nombre = txtNombre.Text;
                    context.SaveChanges();
                }
            }

            MessageBox.Show("Persona actualizada correctamente.");
            btnCarga.PerformClick(); // Actualiza la lista
        }

        private void btnEliminar_Click(object sender, EventArgs e)
        {
            if (listBox.SelectedItem == null)
            {
                MessageBox.Show("Por favor, seleccione una persona de la lista.");
                return;
            }

            var seleccionado = listBox.SelectedItem.ToString();
            var id = int.Parse(seleccionado.Split('-')[0].Trim());

            using (var context = new DemoContext())
            {
                var persona = context.Personas.FirstOrDefault(p => p.PersonaId == id);
                if (persona != null)
                {
                    context.Personas.Remove(persona);
                    context.SaveChanges();
                }
            }

            MessageBox.Show("Persona eliminada correctamente.");
            btnCarga.PerformClick(); // Actualiza la lista
        }
    }
}
