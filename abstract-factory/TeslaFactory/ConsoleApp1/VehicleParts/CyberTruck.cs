using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApp1.VehicleParts
{
    public class CybertruckEngine : Engine
    {
        public override string ToString()
        {
            return "Cybertruck-Engine";
        }
    }
    public class CybertruckBody : Body
    {
        public override string ToString()
        {
            return "Cybertruck-Body";
        }
    }
    public class CybertruckChassis : Chassis
    {
        public override string ToString()
        {
            return "Cybertruck-Chassis";
        }
    }

}
