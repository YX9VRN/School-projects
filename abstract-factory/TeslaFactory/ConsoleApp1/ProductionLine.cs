using System;
using System.Collections.Generic;
using System.Text;
using System.Threading;

namespace ConsoleApp1
{
    class ProductionLine
    {
        private List<Vehicle> manufacturedVehicles = new List<Vehicle>();
        private IPartFactory factory;

        private Engine manufacturedEngine;
        private Chassis manufacturedChassis;
        private Body manufacturedBody;

        private Vehicle actualVehicle = new Vehicle();

        public void StartProduction(int quantity)
        {
            for (int i = 0; i < quantity; i++)
            {
                ManufactureParts();
                try
                {
                    manufacturedChassis.Diagnostics();
                    manufacturedEngine.Diagnostics();
                    manufacturedBody.Diagnostics();
                }
                catch (Exception ex)
                {
                    AlarmSystem.GetAlarm().Alarm(ex.Message);
                }
                actualVehicle = Assembly(manufacturedChassis, manufacturedBody, manufacturedEngine);
                manufacturedVehicles.Add(actualVehicle);
                Thread.Sleep(500);
                Console.WriteLine("["+i+"]"+actualVehicle.ToString());
            }
        }
        private  Vehicle Assembly(Chassis chassis, Body body, Engine engine)
        {
            return new Vehicle(chassis, body, engine);
        }

        public void SetFactory(IPartFactory factory)
        {
            this.factory = factory;
        }
        private void ManufactureParts()
        {
            this.manufacturedChassis = factory.ManufactureChassis();
            this.manufacturedBody = factory.ManufactureBody();
            this.manufacturedEngine = factory.ManufactureEngine();
        }
        
    }
}
