using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ud2Hoja13
{
    internal class ListViewItemComparer : IComparer
    {
        private int col;

        public int Col
        {
            get { return col; }
            set { col = value; }
        }

        public SortOrder Order
        {
            get { return order; }
            set { order = value; }
        }

        private SortOrder order;

        public ListViewItemComparer()
        {
            col = 0;
            order = SortOrder.None;
        }

        public ListViewItemComparer(int column, SortOrder order)
        {
            col = column;
            this.order = order;
        }

        public int Compare(object x, object y)
        {
            int returnVal = -1;
            returnVal = String.Compare(((ListViewItem)x).SubItems[col].Text, ((ListViewItem)y).SubItems[col].Text);
            if (order == SortOrder.Descending)
            {
                returnVal *= -1;
            }
            return returnVal;
        }
    }
}
