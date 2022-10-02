package io.xezot.connector;

import io.camunda.connector.runtime.jobworker.api.outbound.ConnectorJobHandler;
import io.camunda.zeebe.client.ZeebeClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SendSMSViaTwilioApplication {
    private static final Logger log = LoggerFactory.getLogger(SendSMSViaTwilioApplication.class);
    //<editor-fold desc="Camunda Cloud Cluster Connection">
    static ZeebeClient zeebeClient = ZeebeClient.newCloudClientBuilder()
            .withClusterId("b5d8a48d-3ff4-47aa-88bf-689672784a7e")
            .withClientId("O~-osGnqU_1piYBqrcHZGL4wWBbRG2gW")
            .withClientSecret("therWG3znINKVf_FZh2kzh7QEpzGOD3.PTScV9V_cTN8fXTRqZEc_TPjEgUk4XMG")
            .withRegion("bru-2")
            .build();
    //</editor-fold>
    public static void main(String[] args) {
        zeebeClient.newWorker().jobType("io.camunda:my-connector:1").handler(new ConnectorJobHandler(new MyConnectorFunction())).fetchVariables("myProperty", "authentication").open();
        log.info(
                "Alive & kicking"
        );
    }
}
