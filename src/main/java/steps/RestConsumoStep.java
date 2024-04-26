package steps;

import io.restassured.response.Response;
import models.setdata.Constantes;
import models.setdata.RestLombokData;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.assertj.core.api.SoftAssertions;
import utils.MetodosRest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RestConsumoStep extends PageObject
{
    Logger logger=Logger.getLogger("RestConsumoStep");
    SoftAssertions softAssertions = new SoftAssertions();
    Response response=null;
    List<String> responsePaths = new ArrayList<String>();
    List<String> respuestaEsperada = new ArrayList<String>();
    List<String> resultado = new ArrayList<>();
    Object path;
    @Step
    public void consumir(Map<String, Object> headers,RestLombokData data)
    {
        try
        {
            switch (data.getMetodo()) {
                case "GET BASIC AUTH":
                    response=MetodosRest.restGetWithHeadersBasicAuth(data.getUrl(),data.getEndpoint(),headers, Constantes.USER,Constantes.PASS);
                    break;
                case "POST BASIC AUTH":
                    response= MetodosRest.restPostWithHeadersBasicAuth(data.getUrl(),data.getEndpoint(),data.getBody(),headers,Constantes.USER,Constantes.PASS);
                    break;
                case "PUT BASIC AUTH":
                    response= MetodosRest.restPutWithHeadersBasicAuth(data.getUrl(),data.getEndpoint(),data.getBody(),headers,Constantes.USER,Constantes.PASS);
                    break;
                case "PATCH BASIC AUTH":
                    response= MetodosRest.restPatchWithHeadersBasicAuth(data.getUrl(),data.getEndpoint(),data.getBody(),headers,Constantes.USER,Constantes.PASS);
                    break;
                case "DELETE BASIC AUTH":
                    response= MetodosRest.restDeleteBasicAuth(data.getUrl(),data.getEndpoint(),Constantes.USER, Constantes.PASS);
                    break;
                default:
                    logger.info("No existe el METODO HTTP seleccionado");
                    break;
            }
        }
        catch (Exception e)
        {
            logger.log(Level.INFO, "OCURRIO UN ERROR: ",e);
            softAssertions.fail(e.getMessage());
            softAssertions.assertAll();
        }
    }

    @Step
    public void verificarStatusCode(RestLombokData data)
    {
        try
        {
            int sc=response.getStatusCode();
            if(sc!=data.getStatusCode()){
                softAssertions.fail("El status code NO es el esperado: "+sc);
                softAssertions.assertAll();
            }
        }
        catch (Exception e)
        {
            logger.log(Level.INFO, "OCURRIO UN ERROR: ",e);
            softAssertions.fail(e.getMessage());
            softAssertions.assertAll();
        }
    }

    @Step
    public void verificarRespuesta(RestLombokData data)
    {
        try {
            if(!(data.getRespuesta()==null)) {
                for (String pair : data.getRespuesta().split("#")) {
                    String[] entry = pair.split("~");
                    responsePaths.add(entry[0].trim());
                    respuestaEsperada.add(entry[1].trim());
                }

                for (String s : responsePaths) {
                    path = response.path(s);
                    if (path == null) {
                        resultado.add("no tiene mensaje");
                    } else {
                        resultado.add(path.toString());
                    }
                }
                if (resultado != null) {
                    if (!resultado.equals(respuestaEsperada)) {
                        softAssertions.fail("La respuesta NO es la esperada");
                        softAssertions.assertAll();
                    }
                }

            }
        }
        catch (Exception e)
        {
            logger.log(Level.INFO, "OCURRIO UN ERROR: ",e);
            softAssertions.fail(e.getMessage());
            softAssertions.assertAll();
        }
    }
}
