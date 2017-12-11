
package com.networknt.licenses;

import com.networknt.config.Config;
import com.networknt.server.HandlerProvider;
import io.undertow.Handlers;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Methods;
import com.networknt.info.ServerInfoGetHandler;
import com.networknt.health.HealthGetHandler;
import com.networknt.licenses.handler.*;

public class PathHandlerProvider implements HandlerProvider {
    @Override
    public HttpHandler getHandler() {
        return Handlers.routing()
        
            .add(Methods.POST, "/v1/licenses", new LicensesPostHandler())
        
            .add(Methods.GET, "/v1/licenses", new LicensesGetHandler())
        
            .add(Methods.GET, "/v1/health", new HealthGetHandler())
        
            .add(Methods.GET, "/v1/server/info", new ServerInfoGetHandler())
        
            .add(Methods.GET, "/v1/licenses/{licenseid}", new LicensesLicenseidGetHandler())
        
            .add(Methods.DELETE, "/v1/licenses/{licenseid}", new LicensesLicenseidDeleteHandler())
        
        ;
    }
}
