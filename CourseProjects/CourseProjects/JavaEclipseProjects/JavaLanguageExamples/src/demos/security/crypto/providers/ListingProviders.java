package demos.security.crypto.providers;

import java.security.*;
import java.util.*;

public class ListingProviders {
    public static void main(String[] args) {
        Provider[] providers = Security.getProviders();
        System.out.println("Registered JCA providers are:");
        for(int i=0;i<providers.length;i++) {
            System.out.println("\t" + providers[i].getInfo() + " with properties:");
            Set<?> properties = providers[i].entrySet();
            Iterator<?> iter = properties.iterator();
            while(iter.hasNext()) {
                Map.Entry<?, ?> property = (Map.Entry<?, ?>)iter.next();
                System.out.println("\t\t" + property.getKey() + " = " + property.getValue());
            }
        }
    }
}
