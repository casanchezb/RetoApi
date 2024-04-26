package models.setdata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import lombok.Data;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RestLombokData
{
    String pathFile;
    String servicio;
    String peticion;
    String url;
    String endpoint;
    String metodo;
    String body;
    int statusCode;
    String respuesta;

    public static List<RestLombokData> setData(DataTable dataTable) {
        List<RestLombokData> dates = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();
        for (Map<String, String> map : mapInfo) {
            dates.add(new ObjectMapper().convertValue(map, RestLombokData.class));
        }
        return dates;
    }

    public static Map<String, Object> prepararHeader(DataTable table){
        Map<String, Object> headers = new HashMap<>();
        if(!(table.asLists(String.class).get(1).get(5) ==null)) {
            for (String pair : table.asLists(String.class).get(1).get(5).split(",")) {
                String[] entry = pair.split(":");
                headers.put(entry[0].trim(), entry[1].trim());
            }
        }
        return headers;
    }
}
