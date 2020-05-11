using ConsoleApp1.VehicleParts;
using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApp1.Factories
{
    class CybertruckFactory : IPartFactory
    {
        public Body ManufactureBody()
        {
            return new CybertruckBody();
        }

        public Chassis ManufactureChassis()
        {
            return new CybertruckChassis();
        }

        public Engine ManufactureEngine()
        {
            return new CybertruckEngine();
        }
    }
}
