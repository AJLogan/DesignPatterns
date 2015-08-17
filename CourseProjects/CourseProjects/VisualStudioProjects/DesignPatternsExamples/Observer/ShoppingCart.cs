using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Observer {
    public class ShoppingCart {
        public ShoppingCart() {
            observers = new List<IObserver>();
        }

        public void AddItem(string item) {
            NotifyObservers(item);
        }

        public void AddObserver(IObserver observer) {
            observers.Add(observer);
        }

        private void NotifyObservers(string item) {
            observers.ForEach((o) => o.Notify(item));
        }

        private readonly List<IObserver> observers;
    }
}