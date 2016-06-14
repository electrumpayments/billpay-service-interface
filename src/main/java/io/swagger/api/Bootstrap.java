package io.swagger.api;

import io.swagger.jaxrs.config.SwaggerContextService;
import io.swagger.models.Contact;
import io.swagger.models.Info;
import io.swagger.models.License;
import io.swagger.models.Swagger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class Bootstrap extends HttpServlet {
   @Override
   public void init(ServletConfig config) throws ServletException {
      Info info =
            new Info().title("Swagger Server")
                  .description(
                        "The Electrum Bill Payments Service describes an interface for performing bill payments transactions. These transactions require a reference number which uniquely identifies the bill processor, bill issuer, as well as the customer account, and is typically printed on a customer invoice. The customer then makes use of this reference number to make a payment towards the corresponding bill. ")
                  .termsOfService("")
                  .contact(new Contact().email("support@electrum.co.za"))
                  .license(new License().name("Apache 2.0").url("http://www.apache.org/licenses/LICENSE-2.0.html"));

      ServletContext context = config.getServletContext();
      Swagger swagger = new Swagger().info(info);

      new SwaggerContextService().withServletConfig(config).updateSwagger(swagger);
   }
}
