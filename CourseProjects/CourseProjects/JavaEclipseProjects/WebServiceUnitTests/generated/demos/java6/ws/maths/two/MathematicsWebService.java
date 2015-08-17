
package demos.java6.ws.maths.two;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAXWS SI.
 * JAX-WS RI 2.1-02/02/2007 03:56 AM(vivekp)-FCS
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "MathematicsWebService", targetNamespace = "http://two.maths.ws.java6.demos/", wsdlLocation = "http://localhost:8080/Java6WS/maths2?wsdl")
public class MathematicsWebService
    extends Service
{

    private final static URL MATHEMATICSWEBSERVICE_WSDL_LOCATION;

    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/Java6WS/maths2?wsdl");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        MATHEMATICSWEBSERVICE_WSDL_LOCATION = url;
    }

    public MathematicsWebService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MathematicsWebService() {
        super(MATHEMATICSWEBSERVICE_WSDL_LOCATION, new QName("http://two.maths.ws.java6.demos/", "MathematicsWebService"));
    }

    /**
     * 
     * @return
     *     returns Mathematics
     */
    @WebEndpoint(name = "MathematicsPort")
    public Mathematics getMathematicsPort() {
        return (Mathematics)super.getPort(new QName("http://two.maths.ws.java6.demos/", "MathematicsPort"), Mathematics.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Mathematics
     */
    @WebEndpoint(name = "MathematicsPort")
    public Mathematics getMathematicsPort(WebServiceFeature... features) {
        return (Mathematics)super.getPort(new QName("http://two.maths.ws.java6.demos/", "MathematicsPort"), Mathematics.class, features);
    }

}
