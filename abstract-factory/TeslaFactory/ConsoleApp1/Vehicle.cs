using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApp1
{
    class Vehicle
    {
        public Engine engine { get; set; }
        public Chassis chassis { get; set; }
        public Body body { get; set; }
        #region Constructors
        public Vehicle(Chassis chassis, Body body, Engine engine)
        {
            this.chassis = chassis;
            this.body = body;
            this.engine = engine;
        }
        public Vehicle(){}
        #endregion

        public override string ToString()
        {
            return "Vehicle parts:\n\t"+engine.ToString()+"\n\t"+body.ToString()+"\n\t"+chassis.ToString();
        }
    }
}
