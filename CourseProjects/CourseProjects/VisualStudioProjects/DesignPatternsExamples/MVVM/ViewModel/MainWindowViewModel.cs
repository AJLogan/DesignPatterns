using Microsoft.Practices.Unity;

namespace MvvmDemo.ViewModel {
    public sealed class MainWindowViewModel : ViewModel {
        /// <summary>
        /// Constructs a main view model using the supplied view model repository.
        /// Provided purely for unit testing.
        /// </summary>
        public MainWindowViewModel(IUnityContainer container) {
            Initialize(container);
        }

        public IntervalViewModel Interval { get; private set; }

        /*
         *  PRIVATE METHODS 
         */

        private void Initialize(IUnityContainer container) {
            Interval = container.Resolve<IntervalViewModel>();
        }
    }
}