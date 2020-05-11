using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApp1
{
    class ModelYFactory : IPartFactory
    {
        public Body ManufactureBody()
        {
            return new ModelYBody();
        }

        public Chassis ManufactureChassis()
        {
            return new ModelYChassis();
        }

        public Engine ManufactureEngine()
        {
            return new ModelYEngine();
        }
    }
}
