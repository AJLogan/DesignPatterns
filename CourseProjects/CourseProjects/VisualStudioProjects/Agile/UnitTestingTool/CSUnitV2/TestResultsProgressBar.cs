using System;
using System.Windows.Forms;
using System.Drawing;


namespace CSUnitV2
{
	public class TestResultsProgressBar : Control {
		public TestResultsProgressBar(){
			okSoFar = true;
		}
		public int NoOfTests {
			get { return max; }
			set { max = value; }
		}
		public void reset() {
			max = progress = 0;
			okSoFar = true;
			Refresh();
		}
		public void testCompleted(bool passed) {
			if(!passed) {
				okSoFar = false;
			}
			progress++;
			Refresh();
		}
		protected override void OnPaint(PaintEventArgs e) {
			base.OnPaint(e);
			Graphics g = e.Graphics;
			Color barColor;
			if(okSoFar) {
				barColor = Color.Green;
			} else {
				barColor = Color.Red;
			}
			g.DrawRectangle(Pens.Black,this.ClientRectangle);
			if(progress > 0) {
				int width = calculateBarWidth();
				g.FillRectangle(new SolidBrush(barColor),0,0,width,ClientRectangle.Height);
			}
		}
		private int calculateBarWidth() {
			int totalWidth = ClientRectangle.Width;
			if(progress == max) {
				return totalWidth;
			} else {
				int increment = totalWidth / max;
				return increment * progress;
			}
		}
		private int max;
		private int progress;
		private bool okSoFar;

	}
}
