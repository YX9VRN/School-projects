using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace OwnRestaurant.Model
{
    public class Item : ObservableObjectBase
    {
        private string name;
        public string Name
        {
            get => name;
            set => SetAndNotifyIfChanged(ref name, value);
        }

        private int price = 0;
        public int Price
        {
            get => price;
            set => SetAndNotifyIfChanged(ref price, value);
        }

        private int tableId;
        public int TableId
        {
            get => tableId;
            set => SetAndNotifyIfChanged(ref tableId, value);
        }

        private bool ready = false;
        public bool Ready
        {
            get => ready;
            set => SetAndNotifyIfChanged(ref ready, value);
        }
    }
}