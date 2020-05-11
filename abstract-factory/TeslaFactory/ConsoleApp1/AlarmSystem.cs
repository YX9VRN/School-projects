using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApp1
{
    public class AlarmSystem
    {
        private static AlarmSystem instance;

        public static AlarmSystem GetAlarm()
        {
            if (instance == null)
                instance = new AlarmSystem();
            return instance;
        }

        protected AlarmSystem() { }
        
        public void Alarm(string alarmText)
        {
            Console.ForegroundColor = ConsoleColor.Red;
            Console.Error.WriteLine(alarmText);
            Console.ForegroundColor = ConsoleColor.White;
        }
    }
}
