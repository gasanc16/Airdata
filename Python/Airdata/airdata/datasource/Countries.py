from airdata.datasource import Airports


countries = []


def getcountrybyname(name):
    return [x for x in countries if x['name'].lower().startswith(name) or x['code'].lower() == name]


def sortbyairportsqty(top, calc, maxelements):
    if(calc):
        for country in countries:
            country['qty'] = Airports.qtybycountry(country)
    return sorted(countries, key=lambda k: k['qty'], reverse=top)[:maxelements]


def getsortedbyname():
    return sorted(countries, key=lambda k: k['name'])
