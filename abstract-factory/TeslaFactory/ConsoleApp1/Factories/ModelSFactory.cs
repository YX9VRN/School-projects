using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApp1
{
    class ModelSFactory : IPartFactory
    {
        public Body ManufactureBody()
        {
            return new ModelSBody();
        }

        public Chassis ManufactureChassis()
        {
            return new ModelSChassis();
        }

        public Engine ManufactureEngine()
        {
            return new ModelSEngine();
        }
    }
}
