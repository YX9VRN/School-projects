using OwnRestaurant.Model;
using OwnRestaurant.Repository;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace OwnRestaurant.Logic
{
    class ItemService
    {
        private ItemList allItem;
        public ItemService()
        {
            allItem = ItemRepository.LoadOrdersFromFile();
        }
        public ItemList FilterItem(int id)
        {
             var list = new ItemList();
            foreach (var item in allItem)
            {
               if (item.TableId == id)
              {
                 list.Add(item);
            }
            }
            return list;
        }
        public void Add(Item item)
        {
            allItem.Add(item);
            ItemRepository.SaveItemsToFile(allItem);
        }
        public void Remove(Item item)
        {
            allItem.Remove(item);
            ItemRepository.SaveItemsToFile(allItem);
        }
        public void Save()
        {
            ItemRepository.SaveItemsToFile(allItem);
        }
        public IEnumerable<Item> ListAll()
        {
            return allItem;
        }
    }
}
