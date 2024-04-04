package EpolIt.ZadanieTestowe.soap;

import EpolIt.ZadanieTestowe.entity.SvConf;
import EpolIt.ZadanieTestowe.service.SvConfService;
import EpolIt.ZadanieTestowe.soap.com.soap.gen.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class svConfEndpoint {
    private static final String NAMESPACE_URI = "http://www.soap.com/gen";

    private SvConfService svConfService;

    @Autowired
    public svConfEndpoint(SvConfService svConfService) {
        this.svConfService = svConfService;
    }
    public SvConfSoap mapToSvConfSoap(SvConf svConf) {
        SvConfSoap svConfSoap = new SvConfSoap();
        svConfSoap.setAttrName(svConf.getAttrName());
        svConfSoap.setAttrValue(svConf.getAttrValue());
        svConfSoap.setAttrDesc(svConf.getAttrDesc());

        return svConfSoap;
    }
    public SvConf mapToSvConf(SvConfSoap svConfSoap) {
        SvConf svConf = new SvConf();
        svConf.setAttrName(svConfSoap.getAttrName());
        svConf.setAttrValue(svConfSoap.getAttrValue());
        svConf.setAttrDesc(svConfSoap.getAttrDesc());

        return svConf;
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getSvConf")
    @ResponsePayload
    public GetSvConfResponse getSvConf(@RequestPayload GetSvConf request) {
        GetSvConfResponse response = new GetSvConfResponse();
        SvConf temp = svConfService.findByAttrName(request.getAttrName());

        if(temp != null) {
            response.setSvConf(mapToSvConfSoap(temp));
            response.setStatus(0);
        } else {
            response.setStatus(404);
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "postSvConf")
    @ResponsePayload
    public PostSvConfResponse postSvConf(@RequestPayload PostSvConf request) {
        PostSvConfResponse response = new PostSvConfResponse();
        SvConf svConf = new SvConf(request.getAttrName(), request.getAttrValue(), request.getAttrDesc());
        response.setStatus(svConfService.save(svConf));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "putSvConf")
    @ResponsePayload
    public PutSvConfResponse putSvConf(@RequestPayload PutSvConf request) {
        PutSvConfResponse response = new PutSvConfResponse();
        response.setStatus(svConfService.update(mapToSvConf(request.getSvConfSoap())));

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteSvConf")
    @ResponsePayload
    public DeleteSvConfResponse deleteSvConf(@RequestPayload DeleteSvConf request) {
        DeleteSvConfResponse response = new DeleteSvConfResponse();
        response.setStatus(svConfService.delete(request.getAttrName()));

        return response;
    }

}
