package org.sarb.java.messanger.resources;

import jakarta.ws.rs.CookieParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.MatrixParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.UriInfo;

@Path("/injectdemo")
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResources {

	@GET
	@Path("/annotations")
	public String getParamsUsingAnnotations(@MatrixParam("param") String matrixParam,
			@HeaderParam("authSessionID") String header, @CookieParam("name") String cookie) {
		return "MatrixParam : " + matrixParam + " HeaderParam : " + header + " CookieParam : " + cookie;

	}
	
	@GET
	@Path("/context")
	public String getParameterUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders headers)
	{
		return "Path : "+ uriInfo.getAbsolutePath().toString()+" Cookies : "+ headers.getCookies();
	}

}
