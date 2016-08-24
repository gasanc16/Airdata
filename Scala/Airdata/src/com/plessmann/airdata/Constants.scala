package com.plessmann.airdata

/**
 * Created by Plesse on 12/8/2016.
 */
object Constants {

  val OPTIONS: String = "Please enter one of the following options:\n\t1 - Query\n\t2 - Reports\n\tany - exit";
  val COUNTRY_INPUT: String = "Please enter the name or code of a country";
  val GREETING: String = "Welcome to Airdata Airports Informer. ";
  val FAREWELL: String = "Good bye, Have a nice day";

  val COUNTRY_DATA_TMPL: String = "%s airports";
  val AIRPORT_DATA_TMPL: String = "\t - %s runways:";
  val RUNWAY_DATA_TMPL: String = "\t\t - %s";
  val NO_RUNWAY_DATA_TMPL: String = "\t\tNo Runways in %s";
  val NO_AIRPORT_DATA_TMPL: String = "\tNo Airports in %s";
  val NO_COUNTRY_DATA_TMPL: String = "No country for name %s";

  val TOP_COUNTRIES: String = "Top 10 countries with highest number of airports";
  val BOTTOM_COUNTRIES: String = "\nTop 10 countries with lowest number of airports";
  val COUNTRY_QTY_KEY: String = "\t + %s - %s";
  val TOP_RUNWAY_ID: String = "\nTop 10 most common runway identification";
  val RUNWAY_ID_KEY: String = "\t + %s - %s";
  val RUNWAY_TYPE_PER_COUNTRY: String = "\nType of runways (as indicated in \"surface\" column) per country";

  val LOADED_COUNTRIES: String = "Loaded %s countries";
  val LOADED_AIRPORTS: String = "Loaded %s airports";
  val LOADED_RUNWAYS: String = "Loaded %s runways";

  val ENCODING: String = "UTF-8";

  val AIRPORTS_DEFAULT_ROUTE: String = "resources/airports.csv";
  val COUNTRIES_DEFAULT_ROUTE: String = "resources/countries.csv";
  val RUNWAYS_DEFAULT_ROUTE: String = "resources/runways.csv";

  val ONE: String = "1";
  val QUERY_CONSOLE: String = "query";
  val TWO: String = "2";
  val REPORTS_CONSOLE: String = "reports";

  val COUNTRY: String = "Country";

  val MAIN_TITLE: String = "Airdata Airport Informer";
  val SELECT_FILE: String = "Select Data Files";
  val SELECT_FILE_TOOL_TIP: String = "Select your own file or use the default data";
  val QUERY: String = "Query";
  val REPORTS: String = "Reports";
  val COUNTRIES: String = "Countries:";
  val AIRPORTS: String = "Airports:";
  val RUNWAYS: String = "Runways:";


  val OPEN_BRACKET : String = "{";
  val CLOSE_BRACKET : String = "}";
  val DOUBLE : String = "\"";

  val RUNWAY_ID : String = "\"id\":";
  val RUNWAY_AIRPORT_REF : String = ",\"airportRef\":\"";
  val RUNWAY_AIRPORT_IDENT : String = ",\"airportIdent\":\"";
  val RUNWAY_LENGTH : String = ",\"lengthFt\":";
  val RUNWAY_WIDTH : String = ",\"widthFt\":";
  val RUNWAY_SURFACE : String = ",\"surface\":\"";
  val RUNWAY_LIGHTED : String = ",\"lighted\":";
  val RUNWAY_CLOSED : String = ",\"closed\":";
  val RUNWAY_LE_IDENT : String = ",\"leIdent\":\"";
  val RUNWAY_LE_LATITUDE : String = ",\"leLatitudeDeg\":";
  val RUNWAY_LE_LONGITUDE : String = ",\"leLongitudeDeg\":";
  val RUNWAY_LE_ELEVATION : String = ",\"leElevationFt\":";
  val RUNWAY_LE_HEADING : String = ",\"leHeadingDegT\":";
  val RUNWAY_LE_DISPLACED : String = ",\"leDisplacedThresholdFt\":";
  val RUNWAY_HE_IDENT : String = ",\"heIdent\":\"";
  val RUNWAY_HE_LATITUDE : String = ",\"he_latitude_deg\":";
  val RUNWAY_HE_LONGITUDE : String = ",\"he_longitude_deg\":";
  val RUNWAY_HE_ELEVATION : String = ",\"heElevationFt\":";
  val RUNWAY_HE_HEADING : String = ",\"heHeadingDegT\":";
  val RUNWAY_HE_DISPLACED : String = ",\"heDisplacedThresholdFt\":";

  val HIGH : String = "Highest Number of Airports";
  val LOW : String = "Lowest Number of Airports";
  val SURFACE : String = "Surfaces per Country";
  val IDENTS : String = "Top Runways Identifications";

}
