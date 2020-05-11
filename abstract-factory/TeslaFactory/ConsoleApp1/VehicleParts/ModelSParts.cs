using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApp1
{

        public class ModelSEngine : Engine
        {
            public override string ToString()
            {
                return "ModelS-Engine";
            }
        }
        public class ModelSBody : Body
        {
            public override string ToString()
            {
                return "ModelS-Body";
            }
        }
        public class ModelSChassis : Chassis
        {
            public override string ToString()
            {
                return "ModelS-Chassis";
            }
        }
    
}
