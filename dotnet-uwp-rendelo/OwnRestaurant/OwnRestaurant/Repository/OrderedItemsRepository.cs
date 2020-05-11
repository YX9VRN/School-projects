using OwnRestaurant.Model;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Serialization;

namespace OwnRestaurant.Repository
{
    class OrderedItemsRepository
    {
        private static readonly string path = Path.Combine(Windows.Storage.ApplicationData.Current.LocalFolder.Path, "OrderedItems.xml");
        private static readonly object _syncLock = new object();

        public static ItemList LoadOrdersFromFile()
        {
            lock (_syncLock)
            {
                if (File.Exists(path))
                {
                    try
                    {
                        var serializer = new XmlSerializer(typeof(ItemList));
                        using (var fs = File.OpenRead(path))
                            return (ItemList)serializer.Deserialize(fs);
                    }
                    catch
                    {
                    }
                }
                return new ItemList()
                {
                    new Item()
                    {
                        Name = "Alma",
                        Price = 200,
                        TableId = 1,
                        Ready = false
                    },
                    new Item()
                    {
                        Name = "Aranyalma",
                        Price = 2000,
                        TableId = 1,
                        Ready = false
                    }
                };
            }
        }
        public static void SaveItemsToFile(ItemList allItem)
        {
            lock (_syncLock)
            {
                var serializer = new XmlSerializer(typeof(ItemList));
                using (var fs = File.Create(path))
                    serializer.Serialize(fs, allItem);
            }
        }
    }
}
