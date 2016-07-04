package it.unisannio.loganalysis.analysis;

/**
 * Created by mario on 04/07/16.
 */
public class QueryType {
    private Query query;

    public QueryType(Query query) {
        this.query = query;
    }

    public String getDescription() {
        switch (query) {
            case RESOURCE_USAGE: return "Utilizzo delle risorse";
            case RESOURCE_USAGE_TIME: return "Tempo di utilizzo delle risorse";
            case DAILY_ACTIVE_USERS: return "Attività giornaliere degli utenti";
            case DAILY_ACTIVE_RESOURCES: return "Attività giornaliere sulle risorse";
            case DAILY_ACTIVITIES: return "Attività giornaliere";
            case TIME_RANGE_USAGE: return "Fasce temporali di utilizzo";
            case MOST_USED_OS: return "Sistemi operativi più utilizzati";
            case RESOURCE_ADDED_PER_DAY: return "Risorse aggiunte al giorno";
        }
        return null;
    }

}
