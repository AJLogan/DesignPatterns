using System.Windows;
using System.Windows.Input;

namespace MvvmDemo.View
{
    public partial class IncreaseRepeatButton
    {
        public static readonly DependencyProperty IncreaseCommandProperty =
            DependencyProperty.Register("IncreaseCommand", typeof(ICommand), typeof(IncreaseRepeatButton));

        public IncreaseRepeatButton()
        {
            InitializeComponent();
        }

        public ICommand IncreaseCommand
        {
            get { return (ICommand)GetValue(IncreaseCommandProperty); }
            set { SetValue(IncreaseCommandProperty, value); }
        }
    }
}
