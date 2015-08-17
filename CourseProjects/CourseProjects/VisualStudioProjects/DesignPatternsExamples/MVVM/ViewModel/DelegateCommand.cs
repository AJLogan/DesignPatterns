using System;
using System.Windows.Input;

namespace MvvmDemo.ViewModel
{
    /// <summary>
    /// Command that delegates through to an action delegate.
    /// </summary>
    public class DelegateCommand : ICommand
    {
        private readonly Action<object> execute;
        private readonly Predicate<object> canExecute;
                
        /// <summary>
        /// Creates a new command that can always execute.  
        /// </summary>  
        /// <param name="execute">The execution logic.</param>
        public DelegateCommand(Action<object> execute)
        {
            this.execute = execute;
        }   
        
        /// <summary>
        /// Creates a new command. 
        /// </summary>
        /// <param name="execute">The execution logic.</param>
        /// <param name="canExecute">The execution status logic.</param>
        public DelegateCommand(Action<object> execute, Predicate<object> canExecute)
        {
            if (execute == null)
                throw new ArgumentNullException("execute");
        
            this.execute = execute;
            this.canExecute = canExecute;           
        }
            
        public event EventHandler CanExecuteChanged
        {
            add { CommandManager.RequerySuggested += value; }
            remove { CommandManager.RequerySuggested -= value; }
        }

        public virtual bool CanExecute(object parameter)
        {
            return (canExecute == null) || canExecute(parameter);
        }

        public void Execute(object parameter)
        {
            execute(parameter);
        }
    }
}
