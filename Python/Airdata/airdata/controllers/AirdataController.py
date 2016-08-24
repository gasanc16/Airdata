from airdata.datasource.Airports import getairportsbycountry, surface
from airdata.datasource.Countries import getcountrybyname, sortbyairportsqty, getsortedbyname
from airdata.datasource.Runways import getbyairport, toprunwayidentification


COUNTRY_DATA = "Country {}:"
AIRPORT_DATA = "\tAirport {}:"
RUNWAY_DATA = "\t\t- {}"
LIST_TEMPLATE = "+ {} {}"
TOP_COUNTRIES = "Top 10 countries with highest number of airports"
BOTTOM_COUNTRIES = "\nTop 10 countries with lowest number of airports"
TOP_RUNWAY_ID = "\nTop 10 most common runway identification"
RUNWAY_TYPE_PER_COUNTRY = "\nType of runways (as indicated in \"surface\" column) per country"


def query(name):
    for country in getcountrybyname(name):
        print COUNTRY_DATA.format(country['name'])
        for airport in getairportsbycountry(country):
            print AIRPORT_DATA.format(airport['name'])
            for runway in getbyairport(airport):
                print RUNWAY_DATA.format(runway)


def reports():
    print TOP_COUNTRIES
    for country in sortbyairportsqty(True, True, 10):
        print LIST_TEMPLATE.format(country['name'], country['qty'])

    print BOTTOM_COUNTRIES
    for country in sortbyairportsqty(False, False, 10):
        print LIST_TEMPLATE.format(country['name'], country['qty'])

    print RUNWAY_TYPE_PER_COUNTRY
    for country in getsortedbyname():
        print COUNTRY_DATA.format(country['name'])
        for item in surface(country):
            print LIST_TEMPLATE.format(item[0], item[1])

    print TOP_RUNWAY_ID
    for item in toprunwayidentification(10):
        print LIST_TEMPLATE.format(item[0], item[1])

