using System;
using System.Collections.Generic;
using System.Text;
using System.Windows.Forms;

namespace UsingAnonymousDelegates {
    class Program {
        static void Main(string[] args) {
            Form f = new BasicForm("GUI");
            Application.Run(f);
        }
    }
}