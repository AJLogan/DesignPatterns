using System;
using System.Collections.Generic;
using System.Linq;
using System.Xml;
using System.Xml.Linq;
using System.Text;

namespace LinqToXmlQueryingDocs
{
   class Program {
        static void Main(string[] args) {
            XDocument doc = XDocument.Load(@"..\..\purchase_order.xml");
            demo1(doc);
            demo2(doc);
            demo3(doc);
            demo4(doc);
        }
        private static void demo4(XDocument doc) {
            var results = from txt in doc.Root.DescendantNodes().OfType<XText>()
                          where txt.Parent.Name != "description"
                          select txt;

            Console.WriteLine("----- Demo 4 -----");
            Console.WriteLine("\tContents of all text nodes, other than those in descriptions, are:");
            foreach (var txtNode in results)
            {
                Console.WriteLine("\t\t{0}", txtNode.Value);
            }
        }
        private static void demo3(XDocument doc) {
            var results = from txt in doc.Root.DescendantNodes().OfType<XText>()
                          select txt;

            Console.WriteLine("----- Demo 3 -----");
            Console.WriteLine("\tContents of all text nodes are:");
            foreach (var txtNode in results) {
                Console.WriteLine("\t\t{0}", txtNode.Value);
            }
        }
        private static void demo2(XDocument doc) {
            var result = (from e in doc.Root.Descendants("item")
                          where e.Element("description").Value == "Graphics Card"
                          select new {
                              precending = e.ElementsBeforeSelf(),
                              following = e.ElementsAfterSelf()
                          }).Single();

            Console.WriteLine("----- Demo 2 -----");
            Console.WriteLine("\tElements before selected item are:");
            foreach (var element in result.precending) {
                printItemElement(element);
            }
            Console.WriteLine("\tElements after selected item are:");
            foreach (var element in result.following) {
                printItemElement(element);
            }
        }
        private static void printItemElement(XElement element) {
            Console.WriteLine("\t\t{0} of item {1} with description {2}",
                              element.Attribute("quantity").Value,
                              element.Attribute("id").Value,
                              element.Element("description").Value);
        }
        private static void demo1(XDocument doc) {
            var results = from e in doc.Root.Element("itemsList").Elements("item")
                          select new {
                              quantity = e.Attribute("quantity").Value,
                              id = e.Attribute("id").Value,
                              description = e.Element("description").Value
                          };
            Console.WriteLine("----- Demo 1 -----");
            Console.WriteLine("\tDetails of all items are:");
            foreach (var x in results) {
                Console.WriteLine("\t\t{0} of item {1} with description {2}",
                                  x.quantity, x.id, x.description);
            }
        }
    }
}
