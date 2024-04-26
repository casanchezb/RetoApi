package utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.Map;
import static net.serenitybdd.rest.SerenityRest.given;

public class MetodosRest
{
    static Response response=null;

    /**
     * Permite consultar un servicio REST con el metodo GET contentType.JSON con cabeceras y Autenticacion Basica
     *
     * @param url URL del servicio
     * @param endpoint del servicio a consumir incluido parametros, si es necesario
     * @param header     Objeto que implementa el Mapa <V, K> interface que contiene el formato de claves,
     *                   valores de la cabecera necesarios para consumir el servicio
     * @return Objeto de tipo io.restassured.response.Response con la informacion retornada por el servicio.
     * Presenta alguna exception con valores vacios o nulos
     */

    public static Response restGetWithHeadersBasicAuth(String url, String endpoint, Map<String, Object> header, String user, String pass) {
        response = given().contentType(ContentType.JSON).relaxedHTTPSValidation().headers(header)
                .auth().basic(user,pass)
                .when().get(url+endpoint,new Object[0])
                .then().extract().response();
        response.getStatusCode();
        return response;
    }

    /**
     * Permite consultar un servicio REST con el metodo POST contentType.JSON con cabeceras y Autenticacion Basica
     *
     * @param url URL del servicio
     * @param endpoint del servicio a consumir incluido parametros, si es necesario
     * @param body       String que contiene en formato JSON, el body a ser publicado
     * @param headers    Objeto que implementa el Mapa <V, K> interface que contiene el formato de claves,
     *                   valores de la cabecera necesarios para consumir el servicio
     * @param user usuario para autenticacion en el servicio
     * @param pass contrasena para autenticacion en el servicio
     * @return Objeto de tipo io.restassured.response.Response con la informacion retornada por el servicio.
     * Presenta alguna exception con valores vacios o nulos
     */

    public static Response restPostWithHeadersBasicAuth(String url, String endpoint, String body, Map<String, Object>  headers, String user, String pass) {

        response = given().contentType(ContentType.JSON).relaxedHTTPSValidation().headers(headers).
                auth().basic(user,pass).
                body(body).when().post(url+endpoint)
                .then().extract().response();
        response.getStatusCode();
        return response;
    }

    /**
     * Permite consultar un servicio REST con el metodo DELETE contentType.JSON y Autenticacion Basica
     *
     * @param url URL del servicio
     * @param endpoint del servicio a consumir incluido parametros, si es necesario
     *                   valores de la cabecera necesarios para consumir el servicio
     * @param user usuario para autenticacion en el servicio
     * @param pass contrasena para autenticacion en el servicio
     * @return Objeto de tipo io.restassured.response.Response con la informacion retornada por el servicio.
     * Presenta alguna exception con valores vacios o nulos
     */

    public static Response restDeleteBasicAuth(String url, String endpoint, String user, String pass) {
            response = given().relaxedHTTPSValidation().
                    auth().basic(user,pass).
                    when().delete(url+endpoint).then().
                    extract().response();
            response.getStatusCode();
            return response;
    }

    /**
     * Permite consultar un servicio REST con el metodo PUT contentType.JSON con cabeceras y Autenticacion Basica
     *
     * @param url URL del servicio
     * @param endpoint del servicio a consumir incluido parametros, si es necesario
     * @param body       String que contiene en formato JSON, el body a ser publicado
     * @param headers    Objeto que implementa el Mapa <V, K> interface que contiene el formato de claves,
     *                   valores de la cabecera necesarios para consumir el servicio
     * @param user usuario para autenticacion en el servicio
     * @param pass contrasena para autenticacion en el servicio
     * @return Objeto de tipo io.restassured.response.Response con la informacion retornada por el servicio.
     * Presenta alguna exception con valores vacios o nulos
     */

    public static Response restPutWithHeadersBasicAuth(String url, String endpoint, String body, Map<String, Object> headers, String user, String pass) {
            response = given().contentType(ContentType.JSON).relaxedHTTPSValidation()
                    .auth().basic(user,pass)
                    .headers(headers).body(body).when().put(url+endpoint).then()
                    .extract().response();
            response.getStatusCode();
            return response;
    }


    /**
     * Permite consultar un servicio REST con el metodo PATCH contentType.JSON con cabeceras y Autenticacion Basica
     *
     * @param url URL del servicio
     * @param endpoint del servicio a consumir incluido parametros, si es necesario
     * @param body       String que contiene en formato JSON, el body a ser publicado
     * @param headers    Objeto que implementa el Mapa <V, K> interface que contiene el formato de claves,
     *                   valores de la cabecera necesarios para consumir el servicio
     * @param user usuario para autenticacion en el servicio
     * @param pass contrasena para autenticacion en el servicio
     * @return Objeto de tipo io.restassured.response.Response con la informacion retornada por el servicio.
     * Presenta alguna exception con valores vacios o nulos
     */
    public static Response restPatchWithHeadersBasicAuth(String url, String endpoint, String body, Map<String, Object> headers, String user, String pass) {
        response = given().contentType(ContentType.JSON).relaxedHTTPSValidation()
                .auth().basic(user,pass)
                .headers(headers).body(body).when().patch(url + endpoint).then()
                .extract().response();
        response.getStatusCode();
        return response;
    }
}
