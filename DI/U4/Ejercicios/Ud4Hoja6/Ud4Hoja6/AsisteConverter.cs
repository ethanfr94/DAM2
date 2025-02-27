using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Data;

namespace Ud4Hoja6
{
    public class AsisteConverter : IValueConverter
    {
        private const string ReservaAtendida = "Presente";
        private const string ReservaNoAtendida = "No";

        public object Convert(object value, Type targetType, object parameter, CultureInfo culture)
        {
            switch ((bool)value)
            {
                case true:
                    return ReservaAtendida;
                case false:
                    return ReservaNoAtendida;
                default:
                    return ReservaNoAtendida;
            }
        }

        public object ConvertBack(object value, Type targetType, object parameter, CultureInfo culture)
        {
            if (value is string)
            {
                if (((string)value).Equals(ReservaAtendida))
                {
                    return true;
                }
                return false;
            }
            return false;
        }
    }
}
