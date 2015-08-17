using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;

using System.Reactive;
using System.Reactive.Linq;
using System.Reactive.Concurrency;

namespace LinqReactiveExtensions {
    class Program {
        static void Main(string[] args) {
            showRxWithList();
            showRxWithGuiEvents();          
        }
        private static void showRxWithList() {
            IEnumerable<string> inputData = new List<string> { "ab", "cd", "ef", "gh", "ij", "kl", "mn" };
            IObservable<string> observable = inputData.ToObservable();

            observable.Subscribe((item) => Console.WriteLine(item));
        }
        private static void showRxWithGuiEvents() {
            MyForm form = new MyForm();
            IObservable<EventPattern<EventArgs>> observable = Observable.FromEventPattern((h) => form.MyButton.Click += h, (h) => form.MyButton.Click -= h);
            observable.Subscribe((data) => Console.WriteLine("Button Clicked!"),
                                  (ex) => Console.WriteLine("Exception"),
                                  () => Console.WriteLine("All Done"));

            System.Windows.Forms.Application.Run(form);
        }
    }
}
