using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Drawing;

namespace LinqReactiveExtensions {
    public class MyForm : Form {
        public MyForm() {
            Size = new Size(160,100);
            button = new Button();
            button.Text = "Push Me";
            button.Location = new Point(20,20);
            button.Size = new Size(100,30);
            Controls.Add(button);
        }
        public Button MyButton {
            get { return button; }
        }
        private Button button;
    }
}
