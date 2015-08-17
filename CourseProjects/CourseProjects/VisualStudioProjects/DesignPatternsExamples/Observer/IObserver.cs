using System;

namespace Observer {
    public interface IObserver {
        void Notify(string item);
    }

    public class ObserverA : IObserver {
        public void Notify(string item) {
            Console.WriteLine("Observer A notified of {0}", item);
        }
    }

    public class ObserverB : IObserver {
        public void Notify(string item) {
            Console.WriteLine("Observer B notified of {0}", item);
        }
    }

    public class ObserverC : IObserver {
        public void Notify(string item) {
            Console.WriteLine("Observer C notified of {0}", item);
        }
    }
}