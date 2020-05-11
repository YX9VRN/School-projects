using OwnRestaurant.Logic;
using OwnRestaurant.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;

// The Blank Page item template is documented at https://go.microsoft.com/fwlink/?LinkId=402352&clcid=0x409

namespace OwnRestaurant
{
    /// <summary>
    /// An empty page that can be used on its own or navigated to within a Frame.
    /// </summary>
    public sealed partial class MainPage : Page
    {
        private TableService allTables;
        private ItemService allItems;
        private OrderedItemService allOrderedItems;
        private Table selectedTable = null;
        private Item selectedItem = null;
        private Item selectedDisplayedItem = null;
        private ItemList selectedTableDisplayedOrders { get; set; } = new ItemList();
        private ItemList displayedItems;

        public MainPage()
        {
            this.InitializeComponent();
        }

        private void tables_Loaded(object sender, RoutedEventArgs e)
        {
            this.allTables = new TableService();
            this.allItems = new ItemService();
            this.allOrderedItems = new OrderedItemService();
            this.displayedItems = new ItemList();

            foreach (var table in allTables.ListAll())
            {
                tables.MenuItems.Insert(tables.MenuItems.Count - 1, new NavigationViewItem() { Tag = table.Id, Content = table.Id });
            }
            foreach (var item in allItems.ListAll())
            {
                itemsListView.Items.Add(new ListViewItem() { Tag = item.Name, Content = item.Name + " : " + item.Price });
            }
            var items = allOrderedItems.ListAll().Where(item => item.Ready == false);
            foreach (var item in items)
            {
                displayedItems.Add(item);
            }
            foreach (var item in displayedItems)
            {
                orderListView.Items.Add(new ListViewItem() { Tag = item.Name, Content = item.Name + " [" + item.TableId + "]"});
            }
            tables.SelectedItem = tables.MenuItems[1];
            itemsListView.SelectedItem = itemsListView.Items[0];
        }

        private void tables_SelectionChanged(NavigationView sender, NavigationViewSelectionChangedEventArgs args)
        {
            var tableId = args.SelectedItemContainer.Tag as int?;
            if (!tableId.HasValue) return;
            selectedTable = allTables.Find((int)tableId);
            if (selectedTable is null)
            {
                return;
            }
            var seats = selectedTable.Seats;
            textSeats.Text = seats.ToString();

            selectedTableDisplayedOrders.Clear();
            foreach (var item in allOrderedItems.FilterItem(selectedTable.Id))
            {
                selectedTableDisplayedOrders.Add(item);
            }
            total.Text = getTotalInString();
            totalseat.Text = getTotalPerSeatInString();
        }

        private void btnAddTable_Click(object sender, RoutedEventArgs e)
        {
            var newTableNumber = allTables.GetNewTableNumber();
            if (newTableSeats.Text == "" || int.TryParse(newTableSeats.Text, out int numOfSeats) == false) return;

            var newTable = new Table()
            {
                Id = newTableNumber,
                Seats = numOfSeats
            };
            allTables.AddTable(newTable);
            tables.MenuItems.Insert(tables.MenuItems.Count - 1, new NavigationViewItem() { Tag = newTable.Id, Content = newTable.Id });
            tables.SelectedItem = tables.MenuItems[tables.MenuItems.Count - 2];

        }

        private void btnRemoveTable_Click(object sender, RoutedEventArgs e)
        {
            if (allTables.Count() == 0 || selectedTable is null) return;
            textSeats.Text = "";
            tables.MenuItems.RemoveAt(allTables.getSelectedItem(selectedTable.Id));
            allTables.RemoveTable(selectedTable);
            for (int i = 0; i < displayedItems.Count; i++)
            {
                if (displayedItems[i].TableId == selectedTable.Id)
                {
                    displayedItems.RemoveAt(i);
                    orderListView.Items.RemoveAt(i);
                    i--;
                }
            }
            allOrderedItems.RemoveAll(selectedTable.Id, selectedTableDisplayedOrders);
            selectedTableDisplayedOrders.Clear();
            total.Text = getTotalInString();
            totalseat.Text = getTotalPerSeatInString();
            selectedTable = null;
        }

        private void btnChange_Click(object sender, RoutedEventArgs e)
        {
            if (selectedTable is null) return;
            if (textSeats.Text == "" || int.TryParse(textSeats.Text, out int numOfSeats) == false)
            {
                textSeats.Text = selectedTable.Seats.ToString();
                return;
            }
            int seats = Convert.ToInt32(textSeats.Text);
            allTables.ChangeSeats(seats, selectedTable.Id);
            totalseat.Text = getTotalPerSeatInString();
        }

        private void btnAddNewItem_Click(object sender, RoutedEventArgs e)
        {
            if (newItemName.Text == "" || newItemPrice.Text == "" || int.TryParse(newItemPrice.Text, out int itemPrice) == false) return;
            var itemName = newItemName.Text;
            var newItem = new Item
            {
                Name = itemName,
                Price = itemPrice
            };
            allItems.Add(newItem);
            itemsListView.Items.Add(new ListViewItem() { Tag = newItem.Name, Content = newItem.Name + " : " + newItem.Price });
            newItemName.Text = "";
            newItemPrice.Text = "";
        }

        private void btnAddOrderToTable_Click(object sender, RoutedEventArgs e)
        {

            var newItem = new Item()
            {
                Name = selectedItem.Name,
                Price = selectedItem.Price,
                TableId = selectedTable.Id
            };

            allOrderedItems.Add(newItem);
            selectedTableDisplayedOrders.Add(newItem);
            selectedTable.Total += newItem.Price;
            displayedItems.Add(newItem);
            orderListView.Items.Add(new ListViewItem() { Tag = newItem.Name, Content = newItem.Name + " [" + newItem.TableId + "]" });
            total.Text = getTotalInString();
            totalseat.Text = getTotalPerSeatInString();
        }

        private void itemsListView_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            var listViewItem = itemsListView.SelectedItem as ListViewItem;
            var itemName = listViewItem.Tag;
            selectedItem = allItems.ListAll().Where(i => i.Name.Equals(itemName)).Single();
        }

        private string getTotalInString()
        {
            var tableTotal = 0;
            foreach (var item in selectedTableDisplayedOrders)
            {
                tableTotal += item.Price;
            }
            return tableTotal.ToString();
        }
        private string getTotalPerSeatInString()
        {
            if (selectedTable.Seats == 0) return "0";
            var tableTotal = 0;
            foreach (var item in selectedTableDisplayedOrders)
            {
                tableTotal += item.Price;
            }
            tableTotal /= selectedTable.Seats;
            return tableTotal.ToString();
        }
        private void btnFinish_Click(object sender, RoutedEventArgs e)
        {
            for (int i = 0; i < displayedItems.Count; i++)
            {
                if (displayedItems[i].TableId == selectedTable.Id)
                {
                    displayedItems.RemoveAt(i);
                    orderListView.Items.RemoveAt(i);
                    i--;
                }
            }
            allOrderedItems.RemoveAll(selectedTable.Id, selectedTableDisplayedOrders);
            selectedTableDisplayedOrders.Clear();
            total.Text = getTotalInString();
            totalseat.Text = getTotalPerSeatInString();
        }

        private void btnMarkItemAsReady_Click(object sender, RoutedEventArgs e)
        {
            if (selectedDisplayedItem is null || displayedItems.Count == 0) return;
            for (int i = 0; i < displayedItems.Count; i++)
            {
                if (displayedItems[i].Name == selectedDisplayedItem.Name && displayedItems[i].TableId == selectedDisplayedItem.TableId && !displayedItems[i].Ready)
                {
                    displayedItems.RemoveAt(i);
                    orderListView.Items.RemoveAt(i);
                    break;
                }
            }
            for (int i = 0; i < allOrderedItems.Count(); i++)
            {
                if (allOrderedItems.GetItem(i).Name == selectedDisplayedItem.Name && allOrderedItems.GetItem(i).TableId == selectedDisplayedItem.TableId && !allOrderedItems.GetItem(i).Ready)
                {
                    allOrderedItems.SetReady(i);
                    break;
                }
            }
            selectedDisplayedItem = null;
        }

        private void orderListView_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            if (orderListView.SelectedItem is null) return;
            var whatever = orderListView.SelectedItem as ListViewItem;
            var itemName = whatever.Content;
            foreach (var item in displayedItems)
            {
                if ((item.Name + " [" + item.TableId + "]").Equals(itemName))
                {
                    selectedDisplayedItem = item;
                    return;
                }
            } 
        }
        
    }
}