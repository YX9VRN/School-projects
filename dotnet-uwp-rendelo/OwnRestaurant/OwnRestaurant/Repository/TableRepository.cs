using OwnRestaurant.Model;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Serialization;
using OwnRestaurant.Model;

namespace OwnRestaurant.Repository
{
    public class TableRepository
    {
        private static readonly string path = Path.Combine(Windows.Storage.ApplicationData.Current.LocalFolder.Path, "tables.xml");
        private static readonly object _syncLock = new object();
        public static TableList LoadTablesFromFile()
        {
            lock (_syncLock)
            {
                if (File.Exists(path))
                {
                    try
                    {
                        var serializer = new XmlSerializer(typeof(TableList));
                        using (var fs = File.OpenRead(path))
                            return (TableList)serializer.Deserialize(fs);
                    }
                    catch
                    {
                    }
                }
                return new TableList()
                {
                    new Table()
                    {
                        Id = 1,
                        Seats = 0,
                        Order = new List<Item>()
                        {
                            new Item()
                            {
                                Name = "bab",
                                Price = 5,
                                TableId = 1
                            }
                        }
                    },
                    new Table()
                    {
                        Id = 2,
                        Seats = 0,
                        Order = new List<Item>()
                        {
                            new Item()
                            {
                                Name = "rizs",
                                Price = 10,
                                TableId = 2
                            }
                        }
                    }
                };
            }
        }
        public static void SaveTablesToFile(TableList allTables)
        {
            lock (_syncLock)
            {
                var serializer = new XmlSerializer(typeof(TableList));
                using (var fs = File.Create(path))
                    serializer.Serialize(fs, allTables);
            }
        }
    }
}
