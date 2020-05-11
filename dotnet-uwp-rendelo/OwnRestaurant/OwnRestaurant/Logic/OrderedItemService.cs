using OwnRestaurant.Model;
using OwnRestaurant.Repository;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace OwnRestaurant.Logic
{
    class OrderedItemService
    {
        private ItemList allItem;
        public OrderedItemService()
        {
            allItem = OrderedItemsRepository.LoadOrdersFromFile();
        }
        public int Count()
        {
            return allItem.Count;
        }
        public Item GetItem(int i)
        {
            var item = new Item()
            {
                Name = allItem[i].Name,
                Ready = allItem[i].Ready,
                TableId = allItem[i].TableId
            };
            return item;
        }

        public void SetReady(int i)
        {
            allItem[i].Ready = true;
            OrderedItemsRepository.SaveItemsToFile(allItem);
        }
        public ItemList FilterItem(int id)
        {
            var list = new ItemList();
            foreach (var item in allItem.Where(item => item.TableId == id).Select(item => item))
            {
                list.Add(item);
            }
            return list; 
        }
        public void Add(Item item)
        {
            allItem.Add(item);
            OrderedItemsRepository.SaveItemsToFile(allItem);
        }
        public void Remove(Item item)
        {
            allItem.Remove(item);
            OrderedItemsRepository.SaveItemsToFile(allItem);
        }
        public void Save()
        {
            OrderedItemsRepository.SaveItemsToFile(allItem);
        }
        public IEnumerable<Item> ListAll()
        {
            return allItem;
        }
        public void RemoveAll(int tableID, ItemList list)
        {
            foreach (var item in list)
            {
                allItem.Remove(allItem.Where(i => i.TableId == tableID).FirstOrDefault());
            }
            OrderedItemsRepository.SaveItemsToFile(allItem);
        }
    }
}
