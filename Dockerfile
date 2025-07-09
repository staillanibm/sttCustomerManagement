FROM ibmhybridcr.azurecr.io/webmethods-edge-runtime:11.1.0 as builder

ARG WPM_TOKEN

RUN /opt/softwareag/wpm/bin/wpm.sh install -ws https://packages.webmethods.io -wr licensed -j $WPM_TOKEN -d /opt/softwareag/IntegrationServer WmJDBCAdapter:latest

ADD --chown=1724 . /opt/softwareag/IntegrationServer/packages/sttCustomerManagement

USER 0
RUN chgrp -R 0 /opt/softwareag && chmod -R g=u /opt/softwareag


FROM ibmhybridcr.azurecr.io/webmethods-edge-runtime:11.1.0

USER 1724

COPY --from=builder /opt/softwareag/IntegrationServer /opt/softwareag/IntegrationServer
