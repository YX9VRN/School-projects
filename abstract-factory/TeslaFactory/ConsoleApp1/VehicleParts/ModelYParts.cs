using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApp1
{
    public class ModelYEngine : Engine
    {
        public override string ToString()
        {
            return "ModelY-Engine";
        }
    }
    public class ModelYBody : Body
    {

        public override string ToString()
        {
            return "ModelY-Body";
        }
    }
    public class ModelYChassis : Chassis
    {
        public override string ToString()
        {
            return "ModelY-Chassis";
        }
    }
}
