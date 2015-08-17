using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Xml.Linq;

namespace RealWorldAsyncAndAwait {
    public partial class MyForm : Form {
        public MyForm() {
            InitializeComponent();
        }

        private void btLoadStories_Click(object sender, EventArgs e) {
            FetchAndPrintStoryTitles();
            PrintTime("End of event handler");
        }

        private async void FetchAndPrintStoryTitles() {
            var storyTitles = await GetAndParseRssFromBBC();
            foreach (var title in storyTitles) {
                //NB Race condition here ignored for purposes of demo
                lbDisplayStories.Items.Add(title);
            }
            PrintTime("Story titles added");
        }

        private async Task<IEnumerable<XText>> GetAndParseRssFromBBC() {
            var client = new HttpClient();
            var response = await client.GetAsync("http://feeds.bbci.co.uk/news/rss.xml");
            PrintTime("Received Response");
            var responseBody = await response.Content.ReadAsStringAsync();
            PrintTime("Read Response Body");
            var xml = XDocument.Parse(responseBody);
            return xml.Root.Elements("channel").Elements("item").Elements("title").DescendantNodes().OfType<XText>();
        }

        private void PrintTime(string msg) {
            string time = DateTime.Now.ToLongTimeString();
            var fullMsg = string.Format("{0} at {1}", msg, time);
            lbDebugInfo.Items.Add(fullMsg);
        }
    }
}