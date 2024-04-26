package definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.setdata.RestLombokData;
import net.thucydides.core.annotations.Steps;
import steps.RestConsumoStep;

public class RestDefinition {

    @Steps
    RestConsumoStep restConsumoStep;

    @Given("consumo el servicio con la peticion")
    public void consumoElServicioConLaPeticion(DataTable table) {
        restConsumoStep.consumir(RestLombokData.prepararHeader(table), RestLombokData.setData(table).get(0));
    }

    @When("verifico el status code")
    public void verificoElStatusCode(DataTable table) {
        restConsumoStep.verificarStatusCode(RestLombokData.setData(table).get(0));
    }

    @Then("verifico la respuesta en el response")
    public void verificoLaRespuestaEnElResponse(DataTable table) {
        restConsumoStep.verificarRespuesta(RestLombokData.setData(table).get(0));
    }

}
