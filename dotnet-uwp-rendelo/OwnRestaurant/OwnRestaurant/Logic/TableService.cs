using OwnRestaurant.Model;
using OwnRestaurant.Repository;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace OwnRestaurant.Logic
{
    public class TableService
    {
        private TableList allTables;
        public TableService()
        {
            allTables = TableRepository.LoadTablesFromFile();
        }
        public TableList AllTables
        {
            get => allTables;
        }
        public int GetNewTableNumber()
        {
            for (int i = 1; i <= allTables.Count(); i++)
            {
                bool found = false;
                foreach (var table in allTables)
                {
                    if (table.Id == i) found = true;
                }
                if (!found) return i;
            }
            return allTables.Count() + 1;
        }
        public void AddTable(Table table)
        {
            allTables.Add(table);
            TableRepository.SaveTablesToFile(allTables);
        }

        public void RemoveTable(Table table)
        {
            allTables.Remove(table);
            TableRepository.SaveTablesToFile(allTables);
        }
        public Table Find(int tableId)
        {
            foreach (var t in allTables)
            {
                if (t.Id == tableId)
                {
                    return t;
                }
            }
            return null;
        }
        public void ChangeSeats(int seats, int tableId)
        {
            foreach (var t in allTables)
            {
                if (t.Id == tableId)
                {
                    t.Seats = seats;
                }
            }
        }
        public IEnumerable<Table> ListAll()
        {
            return allTables;
        }

        public int getSelectedItem(int SelectedTableId)
        {
            for (int i = 0; i < allTables.Count(); i++)
            {
                if (allTables[i].Id == SelectedTableId)
                {
                    return i + 1;
                }
            }
            return -1;
        }
        public int Count()
        {
            return allTables.Count();
        }
    }
}