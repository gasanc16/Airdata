from itertools import groupby
from operator import itemgetter


runways = []


def getbyairport(airport):
    return [x for x in runways if airport['id'] == x['airport_ref']]


def toprunwayidentification(maxelements):
    result = []
    runways.sort(key=itemgetter("le_ident"))
    for key, group in groupby(runways, lambda item: item["le_ident"]):
        result.append((key, sum(1 for x in group)))
    return sorted(result, key=lambda x: x[1], reverse=True)[:maxelements]


def getsuface(airport):
    result = []
    aux = [x for x in runways if airport['id'] == x['airport_ref']]
    aux.sort(key=itemgetter("surface"))
    for key, group in groupby(aux, lambda item: item["surface"]):
        result.append((key, sum(1 for x in group)))
    return result