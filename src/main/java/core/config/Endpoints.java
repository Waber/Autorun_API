package core.config;

public interface Endpoints {
    String BASE_URI = "https://variousitems.org/api";
    String ITEMS = BASE_URI+"/items";
    String ITEM = ITEMS+"/{id}";
}
