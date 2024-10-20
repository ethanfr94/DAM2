using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http.Headers;
using System.Text;
using System.Threading.Tasks;

namespace Ud2Hoja8
{
    internal class Calculadora
    {
        private float _cache;
        private float _visor { get; set; }
        private OperacionEnum operacion;
        private float memoria;

        public OperacionEnum Operacion
        {
            get { return operacion; }
            set
            {
                if (operacion == OperacionEnum.SinOperacion)
                {
                    _cache = _visor;
                }
                else
                {
                    Calcular();
                    _cache = _visor;
                }
                operacion = value;
            }
        }

        public void Calcular()
        {
            switch (operacion)
            {
                case OperacionEnum.Suma:
                    _visor = _cache + _visor;
                    break;
                case OperacionEnum.Resta:
                    _visor = _cache - _visor;
                    break;
                case OperacionEnum.Multiplicacion:
                    _visor = _cache * _visor;
                    break;
                case OperacionEnum.Division:
                    if (_visor != 0) 
                    {                     
                        _visor = _cache / _visor;
                    }
                    else
                    {
                        _visor = 0;
                    }
                    break;
                case OperacionEnum.SinOperacion:
                    return;
            }
            operacion = OperacionEnum.SinOperacion;
        }

        public void Borrar()
        {
            _cache = 0;
            _visor = 0;
            operacion = OperacionEnum.SinOperacion;
        }
    }
}
