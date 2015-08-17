using System;
using System.Configuration;
using System.Threading;
using System.Windows;
using System.Windows.Threading;
using Microsoft.Practices.Prism;
using MvvmDemo.ViewModel;
using log4net;
using log4net.Config;

namespace MvvmDemo
{
    /// <summary>
    /// Interaction logic for App.xaml
    /// </summary>
    public partial class App
    {
        private static readonly ILog log = LogManager.GetLogger(typeof (App));
        static App()
        {
            XmlConfigurator.Configure();
        }

        // Custom main method to take control of 
        [STAThread]
        public static void Main()
        {
            App app = new App();
            app.InitializeComponent();
            app.Run();
        }

        protected override void OnStartup(StartupEventArgs e)
        {
            base.OnStartup(e);
            log.Debug("Bootstrapping Unity container");
            Bootstrapper bootstrapper = new Bootstrapper();
            bootstrapper.Run();
        }
    }
}
