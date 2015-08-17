using System.Windows;
using MvvmDemo.ViewModel;
using Microsoft.Practices.Prism.UnityExtensions;
using Microsoft.Practices.Unity;

namespace MvvmDemo
{
    public class Bootstrapper : UnityBootstrapper
    {
        protected override void ConfigureContainer()
        {
            base.ConfigureContainer();
            RegisterTypesWithContainer();
        }

        protected override DependencyObject CreateShell()
        {
            return Container.Resolve<MainWindow>();
        }

        protected override void InitializeShell()
        {
            base.InitializeShell();
            Application.Current.MainWindow = (Window)Shell;
            Application.Current.MainWindow.Show();
        }

        private void RegisterTypesWithContainer()
        {
            var singletonLifecycle = new ContainerControlledLifetimeManager();
            Container.RegisterType<IntervalViewModel>(singletonLifecycle);
        }

    }
}
