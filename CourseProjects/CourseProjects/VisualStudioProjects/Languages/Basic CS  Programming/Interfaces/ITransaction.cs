using System;
using System.Collections.Generic;
using System.Text;

namespace Interfaces {
    interface ITransaction {
        void Start();
        void Add(Resource r);
        void Commit();
        void Rollback();
    }
}