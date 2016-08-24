from collections import defaultdict, Counter
from airdata.datasource.Runways import getsuface


airports = []


def getairportsbycountry(country):
    return [x for x in airports if country['code'] == x['iso_country']]


def qtybycountry(country):
    return sum(country['code'] == x['iso_country'] for x in airports)


def surface(country):
    merged = Counter(defaultdict(int))
    for airport in getairportsbycountry(country):
        merged.update(dict(getsuface(airport)))
    return sorted(merged.items(), key=lambda x: x[1], reverse=True)