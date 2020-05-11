using ConsoleApp1.Factories;
using System;

namespace ConsoleApp1
{
    class Program
    {
        static void Main(string[] args)
        {
            IPartFactory factory = null;
            ProductionLine prodLine = new ProductionLine();
            bool quit = false;
            while (!quit)
            {
                Console.WriteLine("how many tesla do you want? ");
                int pieces = Convert.ToInt32(Console.ReadLine());
                Console.WriteLine("What model? (S, Y, Cybertruck)\n(You can quit with the \"Quit\" command)");
                string model = Console.ReadLine();
                switch (model)
                {
                    case "S":
                        factory = new ModelSFactory();
                        break;
                    case "Y":
                        factory = new ModelYFactory();
                        break;
                    case "Cybertruck":
                        factory = new CybertruckFactory();
                        break;
                    case "Quit":
                        quit = true;
                        break;
                    default:
                        break;
                }
                prodLine.SetFactory(factory);
                prodLine.StartProduction(pieces);
            }
        }
    }
}
