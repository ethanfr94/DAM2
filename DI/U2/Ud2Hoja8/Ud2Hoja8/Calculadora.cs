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
        private float _visor;
        private OperacionEnum operacion;
        private float memoria;

        public float Visor
        {
            get { return _visor; }
            set { _visor = value; }
        }

        public float Cache
        {
            get { return _cache; }
            set { _cache = value; }
        }

        public float memoria1
        {
            get { return memoria; }
            set { memoria = value; }
        }

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
