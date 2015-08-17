using System.Windows;
using System.Windows.Input;

namespace MvvmDemo.View
{
    public partial class DecreaseRepeatButton
    {
        public static readonly DependencyProperty DecreaseCommandProperty =
            DependencyProperty.Register("DecreaseCommand", typeof(ICommand), typeof(DecreaseRepeatButton));

        public DecreaseRepeatButton()
        {
            InitializeComponent();
        }

        public ICommand DecreaseCommand
        {
            get { return (ICommand)GetValue(DecreaseCommandProperty); }
            set { SetValue(DecreaseCommandProperty, value); }
        }

    }
}
