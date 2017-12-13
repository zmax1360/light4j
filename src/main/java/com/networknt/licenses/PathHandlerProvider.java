
package com.networknt.licenses;

import com.networknt.health.HealthGetHandler;
import com.networknt.info.ServerInfoGetHandler;
import com.networknt.licenses.handler.LicensesGetHandler;
import com.networknt.licenses.handler.LicensesLicenseidDeleteHandler;
import com.networknt.licenses.handler.LicensesLicenseidGetHandler;
import com.networknt.licenses.handler.LicensesLicenseidPutHandler;
import com.networknt.licenses.handler.LicensesPostHandler;
import com.networknt.server.HandlerProvider;

import io.undertow.Handlers;
import io.undertow.server.HttpHandler;
import io.undertow.util.Methods;

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

            .add(Methods.PUT, "/v1/licenses/{licenseid}", new LicensesLicenseidPutHandler())
        
        ;
    }
}
