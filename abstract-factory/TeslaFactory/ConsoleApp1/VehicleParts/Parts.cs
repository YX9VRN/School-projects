using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApp1
{
    public abstract class Engine
    {
        public void Diagnostics() {
            if(DateTime.Now.Millisecond <= 1000 && DateTime.Now.Millisecond >= 100) throw new Exception("Wrong engine");
        }
    }
    public abstract class Body
    {
        public void Diagnostics() {
            if (DateTime.Now.Millisecond <= 900 && DateTime.Now.Millisecond >= 850) throw new Exception("Wrong body");
        }
    }
    public abstract class Chassis
    {
        public void Diagnostics() {
            if (DateTime.Now.Millisecond <= 600 && DateTime.Now.Millisecond >= 550) throw new Exception("Wrong chassis");
        }
    }
}


