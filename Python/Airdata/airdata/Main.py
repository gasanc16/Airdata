from airdata.controllers.DataLoader import load
from airdata.controllers.AirdataController import query, reports

OPTIONS = "Please enter one of the following options:\n\t1 - Query\n\t2 - Reports\n\tany - exit\n Option: ";
COUNTRY_INPUT = "Please enter the name or code of a country: ";
GREETING = "Welcome to Airdata Airports Informer. ";
FAREWELL = "Good bye, Have a nice day";

load()
print GREETING
while True:
    var = raw_input(OPTIONS)
    if var in ("1", "query"):
        var = raw_input(COUNTRY_INPUT)
        query(var)
    elif var in ("2", "reports"):
        reports()
    else:
        break
print FAREWELL