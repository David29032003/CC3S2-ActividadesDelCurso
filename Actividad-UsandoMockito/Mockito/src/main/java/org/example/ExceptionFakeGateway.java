package org.example;

public class ExceptionFakeGateway  implements Gateway<AstroResponse>{
    @Override
    public AstroResponse getResponse() {
        throw new RuntimeException("Gateway failure");
    }
}
