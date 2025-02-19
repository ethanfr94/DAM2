using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Microsoft.Reporting.WinForms;

namespace Ud3Hoja2
{
    public class Generador
    {
        public void CargarInformeFabricantes()

        {

            VisorInforme visor = new VisorInforme();

            visor.rpvVisorInforme.LocalReport.ReportEmbeddedResource = "Informes.Reports.rptFabricantes.rdlc";


            string consultaFabricantes =

            "select p.fabricante, min(p.Precio) as preciodesde, max(p.precio) as preciohasta, " +

            "count(*) as referencias from productos p " +

            "group by p.Fabricante order by preciodesde";


            NeumaticosEntities ctx = new NeumaticosEntities();

            List<FabricanteWr> listaFabricantes = ctx.Database.SqlQuery<FabricanteWr>(consultaFabricantes, new object[0]).ToList();


            ReportDataSource funteDatosInforme = new ReportDataSource("DataSetFabricantes", listaFabricantes);

            visor.rpvVisorInforme.LocalReport.DataSources.Add(funteDatosInforme);


            ReportParameter parametro = new ReportParameter("ParametroInformacion", "Esto es un mensaje de prueba");

            visor.rpvVisorInforme.LocalReport.SetParameters(parametro);


            visor.rpvVisorInforme.SetDisplayMode(DisplayMode.PrintLayout);

            visor.rpvVisorInforme.RefreshReport();


            //visor.rpvVisorInforme.LocalReport.SubreportProcessing += LocalReport_SubreportProcessing;


            //si quisieramos generar documentos sin el visor deberemos trabajar con el metodo render

            //que devuelve el array de bits

            //visor.rpvVisorInforme.LocalReport.Render(multiples opciones de configuracion);

            visor.Show();

        }


        /*

        private void LocalReport_SubreportProcessing(object sender, SubreportProcessingEventArgs e)

        {

        //Podemos conocer el subreport a traves de la propiedad ReportPath, ojo que es el nombre del

        //report cuando se incrusta en el contenedor

        //e.ReportPath


        //debemos asignar los datasource de los subreports

        //e.DataSources.Add(new ReportDataSource("nombre", datos));

        //los parametros hay que asignarselos al report padre y al insertar el subreport en la pestaña parametros

        //hacer una asignacion manual entre los parametros del contenedor y los del hijo

        throw new NotImplementedException();

        }

        */
    }
}
