using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace OwnRestaurant.Model
{
    public class Table : ObservableObjectBase
    {
        private int seats = 0;
        public int Seats
        {
            get => seats;
            set => SetAndNotifyIfChanged(ref seats, value);
        }
        private int id = 0;
        public int Id
        {
            get =>  id;
            set => SetAndNotifyIfChanged(ref id, value);
        }
        
        private List<Item> order;
        public List<Item> Order
        {
            get => order;
            set => SetAndNotifyIfChanged(ref order, value);
        }
        private int total = 0;
        public int Total
        {
            get => total;
            set => SetAndNotifyIfChanged(ref total, value);
        }
        private int totalseat = 0;
        public int TotalSeat
        {
            get => totalseat;
            set => SetAndNotifyIfChanged(ref totalseat, value);
        }
    }
}
