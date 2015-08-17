using System.Windows.Input;
using log4net;

namespace MvvmDemo.ViewModel {
    public class IntervalViewModel : ViewModel {
        private static readonly ILog log = LogManager.GetLogger(typeof (IntervalViewModel));

        private int interval;
        private DelegateCommand increaseThousandsCommand;
        private DelegateCommand increaseHundredsCommand;
        private DelegateCommand increaseTensCommand;
        private DelegateCommand decreaseThousandsCommand;
        private DelegateCommand decreaseHundredsCommand;
        private DelegateCommand decreaseTensCommand;

        public IntervalViewModel() {
            DialName = "S1";
            CreateCommands();
        }

        public ICommand IncreaseThousandsCommand {
            get { return increaseThousandsCommand; }
        }

        public ICommand IncreaseHundredsCommand {
            get { return increaseHundredsCommand; }
        }

        public ICommand IncreaseTensCommand {
            get { return increaseTensCommand; }
        }

        public ICommand DecreaseThousandsCommand {
            get { return decreaseThousandsCommand; }
        }

        public ICommand DecreaseHundredsCommand {
            get { return decreaseHundredsCommand; }
        }

        public ICommand DecreaseTensCommand {
            get { return decreaseTensCommand; }
        }

        public string DialName { get; private set; }

        public int Thousands {
            get { return Interval/1000; }
        }

        public int Hundreds {
            get { return (Interval%1000)/100; }
        }

        public int Tens {
            get { return (Interval%100)/10; }
        }

        public int Interval {
            get { return interval; }
            set {
                interval = value;
                RaisePropertyChangedEvent("Thousands");
                RaisePropertyChangedEvent("Hundreds");
                RaisePropertyChangedEvent("Tens");
                RaisePropertyChangedEvent("Interval");
                log.DebugFormat("Interval changed in view model to {0}", interval);
            }
        }

        private void ChangeInterval(int delta) {
            var proposedInterval = Interval + delta;
            if ((proposedInterval >= 0) && (proposedInterval <= 9999)) {
                Interval = proposedInterval;
            }
        }

        private void CreateCommands() {
            increaseThousandsCommand = new DelegateCommand(param => ChangeInterval(1000));
            increaseHundredsCommand = new DelegateCommand(param => ChangeInterval(100));
            increaseTensCommand = new DelegateCommand(param => ChangeInterval(10));

            decreaseThousandsCommand = new DelegateCommand(param => ChangeInterval(-1000));
            decreaseHundredsCommand = new DelegateCommand(param => ChangeInterval(-100));
            decreaseTensCommand = new DelegateCommand(param => ChangeInterval(-10));
        }
    }
}