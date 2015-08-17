using System;
using System.Collections.Generic;
using System.Text;
using System.Windows.Forms;
using System.Drawing;

namespace UsingAnonymousDelegates {
    class BasicForm : Form {
        public BasicForm(string title) {
            base.Text = title;
            Size = new Size(100, 150);

            b1 = buildButton("One", new Point(10, 10));
            b2 = buildButton("Two", new Point(10, 40));
            b3 = buildButton("Three", new Point(10, 70));
            b4 = buildButton("Four", new Point(10, 100));

            EventHandler handler = delegate(object obj, EventArgs e) {
                                       Button source = (Button) obj;
                                       MessageBox.Show(String.Format("Button {0} pushed", source.Text));
                                   };
            b1.Click += handler;
            b2.Click += handler;
            b3.Click += handler;
            b4.Click += delegate {
                            MessageBox.Show("Some button pushed");
                        };
        }
        private Button buildButton(string name, Point p) {
            Button b = new Button();
            b.Text = name;
            b.Size = new Size(80, 20);
            b.Location = p;
            Controls.Add(b);
            return b;
        }
        private Button b1;
        private Button b2;
        private Button b3;
        private Button b4;
    }
}