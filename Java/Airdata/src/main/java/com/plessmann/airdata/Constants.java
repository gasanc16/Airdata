/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plessmann.airdata;

/**
 *
 * @author Plesse
 */
public class Constants {
    
    public static final String OPTIONS = "Please enter one of the following options:\n\t1 - Query\n\t2 - Reports\n\tany - exit";
    public static final String COUNTRY_INPUT = "Please enter the name or code of a country";
    public static final String GREETING = "Welcome to Airdata Airports Informer. ";
    public static final String FAREWELL = "Good bye, Have a nice day";
    
    public final static String COUNTRY_DATA_TMPL = "%s airports";
    public final static String AIRPORT_DATA_TMPL = "\t - %s runways:";
    public final static String RUNWAY_DATA_TMPL = "\t\t - %s";
    public final static String NO_RUNWAY_DATA_TMPL = "\t\tNo Runways in %s";
    public final static String NO_AIRPORT_DATA_TMPL = "\tNo Airports in %s";
    public final static String NO_COUNTRY_DATA_TMPL = "No country for name %s";
    
    public final static String TOP_COUNTRIES = "Top 10 countries with highest number of airports";
    public final static String BOTTOM_COUNTRIES = "\nTop 10 countries with lowest number of airports";
    public final static String COUNTRY_QTY_KEY = "\t + %s - %s";
    public final static String TOP_RUNWAY_ID = "\nTop 10 most common runway identification";
    public final static String RUNWAY_ID_KEY = "\t + %s - %d";
    public final static String RUNWAY_TYPE_PER_COUNTRY = "\nType of runways (as indicated in \"surface\" column) per country";
    
    public final static String LOADED_COUNTRIES = "Loaded %d countries";
    public final static String LOADED_AIRPORTS = "Loaded %d airports";
    public final static String LOADED_RUNWAYS = "Loaded %d runways";
    
    public final static String ENCODING = "UTF-8";
    
    public final static String AIRPORTS_DEFAULT_ROUTE = "resources/airports.csv";
    public final static String COUNTRIES_DEFAULT_ROUTE = "resources/countries.csv";
    public final static String RUNWAYS_DEFAULT_ROUTE = "resources/runways.csv";
    
    public final static String ONE = "1";
    public final static String QUERY_CONSOLE = "query";
    public final static String TWO = "2";
    public final static String REPORTS_CONSOLE = "reports";
    
    public final static String ID = "ID:";
    public final static String IDENT = "Ident:";
    public final static String TYPE = "Type:";
    public final static String NAME = "Name:";
    public final static String LATITUDE = "Latitude:";
    public final static String LONGITUDE = "Longitude";
    public final static String ELEVATION = "Elevation:";
    public final static String CONTINENT = "Continent:";
    public final static String ISO_COUNTRY = "ISO Country:";
    public final static String ISO_REGION = "ISO Region:";
    public final static String MUNICIPALITY = "Municipality:";
    public final static String SCHEDULED_SERVICE = "Scheduled Service:";
    public final static String GPS_CODE = "GPS Code:";
    public final static String IATA_CODE = "IATA Code:";
    public final static String LOCAL_CODE = "Local Code:";
    public final static String HOME_LINK = "Home Link";
    public final static String WIKIPEDIA_LINK = "Wikipedia Link:";
    public final static String KEYWORDS = "Keywords:";
    public final static String RUNWAYS = "Runways:";
    
    public final static String MAIN_TITLE = "Airdata Airport Informer";
    public final static String SELECT_FILE = "Select Data Files";
    public final static String SELECT_FILE_TOOL_TIP = "Select your own file or use the default data";
    public final static String QUERY = "Query";
    public final static String REPORTS = "Reports";
    public final static String COUNTRIES = "Countries:";
    public final static String AIRPORTS = "Airports:";
    
    public final static String SELECT = "Select";
    public final static String CLOSE = "Close";
    
    public final static String COUNTRY = "Country";
    public final static String CODE = "Code:";
    public final static String AIRPORTS_QTY = "Airports Quantity:";
    public final static String DETAIL = "Detail";
    
    public final static String HIGH = "Highest Number of Airports";
    public final static String LOW = "Lowest Number of Airports";
    public final static String SURFACE = "Surfaces per Country";
    public final static String IDENTS = "Top Runways Identifications";
    
    public final static String OPEN_BRACKET = "{";
    public final static String CLOSE_BRACKET = "}";
    public final static String DOUBLE = "\"";
    
    public final static String RUNWAY_ID = "\"id\":";
    public final static String RUNWAY_AIRPORT_REF = ",\"airportRef\":\"";
    public final static String RUNWAY_AIRPORT_IDENT = ",\"airportIdent\":\"";
    public final static String RUNWAY_LENGTH = ",\"lengthFt\":";
    public final static String RUNWAY_WIDTH = ",\"widthFt\":";
    public final static String RUNWAY_SURFACE = ",\"surface\":\"";
    public final static String RUNWAY_LIGHTED = ",\"lighted\":";
    public final static String RUNWAY_CLOSED = ",\"closed\":";
    public final static String RUNWAY_LE_IDENT = ",\"leIdent\":\"";
    public final static String RUNWAY_LE_LATITUDE = ",\"leLatitudeDeg\":";
    public final static String RUNWAY_LE_LONGITUDE = ",\"leLongitudeDeg\":";
    public final static String RUNWAY_LE_ELEVATION = ",\"leElevationFt\":";
    public final static String RUNWAY_LE_HEADING = ",\"leHeadingDegT\":";
    public final static String RUNWAY_LE_DISPLACED = ",\"leDisplacedThresholdFt\":";
    public final static String RUNWAY_HE_IDENT = ",\"heIdent\":\"";
    public final static String RUNWAY_HE_LATITUDE = ",\"he_latitude_deg\":";
    public final static String RUNWAY_HE_LONGITUDE = ",\"he_longitude_deg\":";
    public final static String RUNWAY_HE_ELEVATION = ",\"heElevationFt\":";
    public final static String RUNWAY_HE_HEADING = ",\"heHeadingDegT\":";
    public final static String RUNWAY_HE_DISPLACED = ",\"heDisplacedThresholdFt\":";
    
    public final static String COUNTRY_KEY = "%d - %s - %s";
    public final static String AIRPORT_KEY = "%d - %s";
    public final static String SURFACES = "Surfaces";
    
}
