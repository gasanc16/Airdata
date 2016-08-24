import csv
from airdata.datasource.Countries import countries
from airdata.datasource.Airports import airports
from airdata.datasource.Runways import runways


def load():
    loadfile("../resources/countries.csv", 0)
    print "Loaded %s countries" % len(countries)
    loadfile("../resources/airports.csv", 1)
    print "Loaded %s airports" % len(airports)
    loadfile("../resources/runways.csv", 2)
    print "Loaded %s runways" % len(runways)


def loadfile(fileroute, type):
    with open(fileroute, 'rb') as csvfile:
        has_header = csv.Sniffer().has_header(csvfile.read(1024))
        csvfile.seek(0)
        spamreader = csv.reader(csvfile)
        if has_header:
            next(spamreader)
        for row in spamreader:
            if type == 0:
                countries.append(
                    {'id': int(row[0]), 'code': row[1], 'name': row[2], 'continent': row[3], 'wikipediaLink': row[4],
                     'keywords': row[5]})
            elif type == 1:
                airports.append(
                    {'id': int(row[0]), 'ident': row[1], 'type': row[2], 'name': row[3], 'latitude_deg': row[4],
                     'longitude_deg': row[5], 'elevation_ft': row[6], 'continent': row[7], 'iso_country': row[8],
                     'iso_region': row[9],
                     'municipality': row[10], 'scheduled_service': row[11], 'gps_code': row[12], 'iata_code': row[13],
                     'local_code': row[14], 'home_link': row[15], 'wikipedia_link': row[16], 'keywords': row[17]})
            else:
                runways.append(
                    {'id': int(row[0]), 'airport_ref': int(row[1]), 'airport_ident': row[2], 'length_ft': row[3],
                     'width_ft': row[4],
                     'surface': row[5], 'lighted': row[6], 'closed': row[7], 'le_ident': row[8],
                     'le_latitude_deg': row[9],
                     'le_longitude_deg': row[10], 'le_elevation_ft': row[11], 'le_heading_degT': row[12],
                     'le_displaced_threshold_ft': row[13],
                     'he_ident': row[14], 'he_latitude_deg': row[15], 'he_longitude_deg': row[16],
                     'he_elevation_ft': row[17], 'he_heading_degT': row[18], 'he_displaced_threshold_ft': row[19]})

