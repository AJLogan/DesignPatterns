using Microsoft.Practices.Unity;
using MvvmDemo.ViewModel;
using log4net;

namespace MvvmDemo
{
    public partial class MainWindow
    {
        private static readonly ILog log = LogManager.GetLogger(typeof (MainWindow));

        public MainWindow(IUnityContainer container)
        {
            log.Debug("Initializing MainWindow...");
            InitializeComponent();
            DataContext = container.Resolve<MainWindowViewModel>();
        }
    }
}
