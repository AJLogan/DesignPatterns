using System.ComponentModel;

namespace MvvmDemo.ViewModel {
    /// <summary>
    /// Base class of all view model classes
    /// </summary>
    public abstract class ViewModel : INotifyPropertyChanged {
        private bool isEnabled = true;

        public event PropertyChangedEventHandler PropertyChanged;

        public virtual bool IsEnabled {
            get { return isEnabled; }
            set {
                isEnabled = value;
                RaisePropertyChangedEvent("IsEnabled");
            }
        }

        protected void RaisePropertyChangedEvent(string name) {
            var handler = PropertyChanged;
            if (handler != null) {
                handler(this, new PropertyChangedEventArgs(name));
            }
        }
    }
}