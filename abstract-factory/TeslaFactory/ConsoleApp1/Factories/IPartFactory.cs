using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApp1
{
    interface IPartFactory
    {
        Engine ManufactureEngine();
        Chassis ManufactureChassis();
        Body ManufactureBody();
    }
}
